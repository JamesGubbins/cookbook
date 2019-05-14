package jamesg.xmlFrames;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/** XML frame for xml parsing */
@Root
public class IngredientFrame {
  @Attribute private String name;
  @Attribute private int quantity;
  @Attribute private String unit;

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

  /**
   * Gets quantity
   *
   * @return value of quantity
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity
   *
   * @param quantity new value
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Gets unit
   *
   * @return value of unit
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Sets unit
   *
   * @param unit new value
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }
}
