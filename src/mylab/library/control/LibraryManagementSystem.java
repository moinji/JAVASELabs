package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library lib = new Library();

		lib.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-99-01-12345-6", 2019));

		lib.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "979-99-01-67990-01", 2015));

		lib.addBook(new Book("Clean Code", "Robert.C.Martin", "979-0-13-235088-4", 2022));

		lib.addBook(new Book("Effective Java", "Joshua Blochi", "978-0--13-468599-1", 2008));

		lib.addBook(new Book("Head First Java", "Kathy sierra", "978-0-596-00920-5", 2005));

		lib.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));

		System.out.println("------�߾� ������------");
		System.out.println("��ü ���� ��: " + lib.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + lib.getAvailuableBooks());
		System.out.println("���� ���� ���� ��: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));

		System.out.println("------���� �˻� �׽�Ʈ------");
		System.out.println("�������� �˻� ���:");
		System.out.println(lib.findByTitle("�ڹ��� ����"));
		System.out.println("���ڷ� �˻� ���:");
		System.out.println(lib.findByAuthor("Robert.C.Martin"));

		System.out.println("------���� ���� �׽�Ʈ------");
		lib.checkOutBook("978-89-01-14077-4");
		System.out.println("����� ���� ����:");
		System.out.println(lib.findByISBN("978-89-01-14077-4"));
		
		System.out.println("��ü ���� ��: " + lib.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + lib.getAvailuableBooks());
		System.out.println("���� ���� ���� ��: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));
		
		System.out.println("------���� �ݳ� �׽�Ʈ------");
		lib.returnBook("978-89-01-14077-4");
		System.out.println("����� ���� ����:");
		System.out.println(lib.findByISBN("978-89-01-14077-4"));
		
		System.out.println("��ü ���� ��: " + lib.getTotalBooks());
		System.out.println("���� ���� ���� ��: " + lib.getAvailuableBooks());
		System.out.println("���� ���� ���� ��: " + (lib.getTotalBooks() - lib.getAvailuableBooks()));
		
		System.out.println("------���� ������ ���� ���------");
		for (Book book : lib.getAvailable()) {
		    System.out.println(book);
		    System.out.println("---------------------------");
		}
	}
}
