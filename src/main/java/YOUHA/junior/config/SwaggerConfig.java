package YOUHA.junior.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false) //기본 응답코드 표시
                .apiInfo(apiInfo()) //Api 정보
                .select()
                .apis(RequestHandlerSelectors.basePackage("YOUHA.junior.movie"))
                .paths(PathSelectors.any())
                .build();
    }
//테스트
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("티켓플레이스")
                .description("영화 관련 API 모음.")
                .version("1.0")
                .build();
        // 완료가 되었으면 오른쪽 URL 로 접속 => http://localhost:8080/swagger-ui.html
    }
}
