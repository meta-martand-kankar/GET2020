package zooManagementSystem;

/**
 * This class searches for which subclass object of animal should be made.
 *  * @author Martand
 *
 */
public class AnimalTypeFactory {

	/**
	 * This function adds animal of mammal type.
	 * @param type of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param speed of animal.
	 * @param sound of animal.
	 * @return super class reference.
	 */
	public static Animal addAnimal(String type,int age,String name, String category, float weight, int speed,String sound){

		Animal animal = null;
		if("tiger".equals(type))
			animal = new Tiger(age, name, category, weight, speed, sound);

		return animal;
	}


	/**
	 * This function adds animal of reptile type.
	 * @param type of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param swim of animal.
	 * @param sound of animal.
	 * @return super class reference.
	 */
	public static Animal addAnimal(String type,int age,String name, String category, float weight, String swim,String sound){

		Animal animal = null;
		if("crocodile".equalsIgnoreCase(type))
			animal = new Crocodiale(age, name, category, weight, swim, sound);

		return animal;
	}


	/**
	 * This function adds animal of bird type.
	 * @param type of animal.
	 * @param age of animal.
	 * @param name of animal.
	 * @param category of animal.
	 * @param weight of animal.
	 * @param canFly of animal.
	 * @param sound of animal.
	 * @return super class reference.
	 */
	public static Animal addAnimal(String type,int age,String name, String category, float weight, boolean canFly,String sound){

		Animal animal = null;
		if("eagle".equalsIgnoreCase(type))
			animal = new Eagle(age, name, category, weight, canFly, sound);

		return animal;
	}
}
