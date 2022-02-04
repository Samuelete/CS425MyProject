package com.cs425.project.labs.lab14;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cs425.project.labs.lab14.service.ArrayFlattenerService;

public class ArrayReversorTest {

	private ArrayReversor arrayReversor;
	private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
	
    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }
	
    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }
    
    @Test
    public void testArrayReversor() {
    	
    	int[][] input = new int[][]{{0,1,4}, {9,3}, {2,6,7,8}};
    	int[] testing = new int[]{0,1,4,9,3,2,6,7,8};
    	when(arrayFlattenerService.flattenArray(input)).thenReturn(testing);
    	int[] outputReverseExpected = arrayReversor.reverseArray(input);
    	int[] reverseExpected = {9,8,7,6,4,3,2,1,0};
    	 assertArrayEquals(reverseExpected, outputReverseExpected);
         verify(arrayFlattenerService).flattenArray(input);
    }
    
    @Test
    public void testArrayReversorNull() {
    	
        int[][] input = null;
        
        when(arrayFlattenerService.flattenArray(input)).thenReturn(null);
        
        int[] nullArrayReversorExpected = arrayReversor.reverseArray(input);
        int[] nullExpected = null;
        
        assertArrayEquals(nullExpected, nullArrayReversorExpected);
        verify(arrayFlattenerService).flattenArray(input);
    }
    
}
