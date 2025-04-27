package com.bookmanager_springmvc.controller;

import com.bookmanager_springmvc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/list")
    public String getBookList(Model model){
        List<BookDto> bookDtoList = bookService.getBookList();
        model.addAttribute("bookList",bookDtoList);
        return "bookList";
    }
}
