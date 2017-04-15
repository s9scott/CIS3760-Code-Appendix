package shapeDraw;

import java.awt.Graphics2D;


public class Square extends Shape {

	private Rectangle rect;   // Reuse a Rectangle object to represent this square
	
	// constructor: set the centre X,Y coordinates, and the size (width/height)
	// of the square
	public Square (int centreX, int centreY, int size) {
		super();
		
		// create a rectangle with equal height/width
		this.rect = new Rectangle(centreX, centreY, size, size);
	}
	
	// update the position and/or size of the square
	public void updateShape(int centreX, int centreY, int size) {
		this.rect.updateShape(centreX, centreY, size, size);
	}
	
	@Override
	// wrap the draw method of the rectangle, so it draws correctly (the nodeList and 
	// lineList for the rect object are not visible the this object, so the super.draw()
	// method will not work correctly.
	public void draw(Graphics2D g2d) {
		this.rect.draw(g2d);
	}

}
