package fr.afcepf.al33.citron.ws.saison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//NB: @SpringBootApplication est un équivalent
// de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//@EntityScan( basePackages = {"fr.afcepf.al33.entity"} )
public class MySpringBootApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		//SpringApplication.run(MySpringBootApplication.class, args);
		
		SpringApplication app = new SpringApplication(MySpringBootApplication.class);
		app.setLogStartupInfo(true);
		app.setAdditionalProfiles("web.dev");
		ConfigurableApplicationContext context = app.run(args);
		
		System.out.println("http://localhost:7878/articlesSaison/index.html");
		System.out.println("http://localhost:7878/articlesSaison/service (liste des services SOAP)");
		System.out.println("http://localhost:7878/articlesSaison/rest/public/categories (REST GET)");	
		System.out.println("http://localhost:7878/articlesSaison/rest/public/categories/1 (REST GET)");	
		System.out.println("http://localhost:7878/articlesSaison/rest/public/articles (REST GET)");	
		System.out.println("http://localhost:7878/articlesSaison/rest/public/articles/1 (REST GET)");	
		//securité par défaut si la classe WebSecurityConfig n'existe pas dans l'application:
		//System.out.println("default username=user et password précisé au démarrage");
	}
}
