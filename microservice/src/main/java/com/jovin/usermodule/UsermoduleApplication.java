package com.jovin.usermodule;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.tutorwaves.webapp.usermodule.feign")
public class UsermoduleApplication {

	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		Hibernate5Module hm = new Hibernate5Module();
		hm.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a z");
		mapper.setDateFormat(formatter);
		mapper.registerModule(hm);
		messageConverter.setObjectMapper(mapper);
		return messageConverter;

	}

	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {

		return new RequestInterceptor() {

			@Override
			public void apply(RequestTemplate requestTemplate) {

				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
						SecurityContextHolder.getContext().getAuthentication()
								.getDetails();

				System.out.println("details.getTokenValue()"+details.getTokenValue());


				requestTemplate.header("Authorization",
						"bearer " + details.getTokenValue());

			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(UsermoduleApplication.class, args);
	}
}
