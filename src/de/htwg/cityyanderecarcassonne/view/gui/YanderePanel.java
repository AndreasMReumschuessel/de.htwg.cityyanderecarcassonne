package de.htwg.cityyanderecarcassonne.view.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

public class YanderePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private ICarcassonneController controller;
	
	Container contentPane;
	SpringLayout yandereLayout;
	JTextField textField;
	
	public YanderePanel(ICarcassonneController controller, Container contentPane)	{
		this.controller = controller;
		this.contentPane = contentPane;
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,150));
		
		yandereLayout = new SpringLayout();
		yandereLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, contentPane);
		yandereLayout.putConstraint(SpringLayout.NORTH, textField, 50, SpringLayout.NORTH, contentPane);
		this.setLayout(yandereLayout);
	    contentPane.revalidate();
	    
	    this.add(textField);
		
	    this.setPreferredSize(new Dimension(250,350));
	    this.setBackground(Color.PINK);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText(controller.getStatusMessage());
	}
}
