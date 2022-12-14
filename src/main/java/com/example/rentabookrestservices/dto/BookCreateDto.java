package com.example.rentabookrestservices.dto;

public class BookCreateDto {
    private String isbn;
    private String name;
    private String author;
    private int publishYear;
    private int pages;
    private BookPriceCreateDto bookPriceCreateDto;

    public BookCreateDto(String isbn, String name, String author, int publishYear, int pages, BookPriceCreateDto bookPriceCreateDto) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
        this.bookPriceCreateDto = bookPriceCreateDto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookPriceCreateDto getBookPriceCreateDto() {
        return bookPriceCreateDto;
    }

    public void setBookPriceCreateDto(BookPriceCreateDto bookPriceCreateDto) {
        this.bookPriceCreateDto = bookPriceCreateDto;
    }
}
