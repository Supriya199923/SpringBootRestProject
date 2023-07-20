package com.crudDemoREST.crudDemoRest.RestApi;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudDemoREST.crudDemoRest.entity.Student;
import com.crudDemoREST.crudDemoRest.entity.StudentException;
import com.crudDemoREST.crudDemoRest.entity.StudentNotFoundException;

import jakarta.annotation.PostConstruct;


//Writing code for server side to return to client side(Any app or webapp whatever)
@RestController
@RequestMapping("/Rest") //REST Api extension
public class DemoController {
	List<Student> newStudents=new ArrayList<Student>();
	@PostConstruct
	public void loadData()
	{
		newStudents.add(new Student("Supriya","Das"));
		newStudents.add(new Student("Swarnali","Roy"));
		newStudents.add(new Student("Rajib","Patra"));
	}
	@GetMapping("/students") //Endpoint extension
	List<Student> showMsg()
	{
		return newStudents;
	}
	
	@GetMapping("/students/{studentID}")
	Student showStudent(@PathVariable int studentID)
	{
		if(studentID>=newStudents.size() || studentID<0)
		{
			throw new StudentNotFoundException("Student id by sup not found: "+studentID);
		}
		return newStudents.get(studentID);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentException> exceptionHandler(StudentNotFoundException exc)
	{
		StudentException error=new StudentException();
		error.setId(HttpStatus.NOT_FOUND.value());
		error.setMsg(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentException>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<StudentException> exceptionHandler(RuntimeException exc)
	{
		StudentException error=new StudentException();
		error.setId(HttpStatus.BAD_REQUEST.value());
		error.setMsg(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentException>(error, HttpStatus.NOT_FOUND);
	}
}
