package shapeDraw;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Shape {
	
	protected List<Node> nodeList;
	protected List<Line> lineList;
	
	public Shape() {
		
		this.nodeList = new ArrayList<Node>();
		this.lineList = new ArrayList<Line>();
		
	}

	// Update the lineList based on the current list of nodes
	protected void updateLineList() {
		// update associated Lines attached to these nodes
		this.lineList.clear();
		for (Node node : this.nodeList) {
			if (node.getId() != nodeList.size()){
				this.lineList.add(new Line(node, this.nodeList.get(node.getId())));
			} else { // Last node in list, needs to wrap to first node
				this.lineList.add(new Line(node, this.nodeList.get(0)));
			}
		}
	}
	
	// draw Shape to screen, by drawing all nodes first, then all lines
	public void draw(Graphics2D g2d) {
		
		for(Node n: this.nodeList){
			n.draw(g2d);
		}
		for(Line line : this.lineList){
			line.draw(g2d);
		}
	}
}
