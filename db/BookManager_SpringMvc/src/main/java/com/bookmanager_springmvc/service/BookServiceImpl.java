package com.bookmanager_springmvc.service;

import com.bookmanager_springmvc.controller.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Override
    public List<BookDto> getBookList() {
        return List.of();
    }
}
