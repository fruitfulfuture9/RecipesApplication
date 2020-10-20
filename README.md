Assignment #8

For this assignment, you’ll need to ingest a recipe.txt file and store this information in a Java Collection of your choice. You will need to use the Apache Commons CSV project to parse the text file. The final video in this week’s lessons shows you how to import the Apache Commons CSV project.

When parsing the text file, you should store the data in the following POJO:

public class Recipe {

     private Integer cookingMinutes;

     private Boolean dairyFree;

     private Boolean glutenFree;

     private String instructions;

     private Double preparationMinutes;

     private Double pricePerServing;

     private Integer readyInMinutes;

     private Integer servings;

     private Double spoonacularScore;

     private String title;

     private Boolean vegan;

     private Boolean vegetarian;

    
     // INSERT GETTERS & SETTERS HERE

}

 
Once you’ve ingested the recipe.txt file and stored the resulting POJOs into a Collection, your next task is to create “endpoints” inside of a RestController that will filter this data.

 
You should implement the following endpoints:

@GetMapping("/gluten-free")

@GetMapping("/vegan")

@GetMapping("/vegan-and-gluten-free")

@GetMapping("/vegetarian")

@GetMapping("/all-recipes")

 
The “all-recipes” endpoint will not filter the data at all and should return the full Collection.

The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true

The “vegan” endpoint will only return a subset of the full Collection where vegan is true

The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and vegan is true

The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true

   
Hints
 
To get started, be sure to visit start.spring.io and download a fresh new Spring Boot project. You’ll need to import it into your IDE (you learned how to do this in one of the first video lessons from this week).

I recommend creating a RestController, a Service, and if you like you can create a Repository where the Collection of Recipe POJOs can be stored.

 
Try to remember to use good naming conventions for your Objects and the packages they exist inside of.

 
You may also need to create a Configuration class, but that will depend on how you structure your code. So, a Configuration class may not be needed.

 
Do not put any extra code in your program’s "main" method. Just leave whatever code was auto-created for you as is.

