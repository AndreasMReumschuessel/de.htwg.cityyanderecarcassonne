package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class GamePanel extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
    BufferedImage image;
    BufferedImage image1;
    BufferedImage scaled;
    JSlider jSlider;
    JScrollPane scrollPane;
    BoxLayout boxLayout;
    JLabel label;
    Graphics2D g;
    int DimX = 0;
    int DimY = 0;
	
	public GamePanel(ICarcassonneController controller, Container contentPane) throws IOException	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		DimX = 1240;
		DimY = 980;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		getBackgroundImage();
		label = new JLabel(new ImageIcon(image));
        label.setHorizontalAlignment(JLabel.CENTER);
		
        JScrollPane scrollPane = new JScrollPane(label);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(DimX,DimY - 50));
		this.add(scrollPane);
		
		jSlider = getSlider();
		this.add(jSlider);
		
		validate();
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
    
    private JLabel getContent() throws IOException {
    	getBackgroundImage();
        label = new JLabel(new ImageIcon(image));
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }
	
    private JSlider getSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setPreferredSize(new Dimension(DimX, 50));
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        return slider;        
    }
    
	private void getBackgroundImage() throws IOException	{
		
        try {
        	image = ImageIO.read(new File("./data/background.png"));
         } catch (IOException ex) {
              // handle exception...
         }
        
        g = image.createGraphics();
        g.drawImage(image, DimX, DimY, this);
	}
}
