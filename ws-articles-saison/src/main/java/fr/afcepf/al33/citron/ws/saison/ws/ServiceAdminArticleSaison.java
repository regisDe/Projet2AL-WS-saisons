package fr.afcepf.al33.citron.ws.saison.ws;

import java.util.List;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

public interface ServiceAdminArticleSaison {

	public Categorie 		categorieParId(int id);
	public List<Categorie> 	listeCategories();
	public Categorie 		sauvegarderCategorie(Categorie categorie);
	public void				supprimerCategorieParId(int id);
	
	public Article 			articleParId(int id);
	public List<Article> 	listeArticles();
	public Article 			sauvegarderArticle(Article article);
	public void				supprimerArticleParId(int id);
}
