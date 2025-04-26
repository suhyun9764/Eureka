package com.springboot.springbootbasic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springboot.springbootbasic.dto.CarDto;
import com.springboot.springbootbasic.dto.EmpDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


// Json 응답 Json 요청 처리
// 모든 응답을 Json으로 하는 경우라면
// @Controller
// @ResponseBody
// 페이지 요청 처리 못함, only 데이터 처리
@RestController // = @Controller + @ResponseBody
public class JSonController {
	@GetMapping("/string")
	public String m1() {
		System.out.println("/string");
		String str = "안녕하세요!";
		return str;
	}
	
	@GetMapping("/jsonstring")
	public String m2() {
		System.out.println("/jsonstring");
		String jsonStr = "\"result\":\"success\"";
		return jsonStr;
	}
	
	// JSP를 사용하지 않으므로 Client에서 필요한 데이터는 백엔드에서 내려주고 Client에서 적절한 저장하고, 이를 이용해서 화면 처리
	@GetMapping("/map")
	public Map<String, String> m3() {
		System.out.println("/map");
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		map.put("name", "문태신");
		map.put("role", "관리자");
		return map;
	}
	
	// dto
	@GetMapping("/dto")
	public CarDto m4() {
		System.out.println("/dto");
		CarDto carDto = new CarDto("타이칸", 200_000_000, "문태신");
		return carDto;
	}
	
	// dto
	@GetMapping("/listdto")
	public List<CarDto> m5() {
		System.out.println("/listdto");
		List<CarDto> list = new ArrayList<>();
		list.add(new CarDto("타이칸", 200_000_000, "문태신"));
		list.add(new CarDto("파나메라", 150_000_000, "고민정"));
		list.add(new CarDto("상자", 500, "감자"));
		return list;
	}
	
	// LocalDateTime 객체 json 리턴
	// Spring Default Json converter : jackson
	// jackson vs gson
	@GetMapping("/localdatetime")
	public LocalDateTime m6() {
		return LocalDateTime.now();
	}
	
	// http request에 json parameter 처리
	@PostMapping("/emp")
	public Map<String, String> m7(@RequestBody EmpDto empDto) {
		System.out.println("/emp");
		System.out.println(empDto);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	@PostMapping("/emplist")
	public Map<String, String> m8(@RequestBody List<EmpDto> empList) {
		System.out.println("/emplist");
		empList.forEach(empDto -> System.out.println(empDto));
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
}
