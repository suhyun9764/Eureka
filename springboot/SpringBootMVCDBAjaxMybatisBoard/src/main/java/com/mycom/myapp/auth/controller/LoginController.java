package com.mycom.myapp.auth.controller;

import com.mycom.myapp.auth.service.LoginService;
import com.mycom.myapp.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // login 성공하면 session에 userDto 담는다
    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(UserDto userDto, HttpSession session){
        Map<String,String> map = new HashMap<>();
        Optional<UserDto> optional = loginService.login(userDto);
        if(optional.isPresent()){
            UserDto dto = optional.get();
            session.setAttribute("userDto", dto);

            map.put("result","success");
            return map;
        }
        map.put("result","fail");
        return map;
    }
}
