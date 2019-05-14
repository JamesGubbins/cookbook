package jamesg.Controller;

import jamesg.Model.Model;
import jamesg.View.AddRecipePage;
import jamesg.xmlFrames.IngredientFrame;
import jamesg.xmlFrames.RecipeFrame;
import jamesg.xmlFrames.StepFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** The controller for the AddRecipePage view */
public class AddRecipePageController extends Controller {
  private AddRecipePage view;
  private ArrayList<IngredientFrame> ingredients;
  private ArrayList<StepFrame> steps;
  private MainPageController mainPageController;

  /**
   * Constructor NOTE: After a MainPageController has been created call setMainPageController() with
   * the created MainPageController
   *
   * @param model The model that has the data to be interacted with
   * @param view the view being controlled
   */
  public AddRecipePageController(final Model model, final AddRecipePage view) {
    this.model = model;
    this.view = view;
    ingredients = new ArrayList<>();
    steps = new ArrayList<>();
  }

  /** Opens add recipe form for a new recipe */
  public void newRecipe() {
    // Clear fields
    view.getTitleField().setText("");
    view.getServingField().setText("");
    view.getTimeField().setText("");
    view.getIngredientNameField().setText("");
    view.getQuantityField().setText("");
    view.getUnitField().setText("");
    view.getTaskField().setText("");
    view.getTaskList().setModel(new DefaultListModel());
    view.getIngredientList().setModel(new DefaultListModel());

    view.getFrame().setVisible(true);
  }

  /**
   * Sets the MainPageController value MUST be set before any other actions
   *
   * @param main MainPageController object
   */
  public void setMainPageController(MainPageController main) {
    this.mainPageController = main;
    addListeners();
  }

  /** Sets the listners for the view */
  public void addListeners() {
    // Save input step
    view.getTaskButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                StepFrame stepFrame = new StepFrame();
                // Stop steps starting at 0
                stepFrame.setNo(steps.size() + 1);
                // Set Step
                stepFrame.setDesc(view.getTaskField().getText());
                steps.add(stepFrame);
                // Update List
                DefaultListModel listModel = (DefaultListModel) view.getTaskList().getModel();
                listModel.add(listModel.getSize(), stepFrame.getDesc());
                view.getTaskList().setModel(listModel);
                // Clear input
                view.getTaskField().setText("");
              }
            });
    // Save input ingredient
    view.getAddIngredientButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                IngredientFrame ingredient = new IngredientFrame();
                // Check if numbers entered are valid before any other action
                try {
                  ingredient.setQuantity(Integer.parseInt(view.getQuantityField().getText()));
                } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(
                      view.getFrame(), "Error: Quanitiy entered is not a number");
                  return;
                }
                // Get field values
                ingredient.setName(view.getIngredientNameField().getText());
                ingredient.setUnit(view.getUnitField().getText());
                ingredients.add(ingredient);
                // Update List
                DefaultListModel listModel = (DefaultListModel) view.getIngredientList().getModel();
                listModel.add(listModel.getSize(), ingredient.getName());
                view.getIngredientList().setModel(listModel);
                // Clear fields
                view.getIngredientNameField().setText("");
                view.getUnitField().setText("");
                view.getQuantityField().setText("");
              }
            });
    // Saves the recipe
    view.getSaveButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

                RecipeFrame recipe = new RecipeFrame();
                // Check if numbers entered are valid before any other action
                try {
                  recipe.setServing(Integer.parseInt(view.getServingField().getText()));
                  recipe.setTime(Integer.parseInt(view.getTimeField().getText()));
                } catch (NumberFormatException ex) {
                  JOptionPane.showMessageDialog(
                      view.getFrame(),
                      "Error: Serving size or Cooking time entered is not a number");
                  return;
                }
                // Get information
                recipe.setTitle(view.getTitleField().getText());
                recipe.setId(model.getCookbook().getRecipeFrames().size() + 1);
                recipe.setStepFrames(steps);
                recipe.setIngredientFrames(ingredients);
                // Save recipe
                model.getCookbook().getRecipeFrames().add(recipe);
                // Clear Steps and ingredients
                ingredients = new ArrayList<>();
                steps = new ArrayList<>();
                model.saveCookbook();
                // Close form and update recipe list on main page
                view.getFrame().setVisible(false);
                mainPageController.refreshList();
              }
            });
  }
}
