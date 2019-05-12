package fr.afcepf.al33.citron.ws.saison.client;

import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;

import fr.afcepf.al33.citron.ws.saison.client.delegate.AdminArticleDelegate;
import fr.afcepf.al33.citron.ws.saison.client.delegate.AdminArticleDelegateRest;
import fr.afcepf.al33.citron.ws.saison.client.delegate.ClientArticleDelegate;
import fr.afcepf.al33.citron.ws.saison.client.delegate.ClientArticleDelegateSoap;
import fr.afcepf.al33.citron.ws.saison.client.dto.ArticleDto;
import fr.afcepf.al33.citron.ws.saison.client.dto.CategorieDto;
import fr.afcepf.al33.citron.ws.saison.ws.Article;
import fr.afcepf.al33.citron.ws.saison.ws.Categorie;

public class TestAppelWsSoapEtRestApp {

	
    // A  lancer via Run as / java application
	public static void main(String[] args) {
		
		DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
		String[] moisFR = dfsFR.getMonths();
		
		// test AdminArticleDelegateRest
		
		AdminArticleDelegate adminArticleDelegate = new AdminArticleDelegateRest();
		
		CategorieDto categorieEpices = new CategorieDto(0, "épices");
		CategorieDto savedCategorie = adminArticleDelegate.sauvegarderCategorie(categorieEpices);
		System.out.println("*** test adminArticleDelegate.sauvegarderCategorie() = " + savedCategorie);
		System.out.println("*** test adminArticleDelegate.listeCategories() = " + adminArticleDelegate.listeCategories());
		System.out.println("*** test adminArticleDelegate.categorieParId(1) = " + adminArticleDelegate.categorieParId(1));
		System.out.println("*** test adminArticleDelegate.supprimerCategorieParId(3)"); adminArticleDelegate.supprimerCategorieParId(3);
		System.out.println("*** test après supprimerCategorieParId(3) listeCategories() = " + adminArticleDelegate.listeCategories());
		
		CategorieDto categorieFruits = new CategorieDto(1, "fruits");
		ArticleDto savedArticle = adminArticleDelegate.sauvegarderArticle(
				new ArticleDto(0,"fruit test", 1, 12, categorieFruits));
		System.out.println("*** test adminArticleDelegate.sauvegarderArticle() = " + savedArticle);
		System.out.println("*** test adminArticleDelegate.listeArticles() = " + adminArticleDelegate.listeArticles());
		System.out.println("*** test adminArticleDelegate.articleParId(1) = " + adminArticleDelegate.articleParId(1));
		System.out.println("*** test adminArticleDelegate.supprimerArticleParId(1)"); adminArticleDelegate.supprimerArticleParId(1);
		System.out.println("*** test après supprimerArticleParId(1) listeArticles() = " + adminArticleDelegate.listeArticles());
		
		
		
		// test ClientArticleDelegateSoap
		
		ClientArticleDelegate clientArticleDelegate = new ClientArticleDelegateSoap();
		
		DateTime dateTime = new DateTime(new Date());
		int mois = dateTime.getMonthOfYear();
		
		List<Article> articlesMois = clientArticleDelegate.ListeArticlesParMois(mois);
		System.out.println("*** test clientArticleDelegate articles de saison pour le mois de " + moisFR[mois - 1] + " : \n");
		for (Article article : articlesMois) {
			System.out.println(article.getNom() + " de " + moisFR[article.getDebutSaison() - 1]
												+ " à " + moisFR[article.getFinSaison() - 1]);
		}
		
		Categorie fruits = new Categorie();
		fruits.setId(1);
		fruits.setNom("fruits");
		List<Article> fruitsMois = clientArticleDelegate.ListeArticlesParCategorieEtMois(fruits, mois);
		System.out.println("*** test clientArticleDelegate fruits de saison pour le mois de " + moisFR[mois - 1] + " : \n");
		for (Article article : fruitsMois) {
			System.out.println(article.getNom() + " de " + moisFR[article.getDebutSaison() - 1]
												+ " à " + moisFR[article.getFinSaison() - 1]);
		}
				
		String libelle = "pomme";
		List<Article> pommes = clientArticleDelegate.ListeArticlesParNom(libelle);
		System.out.println("*** test clientArticleDelegate articles avec [" + libelle + "] : \n");
		for (Article article : pommes) {
			System.out.println(article.getNom() + " de " + moisFR[article.getDebutSaison() - 1]
												+ " à " + moisFR[article.getFinSaison() - 1]);
		}
		
	}

}
