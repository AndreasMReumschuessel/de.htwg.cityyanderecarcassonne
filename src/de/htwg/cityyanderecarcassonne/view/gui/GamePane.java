package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class GamePane extends JScrollPane implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
    BufferedImage image;
    JLabel label;
	
	public GamePane(ICarcassonneController controller)	{
		this.controller = controller;
		this.createGamePicture();
		createGamePicture();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
        int value = ((JSlider)e.getSource()).getValue();
        double scale = value/100.0;
        BufferedImage scaled = getScaledImage(scale);
	}
	
    private BufferedImage getScaledImage(double scale) {
		return null;
    }
	
	public void createGamePicture()	{
		Graphics2D g2 = image.createGraphics();
		g2.drawString("Hello World?", 250, 250);
	}
	
    private JSlider getControl() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        return slider;        
    }
}
