package org.ssis.edu.config;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

//	Swagger-UI 2.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui.html
//	Swagger-UI 3.x 확인
//	http://localhost:8080/{your-app-root}/swagger-ui/index.html
//  http://localhost:8090/kmboard/swagger-ui/index.html
//  http://localhost:8090/board/swagger-ui.html
	private String version = "V1";
	private String title = "SSIS Board API " + version;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(getConsumeContentTypes()) // 들어오는 데이터 타입.
				.produces(getProduceContentTypes()) // 반환하는 데이터 타입.
				.apiInfo(apiInfo()) // 제목, 설명 등 문서에 대한 정보들을 설정.
					.groupName(version) // groupName(String) : Docket Bean이 한개일 경우 생략 가능, 둘이상일 경우 충돌을 방지하기위해 설정.
					.select() // ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용할 수 있게 해줌.
					.apis(RequestHandlerSelectors.basePackage("org.ssis.edu.controller")) // 스펙이 작성되어 있는 패키지를 지정. (컨트롤러가 존재하는 패키지를 basePackage로 지정하여 해당 패키지에 존재하는 API를 문서화 함.
					.paths(regex("/api/.*")) // apis()로 선택되어진 API중 특정 path 조건에 맞는 API를 다시 필터링하여 문서화.
					.build() 
					.useDefaultResponseMessages(false); // false : Swagger에서제공해주는 응답코드 (200, 401, 403, 404)에 대한 기본 메세지를 제거
	}
	
	private Set<String> getConsumeContentTypes() {
      Set<String> consumes = new HashSet<>();
      consumes.add("application/json;charset=UTF-8");
//    consumes.add("application/xml;charset=UTF-8");
      consumes.add("application/x-www-form-urlencoded");
      return consumes;
  }

  private Set<String> getProduceContentTypes() {
      Set<String> produces = new HashSet<>();
      produces.add("application/json;charset=UTF-8");
      return produces;
  }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title)
				.description("<h3>SSIS API Reference for Developers</h3>Swagger를 이용한 Board API<br><img src=\"./assets/img/ssis.png\" width=\"150\">") 
				.contact(new Contact("SSIS", "https://org.ssis.www", "ssis@ssis.org"))
				.license("SSIS License")
				.licenseUrl("https://www.ssis.org/ssis.jsp")
				.version("1.0").build();
	}
	
}
