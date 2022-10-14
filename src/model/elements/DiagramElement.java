package model.elements;

import view.painters.ElementPainter;

import java.awt.Paint;
import java.awt.Stroke;

public abstract class DiagramElement {
	
	protected Paint paint;
	protected Stroke stroke;
	
	protected String name;
	protected String description;
	protected ElementPainter elementPainter;
	
	public DiagramElement(Stroke stroke, Paint paint){
		this.stroke = stroke;
		this.paint = paint;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ElementPainter getPainter() {
		return elementPainter;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	
}
