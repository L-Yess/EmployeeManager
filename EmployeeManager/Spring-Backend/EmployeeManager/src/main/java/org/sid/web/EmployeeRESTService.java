package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.EmployeeRepository;
import org.sid.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmployeeRESTService {

	@Autowired
	EmployeeRepository er;
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return er.findAll();
	}
	
	@RequestMapping(value="/employees/{id}", method = RequestMethod.GET)
	public Optional<Employee> getContact(@PathVariable Long id){
		return er.findById(id);
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee c){
		System.out.println(c);
		return er.save(c);
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Employee sth(@RequestBody Employee e){
		System.out.println(e);
		return er.save(e);
	}
	
	
	@RequestMapping(value="/employees/{id}", method = RequestMethod.PUT)
	public Employee save(@PathVariable Long id, @RequestBody Employee c){
		c.setId(id);
		return er.save(c);
	}
	
	@RequestMapping(value="/employees/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		er.deleteById(id);
	}
}
