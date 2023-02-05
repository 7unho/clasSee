package com.ssafy.api.response;

import com.ssafy.db.entity.lesson.Review;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@ApiModel("ReviewListGetRes")
public class ReviewListGetRes {

    Long id;
    String title;
    String content;
    Timestamp regtime;
    String img;
    Long score;
    String user_nickname;
    String user_img;

    public ReviewListGetRes(Review review){

        this.id = review.getId();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.regtime = review.getRegtime();
        this.img = review.getImg();
        this.score = review.getScore();
        this.user_nickname = review.getUser().getNickname();
        this.user_img = review.getUser().getImg();

    }


}
