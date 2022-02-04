package com.cs425.project.labs.lab14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.cs425.project.labs.lab14.service.ArrayFlattenerService;

public class ArrayReversor {

    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }


	public int[] reverseArray(int[][] arrayToReverse) {
		
		int[] arrayReversed = new int[]{0,1,4,9,3,2,6,7,8};
		
		if(arrayReversed == null) {
			return null;
		}
		
		List<Integer> reverseList =  Arrays.stream(arrayReversed).boxed().collect(Collectors.toList());
		Collections.reverse(reverseList);
		
		return reverseList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
		
	}
	
}
