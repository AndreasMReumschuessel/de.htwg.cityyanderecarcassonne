package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.util.observer.Event;
import de.htwg.util.observer.IObserver;

public class RightPanel extends JPanel implements ActionListener, IObserver {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
    SpringLayout rightPanelLayout;
    JPanel teammatesPanel;
    JPanel cardPanel;
    JPanel yanderePanel;
    Border blackline;

	public RightPanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		teammatesPanel = new TeammatesPanel(this.controller, this.contentPane);
		cardPanel = new CardPanel(this.controller, this.contentPane);
		yanderePanel = new YanderePanel(this.controller, this.contentPane);

		rightPanelLayout = new SpringLayout();
		rightPanelLayout.putConstraint(SpringLayout.WEST, cardPanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, cardPanel, 0, SpringLayout.NORTH, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.WEST, teammatesPanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, teammatesPanel, 350, SpringLayout.NORTH, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.WEST, yanderePanel, 0, SpringLayout.WEST, contentPane);
		rightPanelLayout.putConstraint(SpringLayout.NORTH, yanderePanel, 675, SpringLayout.NORTH, contentPane);
		this.setLayout(rightPanelLayout);

		this.add(cardPanel);
		this.add(teammatesPanel);
		this.add(yanderePanel);
	    
	    this.setPreferredSize(new Dimension(250,1000));
	    this.setBackground(Color.GRAY.darker());
	    this.setVisible(true);
	}

	@Override
	public void update(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
