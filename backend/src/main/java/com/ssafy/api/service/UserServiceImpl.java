package com.ssafy.api.service;

import com.ssafy.api.request.UserFindPwPostReq;
import com.ssafy.db.entity.user.Auth;
import com.ssafy.db.repository.AuthRepository;
import com.ssafy.db.repository.AuthRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.user.User;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

import java.util.Map;
import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	AuthRepository authRepository;
	@Autowired
	AuthRepositorySupport authRepositorySupport;

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRepositorySupport userRepositorySupport;

	@Autowired
	PasswordEncoder passwordEncoder;

	/*
		회원 가입 요청 request의 정보를 통해 진행
		AUTH, USER 테이블에 데이터 삽입을 위해 Map<String, Object> 객체에 "AUTH", "USER"로 객체 전달받음

		[AUTH] PasswordEncoder를 통해 비밀번호 암호화 후 DB에 save
		[USER] auth객체의 auth_id를 받아 저장 후 DB에 save
	*/
	@Override
	public void createUser(Map<String, Object> userRegisterInfo) {
		Auth auth = (Auth) userRegisterInfo.get("AUTH");
		auth.setPassword(passwordEncoder.encode(auth.getPassword()));
		authRepositorySupport.save(auth);

		User user = (User) userRegisterInfo.get("USER");
		user.setAuth(auth);
		userRepositorySupport.save(user);
	}

	@Override
	public User getUserByAuth(String email) {
		// 디비에 유저 정보 조회 (email을 통한 조회).
		User user = userRepositorySupport.findUserByAuth(email).get();
		return user;
	}

	@Override
	public User getUserByNickname(String nickname)  {
		// 닉네임으로 유저 정보 조회
		User user = new User();

		if(userRepositorySupport.findByNickname(nickname).isPresent()){
			user = userRepositorySupport.findByNickname(nickname).get();
		} else{
			user = userRepositorySupport.findByNickname(nickname).orElse(null);
		}
		return user;
	}

	@Override
	public Optional<Auth> getUserByEmailAndName(UserFindPwPostReq userInfo) {
		String email = userInfo.getEmail();
		String name = userInfo.getName();
		return userRepository.findUserByEmailAndName(email, name);
	}
}
