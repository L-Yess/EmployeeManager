package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.EmployeeRepository;
import org.sid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDbApplication  implements CommandLineRunner{
	
	@Autowired
	EmployeeRepository er;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	

		
		er.save(new Employee("John Doe"	, "HN2739", 682204763L, "Supervisor"));
		er.save(new Employee("Karin Uzumaki"	, "NG8734", 620987126L, "Supervisor"));
		er.save(new Employee("Sarori Chiyo"	, "Gl08990", 698789759L, "Inspector"));
		er.save(new Employee("Shikamaru Nara"	, "SM8390", 687238947L, "Inspector"));
		er.save(new Employee("Sakura Haruno"	, "KK9029", 684723897L, "Worker"));
		er.save(new Employee("Kakashi Hatake"	, "AP0480", 609809585L, "Worker"));

		er.findAll().forEach(c->{
			System.out.println(c.getFullName());
		});	
	}

}
