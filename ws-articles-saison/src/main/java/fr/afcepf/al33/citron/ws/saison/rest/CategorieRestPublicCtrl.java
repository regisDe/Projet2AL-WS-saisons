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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.citron.ws.saison.entity.Categorie;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison;

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
                 //provenant d'autres domaines/applications/...

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/public/categories" , headers="Accept=application/json")
public class CategorieRestPublicCtrl {

	private static Logger logger = LoggerFactory.getLogger(CategorieRestPublicCtrl.class);

	@Autowired //injection du "business service" 
	private ServiceAdminArticleSaison serviceAdminArticleSaison;

	
	//URL= http://localhost:7878/articlesSaison/rest/public/categories/1
	//en mode GET
	//{ "nom" : "nomxy"}
	@RequestMapping(value="/{idCategorie}", method=RequestMethod.GET)
	public Categorie categorieById(@Valid @PathVariable("idCategorie") Integer idCategorie) {
    	Categorie categorie = serviceAdminArticleSaison.categorieParId(idCategorie);
		return categorie;		
	}

	
	//URL= http://localhost:7878/articlesSaison/rest/public/categories
	//en mode GET
	//{ "nom" : "nomxy"}
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Categorie> allCategories(@Valid Categorie categorie) {
		return serviceAdminArticleSaison.listeCategories();		
	}	
	
}
