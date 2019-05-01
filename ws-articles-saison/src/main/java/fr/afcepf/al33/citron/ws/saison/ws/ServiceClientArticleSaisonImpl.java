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
@WebService(endpointInterface="fr.afcepf.al33.citron.ws.saison.ws.ServiceClientArticleSaison")
public class ServiceClientArticleSaisonImpl implements ServiceClientArticleSaison {
	
	@Autowired //injection du dao categorie 
	private CategorieDao categorieDao;
	
	@Autowired //injection du dao article 
	private ArticleDao articleDao;

	@Override
	public List<Categorie> listeCategories() {
		return (List<Categorie>) categorieDao.findAll();
	}

	@Override
	public List<Article> listeArticles() {
		return (List<Article>) articleDao.findAll();
	}

	@Override
	public List<Article> listeArticlesParNom(String nom) {
		return articleDao.findByNomContaining(nom);
	}

	@Override
	public List<Article> listeArticlesParCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listeArticlesParMois(int mois) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listeArticlesParCategorieEtMois(Categorie categorie, int mois) {
		// TODO Auto-generated method stub
		return null;
	}

}
