package shapeDraw;

import java.lang.Math;

public class Triangle extends Shape {

	private int centreX;
	private int centreY;
	private int size;
	
	// Constructor: defines an equilateral triangle, centred at (centreX, centreY)
	// and with side length of "size".
	public Triangle (int centreX, int centreY, int size) {
		super();
		this.centreX = centreX;
		this.centreY = centreY;
		this.size = size;
		
		this.createTriangle();
	}		
	
	// update the position and/or size of the rectangle
	public void updateShape(int centreX, int centreY, int size) {
		this.centreX = centreX;
		this.centreY = centreY;
		this.size = size;
		
		this.createTriangle();
	}

	// Generates an equilateral triangle, centred at (centreX, centreY) and side length "size".
	private void createTriangle(){

		this.nodeList.clear();
		Node node1 = new Node(1, this.centreX, (int)(this.centreY - this.size*Math.sqrt(3)/3));
		Node node2 = new Node(2, (int)(this.centreX - this.size/2), (int)(this.centreY + this.size*Math.sqrt(3)/6));
		Node node3 = new Node(3, (int)(this.centreX + this.size/2), (int)(this.centreY + this.size*Math.sqrt(3)/6));
			
		this.nodeList.add(node1);
		this.nodeList.add(node2);
		this.nodeList.add(node3);

		for (Node node : this.nodeList) {
			if (node.getId() != nodeList.size()){
				this.lineList.add(new Line(node, this.nodeList.get(node.getId())));
			} else { // Last node in list, needs to wrap to first node
				this.lineList.add(new Line(node, this.nodeList.get(0)));
			}
		}
		this.updateLineList();
	}
}
