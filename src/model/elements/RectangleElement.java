package model.elements;
import view.painters.RectanglePainter;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;

public class RectangleElement extends DiagramDevice {

	public RectangleElement(Point position, Dimension size, Stroke stroke, Paint paint) {
		super(position, size, stroke, paint);
		elementPainter = new RectanglePainter(this);
	}

	

}
