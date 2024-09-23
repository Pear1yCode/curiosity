package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMenu {

    Scanner sc = new Scanner(System.in);
        // BookMenu 기본생성자
        public BookMenu() {};

        public void menu() {

        }

        public BookDTO inputBook() {
                BookDTO book = new BookDTO();
                book.setbNo((int) (Math.random() * 100) + 1);
                System.out.println("책 제목 입력");
                book.setTitle(sc.nextLine());
                while (true) {
                System.out.println("책 카테고리 번호 입력 1. 인문, 2. 자연과학, 3. 의료, 4. 기타");
                int Cate = sc.nextInt();
                if (Cate == 1 || Cate == 2 || Cate == 3 || Cate == 4) {
                    book.setCategory(Cate);
                    break;  // while문 안에 if를 넣을 때는 꼭 필요할 것이다.
                } else {
                    System.out.println("1번부터 4번까지만 입력 가능합니다.");
                    continue;  // 마찬가지 (생략가능)
                }
                }
                sc.nextLine();
                System.out.println("저자 입력");
                book.setAuthor(sc.nextLine());

                return book;
        }

    public String inputBookTitle() {
        System.out.println("검색할 도서제목을 입력해주세요.");
        return sc.nextLine();
    }
}
