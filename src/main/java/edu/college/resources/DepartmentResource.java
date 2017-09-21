package edu.college.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import edu.college.interfaces.IDepartmentService;
import edu.college.model.Department;


@Component
@Path("/departments")
public class DepartmentResource {

	@Inject
	private IDepartmentService departmentService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDepartments(){
		return Response.ok(departmentService.getAllDepartments()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getDepartmentById(@PathParam("id") int id){
		return Response.ok(departmentService.getDepartmentById(id)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addDepartment(Department department){
		
		return Response.ok(departmentService.addDepartment(department)).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateDepartment(Department department){
		return Response.ok(departmentService.updateDepartment(department)).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response bulkDelete(List<Department> departments) {
		
		return Response.ok(departmentService.bulkDeleteDepartments(departments)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteDepartment(@PathParam("id") int id){
		departmentService.deleteDepartment(id);
		
		return Response.ok().build();
	}
}
