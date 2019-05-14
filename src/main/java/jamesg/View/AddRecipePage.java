package jamesg.View;

import jamesg.Model.Model;

import javax.swing.*;
import java.awt.*;

public class AddRecipePage extends View {
  private JTextField titleField;
  private JTextField servingField;
  private JTextField timeField;
  private JList ingredientList;
  private JTextField ingredientNameField;
  private JTextField unitField;
  private JButton saveIngredientButton;
  private JButton addIngredientButton;
  private JList taskList;
  private JTextField taskField;
  private JButton taskButton;
  private JButton saveButton;
  private JPanel Edit;
  private JTextField quantityField;
  private JFrame frame;

  /**
   * Constructor
   *
   * @param model cookbook data model
   */
  public AddRecipePage(Model model) {
    this.model = model;
    frame = new JFrame("Recipe Form");
    frame.setContentPane(Edit);
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setMinimumSize(new Dimension(800, 800));
    frame.pack();
    frame.setVisible(false);
  }

  @Override
  public JFrame getFrame() {
    return frame;
  }

  /**
   * Gets titleField
   *
   * @return value of titleField
   */
  public JTextField getTitleField() {
    return titleField;
  }

  /**
   * Gets servingField
   *
   * @return value of servingField
   */
  public JTextField getServingField() {
    return servingField;
  }

  /**
   * Gets timeField
   *
   * @return value of timeField
   */
  public JTextField getTimeField() {
    return timeField;
  }

  /**
   * Gets ingredientList
   *
   * @return value of ingredientList
   */
  public JList getIngredientList() {
    return ingredientList;
  }

  /**
   * Gets ingredientNameField
   *
   * @return value of ingredientNameField
   */
  public JTextField getIngredientNameField() {
    return ingredientNameField;
  }

  /**
   * Gets unitField
   *
   * @return value of unitField
   */
  public JTextField getUnitField() {
    return unitField;
  }

  /**
   * Gets saveIngredientButton
   *
   * @return value of saveIngredientButton
   */
  public JButton getSaveIngredientButton() {
    return saveIngredientButton;
  }

  /**
   * Gets addIngredientButton
   *
   * @return value of addIngredientButton
   */
  public JButton getAddIngredientButton() {
    return addIngredientButton;
  }

  /**
   * Gets taskList
   *
   * @return value of taskList
   */
  public JList getTaskList() {
    return taskList;
  }

  /**
   * Gets taskField
   *
   * @return value of taskField
   */
  public JTextField getTaskField() {
    return taskField;
  }

  /**
   * Gets taskButton
   *
   * @return value of taskButton
   */
  public JButton getTaskButton() {
    return taskButton;
  }

  /**
   * Gets saveButton
   *
   * @return value of saveButton
   */
  public JButton getSaveButton() {
    return saveButton;
  }

  /**
   * Gets Edit
   *
   * @return value of Edit
   */
  public JPanel getEdit() {
    return Edit;
  }

  /**
   * Gets quantityField
   *
   * @return value of quantityField
   */
  public JTextField getQuantityField() {
    return quantityField;
  }
}
