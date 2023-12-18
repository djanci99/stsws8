package org.ssis.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.ssis.edu"})
public class MymboardbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymboardbootApplication.class, args);
	}

}
