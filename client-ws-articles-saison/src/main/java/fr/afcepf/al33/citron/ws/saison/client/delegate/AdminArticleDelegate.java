package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.util.List;

import fr.afcepf.al33.citron.ws.saison.client.dto.ArticleDto;
import fr.afcepf.al33.citron.ws.saison.client.dto.CategorieDto;


// cette interface sera implémentée par:
//		AdminArticleDelegateSoap
// ou 	AdminArticleDelegateRest

public interface AdminArticleDelegate {
	CategorieDto 		categorieParId(int id);
	List<CategorieDto> ListeCategories();
	CategorieDto 		sauvegarderCategorie(CategorieDto categorie);
	void			supprimerCategorieParId(int id);
	
	ArticleDto 		articleParId(int id);
	List<ArticleDto> 	ListeArticles();
	ArticleDto 		sauvegarderArticle(ArticleDto article);
	void			supprimerArticleParId(int id);
}
