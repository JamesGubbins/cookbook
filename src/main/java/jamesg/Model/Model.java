package jamesg.Model;

import jamesg.xmlFrames.CookBookFrame;
import jamesg.xmlFrames.IngredientFrame;
import jamesg.xmlFrames.RecipeFrame;
import jamesg.xmlFrames.StepFrame;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/** Acts as a wrapper for the cookbook */
public class Model {
  private CookBookFrame cookbook;
  private String filePath = "cookbook.xml";

  public Model() {
    cookbook = Model.loadCookbook(filePath);
  }

  /**
   * Gets cookbook
   *
   * @return value of cookbook
   */
  public CookBookFrame getCookbook() {
    return cookbook;
  }

  /**
   * Gets list of recipes in DefaultListMode form
   *
   * @return list of recipes in DefaultListMode form
   */
  public DefaultListModel getRecipeList() {
    ArrayList<String> recipeNames = Model.getRecipeNames(cookbook);
    DefaultListModel listModel = new DefaultListModel();
    for (String name : recipeNames) {
      listModel.addElement(name);
    }
    return listModel;
  }

  /**
   * Gets list of recipe ingredients in DefaultListMode form
   *
   * @return list of recipe ingredients in DefaultListMode form
   */
  public DefaultListModel getIngredientList(String recipeName) {
    RecipeFrame recipe = getRecipe(recipeName);
    ArrayList<IngredientFrame> ingredients = new ArrayList<>(recipe.getIngredientFrames());
    DefaultListModel listModel = new DefaultListModel();
    for (IngredientFrame ingredient : ingredients) {
      listModel.addElement(ingredient.getName());
    }
    return listModel;
  }

  /**
   * Gets list of recipe steps in DefaultListMode form
   *
   * @return list of recipe steps in DefaultListMode form
   */
  public DefaultListModel getStepList(String recipeName) {
    RecipeFrame recipe = getRecipe(recipeName);
    ArrayList<StepFrame> steps = new ArrayList<>(recipe.getStepFrames());
    DefaultListModel listModel = new DefaultListModel();
    for (StepFrame step : steps) {
      listModel.addElement(step.getDesc());
    }
    return listModel;
  }

  /**
   * Gets a list of recipe names
   *
   * @param cookBook the cookbook
   * @return a list of recipe name strings
   */
  public static ArrayList<String> getRecipeNames(CookBookFrame cookBook) {
    ArrayList<String> recipeNames = new ArrayList<String>();
    ArrayList<RecipeFrame> recipes = new ArrayList(cookBook.getRecipeFrames());
    for (RecipeFrame recipe : recipes) {
      recipeNames.add(recipe.getTitle());
    }
    return recipeNames;
  }

  /**
   * Loads the cookbook at path
   *
   * @param path path to cookbook cml file
   * @return A CookbookFrame object of the XML file
   */
  public static CookBookFrame loadCookbook(String path) {
    Serializer serializer = new Persister();
    File source = new File(path);
    CookBookFrame cookbook = null;
    try {
      return serializer.read(CookBookFrame.class, source);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * * Constructs a string from recipe data
   *
   * @param recipeName name of recipe
   * @return string of recipe data
   */
  public String getRecipeInformation(String recipeName) {
    RecipeFrame recipe = getRecipe(recipeName);
    StringBuilder recipeInfo = new StringBuilder();

    recipeInfo.append("Cooking Time: " + recipe.getTime() + " minute(s)\n");
    recipeInfo.append("Serving Size: " + recipe.getServing() + "\n");

    // Ingredient Information
    recipeInfo.append("Ingredients:\n");
    for (IngredientFrame ingredient : recipe.getIngredientFrames()) {
      recipeInfo.append("    ");
      // Different wording for ingredients without a unit (eg 1 potato)
      if (ingredient.getUnit() == "") {
        recipeInfo.append(ingredient.getQuantity() + " " + ingredient.getUnit() + " ");
      } else {
        recipeInfo.append(ingredient.getQuantity() + " " + ingredient.getUnit() + " of ");
      }
      recipeInfo.append(ingredient.getName() + "\n");
    }

    // Cooking Instructions
    recipeInfo.append("Cooking Instructions\n");
    for (StepFrame step : recipe.getStepFrames()) {
      recipeInfo.append("    " + step.getNo());
      recipeInfo.append(".    " + step.getDesc() + "\n");
    }
    return recipeInfo.toString();
  }

  /**
   * Gets a recipe by its name
   *
   * @param recipeName name of recipe
   * @return RecipeFrame of recipe, or null if recipe not found
   */
  public RecipeFrame getRecipe(String recipeName) {
    ArrayList<RecipeFrame> recipes = new ArrayList(cookbook.getRecipeFrames());
    for (RecipeFrame recipe : recipes) {
      if (recipe.getTitle() == recipeName) {
        return recipe;
      }
    }
    return null;
  }

  /**
   * Deletes recipe matching the given name
   *
   * @param recipeName name of recipe to be deleted
   */
  public void deleteRecipe(String recipeName) {
    ArrayList<RecipeFrame> recipes = new ArrayList(cookbook.getRecipeFrames());
    for (int i = 0; i < recipes.size(); i++) {
      if (recipes.get(i).getTitle() == recipeName) {
        cookbook.getRecipeFrames().remove(i);
        return;
      }
    }
  }

  /** Saves the cookbook to the xml file */
  public void saveCookbook() {
    Serializer serializer = new Persister();
    File output = new File(filePath);
    try {
      serializer.write(cookbook, output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
