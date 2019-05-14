package jamesg.xmlFrames;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/** XML frame for xml parsing */
@Root
public class RecipeFrame {
  @Attribute private int id;
  @Element private String title;
  @ElementList private List<IngredientFrame> IngredientFrames;
  @Element private int time;
  @Element private int serving;
  @ElementList private List<StepFrame> stepFrames;

  /**
   * Gets id
   *
   * @return value of id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets id
   *
   * @param id new value
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets title
   *
   * @return value of title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets title
   *
   * @param title new value
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets IngredientFrames
   *
   * @return value of IngredientFrames
   */
  public List<IngredientFrame> getIngredientFrames() {
    return IngredientFrames;
  }

  /**
   * Sets IngredientFrames
   *
   * @param ingredientFrames new value
   */
  public void setIngredientFrames(List<IngredientFrame> ingredientFrames) {
    this.IngredientFrames = ingredientFrames;
  }

  /**
   * Gets time
   *
   * @return value of time
   */
  public int getTime() {
    return time;
  }

  /**
   * Sets time
   *
   * @param time new value
   */
  public void setTime(int time) {
    this.time = time;
  }

  /**
   * Gets serving
   *
   * @return value of serving
   */
  public int getServing() {
    return serving;
  }

  /**
   * Sets serving
   *
   * @param serving new value
   */
  public void setServing(int serving) {
    this.serving = serving;
  }

  /**
   * Gets stepFrames
   *
   * @return value of stepFrames
   */
  public List<StepFrame> getStepFrames() {
    return stepFrames;
  }

  /**
   * Sets stepFrames
   *
   * @param stepFrames new value
   */
  public void setStepFrames(List<StepFrame> stepFrames) {
    this.stepFrames = stepFrames;
  }
}
