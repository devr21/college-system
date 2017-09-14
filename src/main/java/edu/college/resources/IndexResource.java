package edu.college.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class IndexResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Response index(){
		return Response.ok("Hello").build();
	}
	
}
