package fr.afcepf.al33.citron.ws.saison.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.citron.ws.saison.entity.Article;

public interface ArticleDao extends CrudRepository<Article,Integer>{

	List<Article> findByNomContaining(String nom);

	/*
	//méthodes héritées de CrudRepository:
	Optional<Article> findById(Integer id);
	List<Article> findAll();
	void save(Article c);//au sens saveOrUpdate (selon id null ou pas)
	void deleteById(Integer id);
	*/

}
