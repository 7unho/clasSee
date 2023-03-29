package com.clasSee.api.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.clasSee.db.entity.lesson.OpenLesson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ApiModel("LessonScheduleRegisterPostReq")
public class LessonScheduleRegisterPostReq {
    @JsonIgnore
    Long lessonId;
    @ApiModelProperty(name="start_time", example="강의 시작 시간[yyyy-MM-dd HH:mm]")
    String startTime;
    @ApiModelProperty(name="end_time", example="강의 시작 시간[yyyy-MM-dd HH:mm]")
    String endTime;

    public OpenLesson getOpenLessonInfoFromReq(Long lessonId, LessonScheduleRegisterPostReq requestInfo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(requestInfo.getStartTime(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(requestInfo.getEndTime(), formatter);
        OpenLesson openLesson = OpenLesson.builder()
                .lessonId(lessonId)
                .startTime(startTime).endTime(endTime)
                .build();

        return openLesson;
    }
}
