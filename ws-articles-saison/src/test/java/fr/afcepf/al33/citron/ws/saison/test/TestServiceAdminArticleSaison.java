package fr.afcepf.al33.citron.ws.saison.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.citron.ws.saison.MySpringBootApplication;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceAdminArticleSaison {
    
    @Autowired
    private ServiceAdminArticleSaison serviceAdminArticleSaison;
 
    @Test
    public void creationCategorie() {
        // given
        Categorie categorie = new Categorie(0, "fruits");
        
        System.out.println("assertThat(categorie,  is(notNullValue()))");
        assertThat(categorie,  is(notNullValue()));
        
        System.out.println("assertThat(serviceAdminArticleSaison,  is(notNullValue()))");
        assertThat(serviceAdminArticleSaison,  is(notNullValue()));
        
        Categorie returnCategorie = serviceAdminArticleSaison.sauvegarderCategorie(categorie);
     
        // then
        assertThat(returnCategorie.getNom(), is(equalTo(categorie.getNom())));
    } 	
}