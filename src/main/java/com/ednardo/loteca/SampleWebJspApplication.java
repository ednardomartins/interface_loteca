/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ednardo.loteca;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.ConfigureListener;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleWebJspApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SampleWebJspApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebJspApplication.class, args);
	}

	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(facesServlet(), "*.xhtml");
		registration.setName("FacesServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent sce) {
				System.out.println("SERVLET CONTEXT initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				System.out.println("SERVLET CONTEXT destroyed");
			}
		};
	}

}
