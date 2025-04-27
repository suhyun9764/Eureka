package com.mycom.myapp.auth.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.auth.service.LoginService;
import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class LoginController {

	private final LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	// LoginResultDto 대신 Map<String, String> 사용
	// login 성공하면 session 에 사용자 정보인 userDto 를 담는다. 
	@PostMapping("/login")
	@ResponseBody
	public Map<String, String> login(UserDto userDto, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		
		Optional<UserDto> optional = loginService.login(userDto);
		
		if( optional.isPresent() ) { // 로그인 성공 
			UserDto dto = optional.get();
			session.setAttribute("userDto", dto); // session timeout 30분 
			
			map.put("result", "success");
			return map;
		}
		
		// 로그인 실패
		map.put("result", "fail");
		return map;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
