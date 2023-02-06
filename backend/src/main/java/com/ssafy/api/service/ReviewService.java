package com.ssafy.api.service;

import com.ssafy.api.request.ReviewRegistPostReq;
import com.ssafy.api.request.ReviewUpdatePutReq;
import com.ssafy.db.entity.lesson.Review;

import java.util.List;

public interface ReviewService {

    void createReview(ReviewRegistPostReq reviewRegistPostReq);

    List<Review> readReview(Long lesson_id, int offset, int limit);

    Long countReview();

    void updateReview(ReviewUpdatePutReq reviewUpdatePutReq);

    void deleteReview(Long id);

}
