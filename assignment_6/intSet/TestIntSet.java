package intSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * This class tests the class IntSet over multiple test cases.
 * @author Martand
 *
 */
public class TestIntSet {

	@Test
	public void TestIntSet_IsMember_flase(){
		boolean check;
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		check = intSetObject.isMember(11);
		assertEquals(false,check);
	}

	@Test
	public void TestIntSet_IsMember_true(){
		boolean check;
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		check = intSetObject.isMember(3);
		assertEquals(true,check);
	}

	@Test
	public void TestIntSet_Size(){
		int check;
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		check = intSetObject.size();
		assertEquals(6,check);
	}

	@Test
	public void TestIntSet_IsSubSet(){
		boolean check;
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		a[0] = 2;
		a[3] = 4;
		IntSet intSetObject_2 = new IntSet(a);
		check = intSetObject.isSubSet(intSetObject_2);
		assertEquals(false,check);
	}

	@Test
	public void TestIntSet_GetCompliment(){
		boolean check = false;
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		a[0] = 2;
		a[3] = 4;
		IntSet intSetObject_2 = intSetObject.getComplement();
		if(intSetObject_2 != null)
			check = true;
		assertEquals(true,check);
	}

	@Test
	public void TestIntSet_GetUnion(){
		int a[] = {1,3,4,6,7,10};
		IntSet intSetObject = new IntSet(a);
		a[0] = 2;
		a[3] = 4;
		IntSet intSetObject_2 = new IntSet(a);
		IntSet intSetObject_3 = IntSet.getUnion(intSetObject, intSetObject_2);
		assertArrayEquals(new int[] {1,3,4,6,7,10,2},intSetObject_3.getSET_OF_INTEGERS());
	}
}
