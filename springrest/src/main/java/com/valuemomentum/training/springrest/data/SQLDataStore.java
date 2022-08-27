package com.valuemomentum.training.springrest.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.valuemomentum.training.springrest.entity.Employee;
import com.valuemomentum.training.springrest.exception.EmployeeDataException;


public class SQLDataStore {
	public List<Employee> getEmployeeList() throws EmployeeDataException {
		return Collections.EMPTY_LIST;
	}

	public Employee getEmployeeById(String id) throws EmployeeDataException {
		// TODO Auto-generated method stub
		return null;
	}
}
