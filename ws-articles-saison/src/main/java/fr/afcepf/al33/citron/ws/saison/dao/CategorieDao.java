package fr.afcepf.al33.citron.ws.saison.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.citron.ws.saison.entity.Categorie;

public interface CategorieDao extends CrudRepository<Categorie,Integer>{
	/*
	//méthodes héritées de CrudRepository:
	Optional<Categorie> findById(Integer id);
	List<Categorie> findAll();
	void save(Categorie c);//au sens saveOrUpdate (selon id null ou pas)
	void deleteById(Integer id);
	*/
	
}
