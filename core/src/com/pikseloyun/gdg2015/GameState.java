package com.pikseloyun.gdg2015;

public class GameState {

	public int population, food, gold, sciencePoints;
	public Buildings buildings;
	public Upgrades upgrades;
	
	// Starting Constants
	public final int startingPop = 10; 
	public final int startingFood = 100; 
	public final int startingGold = 100; 
	public final int startingSciencePoints = 5;
	
	public GameState(){
		
		buildings = new Buildings();
		upgrades = new Upgrades();
		
		population = startingPop;
		food = startingFood;
		gold = startingGold;
		sciencePoints = startingSciencePoints;
		
	}
	
	public void collectGold(){
		
	}
	
}
