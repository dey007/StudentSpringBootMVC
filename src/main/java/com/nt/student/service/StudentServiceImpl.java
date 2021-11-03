package com.nt.student.service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nt.student.model.Student;
import com.nt.student.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private Environment env;
	
	
	@Override
	public String insertStudent(Student student) {
		int stdId = repo.save(student).getId();
		return "Student data inserted with id :"+stdId;
	}


	@Override
	public Iterable<Student> getAllStudents() {
		return repo.findAll();
	}


	@Override
	public Student getStudentById(int id) {
		return repo.getById(id);
	}


	@Override
	public String updateStudent(Student std) {
		return "Student updated with id :"+repo.save(std).getId();
	}


	@Override
	public String removeStudent(int id) {
		repo.deleteById(id);
		return "Student removed from the portal with id :"+id;
	}


	@Override
	public Set<String> countryList() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet<String>();
		for(Locale locale:locales) {
			countries.add(locale.getDisplayCountry());
		}
		return countries;
	}


	@Override
	public Set<String> getLanguages() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> langs = new TreeSet<String>();
		for(Locale locale:locales) {
			langs.add(locale.getDisplayLanguage());
		}
		return langs;
	}


	@Override
	public List<String> getStatesByCountry(String country) {
		String stateInfo = env.getRequiredProperty(country);
		System.out.println(stateInfo);
		return Arrays.asList(stateInfo.split(","));
	}

}
