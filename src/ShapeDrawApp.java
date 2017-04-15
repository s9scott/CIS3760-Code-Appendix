import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import shapeDraw.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.util.Random;

public class ShapeDrawApp extends JPanel implements ActionListener{
	
	private JButton squareButton; 
	private JButton circleButton; 
	private JButton randomButton;
	private Shape currentShape;
	private Random randomGenerator;		
			
	// Constructor: creates the "Draw Shape" buttons and adds them
	// to this JFrame container. By default they are centred at the top
	// of the container. It sets the default shape to a square
	// and gives it an initial position and size. It initializes the random
	// generator used to randomly select a shape type.
	public ShapeDrawApp() {

		// set initial shape to square, with initial position and size
		this.currentShape = new Square(300, 300, 300); //centreX, centreY, size
		
		this.randomGenerator = new Random(); // initialize random generator for random shapes
		
		// create buttons
		this.squareButton = new JButton("Draw Square");
		this.circleButton = new JButton("Draw Circle");
		this.randomButton = new JButton("Draw Random Shape");

		//set up event callbacks for these buttons
		squareButton.addActionListener(this);
		circleButton.addActionListener(this);
		randomButton.addActionListener(this);

		//add to frame
		this.add(this.squareButton);
		this.add(this.circleButton);
		this.add(this.randomButton);
		
	}

	// Draw the shape to the screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		currentShape.draw(g2d);
	}

	// Main application method. Creates main application window for user interface
	// Adds the "ShapeDrawApp" JFrame container to the main window
	public static void main(String[] input) {
		JFrame frame = new JFrame("Shape Draw");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ShapeDrawApp());
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	// Method called when any of the UI buttons are pressed by the user.
	// Used to set the current shape, based on the button pressed, and then once
	// the shape is set, repaints the screen so the shape visualization is updated.
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
        if (source instanceof JButton) {
        	if (((JButton) source).getText().equalsIgnoreCase("Draw Square")) {
        		this.currentShape = new Square(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2); 
        	} else if (((JButton) source).getText().equalsIgnoreCase("Draw Circle")) {
        		this.currentShape = new Circle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/4); 
        	} else { // equals Draw Random Shape

        		int rand = this.randomGenerator.nextInt(4) + 1;  // Assign current shape to 1-4, randomly
        		switch (rand) {
        			case 1: // Square
        				this.currentShape = new Square(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2);
        				break;
        			case 2: //Circle
        				this.currentShape = new Circle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/4);
        				break;
        			case 3: // Triangle
        				this.currentShape = new Triangle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2);
        				break;
        			case 4: // Rectangle
        				this.currentShape = new Rectangle(this.getWidth()/2, this.getHeight()/2, this.getWidth()/3, this.getHeight()/2);
        				break;
        		}
        	}
        }
		this.repaint();
	}
}
