package shapeDraw;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.EventObject;

// Node represents one node (dot) on the canvas
public class Node {

	private int id;          //id of this node
	private Point location;  //location of this node
	private int size = 10;   //size of a node
	private List<NodeChangeListener> listeners;  // listeners listening for node changes
	
	//Constructor: sets node id, x location, and y location
	public Node(int id, int x, int y){
		//initialize all variables
		this.id = id;
		this.location = new Point(x, y);
		this.listeners = new ArrayList<NodeChangeListener>();
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getX(){
		return location.x;
	}
	
	public int getY(){
		return location.y;
	}
	
	public int getCenterX(){
		return location.x + this.size/2;
	}
	
	public int getCenterY(){
		return location.y + this.size/2;
	}
	
	// update the location of this node and let listeners know that location is updated
	public void updateNodeLocation(int x, int y){
		this.location = new Point(x, y);
		this.fireNodeChangeEvent();
	}

	public void draw(Graphics2D g2){
		//draw circle with Node.size using (x,y) as the top left corner
		//fill the whole circle from degree 0 to 360
		g2.fillArc(this.getX(), this.getY(), this.size, this.size, 0, 360);
	}
	
	//add a listener for node change event
	public void addNodeChangeListener(NodeChangeListener listener){
		this.listeners.add(listener);
	}
	
	//remove a listener
	public void removeNodeChangeListener(NodeChangeListener listener){
		this.listeners.remove(listener);
	}
	
	//notify listeners of changes
	private void fireNodeChangeEvent(){
		EventObject event = new EventObject(this);
	    for (NodeChangeListener i : this.listeners) {
	      i.handleNodeChangeEvent(event);
	    }
	}
}
