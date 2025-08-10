package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library lib = new Library();

		lib.addBook(new Book("자바 프로그래밍", "김자바", "978-99-01-12345-6", 2019));

		lib.addBook(new Book("객체지향의 사실과 오해", "조영호", "979-99-01-67990-01", 2015));

		lib.addBook(new Book("Clean Code", "Robert.C.Martin", "979-0-13-235088-4", 2022));

		lib.addBook(new Book("Effective Java", "Joshua Blochi", "978-0--13-468599-1", 2008));

		lib.addBook(new Book("Head First Java", "Kathy sierra", "978-0-596-00920-5", 2005));

		lib.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));

		System.out.println("------중앙 도서관------");
		System.out.println("전체 도서 수: " + lib.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + lib.getAvailuableBooks());
		System.out.println("대출 중인 도서 수: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));

		System.out.println("------도서 검색 테스트------");
		System.out.println("제목으로 검색 결과:");
		System.out.println(lib.findByTitle("자바의 정석"));
		System.out.println("저자로 검색 결과:");
		System.out.println(lib.findByAuthor("Robert.C.Martin"));

		System.out.println("------도서 대출 테스트------");
		lib.checkOutBook("978-89-01-14077-4");
		System.out.println("대출된 도서 정보:");
		System.out.println(lib.findByISBN("978-89-01-14077-4"));
		
		System.out.println("전체 도서 수: " + lib.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + lib.getAvailuableBooks());
		System.out.println("대출 중인 도서 수: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));
		
		System.out.println("------도서 반납 테스트------");
		lib.returnBook("978-89-01-14077-4");
		System.out.println("대출된 도서 정보:");
		System.out.println(lib.findByISBN("978-89-01-14077-4"));
		
		System.out.println("전체 도서 수: " + lib.getTotalBooks());
		System.out.println("대출 가능 도서 수: " + lib.getAvailuableBooks());
		System.out.println("대출 중인 도서 수: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));
		
		System.out.println("------대출 가능한 도서 목록------");
		for (Book book : lib.getAvailable()) {
		    System.out.println(book);
		    System.out.println("---------------------------");
		}
	}
}
