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

public class TestAppelWsSoapEtRestApp {

	
    // A  lancer via Run as / java application
	public static void main(String[] args) {
		
		DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);
		String[] moisFR = dfsFR.getMonths();
		
		AdminArticleDelegate adminArticleDelegate = new AdminArticleDelegateRest();
		CategorieDto categorieFruits = new CategorieDto(1, "fruits");
		ArticleDto savedArticle = adminArticleDelegate.sauvegarderArticle(
				new ArticleDto(0,"fruit test", 1, 12, categorieFruits));
		System.out.println("savedArticle="+savedArticle);
		System.out.println("tousArticles="+adminArticleDelegate.ListeArticles());
		
		
		
		ClientArticleDelegate clientArticleDelegate 
		= new ClientArticleDelegateSoap();
		
		DateTime dateTime = new DateTime(new Date());
		int mois = dateTime.getMonthOfYear();
		
		List<Article> articlesMois = clientArticleDelegate.ListeArticlesParMois(mois);
		System.out.println("articles de saison pour le mois de " + moisFR[mois - 1] + " : \n");
		for (Article article : articlesMois) {
			System.out.println(article.getNom() + " de " + moisFR[article.getDebutSaison() - 1]
												+ " à " + moisFR[article.getFinSaison() - 1]);
		}
	}

}
