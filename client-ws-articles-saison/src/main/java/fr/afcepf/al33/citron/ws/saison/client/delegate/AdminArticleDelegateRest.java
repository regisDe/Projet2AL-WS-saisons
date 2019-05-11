package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import fr.afcepf.al33.citron.ws.saison.client.dto.ArticleDto;
import fr.afcepf.al33.citron.ws.saison.client.dto.CategorieDto;

public class AdminArticleDelegateRest implements AdminArticleDelegate {

	private Client jaxrs2client;
	
	private String debutUrlCategories="http://localhost:7878/articlesSaison/rest/categories";
	private String debutUrlCategoriesPublic="http://localhost:7878/articlesSaison/rest/public/categories";

	private String debutUrlArticles="http://localhost:7878/articlesSaison/rest/articles";
	private String debutUrlArticlesPublic="http://localhost:7878/articlesSaison/rest/public/articles";
	
	public AdminArticleDelegateRest() {
		this.jaxrs2client = ClientBuilder.newClient()
				            .register(JacksonFeature.class);
	}
	

	public CategorieDto categorieParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<CategorieDto> ListeCategories() {
		// TODO Auto-generated method stub
		return null;
	}


	public CategorieDto sauvegarderCategorie(CategorieDto categorie) {
		// TODO Auto-generated method stub
		return null;
	}


	public void supprimerCategorieParId(int id) {
		// TODO Auto-generated method stub
		
	}


	public ArticleDto articleParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<ArticleDto> ListeArticles() {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticlesPublic);
		ArticleDto[] tabArticles= 
				articlesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(ArticleDto[].class);
		return Arrays.asList(tabArticles);
	}

	public ArticleDto sauvegarderArticle(ArticleDto article) {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticles);
		Response responseSavedArticle =  
				articlesTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .post(Entity.entity(article, MediaType.APPLICATION_JSON_TYPE) );
		if(responseSavedArticle.getStatus()==200 /*OK*/) {
			return responseSavedArticle.readEntity(ArticleDto.class);
		}
		else 
			return null;
	}

	public void supprimerArticleParId(int id) {
		// TODO Auto-generated method stub
		
	}

}
