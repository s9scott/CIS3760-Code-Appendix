package shapeDraw;
import java.util.EventObject;

// a listener that observes the changes in a node
interface NodeChangeListener{

	// handle changes in a node
	void handleNodeChangeEvent(EventObject e);

}
