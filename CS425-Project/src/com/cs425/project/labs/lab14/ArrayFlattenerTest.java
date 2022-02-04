package com.cs425.project.labs.lab14;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerTest {

	private ArrayFlattener arrayFlatener = null;
	
	@Before
	public void setUp() throws Exception {
		this.arrayFlatener = new ArrayFlattener();
	}

	@Test
	public void testNull() {
		
		int[][] test = null;
		assertNull("should be null", arrayFlatener.flattenArray(test));
		
	}
	
	@Test
	public void test2() {
		
		int[][] input = {{1,2},{4,5,6},{0,9}};
		int[] result = arrayFlatener.flattenArray(input);
		int[] testResult = {1,2,4,5,6,0,9};
		
		assertTrue(Arrays.equals(result, testResult));
		
	}

}
