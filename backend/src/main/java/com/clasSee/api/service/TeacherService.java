package com.clasSee.api.service;

import com.clasSee.db.entity.lesson.Lesson;
import com.clasSee.db.entity.user.User;

import java.util.List;

public interface TeacherService {
    List<Lesson> getLessonList(User user);
}
