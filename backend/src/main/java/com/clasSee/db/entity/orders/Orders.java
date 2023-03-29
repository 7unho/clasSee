package com.clasSee.db.entity.orders;

import com.clasSee.db.entity.lesson.OpenLesson;
import com.clasSee.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
*  orders : member = 1 : N
*  orders : open_lesson = 1 : N
*  orders : payment = 1 : N
*/
@Entity
@Getter
@Table(name = "ORDERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "regtime")
    private LocalDateTime regTime;

    private String phone;
    private String email;
    private String address;

    private Long price;

    // 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "open_lesson_id")
    private OpenLesson openLesson;

}
