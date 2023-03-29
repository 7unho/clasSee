package com.clasSee.db.entity.qna;

import com.clasSee.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
*  member : Qna = 1 : N
*/
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "QNA")
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Column(name = "regtime")
    private String regTime;

    // 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "qna", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private QnaAnswer qnaAnswer;
}
