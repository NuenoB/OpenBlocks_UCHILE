package openblocks.shapes.shapesgenerators;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
 
public class WallShapeGeneratorTest {

	@Test
	public void test() {
		assertEquals(-Math.PI/2, WallShapeGenerator.angleBetweenm180p180(3*Math.PI/2),0.001);
		assertEquals(Math.PI,WallShapeGenerator.angleBetweenm180p180(Math.PI*9),0.0001);
		assertEquals(Math.PI/4,WallShapeGenerator.angleBetweenm180p180(Math.atan2(1,1)),0.0001);
		assertEquals(Math.PI/2,WallShapeGenerator.angleBetweenm180p180(Math.atan2(1,0)),0.0001);
	}
	
	@Test
	public void testArrayList(){
		ArrayList<Integer> anNumber1 = new ArrayList<Integer>();
		ArrayList<Integer> anNumber2 = new ArrayList<Integer>();
		
		anNumber1.add(1);
		anNumber1.add(2);
		anNumber1.add(3);
		anNumber2.add(4);
		anNumber2.add(5);
		anNumber2.add(6);
		
		anNumber1.addAll(anNumber2);
		anNumber1.addAll(new ArrayList<Integer>());
		
		for(int i = 1; i <= 5; i++)
			assertEquals(new Integer(i),anNumber1.get(i-1));
	}

}
