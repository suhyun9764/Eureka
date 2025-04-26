package com.springboot.springbootbasic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*") // 이 controller가 처리하는 모든 요청에 대해서 CORS에 필요한 Header를 내려줌
// Get, Post : 가장 일반적으로 백엔드가 이 요청을 지원하는 지 여부 확인 없이 바로 요청
// Put, Delete : 이전에 사용하지 않던 요청, 일반적이지 않은 요청, 백엔드가 이 요청을 지원하는 지 확인 (Options 요청 <= pre-fligth)

//@CrossOrigin(
//		origins = "http://127.0.0.1:5500/",
//		allowCredentials="true",
//		allowedHeaders="*",
//		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD}
//)

public class CorsController {
	@GetMapping("/cors")
	public Map<String, String> getCors(@RequestParam("param") String param){
		System.out.println("get : "+param);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	@PostMapping("/cors")
	public Map<String, String> postCors(@RequestParam("param") String param){
		System.out.println("get : " + param);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	@PutMapping("/cors/{num}")
	public Map<String, String> putCors(@PathVariable("num") int num){
		System.out.println("put : " + num);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	@DeleteMapping("/cors/{num}")
	public Map<String, String> deleteCors(@PathVariable("num") int num){
		System.out.println("delete : " + num);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
}