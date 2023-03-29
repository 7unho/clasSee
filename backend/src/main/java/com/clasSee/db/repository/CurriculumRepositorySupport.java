package com.clasSee.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.clasSee.db.entity.lesson.Curriculum;
import com.clasSee.db.entity.lesson.QCurriculum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional
public class CurriculumRepositorySupport {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
    QCurriculum qCurriculum = QCurriculum.curriculum;

    // 유저를 넣으면 유저를 DB에 저장
    public void save(Curriculum curriculum){
        em.persist(curriculum);
    }

    public void update(Curriculum curriculum) {
        jpaQueryFactory.
                update(qCurriculum)
                .where(qCurriculum.id.eq(curriculum.getId()))
                .set(qCurriculum.description, curriculum.getDescription())
                .set(qCurriculum.stage, curriculum.getStage())
                .execute();

        em.clear();
        em.flush();
    }

    public void delete(Long lessonId) {
        jpaQueryFactory.delete(qCurriculum)
                .where(qCurriculum.lessonId.eq((lessonId))).execute();
    }
}