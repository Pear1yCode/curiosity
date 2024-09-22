package com.ohgiraffers.hw1.model.dto;

import java.util.Objects;

public class BookDTO {
    private int bNo;
    private int category;
    private String title;
    private String author;

    //  기본생성자
    public void BookDTO () {};

    // 3개의 필드 초기화 (매개변수 초기화 생성자)
    public void BookDTO (int category, String title, String author) {
        this.category = category;
        this.title = title;
        this.author = author;
    }

    // setter
    public void setbNo(int bNo) {
        this.bNo = bNo;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // getter
    public int getbBNo() {
        return bNo;
    }
    public int getCategory() {
        return category;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "책 정보{" +
                "책 번호 =" + bNo +
                ", ( 1. 인문, 2. 자연과학 3. 의료 4. 기타 ) 책 장르 =" + category +
                ", 책 제목 ='" + title + '\'' +
                ", 책 저자 ='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return bNo == bookDTO.bNo && category == bookDTO.category && Objects.equals(title, bookDTO.title) && Objects.equals(author, bookDTO.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bNo, category, title, author);
    }
}
