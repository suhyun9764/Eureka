package com.bookmanager_springmvc.service;

import com.bookmanager_springmvc.controller.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<BookDto> getBookList();
}
