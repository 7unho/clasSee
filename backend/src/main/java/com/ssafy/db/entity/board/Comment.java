package com.ssafy.db.entity.board;

import com.ssafy.db.entity.user.User;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/*
* member : comment = 1 : N
* article : comment = 1 : N
* comment : comment = 1 : N
*/
@Entity
@Getter
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private Long step;
    private Long level;

    private String content;

    @CreatedDate
    @Column(name = "regtime")
    private Timestamp regtime;

    // 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
