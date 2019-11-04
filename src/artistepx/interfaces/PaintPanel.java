package artistepx.interfaces;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaintPanel extends JPanel implements MouseListener{

	private Color brushColor;
	
	private int brushEnable = 0;
	
	private int pixelHeight;
	
	private int pixelWidth;
	
	private MainWindow mainWindow;
	
	
	private JTextField[][] pixels;
	
	public PaintPanel(MainWindow mainWindow, int pixelHeight, int pixelWidth) {

		this.pixelHeight = pixelHeight;
		this.pixelWidth = pixelWidth;
		this.brushColor = new Color(0, 0, 0);
		this.mainWindow = mainWindow;
		
		setLayout(new GridLayout(pixelHeight, pixelWidth));
		pixels =  new JTextField[pixelHeight][pixelWidth];
		
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels.length; j++) {
				pixels[i][j] = new JTextField();
				pixels[i][j].addMouseListener(this);
				pixels[i][j].setEditable(false);
				pixels[i][j].setBackground(Color.WHITE);
				add(pixels[i][j]);
			}
		}
		
	}


	public Color getBrushColor() {
		return brushColor;
	}

	public void setBrushColor(Color brushColor) {
		this.brushColor = brushColor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		e.getComponent().setBackground(getBrushColor());
		((JComponent) e.getComponent()).setBorder(BorderFactory.createLineBorder(getBrushColor(), 1));
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(brushEnable == 1)
		{
			e.getComponent().setBackground(getBrushColor());
			((JComponent) e.getComponent()).setBorder(BorderFactory.createLineBorder(getBrushColor(), 1));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(brushEnable == 0)
		{
			brushEnable = 1;
			e.getComponent().setBackground(getBrushColor());
			((JComponent) e.getComponent()).setBorder(BorderFactory.createLineBorder(getBrushColor(), 1));
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(brushEnable == 1)
		{
			brushEnable = 0;
		}
		
	}
	
}
