package openblocks.shapes.shapesgenerators;

import static org.junit.Assert.*;

import org.junit.Test;

public class WallShapeGeneratorTest {

	@Test
	public void test() {
		assertEquals(-Math.PI/2, WallShapeGenerator.angleBetweenm180p180(3*Math.PI/2),0.001);
		assertEquals(Math.PI,WallShapeGenerator.angleBetweenm180p180(Math.PI*9),0.0001);
		assertEquals(Math.PI/4,WallShapeGenerator.angleBetweenm180p180(Math.atan2(1,1)),0.0001);
		assertEquals(Math.PI/2,WallShapeGenerator.angleBetweenm180p180(Math.atan2(1,0)),0.0001);
	}

}
