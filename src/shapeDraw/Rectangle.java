package shapeDraw;

public class Rectangle extends Shape {

	private int centreX;
	private int centreY;
	private int height;
	private int width;
	
	// Constructor: sets the centre position of rectangle to (centreX, centreY) and sets its 
	// height and width. It then generates the rectangle coordinates.
	public Rectangle (int centreX, int centreY, int height, int width) {
		super();
		this.centreX = centreX;
		this.centreY = centreY;
		this.height= height;
		this.width= width;
		
		createRectangle();
	}

	// Updates the centre position of rectangle to (centreX, centreY) and its 
	// height and width. It then generates the rectangle coordinates.
	public void updateShape(int centreX, int centreY, int height, int width) {
		this.centreX = centreX;
		this.centreY = centreY;
		this.height= height;
		this.width = width;
		
		createRectangle();
	}

	// Generates the four corner coordinates based on the centreX, centreY position and its 
	// height and width. 
	private void createRectangle(){

		this.nodeList.clear();
		Node node1 = new Node(1, this.centreX - this.width/2, this.centreY - this.height/2);
		Node node2 = new Node(2, this.centreX - this.width/2, this.centreY + this.height/2);
		Node node3 = new Node(3, this.centreX + this.width/2, this.centreY + this.height/2);
		Node node4 = new Node(4, this.centreX + this.width/2, this.centreY - this.height/2);
			
		this.nodeList.add(node1);
		this.nodeList.add(node2);
		this.nodeList.add(node3);
		this.nodeList.add(node4);

		this.updateLineList();
	}
}
