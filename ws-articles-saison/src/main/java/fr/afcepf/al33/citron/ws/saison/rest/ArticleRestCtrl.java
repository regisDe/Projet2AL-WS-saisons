package fr.afcepf.al33.citron.ws.saison.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaisonImpl;

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
                 //provenant d'autres domaines/applications/...

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/articles" , headers="Accept=application/json")
public class ArticleRestCtrl {

	@Autowired //injection du "business service" 
	private ServiceAdminArticleSaison serviceAdminArticleSaison;
	
	//URL= http://localhost:7878/adminArticleSaisonWebService/rest/articles
	//en mode POST avec la partie body invisible de la requete contenant
	//{ "nom" : "nomxy"}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Article createOrUpdateArticle(@RequestBody @Valid Article article) {
		serviceAdminArticleSaison.sauvegarderArticle(article);
		return article; // l'objet retourné comporte id auto_incr
	}
	
	
	//URL= http://localhost:7878/adminArticleSaisonWebService/rest/articles/1
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/{idArticle}" , method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteArticleById(@PathVariable("idArticle") 
	                                            Integer idArticle) {
		//try {
			serviceAdminArticleSaison.supprimerArticleParId(idArticle);
			return new ResponseEntity<>(HttpStatus.OK);
		/*} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/ //traitement d'exception dejà effectué par defaut
	}
	
	
}
