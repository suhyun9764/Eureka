package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dao.BookDao;
import dto.BookDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// book crud servlet
// mvc
// sub-url
@WebServlet("/books/*")
public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getRequestURI().substring(
                request.getContextPath().length()
        );

        switch (job){
            case "/books/list" : list(request,response); break;
            case "/books/detail" : detail(request,response); break;
            case "/books/insert" : insert(request,response); break;
            case "/books/update" : update(request,response); break;
            case "/books/delete" : delete(request,response); break;
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<BookDto> bookList = bookDao.listBook();
        System.out.println(bookList);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(bookList);
        response.getWriter().write(jsonStr);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDto book = bookDao.detailBook(bookId);
        System.out.println(book);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(book);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("name");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));
        int ret = bookDao.insertBook(new BookDto(bookId, bookName, publisher, price));
        System.out.println(ret);
        Gson gson = new Gson();
        JsonObject jsonObject = new   JsonObject();

        if (ret == 1) {
            jsonObject.addProperty("result", "success");
        } else {
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));
        BookDto bookDto = new BookDto(bookId, bookName, publisher, price);
        int ret = bookDao.updateBook(bookDto);

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (ret == 1) {
            jsonObject.addProperty("result", "success");
        } else {
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int ret = bookDao.deleteBook(bookId);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (ret == 1) {
            jsonObject.addProperty("result", "success");
        } else {
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
        response.getWriter().write(jsonStr);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
