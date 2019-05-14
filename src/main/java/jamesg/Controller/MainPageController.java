package jamesg.Controller;

import jamesg.Model.Model;
import jamesg.View.MainPage;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageController extends Controller {
  private MainPage view;
  private AddRecipePageController editController;

  /**
   * Ther controller for the main page
   *
   * @param model the data model
   * @param view the MainPage object
   * @param addPage the add recipe page controller
   */
  public MainPageController(
      final Model model, final MainPage view, AddRecipePageController addPage) {
    this.model = model;
    this.view = view;
    this.editController = addPage;
    /*
    Add Listeners
     */
    // Opens form for adding recipe
    view.getAddRecipeButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                editController.newRecipe();
              }
            });
    // Shows recipe information when selected from list
    view.getRecipeList()
        .addListSelectionListener(
            new ListSelectionListener() {

              @Override
              public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                  view.showSelectedRecipe();
                }
              }
            });
    // Deletes selected recipe
    view.getDeleteButton()
        .addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                model.deleteRecipe(view.selected);
                model.saveCookbook();
                refreshList();
              }
            });
  }

  /** Refreshes the recipe list */
  public void refreshList() {
    view.setList(model.getRecipeList());
  }
}
