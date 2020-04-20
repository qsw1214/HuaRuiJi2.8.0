package org.LYG.node.image.HoughTransform;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import org.LYG.GUI.OSGI.*;
public class HoughTransformView extends ObjectView{
	private static final long serialVersionUID = 1L;
	public JButton button;
	public String path;
	public HoughTransformView(){
		super();
	}
	public void view() throws Exception{
		scrollPane = new ScrollPane();
		panel=new Panel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g){
				BufferedImage image = new BufferedImage(gout[0].length, gout.length, BufferedImage.TYPE_INT_RGB);
				for (int i = 0; i < image.getHeight(); ++i) {
					for (int j1 = 0; j1 < image.getWidth(); ++j1) {
						int val = (int) gout[i][j1];
						int pixel = (val << 16) | (val << 8) | (val);
						image.setRGB(j1, i, pixel);
					}
				}
				Image im=(Image)image;
				g.drawImage(im,0,0,this);	  			
			}	
		};	
		//
		scrollPane.add(panel);
		add(scrollPane);
		close=false;
		
		
	}
	@Override  
	public ObjectView clone() {   
		objectView = (ObjectView)super.clone();  
		return objectView;  
	}  
}
