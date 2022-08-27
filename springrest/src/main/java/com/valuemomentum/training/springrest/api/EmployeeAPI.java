package com.valuemomentum.training.springrest.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuemomentum.training.springrest.data.EmployeeDataStore;
import com.valuemomentum.training.springrest.entity.Employee;
import com.valuemomentum.training.springrest.exception.EmployeeDataException;

@RestController
@RequestMapping("employee")

public class EmployeeAPI {
	private static Logger log = LoggerFactory.getLogger(EmployeeAPI.class);

	@Autowired
	EmployeeDataStore eds;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> Hello() {
		return ResponseEntity.ok("Hello World!");
	}

	@GetMapping(path = "/error")
	public ResponseEntity<String> Error() {
		log.debug("ERROR MESSAGE FOUND");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR Found");
	}

//	@GetMapping(path = "/error")
//	public ResponseEntity<String> Error() {
//		log.debug("ERROR MESSAGE FOUND");
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR Found");
//	}

	@GetMapping(path = "/list", produces = "application/json")
	public ResponseEntity<List<Employee>> list() throws EmployeeDataException {
		List<Employee> employees = eds.findAll();
		return ResponseEntity.ok(employees);

	}

	@GetMapping(path = "/{ID}/details", produces = "application/json")
	public ResponseEntity<Employee> getById(@PathVariable("ID") String id) throws EmployeeDataException {
		Employee employee = eds.findByEmployeeId(id);
		return ResponseEntity.ok(employee);
	}
}
