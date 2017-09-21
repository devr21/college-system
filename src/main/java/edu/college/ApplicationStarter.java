package edu.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter {  
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApplicationStarter.class);
		/*Properties props = new Properties();
		props.setProperty("spring.resources.staticLocations", "src/main/webapp/static/");
		app.setDefaultProperties(props);*/
		app.run(args);
    }       
}
