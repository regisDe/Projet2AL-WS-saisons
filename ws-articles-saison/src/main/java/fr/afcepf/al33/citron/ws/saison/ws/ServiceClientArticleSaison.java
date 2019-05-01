package fr.afcepf.al33.citron.ws.saison.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

@WebService
//targetNamespace par defaut = http://ws.saison.ws.citron.al33.afcepf.fr/
public interface ServiceClientArticleSaison {

	public List<Categorie> 	listeCategories();
	public List<Article> 	listeArticles();
	public List<Article> 	listeArticlesParNom(@WebParam(name="nom")String nom);
	public List<Article> 	listeArticlesParCategorie(@WebParam(name="categorie")Categorie categorie);
	public List<Article> 	listeArticlesParMois(@WebParam(name="mois")int mois);
	public List<Article> 	listeArticlesParCategorieEtMois(@WebParam(name="categorie")Categorie categorie, @WebParam(name="mois")int mois);
}
