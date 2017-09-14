package edu.college.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import edu.college.resources.DepartmentResource;
import edu.college.resources.IndexResource;

@Component
@ApplicationPath("/system")
public class SystemConfig extends ResourceConfig{

	public SystemConfig(){
		register(IndexResource.class);
		register(DepartmentResource.class);
	}
	
}
