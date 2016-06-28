package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

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
    int DimX = 0;
    int DimY = 0;
    Graphics2D g;
	
	public GamePanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		DimX = 1240;
		DimY = 980;
		
		this.getBackgroundImage();
		
		label = getContent();
		jSlider = getSlider();
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(DimX,DimY));
		
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		
		validate();
		
		this.add(scrollPane);
		this.add(jSlider);
		
		this.setVisible(true);
		this.setPreferredSize(new Dimension(DimX,DimY));
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
    	getBackgroundImage();
        label = new JLabel(new ImageIcon(image));
        label.setHorizontalAlignment(JLabel.CENTER);
    	addImage();
        return label;
    }
	
    private JSlider getSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        return slider;        
    }
    
	private void getBackgroundImage()	{
		int type = BufferedImage.TYPE_INT_RGB;
        image = new BufferedImage(DimX*2, DimY*2, type);
        g = image.createGraphics();
        g.setPaint(new Color(204, 102, 0));
        g.fillRect(0, 0, DimX*2, DimY*2);
	}
	
	private void addImage()	{
		int type = BufferedImage.TYPE_INT_RGB;
        image1 = new BufferedImage(DimX/2, DimY/2, type);
        Graphics2D g2 = image1.createGraphics();
        g2.setPaint(new Color(24, 12, 100));
        g2.fillRect(0, 0, DimX/2, DimY/2);
        //g.drawImage(image1, DimX/2, DimY/2, this);
	}
}
