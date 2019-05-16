package fr.afcepf.al33.citron.ws.saison;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//NB: @SpringBootApplication est un équivalent
// de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//@EntityScan( basePackages = {"fr.afcepf.al33.entity"} )
public class StartWSArticlesSaisonApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String wsHost = "{web service host}";
		try {
			wsHost = Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String wsPort = "7878";

		//SpringApplication.run(MySpringBootApplication.class, args);
		
		SpringApplication app = new SpringApplication(StartWSArticlesSaisonApplication.class);
		app.setLogStartupInfo(true);
		app.setAdditionalProfiles("web.dev");
		ConfigurableApplicationContext context = app.run(args);
		
		System.out.println("\n");
		System.out.println("adresse du web service lue dans application.properties : " + wsHost + ":" + wsPort + " (peut être une adresse du localhost)\n");
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/index.html");
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/service (liste des services SOAP)");
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/service/serviceClientArticleSaison?wsdl");
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/categories (REST GET)");	
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/categories/1 (REST GET)");	
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/articles (REST GET)");	
		System.out.println("http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/articles/1 (REST GET)");	
		//securité par défaut si la classe WebSecurityConfig n'existe pas dans l'application:
		//System.out.println("default username=user et password précisé au démarrage");
	}
}
