package jamesg;

import jamesg.Controller.AddRecipePageController;
import jamesg.Controller.MainPageController;
import jamesg.Model.Model;
import jamesg.View.AddRecipePage;
import jamesg.View.MainPage;

public class App {
  public static void main(String[] args) {
    // Instantiate Objects
    Model model = new Model();
    MainPage mainView = new MainPage(model);
    AddRecipePage addRecipePage = new AddRecipePage(model);
    AddRecipePageController addRecipePageController =
        new AddRecipePageController(model, addRecipePage);
    MainPageController mainController =
        new MainPageController(model, mainView, addRecipePageController);
    addRecipePageController.setMainPageController(mainController);
  }
}
