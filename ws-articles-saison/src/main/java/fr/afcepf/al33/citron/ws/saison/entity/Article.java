package fr.afcepf.al33.citron.ws.saison.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the article database table.
 * 
 */

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment géré par mysql ou h2
	private int id;

	@Column(length=80) //VARCHAR(80)
	private String nom;
	private int debutSaison;
	private int finSaison;
	
	@ManyToOne
	@JoinColumn(name="categorie_id") //nom de la colonne clef etrangère 
	private Categorie categorie;

	@Override
	public String toString() {
		return "Article [nom=" + nom + ", debutSaison=" + debutSaison + ", finSaison=" + finSaison + "]";
	}

	
}