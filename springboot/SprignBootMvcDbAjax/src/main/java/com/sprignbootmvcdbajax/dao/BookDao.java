package com.sprignbootmvcdbajax.dao;


import com.sprignbootmvcdbajax.dto.BookDto;

import java.util.List;

public interface BookDao {
    int insertBook(BookDto book);
    int updateBook(BookDto book);
    int deleteBook(int bookId);
    List<BookDto> listBook();
    BookDto detailBook(int bookid);
}
