package com.webapp.RecipesApplication.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.RecipesApplication.domain.Recipe;
import com.webapp.RecipesApplication.service.RecipeService;

@RestController
public class RecipesController {
	
	
	@Autowired
	private RecipeService recipeService;
	
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() throws IOException {
		 return recipeService.getAllRecipes();
		 
		
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFreeRecipes() {
		return recipeService.getAllRecipes()
				            .stream()
				            .filter(recipe -> recipe.getGlutenFree().equals(true))
				            .collect(Collectors.toList());
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVeganRecipes() {
		return recipeService.getAllRecipes()
	            .stream()
	            .filter(recipe -> recipe.getVegan().equals(true))
	            .collect(Collectors.toList());
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFreeRecipes() {
		return recipeService.getAllRecipes()
	            .stream()
	            .filter(recipe -> (recipe.getVegan().equals(true) &&  recipe.getGlutenFree().equals(true)))
	            .collect(Collectors.toList());
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarianRecipes() {
		return recipeService.getAllRecipes()
	            .stream()
	            .filter(recipe -> recipe.getVegetarian().equals(true))
	            .collect(Collectors.toList());
	}

}
