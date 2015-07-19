package ui;

import java.util.HashMap;
import java.util.TreeSet;

import entities.Entity;

public class Graph {

	private HashMap<Entity, TreeSet<Entity>> edgeList;
	HashMap<Integer, Entity> entities;

	public void addEdge(Entity e1, Entity e2){
		edgeList.get(e1).add(e2);
		edgeList.get(e2).add(e1);
		
	}
	
	public Entity getEdge(){
		return null;
	}
	
	public boolean hasVertex(){
		return false;
	}
	
	public boolean hasEdge(){
		return false;
	}
	

	
	
	
	
	
}
