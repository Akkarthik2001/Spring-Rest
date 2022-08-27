package com.valuemomentum.training.springrest.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valuemomentum.training.springrest.entity.Employee;
import com.valuemomentum.training.springrest.exception.EmployeeDataException;

@Repository
public interface EmployeeDataStore extends JpaRepository<Employee, Long>{
	public Employee findByEmployeeId(String id);
}
