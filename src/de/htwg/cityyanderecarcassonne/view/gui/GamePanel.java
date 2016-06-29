package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class GamePanel extends JPanel implements ChangeListener, IObserver, MouseListener {
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
    TownsquareVisual tv;
	
	public GamePanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		controller.addObserver(this);
		
		DimX = 1240;
		DimY = 980;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
		
        scrollPane = new JScrollPane(label);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(DimX,DimY - 50));
		this.add(scrollPane);
		
		jSlider = getSlider();
		this.add(jSlider);
		
		scrollPane.addMouseListener(this);
		validate();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
        int value = ((JSlider)e.getSource()).getValue();
        rescaleStateChanged(value);
	}
	
	private void rescaleStateChanged(int value) {
		double scale = value/100.0;
        BufferedImage scaled = getScaledImage(scale);
        label.setIcon(new ImageIcon(scaled));
        label.revalidate();
	}
	
    private BufferedImage getScaledImage(double scale) {
    	
    	System.out.println("Unskaled " + image.getWidth() + " , " + image.getWidth());
    	
        int w = (int)(scale*image.getWidth());
        int h = (int)(scale*image.getHeight());
        
    	System.out.println("Skale " + scale + " , " + w + " , " + h);
    	System.out.println();
        
        BufferedImage bi = new BufferedImage(w, h, image.getType());
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
        g2.drawRenderedImage(image, at);
        g2.dispose();
        return bi;
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

	@Override
	public void update(Event e) {
		if(controller.getStatus().equals(GameStatus.CREATE)){
			tv = new TownsquareVisual(controller.getTownsquare());
			image = tv.normalTownsquareVisual();
			autoSizeView();
		} else if(!controller.getStatus().equals(GameStatus.WELCOME)) {
			if(controller.getStatus().equals(GameStatus.ROUND_START)) {
				image = tv.possTownsquareVisual(controller.getCardPossibilitiesMap(controller.cardOnHand()));
				autoSizeView();
			} else if(controller.getStatus().equals(GameStatus.CARD_SET_SUCCESS)) {
				image = tv.meepleTownsquareVisual(controller.cardOnHand(), controller.getRegionPossibilitiesMap(controller.cardOnHand()));
				autoSizeView();
			}
		}
	}
	
	private void autoSizeView() {
		label.setIcon(new ImageIcon(image));
		int zoom = 50;
		jSlider.setValue(zoom);
		rescaleStateChanged(zoom);
		scrollPane.setAutoscrolls(true);
		//scrollPane.getVerticalScrollBar().setValue((scrollPane.getVerticalScrollBar().getVisibleAmount() / 2) + (image.getHeight() / 2));
		//Rectangle r = new Rectangle(4000, 4000, 2000, 2000);
		//scrollPane.scrollRectToVisible(r);
		//System.out.println(scrollPane.getVerticalScrollBar().getValue() + scrollPane.getVerticalScrollBar().getVisibleAmount());
	}
	
    public Point toImageContext(Point p) {
        Point imgLocation = getImageLocation();
        Point relative = new Point(p);
        relative.x -= imgLocation.x;
        relative.y -= imgLocation.y;  
        return relative;
    }
    
    protected Point getImageLocation() {
        Point p = null;
        if (image != null) {
            int x = (getWidth() - image.getWidth()) / 2;
            int y = (getHeight() - image.getHeight()) / 2;
            p = new Point(x, y);
        }
        return p;
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
//		int x = (int) arg0.getPoint().getX();
//		int y = (int) arg0.getPoint().getY();
//		
//		JOptionPane.showMessageDialog(this, x + " , " + y);
		

		
//        Point panelPoint = arg0.getPoint();
//        Point imgContext = this.toImageContext(panelPoint);
//		
//		JOptionPane.showMessageDialog(this,"Click at " + panelPoint + " which is relative to the image " + imgContext);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}