package com.pikseloyun.gdg2015;

public class Upgrade {

	public String name;
	/* Type types
	 * 0 = time reduce (percent)
	 * 1 = cost reduce (percent)
	 * 2 = production bonus (percent)
	 * 3 = defence bonus (percent)
	 * 4 = attack bonus (percent)
	 */
	public int type;
	public int effect;
	public int cost;
	/* Building Types
	 * 0 = Not Building
	 * 1 = Farm
	 * 2 = House
	 * 3 = Crypt
	 * 4 = Barrakcs
	 */
	public int buildingType;
	public boolean purchased;
	
	public Upgrade(String name, int type, int effect, int cost, int buildingType, boolean purchased){
		this.name = name;
		this.type = type;
		this.effect = effect;
		this.cost = cost;
		this.buildingType = buildingType;
		this.purchased = purchased;
	}
	
}
