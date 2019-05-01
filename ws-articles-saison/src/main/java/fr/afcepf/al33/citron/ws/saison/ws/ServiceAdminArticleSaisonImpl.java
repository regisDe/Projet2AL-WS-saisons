package fr.afcepf.al33.citron.ws.saison.ws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al33.citron.ws.saison.dao.ArticleDao;
import fr.afcepf.al33.citron.ws.saison.dao.CategorieDao;
import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

@Service  //de Spring
@WebService(endpointInterface="fr.afcepf.al33.citron.ws.saison.ws.ServiceAdminArticleSaison")
public class ServiceAdminArticleSaisonImpl implements ServiceAdminArticleSaison {
	
	@Autowired //injection du dao categorie 
	private CategorieDao categorieDao;
	
	@Autowired //injection du dao article 
	private ArticleDao articleDao;

	@Override
	public Categorie categorieParId(int id) {
		return categorieDao.findById(id).orElse(null);
	}

	@Override
	public List<Categorie> listeCategories() {
		return (List<Categorie>) categorieDao.findAll();
	}

	@Override
	public Categorie sauvegarderCategorie(Categorie categorie) {
		return categorieDao.save(categorie);
	}

	@Override
	public void supprimerCategorieParId(int id) {
		categorieDao.deleteById(id);
	}

	@Override
	public Article articleParId(int id) {
		return articleDao.findById(id).orElse(null);
	}

	@Override
	public List<Article> listeArticles() {
		return (List<Article>) articleDao.findAll();
	}

	@Override
	public Article sauvegarderArticle(Article article) {
		return articleDao.save(article);
	}

	@Override
	public void supprimerArticleParId(int id) {
		articleDao.deleteById(id);
	}

}
