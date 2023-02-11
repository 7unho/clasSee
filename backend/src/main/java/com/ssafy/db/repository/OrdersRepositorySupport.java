package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.board.Photocard;
import com.ssafy.db.entity.lesson.*;
import com.ssafy.db.entity.orders.Orders;
import com.ssafy.db.entity.orders.QOrders;
import com.ssafy.db.entity.user.QUser;
import io.lettuce.core.api.push.PushListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersRepositorySupport {

    private final EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;

    QOrders qOrders  = QOrders.orders;

    QUser qUser = QUser.user;

    public void save(Orders orders) { em.persist(orders); }

    public void delete(Orders orders){ em.remove(orders); }

    public Orders findOne(Long id){ return em.find(Orders.class, id); }

    public Orders findOne(Long user_id, Long openLesson_id){
        Orders orders = jpaQueryFactory
                .selectFrom(qOrders)
                .where(qOrders.user.id.eq(user_id), qOrders.openLesson.id.eq(openLesson_id))
                .fetchOne();

        return orders;
    }

    public OpenLesson findOneOpenLesson(Long id){ return em.find(OpenLesson.class, id); }

    public Lesson findOneLesson(Long id){ return em.find(Lesson.class, id); }

    public List<Orders> findList(Long user_id, int offset, int limit) {
        return jpaQueryFactory
                .selectFrom(qOrders)
                .where(qOrders.user.id.eq(user_id))
                .orderBy(qOrders.id.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    public Long countOrders(Long user_id){
        return jpaQueryFactory.select(qOrders.count())
                .from(qOrders)
                .where(qOrders.user.id.eq(user_id))
                .fetchOne();
    }

    public void updatePoint(Long user_id, Long point){
        jpaQueryFactory
                .update(qUser)
                .where(qUser.id.eq(user_id))
                .set(qUser.point, qUser.point.add(point))
                .execute();

        em.clear();
        em.flush();
    }

    public void deleteOrders(Long ordersId){
        Orders orders = jpaQueryFactory
                .selectFrom(qOrders)
                .where(qOrders.id.eq(ordersId))
                .fetchOne();

        em.remove(orders);
    }

}
