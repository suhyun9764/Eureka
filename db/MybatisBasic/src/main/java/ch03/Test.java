package ch03;

import ch03.dto.BookDto;
import ch03.config.MyBatisConfig;
import ch03.dao.BookDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

// 1. myBatis 의존성 추가
// 2. myBatis 설정( xml, java )
// 3. mysql jdbc driver 의존성 추가
// 4. 위 설정한 mybatis_xml 문서를 mybatis library가 읽어서 처리하도록 코드 작성

// mybatis는 SQlSession을 통해서 db와 연동

// ch02는 xml mapper 사용 x, Dao에 annotation으로 대체 <= config.xml 변경

// ch03은 xml 설정파일을 java 클래스로 대체
public class Test {
    public static void main(String[] args) throws IOException {
        // mybatis 설정 파일을 읽고 정보는 저장하는 reader객체 생성
        // SqlSessionFactory를 Builder패턴으로 생성
        MyBatisConfig myBatisConfig = new MyBatisConfig();
        SqlSessionFactory sqlSessionFactory = myBatisConfig.getSqlSessionFactory();
        // SqlSession객체를 Factory 패턴으로 생성
        SqlSession session = sqlSessionFactory.openSession();
        BookDao bookDao = session.getMapper(BookDao.class);
        // mybatis로 db연동 작업 진행
        // 목록
//        {
//            // BookDao 클래스 정보를 sqlsession 객첻에 전달
//
//            List<BookDto> bookList = bookDao.listBook();
//            for (BookDto bookDto : bookList) {
//                System.out.println(bookDto);
//            }
//        }
//        {
//            BookDto bookDto =  bookDao.detailBook(1);
//            System.out.println(bookDto);
//        }

        // 등록
//        {
//            BookDto bookDto = new BookDto(11,"11번째 책","11 출판사", 20000);
//            int ret = bookDao.insertBook(bookDto);
//            System.out.println(ret);
//            session.commit();
//        }

        // 수정
//        {
//            BookDto bookDto = new BookDto(11,"11번째 책 수정","11 출판사 수정", 30000);
//            int ret = bookDao.updateBook(bookDto);
//            System.out.println(ret);
//            session.commit();
//        }

//        // 삭제
//        {
//            int ret = bookDao.deleteBook(11);
//            System.out.println(ret);
//            session.commit();
//        }
        session.close();
    }
}
