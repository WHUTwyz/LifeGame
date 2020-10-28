package next;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenerationTest {

	private static Generation generation=new Generation();
	@Before
	public void setUp() throws Exception {
		generation.clear();
	}

	@Test
	public void testSelect() {
		//fail("Not yet implemented");
		assertEquals(0,generation.select(1, 1));
		generation.set(1,1,1);
		assertEquals(1,generation.select(1, 1));
		
		assertEquals(0,generation.select(15, 15));
		generation.set(15,15,1);
		assertEquals(1,generation.select(15, 15));
		
		assertEquals(0,generation.select(30, 17));
		generation.set(30, 17, 1);
		assertEquals(1,generation.select(30, 17));
	}

	@Test
	public void testPrintTheLife() {
		//fail("Not yet implemented");
		assertEquals(0,generation.select(1, 1));
		generation.set(1,1,1);
		assertEquals(1,generation.select(1, 1));
		
		assertEquals(0,generation.select(15, 15));
		generation.set(15,15,1);
		assertEquals(1,generation.select(15, 15));
		
		assertEquals(0,generation.select(30, 17));
		generation.set(30, 17, 1);
		assertEquals(1,generation.select(30, 17));
	}

	@Test
	public void testGetNeighborCount() {
		//fail("Not yet implemented");
		//≤‚ ‘1,1
		generation.set(1,2,1);
		generation.set(2,1,1);
		assertEquals(2,generation.getNeighborCount(1, 1));
		//≤‚ ‘13,15
		generation.set(13,16,1);
		generation.set(13,14,1);
		generation.set(14,16,1);
		generation.set(12,16,1);
		assertEquals(4,generation.getNeighborCount(13, 15));
		
		//≤‚ ‘30,12
		generation.set(30,13,1);
		generation.set(29,12,1);
		assertEquals(2,generation.getNeighborCount(30, 12));
		
		
	}

	@Test
	public void testUpdate() {
		//≤‚ ‘1,1
		generation.set(1,2,1);
		generation.set(2,1,1);
		

		//≤‚ ‘13,15
		generation.set(13,16,1);
		generation.set(13,14,1);
		generation.set(14,16,1);
		generation.set(12,16,1);
	
		
		//≤‚ ‘30,12
		generation.set(30, 12, 1);
		generation.set(30,13,1);
		generation.set(29,12,1);
		
		generation.update();
		assertEquals(0,generation.select(1,1));
		assertEquals(0,generation.select(13, 15));
		assertEquals(1,generation.select(30, 12));
	}

}
