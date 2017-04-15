package shapeDraw;
import java.awt.Graphics2D;
import java.util.EventObject;

//Line connects two nodes with an undirected line
public class Line implements NodeChangeListener {

	private Node startNode;
	private Node endNode; 
	
	// Constructor: sets the start and end coordinates (startPoint, endPoint) 
	// of the starting and ending nodes, sets the ids of the starting and
	// ending nodes located at the start and end of this line. It then
	// registers itself with the NodeChangeListener to learn about 
	// any changes about the start or end nodes.
	public Line(Node start, Node end) {

		this.startNode = start;
		this.endNode = end;
		
		// listen for node change events
		start.addNodeChangeListener(this);
		end.addNodeChangeListener(this);
	}

	// draw to screen
	public void draw(Graphics2D g2d) {
		
		g2d.drawLine(this.startNode.getCenterX(), this.startNode.getCenterY(), this.endNode.getCenterX(), this.endNode.getCenterY());
	}

	//handle node location update
	public void handleNodeChangeEvent(EventObject e) {
		if (e != null && e.getSource() instanceof Node) {
			Node changed = ((Node) e.getSource());

			// determine which node was changed and update accordingly
			if (changed.getId() == this.startNode.getId()) {
				this.startNode = (Node) e.getSource();   
			} else if (changed.getId() == this.endNode.getId()) {
				this.endNode = (Node) e.getSource();   
			}
		}
	}
}
