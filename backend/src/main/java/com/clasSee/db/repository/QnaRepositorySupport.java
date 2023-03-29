package com.clasSee.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.clasSee.api.request.QnaUpdatePutReq;
import com.clasSee.db.entity.qna.QQna;
import com.clasSee.db.entity.qna.QQnaAnswer;
import com.clasSee.db.entity.qna.Qna;
import com.clasSee.db.entity.qna.QnaAnswer;
import com.clasSee.db.entity.user.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QnaRepositorySupport {

    private final EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;

    QQna qQna = QQna.qna;
    QQnaAnswer qQnaAnswer = QQnaAnswer.qnaAnswer;
    QUser qUser = QUser.user;

    public void save(Qna qna){ em.persist(qna); }

    public void saveAnswer(QnaAnswer qnaAnswer) { em.persist(qnaAnswer); }

    public void delete(Qna qna){ em.remove(qna); }

    public void deleteAnswer(QnaAnswer qnaAnswer) { em.remove(qnaAnswer); }

    public Qna findOne(Long id){ return em.find(Qna.class, id);}

    public QnaAnswer findOneAnswer(Long id) { return em.find(QnaAnswer.class, id); }

    public List<Qna> findAll(){
        return jpaQueryFactory
                .select(qQna)
                .from(qQna)
                .fetch();
    }

    public List<Qna> findList(int offset, int limit, Long user_id){
        return jpaQueryFactory
                .selectFrom(qQna)
                .where(qQna.user.id.eq(user_id))
                .orderBy(qQna.id.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    public Long QnaCount(){
        return jpaQueryFactory
                .select(qQna.count())
                .from(qQna)
                .fetchOne();
    }

    public void updateQna(QnaUpdatePutReq qnaUpdatePutReq){
        jpaQueryFactory
                .update(qQna)
                .where(qQna.id.eq(qnaUpdatePutReq.getId()))
                .set(qQna.title, qnaUpdatePutReq.getTitle())
                .set(qQna.content, qnaUpdatePutReq.getContent())
                .execute();

        em.clear();
        em.flush();
    }



}
