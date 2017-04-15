package shapeDraw;

public class Circle extends Shape {

	private int centreX;
	private int centreY;
	private int radius;
	
	// Constructor: sets the centre position of circle to 
	// (centreX, centreY) and sets its radius length.
	// It then generates the circle coordinates.
	public Circle (int centreX, int centreY, int radius) {

		super();
		this.centreX = centreX;
		this.centreY = centreY;
		this.radius = radius;
		
		// generate the circle using the centre position and radius
		createCircle();
	}
	
	// update the position and/or radius length of the circle
	public void updateShape(int centreX, int centreY, int radius) {
		this.centreX = centreX;
		this.centreY = centreY;
		this.radius = radius;
		
		// regenerate the circle using the new position and radius
		createCircle();
	}

	// Creates a circle using the midpoint algorithm, centred at
	// (centreX, centreY) and using "radius" as its circle radius. 
	private void createCircle(){

		int x0 = this.centreX;  // use temp variables for brevity of midpoint algorithm code below
		int y0= this.centreY;   // use temp variables for brevity of midpoint algorithm code below

	    int x = this.radius; // set x to the radius
	    int y = 0;
	    int err = 0;

	    int nodeCounter = 1;
	    while (x >= y) {
	        this.nodeList.add(new Node(nodeCounter++, x0 + x, y0 + y));
	        this.nodeList.add(new Node(nodeCounter++, x0 + y, y0 + x));
	        this.nodeList.add(new Node(nodeCounter++, x0 - y, y0 + x));
	        this.nodeList.add(new Node(nodeCounter++, x0 - x, y0 + y));
	        this.nodeList.add(new Node(nodeCounter++, x0 - x, y0 - y));
	        this.nodeList.add(new Node(nodeCounter++, x0 - y, y0 - x));
	        this.nodeList.add(new Node(nodeCounter++, x0 + y, y0 - x));
	        this.nodeList.add(new Node(nodeCounter++, x0 + x, y0 - y));

	        if (err <= 0) {
	            y += 1;
	            err += 2*y + 1;
	        } else { // (err > 0) 
	            x -= 1;
	            err -= 2*x + 1;
	        }
	    }			
	    // clear the lineList so that only the points will be drawn - there are sufficient points
	    // calculated above to fill in whole circle.
	    this.lineList.clear();
	}
}
