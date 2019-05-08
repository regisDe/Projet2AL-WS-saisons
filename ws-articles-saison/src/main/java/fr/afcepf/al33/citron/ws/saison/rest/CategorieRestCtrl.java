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

import fr.afcepf.al33.citron.ws.saison.entity.Categorie;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
                 //provenant d'autres domaines/applications/...

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/categories" , headers="Accept=application/json")
public class CategorieRestCtrl {

	@Autowired //injection du "business service" 
	private ServiceAdminArticleSaison serviceAdminArticleSaison;

	
	//URL= http://localhost:7878/articlesSaison/rest/categories
	//en mode POST avec la partie body invisible de la requete contenant
	//{ "nom" : "nom_categorie"}
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Categorie createOrUpdateCategorie(@RequestBody @Valid Categorie categorie) {
		serviceAdminArticleSaison.sauvegarderCategorie(categorie);
		return categorie; // l'objet retourné comporte id auto_incr
	}
	
	
	//URL= http://localhost:7878/articlesSaison/rest/categories/1
	//en mode DELETE
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/{idCategorie}" , method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCategorieById(@PathVariable("idCategorie") 
	                                            Integer idCategorie) {
		//try {
			serviceAdminArticleSaison.supprimerCategorieParId(idCategorie);
			return new ResponseEntity<>(HttpStatus.OK);
		/*} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/ //traitement d'exception dejà effectué par defaut
	}
	
	
}
