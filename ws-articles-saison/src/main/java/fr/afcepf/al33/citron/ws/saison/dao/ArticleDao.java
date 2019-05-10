package fr.afcepf.al33.citron.ws.saison.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.afcepf.al33.citron.ws.saison.entity.Article;
import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

public interface ArticleDao extends CrudRepository<Article,Integer>{

	List<Article> findByNomContaining(String nom);

	List<Article> findByCategorie(Categorie categorie);

    @Query("select a from Article a where "
    		+ "    (a.debutSaison <= a.finSaison and a.debutSaison <= :mois and :mois <= a.finSaison) "
    		+ "or  (a.debutSaison > a.finSaison and a.debutSaison <= :mois and :mois <= a.finSaison)")
    List<Article> findAllByMois(
      @Param("mois") int mois);

    @Query("select a from Article a where "
    		+ " a.categorie = :categorie"
    		+ " and ("
    		+ "       (a.debutSaison <= a.finSaison and a.debutSaison <= :mois and :mois <= a.finSaison) "
    		+ "   or  (a.debutSaison > a.finSaison and a.debutSaison <= :mois and :mois <= a.finSaison)"
    		+ " )")
    List<Article> findAllByCategorieAndMois(
    		@Param("categorie") Categorie categorie,
    		@Param("mois") int mois);
    
	/*
	//méthodes héritées de CrudRepository:
	Optional<Article> findById(Integer id);
	List<Article> findAll();
	void save(Article c);//au sens saveOrUpdate (selon id null ou pas)
	void deleteById(Integer id);
	*/

}
