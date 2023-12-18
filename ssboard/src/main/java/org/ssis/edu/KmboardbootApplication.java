package org.ssis.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.ssis.edu"})
public class KmboardbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmboardbootApplication.class, args);
	}

}
