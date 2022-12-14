package view.painters;
import model.elements.DiagramDevice;
import model.elements.DiagramElement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

public class DevicePainter extends ElementPainter {
	
	protected Shape shape;
	
	public DevicePainter(DiagramElement device){
		super(device);
	}
	
	public void paint(Graphics2D g, DiagramElement element){
		
		g.setPaint(Color.RED);

		g.setStroke(element.getStroke());
		g.draw(getShape());
		g.setPaint(element.getPaint());

		g.fill(getShape());
		
		if (element instanceof DiagramDevice){
			g.setPaint(Color.BLACK);
			DiagramDevice device=(DiagramDevice )element;
			g.drawString(device.getName(), (int)device.getPosition().getX()+10, 
										   (int)device.getPosition().getY()+10);
		}
		
		
	}
	
	public boolean elementAt(DiagramElement element, Point pos){
		return getShape().contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
