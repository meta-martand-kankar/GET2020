package zooManagementSystem;

import java.util.LinkedHashMap;

/**
 * This is Zoo management Class.
 * @author Martand
 *
 */
public class Zoo {
	/*
	 * to add animal;
	 * to add cage automatically when animal arrives;
	 * remove animal when it dies;
	 */

	// tiger ----- String type,int age,String name, String category, float weight, int speed,String sound
	//zone ------int capacityForCagesInZone,String zoneType
	// cage ---- String typeOfAnimal, int capacity

	private LinkedHashMap<Integer,Zones> listOfZones = new LinkedHashMap<Integer,Zones>();

	/**
	 * This function adds zone in the Zoo.
	 * @param capacityOfCages sets capacity of cages in a zone.
	 * @param zoneType specifies category of animal to be kept in a zone.
	 * @param park if zone has a park.
	 * @param canteen if zone has a canteen.
	 * @return true if zone is added successfully else false.
	 */
	public boolean addZone(int capacityOfCages, String zoneType, boolean park, boolean canteen){
		Zones zoneObj = new Zones(capacityOfCages, zoneType, park, canteen);
		listOfZones.put(zoneObj.zoneId, zoneObj);
		return true;
	}

	/**
	 * This function adds cage in zone.
	 * @param zoneType category of animal in zone.eg - "mammal"
	 * @param animalBreed type of animal in cage.eg - "tiger"
	 * @param capacity sets capacity of cage to hold animals.
	 * @return true if cage added successfully else false.
	 */
	public boolean addCage(String zoneType,String animalBreed, int capacity){
		Cage cageObj = new Cage(animalBreed, capacity);
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == zoneType && listOfZones.get(i).limitOfCages > listOfZones.get(i).listOfCages.size()){
				listOfZones.get(i).listOfCages.add(cageObj);
				return true;
			}
		}
		return false;
	}

	//mammal
	/**
	 * This function adds mammals in zoo.
	 * @param type breed of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param speed of animal.
	 * @param sound of animal.
	 * @return true if added successfully else false.
	 * @throws AssertionError when animal with same name present in the cage.
	 */
	public boolean addAnimal(String type,int age,String name, String category, float weight, int speed,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, speed, sound);
		System.out.println("ïn 1");
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage > listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}

		return false;
	}

	//bird
	/**
	 * This function adds birds in zoo.
	 * @param type breed of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param canFly checks is animal can fly or not.
	 * @param sound of animal.
	 * @return true if added successfully else false.
	 * @throws AssertionError when animal with same name present in the cage.
	 */
	public boolean addAnimal(String type,int age,String name, String category, float weight, boolean canFly,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, canFly, sound);
		System.out.println("in 2");
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}

		return false;
	}

	//reptile
	/**
	 * This function adds mammals in zoo.
	 * @param type breed of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param swim checks if animal can swim or not.
	 * @param sound of animal.
	 * @return true if added successfully else false.
	 * @throws AssertionError when animal with same name present in the cage.
	 */
	public boolean addAnimal(String type,int age,String name, String category, float weight, String swim,String sound) throws AssertionError{
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, swim, sound);
		System.out.println("ïn 1");
		for(int i=0;i< listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone == category){
				for(int j =0;j < listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name))
						throw new AssertionError("Animal with this name already present");
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * This function removes animal after his death.
	 * @param category of animal.
	 * @param breed of animal.
	 * @param name of animal.
	 * @return true if removed successfully else false.
	 */
	public boolean removeAnimal(String category,String breed,String name){
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone==category){
				for(int j =0;j<listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == breed && listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name)){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.remove(name);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * This function gets the sound of animal.
	 * @param category of animal.
	 * @param breed of animal.
	 * @param name of animal.
	 * @return sound of animal.
	 * @throws AssertionError if no animal with this name is found.
	 */
	public String getAnimalSound(String category,String breed,String name) throws AssertionError{
		for(int i=0;i<listOfZones.size();i++){
			if(listOfZones.get(i).typeOfZone==category){
				for(int j =0;j<listOfZones.get(i).listOfCages.size();j++){
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == breed){
						return listOfZones.get(i).listOfCages.get(j).listOfAnimal.get(name).getSound();
					}
				}
			}
		}
		throw new AssertionError("No animal of this breed");
	}


	/*	public static void main(String[] args){
		Zoo obj = new Zoo();
		boolean check = false;
		check = obj.addZone(2, "mammal",true,false);
		System.out.println(check);
		System.out.println("-------1--------");

		check = obj.addZone(1, "reptile",false,true);
		System.out.println(check);
		System.out.println("--------2-------");

		check = obj.addZone(1, "bird",true ,true);
		System.out.println(check);
		System.out.println("---------3------");

		check = obj.addCage("mammal", "tiger", 2);
		System.out.println(check);
		System.out.println("----------4-----");

		check = obj.addCage("bird","eagle", 1);
		System.out.println(check);
		System.out.println("-----------5----");

		check = obj.addCage("reptile","crocodile", 1);
		System.out.println(check);
		System.out.println("----------6-----");

		check = obj.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("-----------7----");

		check = obj.removeAnimal("mammal", "tiger", "ramu");
		System.out.println(check);
		System.out.println("----------8-----");

		check = obj.removeAnimal("reptile", "crocodile", "shyamu");
		System.out.println(check);
		System.out.println("---------9------");

		check = obj.addAnimal("eagle", 5, "chiya", "bird", 10.00f, check, "beep");
		System.out.println(check);
		System.out.println("----------10-----");

		check = obj.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("----------12-----");

		System.out.println(obj.getAnimalSound("mammal","tiger","ramu"));
		System.out.println("----------13-----");
	} */
}
