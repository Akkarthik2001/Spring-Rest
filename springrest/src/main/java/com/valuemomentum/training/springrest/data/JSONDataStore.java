package com.valuemomentum.training.springrest.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valuemomentum.training.springrest.api.EmployeeAPI;
import com.valuemomentum.training.springrest.entity.Employee;
import com.valuemomentum.training.springrest.exception.EmployeeDataException;

public class JSONDataStore {
	private static Logger log = LoggerFactory.getLogger(JSONDataStore.class);
	private List<Employee> employees;

	public JSONDataStore() throws IOException {
		super();
		ObjectMapper mapper = new ObjectMapper();

		String str = IOUtils.resourceToString("/employee-list.json", Charset.defaultCharset());
		employees = mapper.readValue(str, new TypeReference<List<Employee>>() {
		});
	}

	public List<Employee> getEmployeeList() throws EmployeeDataException {
		return employees;
	}

	public Employee getEmployeeById(String id) throws EmployeeDataException {
		{
			for (Employee e : employees) {
				log.debug(e.getId() + " " + id);
				if (e.getId().equals(id)) {
					return e;
				}
			}
			throw new EmployeeDataException("Failed to retrieve data");
		}
	}
}
