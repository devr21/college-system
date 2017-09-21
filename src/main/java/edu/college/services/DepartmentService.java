package edu.college.services;

import java.util.List;

import edu.college.interfaces.IDepartmentDAO;
import edu.college.interfaces.IDepartmentService;
import edu.college.model.Department;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DepartmentService implements IDepartmentService{

	@Inject
	private IDepartmentDAO departmentDAO;
	
	public List<Department> getAllDepartments() {

		return departmentDAO.getAllDepartments();
	}

	public Department getDepartmentById(int id) {
		return departmentDAO.getDepartmentById(id);
	}

	public Department addDepartment(Department department) {
		
		return departmentDAO.addDepartment(department);
	}

	public Department updateDepartment(Department department) {
		
		return departmentDAO.updateDepartment(department);
	}

	public void deleteDepartment(int id) {
		departmentDAO.deleteDepartment(id);
	}

	public boolean departmentExists(String name) {
		return departmentDAO.departmentExists(name);
	}

	public List<Department> bulkDeleteDepartments(List<Department> departments) {
		return departmentDAO.bulkDeleteDepartments(departments);
		
	}

}
