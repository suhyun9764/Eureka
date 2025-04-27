package ch02.dao;

import ch02.dto.BookDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    // 5가지 기능
    @Select("select bookid bookId, bookname bookName, publisher, price from book")
    List<BookDto> listBook();
    @Select("select bookid bookId, bookname bookName, publisher, price\n" +
            "        from book\n" +
            "        where bookid = #{bookid}")
    BookDto detailBook(int bookId);
    @Insert("  insert into book (bookid, bookname, publisher, price)\n" +
            "            values( #{bookId}, #{bookName}, #{publisher}, #{price})")
    int insertBook(BookDto bookDto);
    @Update("update book\n" +
            "            set bookname = #{bookName},\n" +
            "                publisher = #{publisher},\n" +
            "                price = #{price}\n" +
            "            where bookId = #{bookId}")
    int updateBook(BookDto bookDto);
    @Delete("delete from book where bookid = #{bookId}")
    int deleteBook(int bookId);
}
