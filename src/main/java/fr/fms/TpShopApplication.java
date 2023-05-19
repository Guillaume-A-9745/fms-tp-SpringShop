package fr.fms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class TpShopApplication implements CommandLineRunner {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//feedDatabase(); 														//Alimenter la base de donner
		System.out.println("Bienvenu dans le SpringShop\n Voici la liste des articles disponibles :");
		
		List<Article> articles = articleRepository.findAll();
		for(Article article : articles) {					//Afficher tous les articles
			System.out.println(article);
		}
							
				
	}
	
	public void feedDatabase() {
		Category smartphone = categoryRepository.save(new Category("Smartphone", "Les derniere generation de téléphones mobiles"));
		Category tablet = categoryRepository.save(new Category("Tablet", "Les dérnière générations de tablets"));
		Category pc = categoryRepository.save(new Category("PC", "ordinateur portable ou odinateur de bureau"));
		Category hardware = categoryRepository.save(new Category("Hardware", "Tout le materiel informatique"));
		
		articleRepository.save(new Article("S10","Samsung", 500, smartphone));
		articleRepository.save(new Article("S9","Samsung", 350, smartphone));
		articleRepository.save(new Article("MI10","Xiaomi", 100, smartphone));
		articleRepository.save(new Article("Iphone 10","Apple", 900, smartphone));
		articleRepository.save(new Article("Iphone 11","Apple", 1500, smartphone));
		
		articleRepository.save(new Article("Galaxy Tab","Samsung", 450, tablet));
		articleRepository.save(new Article("Ipad","Apple", 350, tablet));
		
		articleRepository.save(new Article("R510","Asus", 600, pc));
		articleRepository.save(new Article("MacBook","Apple", 2000, pc));
		articleRepository.save(new Article("Laptop","HP", 1199, pc));
		
		articleRepository.save(new Article("Souris","Logitoch", 65, hardware));
		articleRepository.save(new Article("Clavier","Microhard", 49.5, hardware));
		articleRepository.save(new Article("Tapis souris","Chapeau Bleu", 8, hardware));
	}
}
