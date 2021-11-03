function formValidation(frm){

	document.getElementById("name_error").innerHTML = "";
	document.getElementById("dept_error").innerHTML = "";
	
	var name = frm.name.value;
	var dept = frm.dept.value;
	var validationFlag = true;
	
	if(document.getElementById("name.errors") != null){
		document.getElementById("name.errors").innerHTML = "";
	}
	if(document.getElementById("dept.errors") != null){
		document.getElementById("dept.errors").innerHTML = "";
	}
	
	if(name==""){
		//alert("1");
		document.getElementById("name_error").innerHTML = "Name is required(cs).";
		validationFlag = false;
	}
	else if(name.length<4){
		//alert("2");
		document.getElementById("name_error").innerHTML = "Length of name must be greater than 4 characters(cs).";
		validationFlag = false;
	}
	
	if(dept==""){
		//alert("3");
		document.getElementById("dept_error").innerHTML = "Department is required(cs).";
		validationFlag = false;
	}
	else if(dept.length<5){
		//alert("4")
		document.getElementById("dept_error").innerHTML = "Length of department must be greater than 5 characters(cs).";
		validationFlag = false;
	}
	
	frm.vflag.value = "yes";
	
	return validationFlag;
}