package com.recollection.back_end_recollection.Config;

import java.util.ArrayList;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config_Swagger {
    
    @Bean
    public Docket RecollectionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

   private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Recollection API REST",
                "API REST para relembrar bons momentos.",
                "1.0",
                "Terms of Service",
                new Contact("Éverton (Ed)", "http://bit.ly/3eWL0RK",
                        "foreverplayer95@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    } 
}
