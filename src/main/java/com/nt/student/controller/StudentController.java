package com.nt.student.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nt.student.editor.LocalDateTimeEditor;
import com.nt.student.model.Student;
import com.nt.student.service.StudentService;
import com.nt.student.validate.StudentValidate;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private StudentValidate validator;
	
	@GetMapping(path = {"/", "/report" })
	public String home(Map<String, Object> map) {
		List<Student> stdList = (List<Student>) service.getAllStudents();
		map.put("stdList", stdList);
		return "report";
	}

	@GetMapping("/add_student")
	public String addStudentForm(@ModelAttribute("stu") Student stu) {
		return "add_student";
	}

	@PostMapping("/add_student")
	public String importStudent(RedirectAttributes attrs, @ModelAttribute("stu") Student stu,
			BindingResult errors /* Map<String, Object> map */) {

		// server side form validation
		if (stu.getVflag().equalsIgnoreCase("no")) {
			System.out.println("StudentController.importStudent()");
			if (validator.supports(stu.getClass())) {
				validator.validate(stu, errors);
			}
			if (errors.hasErrors()) {
				return "add_student";
			}
		}

		// b.logic validation
		 if (!(stu.getDept().equalsIgnoreCase("Science") || stu.getDept().equalsIgnoreCase("Commerce")
				|| stu.getDept().equalsIgnoreCase("Arts"))) {
			errors.rejectValue("dept", "stu.dept.restriction");
			return "add_student";
		}
		String result = service.insertStudent(stu);
		attrs.addFlashAttribute("result", result);
		System.out.println("StudentController.importStudent()"+ stu);
		// map.put("result", result);
		return "redirect:report";
	}

	@GetMapping("/edit_student")
	public String editStudentForm(@RequestParam("stdId") int id, @ModelAttribute("stu") Student stu) {
		Student std = service.getStudentById(id);
		BeanUtils.copyProperties(std, stu);
		return "modify_student";
	}

	@PostMapping("/edit_student")
	public String editStudent(@ModelAttribute("stu") Student stu, RedirectAttributes attrs, BindingResult errors) {
		// server side form validation
		if (stu.getVflag().equalsIgnoreCase("no")) {
			System.out.println("StudentController.editStudent()");
			if (validator.supports(stu.getClass())) {
				validator.validate(stu, errors);
			}
			if (errors.hasErrors()) {
				return "modify_student";
			}
		}
		// b.logic validation
		if (!(stu.getDept().equalsIgnoreCase("Science") || stu.getDept().equalsIgnoreCase("Commerce")
				|| stu.getDept().equalsIgnoreCase("Arts"))) {
			errors.rejectValue("dept", "stu.dept.restriction");
			return "modify_student";
		}

		String result = service.updateStudent(stu);
		attrs.addFlashAttribute("result", result);
		return "redirect:report";
	}
	
	@PostMapping("/states")
	public String getStatesByCountry(@RequestParam("country") String country, @ModelAttribute("stu") Student stu,
			Map<String,Object> map, BindingResult result){
		List<String> stateList = service.getStatesByCountry(country);
		map.put("stateInfo", stateList);
		return "add_student";
	}

	@GetMapping("/delete_student")
	public String deleteStudent(@RequestParam("stdId") int id, RedirectAttributes attrs) {
		String result = service.removeStudent(id);
		attrs.addFlashAttribute("result", result);
		return "redirect:report";
	}
	
	@ModelAttribute("countryInfo")
	public Set<String> getCountries(){
		return service.countryList();
	}
	
	@ModelAttribute("langInfo")
	public Set<String> languages(){
		return service.getLanguages();
	}
	
	/*
	 * this method is useful only when we will use Date Property, for LocalDate, LocalDateTime
	 * the below method will not work.
	 * ================================================================================
	 * @InitBinder public void myInitBinder(WebDataBinder binder) { SimpleDateFormat
	 * format = new SimpleDateFormat("yyyy-MM-dd"); CustomDateEditor editor = new
	 * CustomDateEditor(format, false);
	 * binder.registerCustomEditor(java.util.Date.class, editor);
	 * ================================================================================
	 * 
	 * }
	 */
	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDateTimeEditor());
	}
	
	@GetMapping("/denied")
	public String showDeniedPage() {
		return "access_denied";
	}
}
