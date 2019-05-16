package fr.afcepf.al33.citron.ws.saison.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.citron.ws.saison.StartWSArticlesSaisonApplication;
import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {StartWSArticlesSaisonApplication.class})
public class TestServiceAdminArticleSaison {
    
    @Autowired
    private ServiceAdminArticleSaison serviceAdminArticleSaison;
 
    //@Test
    public void creationCategorie() {
        // given
        Categorie categorie = new Categorie(0, "épices");        
        Categorie returnCategorie = serviceAdminArticleSaison.sauvegarderCategorie(categorie);     
        // then
        assertThat(returnCategorie.getNom(), is(equalTo(categorie.getNom())));
    } 	
    
    //@Test
    public void creationArticle() {
        // given
        Categorie categorie = new Categorie(0, "épices");        
        Categorie returnCategorie = serviceAdminArticleSaison.sauvegarderCategorie(categorie);     
    	Article article = new Article(0, "poivre", 1, 12, returnCategorie);        
    	Article returnArticle = serviceAdminArticleSaison.sauvegarderArticle(article);     
        // then
        assertThat(returnCategorie.getNom(), is(equalTo(categorie.getNom())));
    } 	
}