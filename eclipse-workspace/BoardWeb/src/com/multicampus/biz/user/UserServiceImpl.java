package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 4. Service 구현 클래스
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO; // DB연동을 위한 객체 호출

	public void insertUser(UserVO vo) {
	
	}


	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}


	public void deleteUser(UserVO vo) {
		// TODO Auto-generated method stub

	}


	public UserVO getUser(UserVO vo) {
		// TODO Auto-generated method stub
		return userDAO.getUser(vo);
	}


	public List<UserVO> getUserList(UserVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
