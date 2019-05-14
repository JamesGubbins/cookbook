package jamesg.View;

import jamesg.Model.Model;

import javax.swing.*;
import java.awt.*;

/** This is the class storing all the main page form objects */
public class MainPage extends View {
  private JPanel Main;
  private JList recipeList;
  private JTextArea recipeInfo;
  private JLabel recipeName;
  public JButton saveButton;
  public JButton addRecipeButton;
  private JButton deleteButton;
  public String selected;
  private JFrame frame;

  /**
   * Constructor of class
   *
   * @param model the model that has the recipe data
   */
  public MainPage(final Model model) {
    // Instantiate form
    this.model = model;
    frame = new JFrame("Model Viewer");
    frame.setContentPane(Main);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setMinimumSize(new Dimension(800, 800));
    frame.pack();
    frame.setVisible(true);

    // Sets a selected value for the list
    setList(model.getRecipeList());
  }

  /**
   * Sets the first item in the list as selected
   *
   * @param listModel the data that is stored in the list
   */
  public void setList(DefaultListModel listModel) {
    // setting the model returns an NullPointerException that can be ignored
    try {
      recipeList.setModel(listModel);
    } catch (NullPointerException e) {
      // Do nothing
    }
    recipeList.setSelectedIndex(0);
    showSelectedRecipe();
  }

  /** This shows the selected recipe information */
  public void showSelectedRecipe() {
    selected = recipeList.getSelectedValue().toString();
    recipeName.setText(selected);
    recipeInfo.setText(model.getRecipeInformation(selected));
  }

  @Override
  public JFrame getFrame() {
    return frame;
  }

  /**
   * Gets Main
   *
   * @return value of Main
   */
  public JPanel getMain() {
    return Main;
  }

  /**
   * Gets recipeList
   *
   * @return value of recipeList
   */
  public JList getRecipeList() {
    return recipeList;
  }

  /**
   * Gets recipeInfo
   *
   * @return value of recipeInfo
   */
  public JTextArea getRecipeInfo() {
    return recipeInfo;
  }

  /**
   * Gets recipeName
   *
   * @return value of recipeName
   */
  public JLabel getRecipeName() {
    return recipeName;
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
   * Gets addRecipeButton
   *
   * @return value of addRecipeButton
   */
  public JButton getAddRecipeButton() {
    return addRecipeButton;
  }

  /**
   * Gets deleteButton
   *
   * @return value of deleteButton
   */
  public JButton getDeleteButton() {
    return deleteButton;
  }

  /**
   * Gets selected
   *
   * @return value of selected
   */
  public String getSelected() {
    return selected;
  }
}
