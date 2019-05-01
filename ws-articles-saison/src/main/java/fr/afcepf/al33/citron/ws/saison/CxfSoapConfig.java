package fr.afcepf.al33.citron.ws.saison;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import fr.afcepf.al33.citron.ws.saison.ws.ServiceClientArticleSaisonImpl;

@Configuration
@EnableAutoConfiguration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CxfSoapConfig {

	@Autowired
    private ApplicationContext applicationContext;
	
	// Replaces the need for web.xml
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");
    }
    
    @Autowired 
    private ServiceClientArticleSaisonImpl serviceClientArticleSaison;
 
    // Replaces cxf-servlet.xml
    @Bean
    // <jaxws:endpoint id="convertisseurServiceEndpoint" implementor="#convertisseurImpl" address="/convertisseur"/>
    public EndpointImpl serviceClientArticleSaisonServiceEndpoint() {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        EndpointImpl endpoint = new EndpointImpl(bus, serviceClientArticleSaison /* implementor */);
        endpoint.publish("/serviceClientArticleSaison");
        //URL soap complete:
        //http://localhost:7878/ws-articles-saison/service/serviceClientArticleSaison
        return endpoint;
    }
 

}
