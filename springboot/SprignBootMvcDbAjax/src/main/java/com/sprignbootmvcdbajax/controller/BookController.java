package com.sprignbootmvcdbajax.controller;

import com.sprignbootmvcdbajax.dto.BookDto;
import com.sprignbootmvcdbajax.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
// @ResponseBody bookMain() 는 jsp 로 분기되어야 한다.
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // index.html 의 도서 관리 링크 대응
    // books.jsp 로 이동
    @GetMapping(value="/")
    public String bookMain() {
        return "books";
    }

    // 목록 : /books/list,   get,  X,       list.jsp
    @GetMapping(value="/list")
    @ResponseBody
    public List<BookDto> listBook() {
        List<BookDto> bookList = bookService.listBook();
        return bookList;
    }

    // 상세 : /books/detail, get,  bookId,  detailForm.jsp  // /books/detail/9 path variable
    @GetMapping(value="/detail/{bookId}")
    @ResponseBody
    public BookDto detailBook(@PathVariable int bookId) {
        System.out.println(bookId);
        BookDto bookDto = bookService.detailBook(bookId);
        return bookDto;
    }

    // 등록 : /books/insert, post, BookDto, insertResult.jsp
    @PostMapping(value="/insert")
    @ResponseBody
    public int insertBook(BookDto bookDto) {
        System.out.println(bookDto);
        int ret = bookService.insertBook(bookDto);
        System.out.println(ret);
        return ret;
    }

    // 수정 : /books/update, post, BookDto, updateResult.jsp
    @PostMapping(value="/update")
    @ResponseBody
    public int updateBook(BookDto bookDto) {
        System.out.println(bookDto);
        int ret = bookService.updateBook(bookDto);
        System.out.println(ret);
        return ret;
    }
    // 삭제 : /books/delete, get,  bookId,  deleteResult.jsp
    @GetMapping(value="/delete/{bookId}")
    @ResponseBody
    public int deleteBook(@PathVariable int bookId) {
        System.out.println(bookId);
        int ret = bookService.deleteBook(bookId);
        return ret;
    }

    // insertForm.jsp 는 삭제
}












