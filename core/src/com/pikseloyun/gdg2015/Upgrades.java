package com.pikseloyun.gdg2015;

import java.util.ArrayList;

public class Upgrades {

	ArrayList<Upgrade> upgradeList;

	public Upgrades(){

		upgradeList = new ArrayList<Upgrade>();

		// Farm Upgrades
		farmTimeReduceUpgrades();
		farmCostReduceUpgrades();
		farmProductionBonus();

		// House Upgrades
		houseTimeReduceUpgrades();
		houseCostReduceUpgrades();
		houseProductionBonus();

		// Crypt Upgrades
		cryptTimeReduceUpgrades();
		cryptCostReduceUpgrades();
		cryptProductionBonus();

		// Barrakcs Upgrades
		barracksTimeReduceUpgrades();
		barracksCostReduceUpgrades();
		barracksProductionBonus();

		// Military Upgrades
		offensiveUpgrades();
		defensiveUpgrades();

	}

	public void farmTimeReduceUpgrades(){

		upgradeList.add(new Upgrade("Farm - 10% faster collect", 0, 10, 100, 1, false));

	}

	public void farmCostReduceUpgrades(){

		upgradeList.add(new Upgrade("Farm - 10% cheaper build", 1, 10, 200, 1, false));

	}

	public void farmProductionBonus(){

		upgradeList.add(new Upgrade("Farm - 20% more production", 2, 20, 300, 1, false));

	}

	public void houseTimeReduceUpgrades(){

		upgradeList.add(new Upgrade("House - 10% faster collect", 0, 10, 100, 2, false));

	}

	public void houseCostReduceUpgrades(){

		upgradeList.add(new Upgrade("House - 10% cheaper build", 1, 10, 200, 2, false));

	}

	public void houseProductionBonus(){

		upgradeList.add(new Upgrade("House - 20% more production", 2, 20, 300, 2, false));

	}

	public void cryptTimeReduceUpgrades(){

		upgradeList.add(new Upgrade("Crypt - 10% faster collect", 0, 10, 100, 3, false));

	}

	public void cryptCostReduceUpgrades(){

		upgradeList.add(new Upgrade("Crypt - 10% cheaper build", 1, 10, 200, 3, false));

	}

	public void cryptProductionBonus(){

		upgradeList.add(new Upgrade("Crypt - 20% more production", 2, 20, 300, 3, false));


	}

	public void barracksTimeReduceUpgrades(){

		upgradeList.add(new Upgrade("Barrakcs - 10% faster collect", 0, 10, 100, 4, false));

	}

	public void barracksCostReduceUpgrades(){

		upgradeList.add(new Upgrade("Barracks - 10% cheaper build", 1, 10, 200, 4, false));

	}

	public void barracksProductionBonus(){

		upgradeList.add(new Upgrade("Barrakcs - 20% more production", 2, 20, 300, 4, false));

	}

	public void defensiveUpgrades(){

		upgradeList.add(new Upgrade("Defence - 10% more strong defence", 3, 10, 300, 0, false));

	}

	public void offensiveUpgrades(){

		upgradeList.add(new Upgrade("Attack - 10% more strong attacks", 4, 10, 300, 0, false));

	}



}
