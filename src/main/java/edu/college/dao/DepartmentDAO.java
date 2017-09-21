package edu.college.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.college.interfaces.IDepartmentDAO;
import edu.college.model.Department;

@Transactional
@Repository
@Named
public class DepartmentDAO implements IDepartmentDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments() {

		return (List<Department>) entityManager.createQuery("from Department").getResultList();
	}

	public Department getDepartmentById(int id) {

		return entityManager.find(Department.class, id);
	}

	public Department addDepartment(Department department) {
		try{
		entityManager.persist(department);
		}
		catch (Exception e) {
			return null;
		}
		return department;
	}

	public Department updateDepartment(Department department) {
		Department dept = null;
		try{
			dept = getDepartmentById(department.getDepartmentId());
			dept.setDepartmentName(department.getDepartmentName());
			dept.setHeadOfDepartment(department.getHeadOfDepartment());
			entityManager.flush();
		}catch(Exception e){
			return null;
		}
		
		return dept;
	}

	public void deleteDepartment(int id) {
		entityManager.remove(getDepartmentById(id));
		
	}

	public boolean departmentExists(String name) {
		String hql = "from Department as dept where dept.departmentName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
		return count>0?true:false;
	}

	public List<Department> bulkDeleteDepartments(List<Department> departments) {
		List<Integer> ids = new ArrayList<Integer>();
		for(Department d: departments)
			ids.add(d.getDepartmentId());
		String hql = "delete from Department d where d.departmentId in (:list)";
		
			entityManager.createQuery(hql).setParameter("list", ids).executeUpdate();
		return getAllDepartments();
	}
	


}
