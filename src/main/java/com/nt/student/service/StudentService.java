package com.nt.student.service;

import java.util.List;
import java.util.Set;

import com.nt.student.model.Student;

public interface StudentService {

	public String insertStudent(Student student);
	public Iterable<Student> getAllStudents();
	public Student getStudentById(int id);
	public String updateStudent(Student std);
	public String removeStudent(int id);
	public Set<String> countryList();
	public Set<String> getLanguages();
	public List<String> getStatesByCountry(String country);
}
