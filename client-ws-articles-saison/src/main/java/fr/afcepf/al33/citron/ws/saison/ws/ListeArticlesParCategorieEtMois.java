
package fr.afcepf.al33.citron.ws.saison.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import fr.afcepf.al33.citron.ws.saison.ws.entity.Categorie;


/**
 * <p>Classe Java pour listeArticlesParCategorieEtMois complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="listeArticlesParCategorieEtMois">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categorie" type="{http://entity.ws.saison.ws.citron.al33.afcepf.fr/}categorie" minOccurs="0"/>
 *         &lt;element name="mois" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listeArticlesParCategorieEtMois", propOrder = {
    "categorie",
    "mois"
})
public class ListeArticlesParCategorieEtMois {

    protected Categorie categorie;
    protected int mois;

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
     * Obtient la valeur de la propri�t� mois.
     * 
     */
    public int getMois() {
        return mois;
    }

    /**
     * D�finit la valeur de la propri�t� mois.
     * 
     */
    public void setMois(int value) {
        this.mois = value;
    }

}
