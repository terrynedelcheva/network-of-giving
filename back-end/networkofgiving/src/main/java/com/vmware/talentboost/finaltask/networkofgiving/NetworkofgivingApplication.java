package com.vmware.talentboost.finaltask.networkofgiving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.vmware.talentboost.finaltask.networkofgiving.Constants.STATIC_IMAGES_FILE_PATH;

@SpringBootApplication
public class NetworkofgivingApplication {

	@Bean
	WebMvcConfigurer configurer () {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				String imagePathPattern = Constants.IMAGE_PATH + "**";
				registry.addResourceHandler(imagePathPattern).
						addResourceLocations(STATIC_IMAGES_FILE_PATH);
			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(NetworkofgivingApplication.class, args);
	}

}
