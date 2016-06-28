package de.htwg.cityyanderecarcassonne.view.guitwo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class PicturePanel extends JPanel implements ChangeListener, IObserver {
	
	private ICarcassonneController controller;
	private BufferedImage image;
	private JLabel label;
	
	public PicturePanel(ICarcassonneController controller) {
		this.controller = controller;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		createAnImage();
		label = new JLabel(new ImageIcon(image));
        label.setHorizontalAlignment(JLabel.CENTER);
        
        JScrollPane jsp = new JScrollPane(label);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setPreferredSize(new Dimension(100, 100));
        this.add(jsp);
        
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        this.add(slider);
        
        validate();
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}
	
	private void createAnImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./data/rueckseite_start.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        int w = 500;
        int h = 500;
        int type = BufferedImage.TYPE_INT_RGB; // many options
        image = new BufferedImage(w, h, type);
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                            RenderingHints.VALUE_STROKE_PURE);
        g2.setPaint(new Color(240,200,200));
        g2.fillRect(0,0,w,h);
        g2.setPaint(Color.blue);
        g2.draw(new Rectangle2D.Double(w/16, h/16, w*7/8, h*7/8));
        g2.setPaint(Color.green.darker());
        g2.draw(new Line2D.Double(w/16, h*15/16, w*15/16, h/16));
        Ellipse2D e = new Ellipse2D.Double(w/4, h/4, w/2, h/2);
        g2.setPaint(new Color(240,240,200));
        g2.fill(e);
        g2.setPaint(Color.red);
        g2.draw(e);
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
    }

}
