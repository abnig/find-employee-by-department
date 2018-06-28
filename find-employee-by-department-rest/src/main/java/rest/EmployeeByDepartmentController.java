package rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import model.Employee;
import model.dao.service.EmployeeRepositoryService;

@RestController
public class EmployeeByDepartmentController {

	@Autowired
	private EmployeeRepositoryService employeeRepositoryServiceImpl;

	@HystrixCommand(fallbackMethod = "reliable")
	@RequestMapping(value = "/department/{department}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> greeting(@PathVariable(value = "department") String department) {
		System.out.println("Recieved department:" + department);
		return this. employeeRepositoryServiceImpl.findByDepartment(department);
	}

	public List<Employee> reliable(String department) {
		Employee e =  new Employee();
		e.setDepartment("failover");
		e.setFirstName("failover");
		List<Employee> list = new ArrayList<Employee>();
		list.add(e);
		return list;
	}
}