
package fr.afcepf.al33.citron.ws.saison.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour listeArticlesParMois complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="listeArticlesParMois">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "listeArticlesParMois", propOrder = {
    "mois"
})
public class ListeArticlesParMois {

    protected int mois;

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
