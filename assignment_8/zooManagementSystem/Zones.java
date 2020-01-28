package zooManagementSystem;

import java.util.ArrayList;

/**
 * This class holds capacity of cages and type of animal in zone.
 * @author Martand
 *
 */
public class Zones {
	final int limitOfCages;
	String typeOfZone;
	final int zoneId;
	static int counter = 0;
	ArrayList<Cage> listOfCages = new ArrayList<Cage>();
	boolean hasPark;
	boolean hasCanteen;


	public Zones(int capacityForCagesInZone,String zoneType,boolean park, boolean canteen) {

		limitOfCages = capacityForCagesInZone;
		typeOfZone = zoneType;
		zoneId = counter++;
		hasPark = park;
		hasCanteen = canteen;
	}

}
