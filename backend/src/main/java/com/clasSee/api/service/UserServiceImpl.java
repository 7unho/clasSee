package com.clasSee.api.service;

import com.clasSee.api.dto.UserEmailPwDto;
import com.clasSee.api.request.UserFindPwPostReq;
import com.clasSee.common.exception.handler.UserException;
import com.clasSee.db.entity.user.Auth;
import com.clasSee.db.entity.user.UserType;
import com.clasSee.db.repository.AuthRepository;
import com.clasSee.db.repository.AuthRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasSee.db.entity.user.User;
import com.clasSee.db.repository.UserRepository;
import com.clasSee.db.repository.UserRepositorySupport;

import java.util.Map;
import java.util.Optional;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	AuthRepositorySupport authRepositorySupport;

	@Autowired
	AuthRepository authRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRepositorySupport userRepositorySupport;


	/*
		회원 가입 요청 request의 정보를 통해 진행
		AUTH, USER 테이블에 데이터 삽입을 위해 Map<String, Object> 객체에 "AUTH", "USER"로 객체 전달받음

		[AUTH] PasswordEncoder를 통해 비밀번호 암호화 후 DB에 save
		[USER] auth객체의 auth_id를 받아 저장 후 DB에 save
	*/
	@Override
	public void createUser(Map<String, Object> userRegisterInfo) {
		Auth auth = (Auth) userRegisterInfo.get("AUTH");
		if(auth.getType() != UserType.KAKAO) auth.setPassword(auth.getPassword());
		authRepositorySupport.save(auth);

		User user = (User) userRegisterInfo.get("USER");
		user.setAuth(auth);
		userRepositorySupport.save(user);
	}

	@Override
	public User getUserByAuth(String email) {
		// 디비에 유저 정보 조회 (email을 통한 조회).

		User user = User.builder().build();

		if(userRepositorySupport.findUserByAuth(email).isPresent()){
			user = userRepositorySupport.findUserByAuth(email).get();
		} else{
			user = userRepositorySupport.findUserByAuth(email).orElse(null);
		}
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

	@Override
	public void updatePassword(UserEmailPwDto userInfo) {
		String email = userInfo.getEmail();
		String password = userInfo.getPassword();
		userRepository.updatePassword(email, password);
	}

	// 유저 닉네임, 비밀번호, 전화번호, 주소, 소개 업데이트 시작
	@Override
	public void updateUserNickname(String email, String nickname) throws UserException {

		if(userRepositorySupport.findId(email) == null){
			throw new UserException("user not found");
		}

		userRepositorySupport.updateNickname(email, nickname);
	}

	@Override
	public void updateUserPhone(String email, String phone) throws UserException {

		if(userRepositorySupport.findId(email) == null){
			throw new UserException("user not found");
		}

		userRepositorySupport.updatePhone(email, phone);
	}

	@Override
	public void updateUserAddress(String email, String address) throws UserException {

		if(userRepositorySupport.findId(email) == null){
			throw new UserException("user not found");
		}

		userRepositorySupport.updateAddress(email, address);
	}

	@Override
	public void updateUserDescription(String email, String description) throws UserException {

		if(userRepositorySupport.findId(email) == null){
			throw new UserException("user not found");
		}

		userRepositorySupport.updateDescription(email, description);
	}

	@Override
	public void updateUserImg(String email, String img) throws UserException {

		if(userRepositorySupport.findId(email) == null){
			throw new UserException("user not found");
		}

		userRepositorySupport.updateImg(email, img);
	}

	// 유저 닉네임, 비밀번호, 전화번호, 주소, 소개 업데이트 끝

	@Override
	public void deleteUser(String email) throws UserException {
		Long userId = userRepositorySupport.findId(email);

		if(userId == null){
			throw new UserException("user not found");
		}

		User user = userRepositorySupport.findOne(userId);
		userRepositorySupport.delete(user);
	}

}
