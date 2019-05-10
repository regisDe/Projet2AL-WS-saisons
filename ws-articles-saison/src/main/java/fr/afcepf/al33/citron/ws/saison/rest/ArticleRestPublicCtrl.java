package fr.afcepf.al33.citron.ws.saison.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
                 //provenant d'autres domaines/applications/...

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/public/articles" , headers="Accept=application/json")
public class ArticleRestPublicCtrl {

	private static Logger logger = LoggerFactory.getLogger(ArticleRestPublicCtrl.class);

	@Autowired //injection du "business service" 
	private ServiceAdminArticleSaison serviceAdminArticleSaison;

	
	//URL= http://localhost:7878/articlesSaison/rest/public/articles/1
	//en mode GET
	//{ "nom" : "nomxy"}
	@RequestMapping(value="/{idArticle}", method=RequestMethod.GET)
	public Article articleById(@Valid @PathVariable("idArticle") Integer idArticle) {
    	Article article = serviceAdminArticleSaison.articleParId(idArticle);
		//System.out.println("article.getCategorie() = " + article.getCategorie());
    	return article;		
	}

	
	//URL= http://localhost:7878/articlesSaison/rest/public/articles
	//en mode GET
	//{ "nom" : "nomxy"}
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Article> allArticles(@Valid Article article) {
		return serviceAdminArticleSaison.listeArticles();		
	}	
	
}
