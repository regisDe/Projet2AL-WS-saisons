package fr.afcepf.al33.citron.ws.saison.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the categorie database table.
 * 
 */

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@XmlType(namespace="http://entity.ws.saison.ws.citron.al33.afcepf.fr/")
@XmlAccessorType(XmlAccessType.FIELD)//pour que @XmlTRansient soit interprété sur du private.
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	
	@JsonIgnore
	@XmlTransient
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
