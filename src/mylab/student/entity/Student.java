package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {

	private String studentId;
	private String name;
	private String major;
	private int grade;

	public Student() {
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		this.grade=grade;
	}
	

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) throws InvalidGradeException{
		if(grade>4 || 1>grade) {
			String errMessage = String.format("�г��� 1~4 ���̿��� �մϴ�.", grade);
			throw new InvalidGradeException(errMessage);
		}
		this.grade = grade;
	}
}
