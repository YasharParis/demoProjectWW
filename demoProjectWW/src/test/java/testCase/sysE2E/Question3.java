package testCase.sysE2E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Question3 {
	
	
	public static void main(String[] args) {
        int counter;
        Random rnum = new Random();
     
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (counter =1; counter <= 500; counter++) {
           
           arrayList.add(rnum.nextInt(1000));
        
        }
        System.out.println("Size of randomly generated numbers: " + arrayList.size());
        System.out.println(arrayList);
        System.out.println("=========================================");
        
        
        int minNumIndex = arrayList.indexOf(Collections.min(arrayList));
        int minNumber = arrayList.get(minNumIndex);
        System.out.println("Smallest number: " + minNumber);
    
     }
	
	
	
	
	

}
