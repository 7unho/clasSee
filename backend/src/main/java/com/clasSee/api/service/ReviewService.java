package com.clasSee.api.service;

import com.clasSee.api.request.ReviewRegistPostReq;
import com.clasSee.api.request.ReviewUpdatePutReq;
import com.clasSee.common.exception.handler.LessonException;
import com.clasSee.common.exception.handler.ReviewException;
import com.clasSee.common.exception.handler.UserException;
import com.clasSee.db.entity.lesson.Review;

import java.util.List;

public interface ReviewService {

    Long createReview(ReviewRegistPostReq reviewRegistPostReq) throws Exception;

    List<Review> readReview(Long lesson_id, int offset, int limit) throws LessonException;

    List<Review> readMyReview(String email, int offset, int limit) throws UserException;

    Long countReview(Long lesson_id);

    Long countMyReview(String email);

    void updateReview(ReviewUpdatePutReq reviewUpdatePutReq) throws ReviewException;

    void deleteReview(Long id) throws ReviewException;

}
