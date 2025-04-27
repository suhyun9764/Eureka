package com.mycom.myapp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 개별 컨트롤러에서 처리하지 않는 예외
// 현재 srping Mvc + jsp + ajax 구조에서는 ajax처리 전담
// fetch data에 "result : exception" 응답
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,String> handlerException(Exception e){
        // Map 자료구조를 이용해서 result : success 포함 추가적인 정보를 전달하려면 Map 객체에 추가
        // Clinet는 적절한 조치를 취함
        Map<String, String> map = new HashMap<>();
        map.put("result","exception");
        return map;
    }
}
