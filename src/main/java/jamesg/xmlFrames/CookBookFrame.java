package jamesg.xmlFrames;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/** XML frame for xml parsing */
@Root(name = "Model")
public class CookBookFrame {
  @ElementList private List<RecipeFrame> RecipeFrames;
  @Attribute private String name;

  /**
   * Gets RecipeFrames
   *
   * @return value of RecipeFrames
   */
  public List<RecipeFrame> getRecipeFrames() {
    return RecipeFrames;
  }

  /**
   * Sets RecipeFrames
   *
   * @param recipeFrames new value
   */
  public void setRecipeFrames(List<RecipeFrame> recipeFrames) {
    this.RecipeFrames = recipeFrames;
  }

  /**
   * Gets name
   *
   * @return value of name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name
   *
   * @param name new value
   */
  public void setName(String name) {
    this.name = name;
  }
}
