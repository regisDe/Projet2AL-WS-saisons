package fr.afcepf.al33.citron.ws.saison.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the categorie database table.
 * 
 */

@Getter @Setter @NoArgsConstructor
@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
	//mappedBy="nom java de la relation inverse manyToOne"
	private List<Article> articles;	
	
	@Override
	public String toString() {
		return "Categorie [nom=" + nom + "]";
	}

	public Categorie(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	
	
}
