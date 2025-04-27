package ch01.dao;

import ch01.dto.BookDto;

import java.awt.print.Book;
import java.util.List;

public interface BookDao {
    // 5가지 기능
    List<BookDto> listBook();
    BookDto detailBook(int bookId);
    int insertBook(BookDto bookDto);
    int updateBook(BookDto bookDto);
    int deleteBook(int bookId);
}
