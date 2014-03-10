package nl.ovapi.rid.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;

public class Block {

	@Getter private ArrayList<Journey> segments;
	@Getter private String blockRef;
	
	public Block(String blockRef){
		segments = new ArrayList<Journey>();
		this.blockRef = blockRef;
	}
		
	public void addJourney(Journey journey){
		if (journey.getBlockRef() != blockRef && !blockRef.equals(journey.getBlockRef())){
			throw new IllegalArgumentException("Journey not part of this block");
		}
		segments.add(journey);
	}
}
