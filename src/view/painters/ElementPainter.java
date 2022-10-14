package view.painters;


import model.elements.DiagramElement;

import java.awt.Graphics2D;
import java.awt.Point;


public abstract class ElementPainter {

	public ElementPainter(DiagramElement element) {	}

	public abstract void paint(Graphics2D g, DiagramElement element);
	
	public abstract boolean elementAt(DiagramElement element, Point pos);

	
}
