package com.clasSee.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.clasSee.db.entity.user.Auth;
import com.clasSee.db.entity.user.QAuth;
import com.clasSee.db.entity.user.QUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
@Repository
@RequiredArgsConstructor
@Transactional
public class AuthRepositorySupport {
    private final EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;
    QUser qUser = QUser.user;
    QAuth qAuth = QAuth.auth;

    public void save(Auth auth){
        em.persist(auth);
    }
}
