package edu.college.interfaces;

import java.util.List;

import edu.college.model.Department;

public interface IDepartmentService {

	List<Department> getAllDepartments();
	Department getDepartmentById(int id);
	Department addDepartment(Department department);
	Department updateDepartment(Department department);
	void deleteDepartment(int id);
	boolean departmentExists(String name);
	List<Department> bulkDeleteDepartments(List<Department> departments);
	
}
