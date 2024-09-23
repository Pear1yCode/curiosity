package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.model.comparator.AscCategory;
import com.ohgiraffers.hw1.model.comparator.DescCategory;
import com.ohgiraffers.hw1.model.dto.BookDTO;
import com.ohgiraffers.hw1.view.BookMenu;

import java.util.*;

public class BookManager {
    Scanner sc = new Scanner(System.in);
    private ArrayList<BookDTO> bookList;

    public BookManager() {
//        ArrayList<BookDTO> bookList = new ArrayList<>(); 지역변수에만 담기는 문제
        bookList = new ArrayList<>(); // 이렇게 해야 booklist에 null로 담기지 않는다고함
    };


// inputbook을 굳이 여기서 연결할 필요없고(연결하기가 어렵다? 만든 객체를 가져와야하는?) 메인메소드에서 합치면 되는 것 같다.
public void addBook(BookDTO book) {
    bookList.add(book);
    int bNo = bookList.size();
    if (bookList.size() != 0) {
        book.setbNo(bNo);
    } else {
        System.out.println("책이 없음");
    }
}
public ArrayList<BookDTO> getBookList() {
    return bookList;
}

public void deleteBook(int index){
    if(bookList.size() == 0) {
        System.out.println("책이 없습니다.");
    } else {
        bookList.remove(index);
    }
}

public void searchBook(String title){
    BookMenu bm = new BookMenu();
    String searchTitle = bm.inputBookTitle(); // 제목을 inputBookTitle에서 받고 String searchTitle에 저장한 상태
    BookDTO searchBook = new BookDTO(); // 비교를 위한 책 객체 생성
    searchBook.setTitle(searchTitle); // 생성한 객체에 책 이름을 저장해주어 이름 비교용 책 객체의 이름 변경
    int index = bookList.indexOf(searchBook); // indexOf의 내부에는 객체가 들어가야해서 searchTitle은 적절하지 못함
    if (index != -1) {
        System.out.println(bookList.get(index));
    } else {
        System.out.println("책이 없습니다.");
    }
}

public void printBook(int index){
    BookMenu bm = new BookMenu();
    searchBook(bm.inputBookTitle()); // String title이라는 변수가 있기 때문에 괄호 안에 title에 대한 내용이 들어와야 한다.
}       //   여기서 책의 이름을 입력받는 inputBookTitle 메소드를 넣어보았다.
       //  메소드 선언시 나오는 소괄호 안 변수의 용도가 조금 이해가 갔다.
      //  일단 사용 목적은 메소드 내부가 아닌 메소드 외부에서 메소드 호출 시 메소드 호출 후 괄호 안에 값을 넣을 때 그 변수로 제한하는? 느낌이 강하다.
     //  사실 아직 활용할 정도의 익힘이 아니지만 약간 이해가 됐기에 조금씩 사용해볼 수 있는 경우 사용해보도록 하겠다.

public void displayAll(){
    // 배열의 전체를 불러오는 방법은 Iterator (배운 부분)를 사용해야 한다.
    /* 방법
    * 1. For Loop (for 문)
    * 2. Advanced For Loop (상급 for 문)
    * 3. Iterator
    * 4. While Loop
    * 5. Collection's stream() util
    * 이 있다고 구글링해본결과 알 수 있었다.
    */
    // 복습을 위해 Iterator를 사용해보았다. (현재 이해가 잘 안된 부분이지만 사용하면서 이해해보겠다.)
//    bookList = new LinkedList<>(bookList); // 일단 이렇게 객체를 만드는 것 같다? 의미를 잘 모르겠다 아직 (그저 객체를 만들었다? 정도)
//    // => 객체를 만들었다기보다 형변환? ArrayList로 만들어졌던 bookList를 형변환해준 느낌?
    // => 여기서는 변수를 넣은 메소드가 많아서 그런지? 성립되지 않아 ArrayList로 그냥 쓰게 됐다.
//    Iterator<String> bookIter = ((LinkedList<String>) bookList). descendingIterator();
    if (bookList.size() == 0) {
        System.out.println("출력할 도서가 없습니다.");
    } else {
        Iterator<BookDTO> bookIter = bookList.iterator();
        while (bookIter.hasNext()) {
            System.out.println(bookIter.next());
        }
    }
    // 이게맞나?

    // 책 전체의 정보가 나오는 로직이 필요할까?
}

public ArrayList<BookDTO> sortedBookList(int select){
    if (select == 1) {
        AscCategory ac = new AscCategory();
        bookList.sort(new AscCategory());
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    } else if (select == 2) {
        DescCategory dc = new DescCategory();
        bookList.sort(new DescCategory());
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    } else {
        System.out.println("번호를 잘못입력하였습니다.");
    }
    return bookList;
}

public void printBookList(ArrayList<BookDTO> br) {
    for (BookDTO book : br) {
        System.out.println(book);
    }
}
}
