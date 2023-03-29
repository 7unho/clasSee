package com.clasSee.db.repository;

import com.clasSee.db.entity.user.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * auth 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
}
