package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		Student student =new Student();
		
		student.setName("��μ�");
		student.setMajor("��ǻ�Ͱ���");
		try {
			student.setGrade(3);
		} catch (InvalidGradeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(student.getName()+"/"+student.getMajor()+"/"+student.getGrade()+"�г�");

		System.out.println("5�г����� ����");
		try {
			student.setGrade(5);
		} catch (InvalidGradeException e) {
		
			System.out.println(e.getMessage());
		}
		
		
	}
}
