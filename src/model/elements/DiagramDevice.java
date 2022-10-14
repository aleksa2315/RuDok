package model.elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;


public abstract class DiagramDevice extends DiagramElement {

	protected Dimension size;
	protected Point position;
	
	public DiagramDevice(Point position, Dimension size, Stroke stroke, Paint paint){
		super(stroke, paint);
		this.size = size;
		this.position = position;
	}
	
	


	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	
}
