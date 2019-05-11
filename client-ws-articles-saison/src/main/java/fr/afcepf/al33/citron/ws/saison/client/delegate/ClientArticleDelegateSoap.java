package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import fr.afcepf.al33.citron.ws.saison.ws.Article;
import fr.afcepf.al33.citron.ws.saison.ws.Categorie;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceClientArticleSaison;
import fr.afcepf.al33.citron.ws.saison.ws.ServiceClientArticleSaisonImplService;

public class ClientArticleDelegateSoap implements ClientArticleDelegate {

	private ServiceClientArticleSaison proxyWsServiceClientArticleSaison;
	public ClientArticleDelegateSoap() {
		//code d'appel du WS soap qui s'appuie sur le code généré
		//par wsimport -keep -... URL_WSDL
		//.... (...Service).get...Port()
		try {
			String sEndPointUrl = 
					"http://localhost:7878/articlesSaison/service/serviceClientArticleSaison";
			String sWsdlUrl = sEndPointUrl + "?wsdl";
			URL wsdlUrl = new URL(sWsdlUrl);
			this.proxyWsServiceClientArticleSaison
			= (new ServiceClientArticleSaisonImplService(wsdlUrl)).getServiceClientArticleSaisonImplPort();
			
			//preciser l'url soap (seulement si necessaire):
			javax.xml.ws.BindingProvider bp = 
					  (javax.xml.ws.BindingProvider) proxyWsServiceClientArticleSaison;
			Map<String,Object> context = bp.getRequestContext();
			context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,sEndPointUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Categorie> ListeCategories() {
		return proxyWsServiceClientArticleSaison.listeCategories();
	}

	public List<Article> ListeArticles() {
		return proxyWsServiceClientArticleSaison.listeArticles();
	}

	public List<Article> ListeArticlesParCategorie(Categorie categorie) {
		return proxyWsServiceClientArticleSaison.listeArticlesParCategorie(categorie);
	}

	public List<Article> ListeArticlesParCategorieEtMois(Categorie categorie, int mois) {
		return proxyWsServiceClientArticleSaison.listeArticlesParCategorieEtMois(categorie, mois);
	}

	public List<Article> ListeArticlesParMois(int mois) {
		return proxyWsServiceClientArticleSaison.listeArticlesParMois(mois);
	}

	public List<Article> ListeArticlesParNom(String nom) {
		return proxyWsServiceClientArticleSaison.listeArticlesParNom(nom);
	}

}
