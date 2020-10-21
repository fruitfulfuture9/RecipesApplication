package com.webapp.RecipesApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webapp.RecipesApplication.domain.Recipe;

@Repository
public class RecipeRepository {
	
	private List<Recipe> recipes = new ArrayList<>(100);
	
	public List<Recipe> getAllRecipes(){
		return recipes;
	}

}
