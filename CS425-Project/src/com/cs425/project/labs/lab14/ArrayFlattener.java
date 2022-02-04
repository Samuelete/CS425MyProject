package com.cs425.project.labs.lab14;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {

	public int[] flattenArray(int[][] dimArrays) {
		
		if(dimArrays == null) {
			return null;
		}

		List<Integer> flattenArray = new ArrayList<>();
		
		for (int row = 0; row < dimArrays.length; row++) {
		    for (int col = 0; col < dimArrays[row].length; col++) {
		    	flattenArray.add(dimArrays[row][col]);
		    }
		}
		
		return flattenArray.stream()
                .mapToInt(Integer::intValue)
                .toArray();
		
	}
	
}
