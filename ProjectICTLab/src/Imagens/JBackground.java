package Imagens;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JBackground extends JPanel{

	private static final long serialVersionUID = -9123094344589722326L;
	
	private Image img;
	
	public JBackground(String path) {
		
		img = new ImageIcon(this.getClass().getResource(path)).getImage();
		
	}
	
	@Override
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),this);
		
	}
	
}
