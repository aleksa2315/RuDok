package view.painters;

import model.elements.DiagramElement;
import model.elements.RectangleElement;

import java.awt.geom.GeneralPath;

public class RectanglePainter extends DevicePainter{

	public RectanglePainter(DiagramElement device) {
		super(device);
		RectangleElement rectangle = (RectangleElement) device;

		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();

		
	}
	

	
}
