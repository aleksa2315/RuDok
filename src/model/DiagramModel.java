package model;




import model.elements.DiagramDevice;
import observer.Observable;
import observer.Observer;
import observer.ObserverList;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.EventListenerList;

public class DiagramModel implements Observer,Observable{

	private static int count=0;
	private String name;
	private ObserverList observerList = new ObserverList();
	protected ArrayList<DiagramDevice> diagramElements =new ArrayList<DiagramDevice>();

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		DiagramModel.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	public int getElementCount(){
		return diagramElements.size();
	}
	
	public Iterator<DiagramDevice> getDeviceIterator(){
		return diagramElements.iterator();
	}
	
	public void addDiagramElements(DiagramDevice device){
		diagramElements.add(device);
		notifyObservers();
	}

	@Override
	public void addObserver(Observer observer) {
		observerList.addObserver(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.removeObserver(observer);
	}

	@Override
	public void notifyObservers() {
//		Object[] listeners = observerList.getObservers().toArray();
//
//		for (int i = listeners.length-1; i>=0; i-=1) {
//			if (listeners[i]==UpdateListener.class) {
//				// Lazily create the event:
//				if (updateEvent == null)
//					updateEvent = new UpdateEvent(this);
//				((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
//			}
//		}

		for (Observer obs : observerList.getObservers()){
			obs.update(this);
		}
	}

	@Override
	public void update(Object obj) {

	}
}
