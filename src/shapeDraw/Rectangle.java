package shapeDraw;

public class Rectangle extends Shape {

	private int centreX;
	private int centreY;
	private int height;
	private int width;
	
	public Rectangle (int centreX, int centreY, int height, int width) {

		super();

		this.centreX = centreX;
		this.centreY = centreY;
		this.height= height;
		this.width= width;
		
		createRectangle();
	}
	
	public void updateShape(int centreX, int centreY, int height, int width) {

		this.centreX = centreX;
		this.centreY = centreY;
		this.height= height;
		this.width = width;
		
		createRectangle();
	}

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

//		for (Node node : this.nodeList) {
//			if (node.getId() != nodeList.size()){
//				this.lineList.add(new Line(node, this.nodeList.get(node.getId())));
//			} else { // Last node in list, needs to wrap to first node
//				this.lineList.add(new Line(node, this.nodeList.get(0)));
//			}
//		}
		
		this.updateLineList();
	}
	
}
