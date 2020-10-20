package com.webapp.RecipesApplication.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.webapp.RecipesApplication.domain.Recipe;


public class RecipeService {
	
	private String filename;
	
	
	public RecipeService(String filename) {
		this.filename = filename;
	}

	
	public List<Recipe> ingestRecipesFile(){
		
		 List<Recipe> recipes = new ArrayList<>();
		
		  Integer cookingMinutes;
		  
          Boolean dairyFree;

	     Boolean glutenFree;

	     String instructions;

	     Double preparationMinutes;

	     Double pricePerServing;

	     Integer readyInMinutes;

	     Integer servings;

	     Double spoonacularScore;

	     String title;

	     Boolean vegan;

	     Boolean vegetarian;
		
		try {
		Reader reader = new FileReader(filename);
		final CSVParser parser = new CSVParser(reader, CSVFormat
				                                        .DEFAULT
				                                        .withDelimiter(',')
				                                        .withEscape('\\') // full double quote escape
				                                        .withFirstRecordAsHeader()
				                                        .withSkipHeaderRecord()
				                                        .withIgnoreSurroundingSpaces()
				                                        );
		
		
		for (CSVRecord record : parser) {
			cookingMinutes = Integer.parseInt(record.get("Cooking Minutes")) ;
			dairyFree = Boolean.valueOf(record.get("Dairy Free"));
			glutenFree =  Boolean.valueOf(record.get("Gluten Free"));
			instructions = record.get("Instructions");
			preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
            pricePerServing	= Double.parseDouble(record.get("Price Per Serving")); 	
            readyInMinutes = Integer.parseInt(record.get("Ready In Minutes")) ;
            servings = Integer.parseInt(record.get("Servings")) ;
            spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
            title = record.get("Title");
            vegan = Boolean.valueOf(record.get("Vegan"));
            vegetarian = Boolean.valueOf(record.get("Vegetarian"));
            
            Recipe recipe = new Recipe( cookingMinutes,  dairyFree,  glutenFree,  instructions,
			 preparationMinutes,  pricePerServing,  readyInMinutes,  servings,
			 spoonacularScore,  title,  vegan,  vegetarian);
            
            recipes.add(recipe);
            
		    System.out.println(title);
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total no of recipes from the file : "+recipes.size());
		return recipes;
	}
	
}
