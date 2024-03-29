import React, { useState, useRef } from 'react';
import { useNavigate } from 'react-router-dom';

import { Stack, TextField, Button, Card } from '@mui/material/';

import ScheduleViewModel from '../../viewmodels/ScheduleViewModel';

import { CreateScheduleProps, ScheduleRequest } from '../../types/LessonsType';

const CreateScheduleComponent = ({
  runningtime,
  lessonId,
  setScheduleInputState,
  schedulesListState,
  rerenderSchedule,
  setRerenderSchedule,
}: CreateScheduleProps) => {
  // 강의 시작 시간, 종료 시간을 담을 state 각각 생성
  const [startTime, setStartTime] = useState<string>('');
  const [endTime, setEndTime] = useState<string>('');

  const { createSchedule } = ScheduleViewModel();
  const navigate = useNavigate();
  const today = new Date();

  // 시간 input 값 변경 시, endTime값도 함께 수정(runningTime이 0보다 높을 때 효력 발생함)
  const handleStartTimeChange = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    const newStartTime = event.target.value;
    setStartTime(newStartTime);
    const startDate = new Date(newStartTime);
    const endDate = new Date(
      startDate.getTime() + runningtime * 60 * 60 * 1000,
    );
    setEndTime(
      new Date(endDate.getTime() - endDate.getTimezoneOffset() * 60 * 1000)
        .toISOString()
        .slice(0, 16),
    );
    schedulesListState.forEach((schedule: any) => {
      const listScheduleStart = new Date(schedule.startTime);
      const listScheduleEnd = new Date(schedule.endTime);

      if (listScheduleStart <= startDate && startDate <= listScheduleEnd) {
        alert('중복된 시간은 선택하실 수 없습니다.');
        setStartTime('');
        setEndTime('');
      }
    });
  };

  const handleEndTimeChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEndTime(event.target.value);
  };

  const handleCloseInput = (event: React.MouseEvent<HTMLButtonElement>) => {
    setScheduleInputState(false);
    setStartTime('');
    setEndTime('');
  };
  // 만약 스케줄 등록 버튼을 눌렀을 시, api 요청을 보냄
  // 그 전에 해당 값을 입력했는지를 먼저 검증하고, 입력하지 않았을 시 alert로 입력하라고 지시함
  const handelSubmitSchedule = async (
    event: React.MouseEvent<HTMLButtonElement>,
  ) => {
    if (startTime === '') {
      alert('강의 시작 시간을 입력해주세요.');
    } else if (endTime === '') {
      alert('강의 종료 시간을 입력해주세요.');
    } else {
      // 만약 둘 모두 입력했음에도 끝나는 시간이 시작 시간보다 더 이르다면(runnigtime 0일시에만 해당), alert 창으로 알려줌
      const selectedStartDate = new Date(startTime);
      const selectedEndDate = new Date(endTime);
      if (selectedEndDate <= selectedStartDate) {
        alert('종료 시간은 시작 시간보다 늦은 시간으로 설정해주세요.');
        setEndTime('');
      } else if (selectedEndDate <= today) {
        alert('해당 시간대는 등록이 불가합니다. 다시 선택해주세요.');
        setStartTime('');
        setEndTime('');
      } else {
        // datetime input의 경우 중간에 T로 시간을 구분하고 있음
        // 해당 T까지 DB에 보내면 안되기 때문에, sclice로 해당 부분만 제거해서 데이터를 담아줌
        const createScheduleRequestBody: ScheduleRequest = {
          endTime: `${endTime.slice(0, 10)} ${endTime.slice(-5)}`,
          startTime: `${startTime.slice(0, 10)} ${startTime.slice(-5)}`,
        };

        const res = await createSchedule(createScheduleRequestBody, lessonId);
        if (res?.statusCode === 200) {
          alert('스케줄이 등록되었습니다');
          setScheduleInputState(false);
          setRerenderSchedule(!rerenderSchedule);
        } else if (res?.statusCode === 401) {
          alert('로그인 후 이용 가능합니다.');
          navigate('/login');
        } else if (res?.statusCode === 404) {
          alert('사용자가 존재하지 않습니다');
        } else if (res?.statusCode === 500) {
          alert('서버 오류입니다. 다시 시도해주십시오.');
        } else {
          alert('다시 시도해주세요');
        }
      }
    }
  };

  return (
    <Card className="create-schedule__body">
      <div className="create-schedule__header"> 스케줄 생성</div>
      <Stack
        component="form"
        noValidate
        direction="row"
        spacing={3}
        justifyContent="space-around"
      >
        <div className="create-schedule__container">
          <h3>시작 시간</h3>
          <TextField
            id="datetime-local"
            label="시작 시간"
            type="datetime-local"
            value={startTime}
            sx={{ width: 250 }}
            InputLabelProps={{
              shrink: true,
            }}
            onChange={handleStartTimeChange}
          />
        </div>
        <div className="create-schedule__container">
          <h3>종료 시간</h3>
          <TextField
            id="datetime-local"
            label="종료 시간"
            type="datetime-local"
            value={endTime}
            sx={{ width: 250 }}
            InputLabelProps={{
              shrink: true,
            }}
            // 만약 기존 강의 예상 시간이 0 이상이라면, 수정 불가
            disabled={runningtime !== 0}
            onChange={handleEndTimeChange}
          />
        </div>
      </Stack>
      <Stack
        direction="row"
        justifyContent="center"
        spacing={2}
        marginTop={2}
        marginBottom={2}
      >
        <Button
          type="button"
          onClick={handelSubmitSchedule}
          variant="contained"
        >
          등록
        </Button>
        <Button type="button" onClick={handleCloseInput} variant="contained">
          닫기
        </Button>
      </Stack>
    </Card>
  );
};
export default CreateScheduleComponent;
