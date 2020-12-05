package com.nwawsoft.stac.ui;

import com.nwawsoft.stac.model.CounterKeyListener;
import com.nwawsoft.stac.model.Trick;
import com.nwawsoft.util.ui.ComponentFunctions;
import org.jnativehook.GlobalScreen;

import javax.swing.*;
import java.awt.*;

public class Visualization extends JFrame {
  private final static String PREFIX_TRICK = "Trick: ";
  private final static String PREFIX_ATTEMPTS = "Attempts: ";
  private final static String PREFIX_SUCCESSES = "Successes: ";
  private final static String PREFIX_SUCCESSES_BACK_TO_BACK = "Successes in a row: ";
  private final static String PREFIX_SUCCESSES_HIGHSCORE = "Highscore: ";

  private final Trick t;

  private final JLabel labelAttemptsValue;
  private final JLabel labelSuccessesValue;
  private final JLabel labelSuccessesBackToBackValue;
  private final JLabel labelSuccessesHighscoreValue;

  public Visualization(final Trick t) {
    super("STAC");
    this.t = t;
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // ToDo: Ask for save
    int frameWidth = 340;
    int frameHeight = 160;
    setSize(frameWidth, frameHeight);
    ComponentFunctions.center(this);
    Container cp = getContentPane();
    cp.setLayout(null);

    JLabel labelTrickName = new JLabel(PREFIX_TRICK);
    JLabel labelAttempts = new JLabel(PREFIX_ATTEMPTS);
    JLabel labelSuccesses = new JLabel(PREFIX_SUCCESSES);
    JLabel labelSuccessesBackToBack = new JLabel(PREFIX_SUCCESSES_BACK_TO_BACK);
    JLabel labelSuccessesHighscore = new JLabel(PREFIX_SUCCESSES_HIGHSCORE);

    JLabel labelTrickNameValue = new JLabel(t.getName());
    labelAttemptsValue = new JLabel("" + t.getAttempts());
    labelSuccessesValue = new JLabel("" + t.getSuccesses());
    labelSuccessesBackToBackValue = new JLabel("" + t.getSuccessesBackToBack());
    labelSuccessesHighscoreValue = new JLabel("" + t.getSuccessesHighscore());


    int left_column_width = 120;
    int right_column_start = left_column_width + 20;
    int right_column_width = 150;

    labelTrickName.setBounds(10, 10, left_column_width, 20);
    labelTrickNameValue.setBounds(right_column_start, 10, 2000, 20);
    labelAttempts.setBounds(10, 30, left_column_width, 20);
    labelAttemptsValue.setBounds(right_column_start, 30, right_column_width, 20);
    labelSuccesses.setBounds(10, 50, left_column_width, 20);
    labelSuccessesValue.setBounds(right_column_start, 50, right_column_width, 20);
    labelSuccessesBackToBack.setBounds(10, 70, left_column_width, 20);
    labelSuccessesBackToBackValue.setBounds(right_column_start, 70, right_column_width, 20);
    labelSuccessesHighscore.setBounds(10, 90, left_column_width, 20);
    labelSuccessesHighscoreValue.setBounds(right_column_start, 90, right_column_width, 20);

    cp.setBackground(Color.WHITE);

    cp.add(labelTrickName);
    cp.add(labelTrickNameValue);
    cp.add(labelAttempts);
    cp.add(labelAttemptsValue);
    cp.add(labelSuccesses);
    cp.add(labelSuccessesValue);
    cp.add(labelSuccessesBackToBack);
    cp.add(labelSuccessesBackToBackValue);
    cp.add(labelSuccessesHighscore);
    cp.add(labelSuccessesHighscoreValue);

    GlobalScreen.addNativeKeyListener(new CounterKeyListener(this, t));

    setResizable(true);
    setVisible(true);
  }

  public void updateAttempts() {
    labelAttemptsValue.setText("" + t.getAttempts());
  }

  public void updateSuccesses() {
    labelSuccessesValue.setText("" + t.getSuccesses());
  }

  public void updateSuccessesBackToBack() {
    labelSuccessesBackToBackValue.setText("" + t.getSuccessesBackToBack());
  }

  public void updateSuccessesHighscore() {
    labelSuccessesHighscoreValue.setText("" + t.getSuccessesHighscore());
  }

  public void updateStats() {
    updateAttempts();
    updateSuccesses();
    updateSuccessesBackToBack();
    updateSuccessesHighscore();
  }
}
