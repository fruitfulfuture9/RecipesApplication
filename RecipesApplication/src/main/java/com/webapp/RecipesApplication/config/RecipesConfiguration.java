package com.webapp.RecipesApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.webapp.RecipesApplication.service.RecipeService;

@Configuration
public class RecipesConfiguration {
	
	@Bean
	public RecipeService recipeService() {
		return new RecipeService("recipes.txt");
	}

}
