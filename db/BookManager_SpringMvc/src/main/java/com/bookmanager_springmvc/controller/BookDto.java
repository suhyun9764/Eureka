package com.bookmanager_springmvc.controller;

public class BookDto {
    private Long bookId;
    private String bookName;
    private String author;
    private String publisher;
    private int price;

    public BookDto(Long bookId, String bookName, String author, String publisher, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }
}
