package com.nt.student.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.student.model.Student;

@Component
public class StudentValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student std = (Student) target;
		
		if(std.getName() == null || std.getName().isBlank()) {
			errors.rejectValue("name", "stu.name.mandatory");
		} else if(std.getName().length()<4) {
			errors.rejectValue("name", "stu.name.length");
		}
		
		if(std.getDept() == null || std.getDept().isBlank()) {
			errors.rejectValue("dept", "stu.dept.mandatory");
		} else if(std.getDept().length()<4) {
			errors.rejectValue("dept", "stu.dept.length");
		}
	}

}
