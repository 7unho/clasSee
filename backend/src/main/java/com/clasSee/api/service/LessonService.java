package com.clasSee.api.service;

import com.clasSee.api.dto.LessonInfoDto;
import com.clasSee.api.dto.LessonSearchFilterDto;
import com.clasSee.api.response.AttendLessonInfoListRes;
import com.clasSee.api.response.LessonDetailsRes;
import com.clasSee.api.response.LessonSchedulesRes;
import com.clasSee.db.entity.lesson.Lesson;
import com.clasSee.db.entity.lesson.OpenLesson;
import com.clasSee.db.entity.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface LessonService {
    Long createLesson(Map<String, Object> lessonInfo);
    void updateLesson(Map<String, Object> lessonInfo);

    List<LessonInfoDto> setLessonProperty(List<Lesson> lessonList, User user);

    void createSchedule(OpenLesson requestInfo) throws Exception;

    LessonDetailsRes getLessonDetails(Long lessonId, User user);

    LessonSchedulesRes getLessonSchedules(Long lessonId, LocalDate regDate);

    AttendLessonInfoListRes getAttendLessonListByTeacher(Long userId, int limit, int offset);
    AttendLessonInfoListRes getAttendLessonListByStudent(Long userId, String query, int limit, int offset);

    List<Lesson> getPopularLessonList();

    Map<String, Object> getLessonListByFilter(LessonSearchFilterDto requestInfo, int offset, int limit);

    int deleteLesson(Long lessonId);

    int deleteOpenLesson(Long openLessonId);
}
