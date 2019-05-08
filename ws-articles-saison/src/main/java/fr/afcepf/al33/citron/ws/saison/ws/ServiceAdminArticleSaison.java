package fr.afcepf.al33.citron.ws.saison.ws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

@WebService
public interface ServiceAdminArticleSaison {

	public Categorie 		categorieParId(@WebParam(name="id")int id);
	public List<Categorie> 	listeCategories();
	public Categorie 		sauvegarderCategorie(@WebParam(name="categorie")Categorie categorie);
	public void				supprimerCategorieParId(@WebParam(name="id")int id);
	
	public Article 			articleParId(@WebParam(name="id")int id);
	public List<Article> 	listeArticles();
	public Article 			sauvegarderArticle(@WebParam(name="article")Article article);
	public void				supprimerArticleParId(@WebParam(name="id")int id);
}
