package com.pikseloyun.gdg2015;

public class GameState {

	public int population, soldiers, gold, sciencePoints;
	
	public int farmTime, barracksTime, houseTime, cryptTime;
	public int farmProduction, barracksProduction, houseProduction, cryptProduction;
	public int farmCost, barracksCost, houseCost, cryptCost;

	public Buildings buildings;
	public Upgrades upgrades;

	// Starting Constants
	public final int startingPop = 10; 
	public final int startingSoldiers = 1; 
	public final int startingGold = 100; 
	public final int startingSciencePoints = 5;

	public GameState(){

		buildings = new Buildings();
		upgrades = new Upgrades();

		population = startingPop;
		soldiers = startingSoldiers;
		gold = startingGold;
		sciencePoints = startingSciencePoints;

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
		sciencePoints += cryptProduction;
	}

	public void collectSoldiers(){
		soldiers += barracksProduction;
	}

	public void buyFarmUpgrade(Upgrade u){

		if(u.buildingType != 1)
			return;
		
		sciencePoints -= u.cost;

		// time reduce
		if(u.type == 0){
			farmTime -= farmTime * u.effect/100;
		}

		// cost reduce
		if(u.type == 1){
			farmCost -= farmCost * u.effect/100;
		}

		// production bonus
		if(u.type == 2){
			farmProduction += farmProduction * u.effect/100;
		}

	}
	
	public void buyHouseUpgrade(Upgrade u){

		if(u.buildingType != 2)
			return;

		sciencePoints -= u.cost;
		
		// time reduce
		if(u.type == 0){
			houseTime -= houseTime * u.effect/100;
		}

		// cost reduce
		if(u.type == 1){
			houseCost -= houseCost * u.effect/100;
		}

		// production bonus
		if(u.type == 2){
			houseProduction += houseProduction * u.effect/100;
		}

	}
	
	public void buyCryptUpgrade(Upgrade u){

		if(u.buildingType != 3)
			return;

		sciencePoints -= u.cost;
		
		// time reduce
		if(u.type == 0){
			cryptTime -= cryptTime * u.effect/100;
		}

		// cost reduce
		if(u.type == 1){
			cryptCost -= cryptCost * u.effect/100;
		}

		// production bonus
		if(u.type == 2){
			cryptProduction += cryptProduction * u.effect/100;
		}

	}
	
	public void buyBarracksUpgrade(Upgrade u){

		if(u.buildingType != 4)
			return;

		sciencePoints -= u.cost;
		
		// time reduce
		if(u.type == 0){
			barracksTime -= barracksTime * u.effect/100;
		}

		// cost reduce
		if(u.type == 1){
			barracksCost -= barracksCost * u.effect/100;
		}

		// production bonus
		if(u.type == 2){
			barracksProduction += barracksProduction * u.effect/100;
		}

	}

	public void buildFarm(){
		population -= farmCost + farmCost/2 * buildings.farm.level;
		buildings.farm.level++;
	}
	
	public void buildHouse(){
		population -= houseCost + houseCost/2 * buildings.house.level;
		buildings.house.level++;
	}
	
	public void buildCrypt(){
		gold -= cryptCost + cryptCost/2 * buildings.crypt.level;
		buildings.crypt.level++;
	}
	
	public void buildBarracks(){
		gold -= barracksCost + barracksCost/2 * buildings.barracks.level;
		buildings.barracks.level++;
	}
	
}
