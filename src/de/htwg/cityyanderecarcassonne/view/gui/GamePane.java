package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.ScrollPane;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class GamePane extends JScrollPane implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
    BufferedImage image;
    BufferedImage scaled;
    JSlider js;
    SpringLayout paneLayout;
    ScrollPaneLayout scrollpane;
    JLabel label;
	
	public GamePane(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		this.getImage();
		label = getContent();
		js = getControl();
		
//		scrollpane = new ScrollPaneLayout();
//		this.setLayout(scrollpane);
//		
////		paneLayout = new SpringLayout();
////		paneLayout.putConstraint(SpringLayout.WEST, js, 1490, SpringLayout.WEST, contentPane);
////		paneLayout.putConstraint(SpringLayout.NORTH, js, 1000, SpringLayout.NORTH, contentPane);
////		this.setLayout(paneLayout);
	    contentPane.revalidate();
		
		contentPane.add(getContent());
		contentPane.add(getControl());
		
		this.setVisible(true);
		this.setPreferredSize(new Dimension(1050,850));
		contentPane.revalidate();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
        int value = ((JSlider)e.getSource()).getValue();
        double scale = value/100.0;
        BufferedImage scaled = getScaledImage(scale);
        label.setIcon(new ImageIcon(scaled));
        label.revalidate();  // signal scrollpane
	}
	
    private BufferedImage getScaledImage(double scale) {
        int w = (int)(scale*image.getWidth());
        int h = (int)(scale*image.getHeight());
        BufferedImage bi = new BufferedImage(w, h, image.getType());
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
        g2.drawRenderedImage(image, at);
        g2.dispose();
        return bi;
    }
    
    private JLabel getContent() {
    	getImage();
        label = new JLabel(new ImageIcon(image));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
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
    
	private void getImage()	{
        try {
        	image =  ImageIO.read(new File("./src/de/htwg/cityyanderecarcassonne/view/gui/rueckseite_start.png"));
         } catch (IOException ex) {
              // handle exception...
         }
	}
}
