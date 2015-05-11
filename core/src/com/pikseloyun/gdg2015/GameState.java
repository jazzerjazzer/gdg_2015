package com.pikseloyun.gdg2015;

public class GameState {

	public int population, soldiers, gold, magic;
	
	public int farmTime, barracksTime, houseTime, cryptTime;
	public int farmProduction, barracksProduction, houseProduction, cryptProduction;
	public int farmCost, barracksCost, houseCost, cryptCost;

	public Upgrades upgrades;
	public Building[] buildings;

	// Starting Constants
	public final int startingPop = 10; 
	public final int startingSoldiers = 1; 
	public final int startingGold = 100; 
	public final int startingSciencePoints = 5;

	public GameState(){

		upgrades = new Upgrades();
		buildings = new Building[80];

		population = startingPop;
		soldiers = startingSoldiers;
		gold = startingGold;
		magic = startingSciencePoints;

		farmTime = 100;
		houseTime = 100;
		cryptTime = 500;
		barracksTime = 1000;

		farmProduction = 100;
		houseProduction = 100;
		cryptProduction = 500;
		barracksProduction = 1000;
		
		farmCost = 10;
		houseCost = 10;
		barracksCost = 50;
		cryptCost = 100;

	}

	public void collectPopulation(){
		population += farmProduction;
	}

	public void collectGold(){
		gold += houseProduction;
	}

	public void collectSciencePoints(){
		magic += cryptProduction;
	}

	public void collectSoldiers(){
		soldiers += barracksProduction;
	}

	

	
}
