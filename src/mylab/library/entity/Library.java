package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> books;

	public Library() {
		books = new ArrayList();
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: "+book.getTitle());
	}

	public Book findByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}

	public Book findByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equalsIgnoreCase(author)) {
				return book;
			}
		}
		return null;
	}

	public Book findByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equalsIgnoreCase(isbn)) {
				return book;
			}
		}
		return null;
	}

	public boolean checkOutBook(String isbn) {
		Book book = findByISBN(isbn);
		if (book != null && book.getIsAvailable()) {
			book.setIsAvailable(false);
			System.out.println("도서 대출 성공");
			return true;
		}
		System.out.println("도서 대출 실패");
		return false;
	}

	public boolean returnBook(String isbn) {
		Book book = findByISBN(isbn);
		if (book != null && !book.getIsAvailable()) {
			book.setIsAvailable(true);
			System.out.println("도서 반납 성공");
			return false;
		}
		System.out.println("도서 반납 실패");
		return true;
	}

	public List<Book> getAllBooks() {
		return new ArrayList<>(books);
	}

	public List<Book> getAvailable() {
		List<Book> available = new ArrayList<>();
		for (Book book : books) {
			if (book.getIsAvailable()) {
				available.add(book);
			}
		}
		return available;
	}

	public int getTotalBooks() {
		return books.size();
	}

	public int getAvailuableBooks() {
		return getAvailable().size();
	}
}
