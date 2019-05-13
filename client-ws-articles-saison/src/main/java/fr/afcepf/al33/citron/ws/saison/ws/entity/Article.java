
package fr.afcepf.al33.citron.ws.saison.ws.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour article complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="article">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categorie" type="{http://entity.ws.saison.ws.citron.al33.afcepf.fr/}categorie" minOccurs="0"/>
 *         &lt;element name="debutSaison" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="finSaison" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "article", propOrder = {
    "categorie",
    "debutSaison",
    "finSaison",
    "id",
    "nom"
})
public class Article {

    protected Categorie categorie;
    protected int debutSaison;
    protected int finSaison;
    protected int id;
    protected String nom;

    /**
     * Obtient la valeur de la propri�t� categorie.
     * 
     * @return
     *     possible object is
     *     {@link Categorie }
     *     
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * D�finit la valeur de la propri�t� categorie.
     * 
     * @param value
     *     allowed object is
     *     {@link Categorie }
     *     
     */
    public void setCategorie(Categorie value) {
        this.categorie = value;
    }

    /**
     * Obtient la valeur de la propri�t� debutSaison.
     * 
     */
    public int getDebutSaison() {
        return debutSaison;
    }

    /**
     * D�finit la valeur de la propri�t� debutSaison.
     * 
     */
    public void setDebutSaison(int value) {
        this.debutSaison = value;
    }

    /**
     * Obtient la valeur de la propri�t� finSaison.
     * 
     */
    public int getFinSaison() {
        return finSaison;
    }

    /**
     * D�finit la valeur de la propri�t� finSaison.
     * 
     */
    public void setFinSaison(int value) {
        this.finSaison = value;
    }

    /**
     * Obtient la valeur de la propri�t� id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * D�finit la valeur de la propri�t� id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propri�t� nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * D�finit la valeur de la propri�t� nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

}
