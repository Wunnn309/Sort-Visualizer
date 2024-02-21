package B2012131;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Bar
{
	private final int MARGIN = 1;
	private int x, y, width, height ,value;
	private Color color;

	// y: the bottom left corner
	public Bar(int x, int y, int width, int value, Color color)
	{
                this.height = value*5;
		this.x = x;
		this.y = y;
		this.width = width;
		this.value = value;
		this.color = color;
	}


	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x + MARGIN, (y-value*4), width - MARGIN * 2, value*4);
	}


	public void clear(Graphics g)
	{
		// clear the space
		g.setColor(ColorManager.MyCanvasColor);
		g.fillRect(x + MARGIN, y-value*4, width - MARGIN * 2, value*4);
	}


	public void setValue(int value) { this.value = value; }

	public int getValue() { return value; }

	public void setColor(Color color) { this.color = color; }

	public Color getColor() { return color; }
}
