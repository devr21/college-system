package edu.college.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import edu.college.resources.DepartmentResource;

@Component
@ApplicationPath("/system")
public class SystemConfig extends ResourceConfig{

	public SystemConfig(){
		register(DepartmentResource.class);
	}
	
}
