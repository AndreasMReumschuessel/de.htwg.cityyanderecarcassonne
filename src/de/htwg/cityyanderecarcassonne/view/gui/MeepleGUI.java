package de.htwg.cityyanderecarcassonne.view.gui;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MeepleGUI {

	JLabel meeple;
	Icon meeplePicture;

	public MeepleGUI(Icon meeplePicture)	{
		meeple = new JLabel();
        meeple.setIcon(meeplePicture);		
	}
	
	public JLabel getMeeple() {
		return meeple;
	}

	public void setMeeple(JLabel meeple) {
		this.meeple = meeple;
	}
	
	public void setIcon(Icon meeplePicture)	{
		this.meeplePicture = meeplePicture;
	}
	
}
