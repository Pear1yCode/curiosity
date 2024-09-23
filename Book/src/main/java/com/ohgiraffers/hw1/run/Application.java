package com.ohgiraffers.hw1.run;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import com.ohgiraffers.hw1.view.BookMenu;

import java.util.Comparator;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDTO book = new BookDTO();
        BookMenu bm = new BookMenu();
        BookManager bmm = new BookManager();

        while (true) {

        System.out.println(" *** 도서 관리 프로그램 ");
        System.out.println(" 1. 새 도서 추가");
        System.out.println(" 2. 도서정보 정렬 후 출력 ");
        System.out.println(" 3. 도서 삭제 ");
        System.out.println(" 4. 도서 검색출력 ");
        System.out.println(" 5. 전체 출력 ");
        System.out.println(" 6. 끝내기 ");

        System.out.println(" 입력할 명령의 번호를 입력해주세요.");
        int Number = sc.nextInt();

        switch (Number) {
            case 1 : bmm.addBook(bm.inputBook());
            break;

            case 2 :
                System.out.println("정렬 방식 입력 1. 오름차순, 2. 내림차순");
                int sortNum = sc.nextInt();
                if (sortNum == 1) {
//                bmm.sortedBookList(1);
                    bmm.printBookList(bmm.sortedBookList(1));
                } else if (sortNum == 2) {
//                bmm.sortedBookList(2);
                bmm.printBookList(bmm.sortedBookList(2));
            } else {
                    System.out.println("1. 오름차순, 2. 내림차순 중 한가지 번호를 입력바랍니다.");
                }
                break;
            case 3 :
                System.out.println("제거할 책의 번호를 입력하세요.");
                int deleteNum = sc.nextInt();
                bmm.deleteBook(deleteNum - 1);
                break;
            case 4 :
                String bookName = sc.nextLine();
                bmm.searchBook(bookName);
                break;
            case 5 :
                bmm.displayAll();
                break;
            case 6 :
                bm.menu();
                break;
            }
        }
    }
}
