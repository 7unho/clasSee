package com.clasSee.common.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.clasSee.api.service.UserService;
import com.clasSee.db.entity.user.User;


/**
 * 현재 액세스 토큰으로 부터 인증된 유저의 상세정보(활성화 여부, 만료, 롤 등) 관련 서비스 정의.
 */
@Component
public class ClasseeUserDetailService implements UserDetailsService{
	@Autowired
	UserService userService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    		User user = userService.getUserByAuth(username);
    		if(user != null) {
    			ClasseeUserDetails userDetails = new ClasseeUserDetails(user);
    			return userDetails;
    		}
    		return null;
    }
}
