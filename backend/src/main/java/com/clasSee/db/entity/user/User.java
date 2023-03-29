package com.clasSee.db.entity.user;

import com.clasSee.db.entity.board.Likes;
import com.clasSee.db.entity.board.Notice;
import com.clasSee.db.entity.qna.Qna;
import com.clasSee.db.entity.board.Article;
import com.clasSee.db.entity.board.Photocard;
import com.clasSee.db.entity.lesson.Lesson;
import com.clasSee.db.entity.lesson.Review;
import com.clasSee.db.entity.orders.Orders;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Builder
@Entity
@Table(name = "USER")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private String address;
    private LocalDate birth;
    private String phone;
    private Long point;
    private String img;
    private String description;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String createdAt;

    // 연결
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id")
    private Auth auth;

    @OneToMany(mappedBy = "targetUserEmail")
    private List<Notification> targetUserList = new ArrayList<>();

    @OneToMany(mappedBy = "sendUserEmail")
    private List<Notification> sendMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Lesson> lessonList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Bookmark> bookmarkList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photocard> photocardList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Article> articleList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Qna> qnaList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Orders> ordersList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Notice> noticeList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likesList = new ArrayList<>();

}
