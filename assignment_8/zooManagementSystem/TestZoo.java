package zooManagementSystem;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class TestZoo {
	Zoo obj ;
	boolean check = false;
	
	@Before
	public void runBeforeAll(){
		obj = new Zoo();
		obj.addZone(2, "mammal",true,false);
		obj.addZone(1, "reptile",false,true);
		obj.addZone(1, "bird",true ,true);
		obj.addCage("mammal", "tiger", 2);
		obj.addCage("bird","eagle", 1);
		obj.addCage("reptile","crocodile", 1);
	}
	
	@Test 
	public void TestZoo_addZone(){
		
	}
}
