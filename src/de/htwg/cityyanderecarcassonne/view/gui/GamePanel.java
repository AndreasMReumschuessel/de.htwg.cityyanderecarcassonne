package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.htwg.cityyanderecarcassonne.controller.GameStatus;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.IRegion;
import de.htwg.cityyanderecarcassonne.model.Position;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class GamePanel extends JPanel implements ChangeListener, IObserver, MouseListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	private BufferedImage image;
	private JSlider jSlider;
	private JScrollPane scrollPane;
	private ImagePanel imgPanel;
    int DimX = 0;
    int DimY = 0;
    private TownsquareVisual tv;
    
	private Map<Position, String> cardPoss;
	private double scaleFactor;
	private int cardXOff, cardYOff;
	private Map<IRegion, String> meeplePoss;
	
	public GamePanel(ICarcassonneController controller)	{
		this.controller = controller;
		controller.addObserver(this);
		
		DimX = 1240;
		DimY = 980;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		imgPanel = new ImagePanel(null);
		
		scrollPane = new JScrollPane(imgPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(DimX,DimY - 50));
		this.add(scrollPane);
		
		jSlider = getSlider();
		jSlider.setEnabled(false);
		this.add(jSlider);
		
		imgPanel.addMouseListener(this);
		validate();
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
        int value = ((JSlider)e.getSource()).getValue();
        rescaleStateChanged(value);
	}
	
	private void rescaleStateChanged(int value) {
		scaleFactor = value/100.0;
        BufferedImage scaled = getScaledImage(scaleFactor);
        imgPanel.setImage(scaled);
        imgPanel.revalidate();
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
		GameStatus status = controller.getStatus();
		
		if (status.equals(GameStatus.CARD_SET_SUCCESS))
			cardPoss = null;
		
		if (status.equals(GameStatus.MEEPLE_SET_SUCCESS) || status.equals(GameStatus.ROUND_END)) {
			meeplePoss = null;
			cardXOff = 0;
			cardYOff = 0;
		}
		
		if(status.equals(GameStatus.CREATE)){
			tv = new TownsquareVisual(controller.getTownsquare());
			jSlider.setEnabled(true);
			image = tv.normalTownsquareVisual();
			autoSizeView();
			scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum() / 2 - scrollPane.getVerticalScrollBar().getVisibleAmount() / 2);
			scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMaximum() / 2 - scrollPane.getHorizontalScrollBar().getVisibleAmount() / 2);
		} else if(!status.equals(GameStatus.WELCOME)) {
			if(status.equals(GameStatus.ROUND_START)) {
				cardPoss = controller.getCardPossibilitiesMap(controller.cardOnHand());
				image = tv.possTownsquareVisual(cardPoss);
				autoSizeView();
			} else if(status.equals(GameStatus.CARD_SET_SUCCESS)) {
				meeplePoss = controller.getRegionPossibilitiesMap(controller.cardOnHand());
				image = tv.meepleTownsquareVisual(controller.cardOnHand(), meeplePoss);
				autoSizeView();
			}
		}
	}
	
	private void autoSizeView() {
		imgPanel.setImage(image);
		imgPanel.revalidate();
		int zoom = jSlider.getValue();
		jSlider.setValue(zoom);
		rescaleStateChanged(zoom);
		scrollPane.setAutoscrolls(true);
		//Rectangle r = new Rectangle(4000, 4000, 2000, 2000);
		//scrollPane.scrollRectToVisible(r);
		//System.out.println(scrollPane.getVerticalScrollBar().getValue() + scrollPane.getVerticalScrollBar().getVisibleAmount());
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Point panelPoint = arg0.getPoint();
        Point imgContext = imgPanel.toImageContext(panelPoint);
        
        placeCardOnPosition(imgContext.getX(), imgContext.getY());
        placeMeepleOnPosition(imgContext.getX(), imgContext.getY());
	}

	private void placeCardOnPosition(double x, double y) {
		double relation = 200 * scaleFactor;
		if (cardPoss != null) {
			for (Position p : cardPoss.keySet()) {
				if ((x >= p.getX() * relation && x <= p.getX() * relation + 200 * scaleFactor) && 
					(y >= p.getY() * relation && y <= p.getY() * relation + 200 * scaleFactor)) {
					cardXOff = p.getX();
					cardYOff = p.getY();
					Position tmppos = new Position(cardXOff, cardYOff);
					controller.placeCard(controller.cardOnHand(), cardPoss.get(tmppos));
				}
					
			}
		}
	}
	
	private void placeMeepleOnPosition(double x, double y) {
		double relation = 200 * scaleFactor;
		checkLeft(x, y, relation);
		checkBelow(x, y, relation);
		checkCenter(x, y, relation);
		checkTop(x, y, relation);
		checkRight(x, y, relation);
	}

	private void checkLeft(double x, double y, double relation) {
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 5 * scaleFactor && x <= cardXOff * relation + 5 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 30 * scaleFactor && y <= cardYOff * relation + 30 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getLeftTop()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 5 * scaleFactor && x <= cardXOff * relation + 5 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 90 * scaleFactor && y <= cardYOff * relation + 90 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getLeftMiddle()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 5 * scaleFactor && x <= cardXOff * relation + 5 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 150 * scaleFactor && y <= cardYOff * relation + 150 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getLeftBelow()));
		}
	}

	private void checkBelow(double x, double y, double relation) {
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 30 * scaleFactor && x <= cardXOff * relation + 30 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 175 * scaleFactor && y <= cardYOff * relation + 175 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getBelowLeft()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 90 * scaleFactor && x <= cardXOff * relation + 90 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 175 * scaleFactor && y <= cardYOff * relation + 175 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getBelowMiddle()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 150 * scaleFactor && x <= cardXOff * relation + 150 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 175 * scaleFactor && y <= cardYOff * relation + 175 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getBelowRight()));
		}
	}

	private void checkCenter(double x, double y, double relation) {
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 90 * scaleFactor && x <= cardXOff * relation + 90 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 90 * scaleFactor && y <= cardYOff * relation + 90 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getCenterMiddle()));
		}
	}

	private void checkTop(double x, double y, double relation) {
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 30 * scaleFactor && x <= cardXOff * relation + 30 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 5 * scaleFactor && y <= cardYOff * relation + 5 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getTopLeft()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 90 * scaleFactor && x <= cardXOff * relation + 90 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 5 * scaleFactor && y <= cardYOff * relation + 5 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getTopMiddle()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 150 * scaleFactor && x <= cardXOff * relation + 150 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 5 * scaleFactor && y <= cardYOff * relation + 5 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getTopRight()));
		}
	}
	
	private void checkRight(double x, double y, double relation) {
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 175 * scaleFactor && x <= cardXOff * relation + 175 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 30 * scaleFactor && y <= cardYOff * relation + 30 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getRightTop()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 175 * scaleFactor && x <= cardXOff * relation + 175 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 90 * scaleFactor && y <= cardYOff * relation + 90 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getRightMiddle()));
		}
		
		if (meeplePoss != null) {
			if ((x >= cardXOff * relation + 175 * scaleFactor && x <= cardXOff * relation + 175 * scaleFactor + 20 * scaleFactor) &&
				(y >= cardYOff * relation + 150 * scaleFactor && y <= cardYOff * relation + 150 * scaleFactor + 20 * scaleFactor))
				controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), meeplePoss.get(controller.cardOnHand().getRightBelow()));
		}
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