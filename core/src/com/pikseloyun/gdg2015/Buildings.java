package com.pikseloyun.gdg2015;

import Buildings.Barracks;
import Buildings.Crypt;
import Buildings.Farm;
import Buildings.House;

public class Buildings {

	public Farm farm;
	public Crypt crypt;
	public House house;
	public Barracks barracks;
	
	public Buildings(){
		
		farm = new Farm();
		crypt = new Crypt();
		house = new House();
		barracks = new Barracks();
		
	}
	
}
