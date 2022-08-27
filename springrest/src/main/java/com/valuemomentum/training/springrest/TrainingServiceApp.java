package com.valuemomentum.training.springrest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import com.valuemomentum.training.springrest.api.EmployeeAPI;
import com.valuemomentum.training.springrest.data.EmployeeDataStore;
import com.valuemomentum.training.springrest.data.JSONDataStore;
import com.valuemomentum.training.springrest.data.SQLDataStore;
import com.valuemomentum.training.springrest.exception.EmployeeDataException;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableJpaRepositories
public class TrainingServiceApp {
	private static Logger log = LoggerFactory.getLogger(EmployeeAPI.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TrainingServiceApp.class, args);

	}
//	@Bean
//	@ConditionalOnProperty(prefix = "employee" ,name = "datastore", havingValue = "JSON")
//	public EmployeeDataStore createEDS() {
//		return new JSONDataStore();
//	}
//	
//	@Bean
//	@ConditionalOnProperty(prefix = "employee" ,name = "datastore", havingValue = "SQL")
//	public EmployeeDataStore createSQL() {
//		return new SQLDataStore();
//	}
	
	@Bean
	public Jackson2RepositoryPopulatorFactoryBean loadJson() {
		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setResources(new Resource[] {new ClassPathResource("/employee-list.json")});
		return factory;
	}
}
