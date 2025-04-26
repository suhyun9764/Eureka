package com.springbootmvc.controller;
// 다양한 url mapping을 다뤄본다

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UrlMappingController {

    @RequestMapping("/m1")  // get, post ... 가능
    public void m1(){
        System.out.println("/m1");
    }


    @RequestMapping(value="/m2", method = RequestMethod.GET)  // get
    public void m2(){
        System.out.println("/m2");
    }

    @RequestMapping(value="/m3", method = RequestMethod.POST)  // get
    public void m3(){
        System.out.println("/m3");
    }

    @GetMapping(value = "/m4")
    public void m4(){
        System.out.println("/m4");
    }

    @PostMapping(value = "/m5")
    public void m5(){
        System.out.println("/m5");
    }

    // path variable
    // client가 요청시 보내는 데이터는 기본적으로 parameter 사용
    // 대신 요청 ㅕ기의 일부에 포함시켜서 보낼 수도 있다. (REST API)

    // ../books?bookId = 8 <= parameter
    // ../books/7 <= path variable
    @GetMapping(value ="/book/{bookId}")
    public void m6(@PathVariable int bookId){
        System.out.println("/m7" + bookId);
    }

    // 목록 페이징 limit, offset
    @GetMapping(value = "/list/{limit}/and/{offset}")
    public void m7(@PathVariable int limit, @PathVariable int offset){

    }
}
