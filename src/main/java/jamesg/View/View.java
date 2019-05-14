package jamesg.View;

import jamesg.Model.Model;

import javax.swing.*;

/** The abstract class for classes associated with a swing form */
public abstract class View {
  protected Model model;

  /**
   * Gets Frame object
   *
   * @return JFrame object of swing form
   */
  public abstract JFrame getFrame();
}
