//Andrew Grace
//Homework Week 3, Part 4, Time Analysis of IntArrayBag & IntLinkedBag

//Timer Pattern from http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java (recommended by James Oakley)
// long start_time = System.currentTimeMillis();
// object.method();
// long end_time = System.currentTimeMillis();
// long execution_time = end_time - start_time;

import java.util.*;

public class CompareArrayBagTimes 
{
  //Using Global Variables to Simplify Calls to Methods from Main Method and Test Driver Methods

	//Global Constants
	//These represent exponents applied to number 10, such as 10^2 = 100
	static final int EXPONENT_START = 2;		//start with 100
	static final int EXPONENT_FINISH = 6;	//end with 1 million
	
	//Global Variables
	//waiting until the size of the arrayBag is known before instantiating with size of bag.
	public static IntArrayBag myArrayBag;		//declared & not instantiated
	public static IntLinkedBag myLinkedBag;

	//Global Variables Used for Storing Test Data for Each Type of Bag.
	//Creating 3 arrays for test reults: 1 for test names, 2 for test results (a results array for each bag type)
	static String[] testNames = {"Constructor","countOccurences","getCapacity","remove","size","trimToSize","Union"};
	static int numberOfTests = testNames.length;
	static int numberOfExponents = (EXPONENT_FINISH - EXPONENT_START)+1;	
		
	//These two arrays are 2 tables to hold test results
	//fist dimension: the index number represents exponent of 10 minus EXPONENT_START offset value (add it back to get the exponent used for calculation)
	//second dimesion: represents the quantity of tests to be performed, need to test 7 different method names per class
	public static long[][] arrayBagResults = new long[numberOfExponents][numberOfTests];		 
	public static long[][] linkedBagResults = new long[numberOfExponents][numberOfTests];

//***************************************************************
//Main Method
//***************************************************************

	public static void main (String[] args)
	{										
		//loop through the different sized bags for each exponent of 10
		for (int i = 0; i < numberOfExponents; i++)
		{
			arrayBagTests(i);
			linkedBagTests(i);
		}			
		
		//Print out the results onto console
		outputResults();
		
		//end main		
	}
	
	//***************************************************************
	
	static void outputResults()
	{
		
		final int FIELD_LENGTH = 30;
		final int REPEAT_LENGTH = FIELD_LENGTH *3;
		
		String tableHeaderFormat = "%-30s %-30s %-30s";		//formats to use with printf, leaving field length values in for clarity
		String rowOutputFormat = "%-30s %-30d %-30d";
		
				
		System.out.println(repeatString("*",REPEAT_LENGTH));
		System.out.println("Printing Results");
		System.out.println(repeatString("*",REPEAT_LENGTH));
						
		//Print results		
		for (int i = 0; i < numberOfExponents; i++)
		{
			int expValue = i + EXPONENT_START;	
			int powerOfTen = (int) Math.pow(10,expValue);		
			
			System.out.println("Results for: 10^" + expValue + " (" + String.format("%,d", powerOfTen) + ") # of elements in each bag.");
			System.out.println(repeatString("-",REPEAT_LENGTH));	//visual line separator
			System.out.printf(tableHeaderFormat, "Method Name Tested:", "IntArrayBag:", "IntLinkedBag:");
			System.out.println();
			System.out.println(repeatString("-",REPEAT_LENGTH));	//visual line separator
					
			for (int j = 0; j < numberOfTests; j++)
			{
				System.out.printf(rowOutputFormat, testNames[j], arrayBagResults[i][j], linkedBagResults[i][j]);
				System.out.println();
			}

			System.out.println(repeatString("=",REPEAT_LENGTH)); //visual line separator
			System.out.println();
		}			

		System.out.println(repeatString("*",REPEAT_LENGTH)); //visual line separator
	}

//***************************************************************
//ArrayBag Test Driver Method
//***************************************************************

	//work directly on arrayBag object
	static void arrayBagTests(int exponentIndex)
	{
		int testIndex = 0;
		int expValue = exponentIndex + EXPONENT_START;
		int powerOfTen = (int) Math.pow(10,expValue);
		
		//instantiate arrayBag variable now that size of var  is known
		//myArrayBag = new IntArrayBag(Math.pow(10,expValue));
		myArrayBag = new IntArrayBag(powerOfTen);
						
		arrayBagResults[exponentIndex][testIndex] = test_constructor_arrayBag(expValue);
		testIndex++;
		
		arrayBagResults[exponentIndex][testIndex] = test_countOccurrences_arrayBag(expValue);
		testIndex++;

		arrayBagResults[exponentIndex][testIndex] = test_getCapacity_arrayBag(expValue);
		testIndex++;
		
		arrayBagResults[exponentIndex][testIndex] = test_remove_arrayBag(expValue);
		testIndex++;
		
		arrayBagResults[exponentIndex][testIndex] = test_size_arrayBag(expValue);
		testIndex++;
		
		arrayBagResults[exponentIndex][testIndex] = test_trimtoSize_arrayBag(expValue);
		testIndex++;
		
		arrayBagResults[exponentIndex][testIndex] = test_Union_arrayBag(expValue);		
 	}
	
//***************************************************************
//LinkedBag Test Driver Method
//***************************************************************
	
	static void linkedBagTests(int exponentIndex)
	{
		int testIndex = 0;
		int expValue = exponentIndex + EXPONENT_START;
		int powerOfTen = (int) Math.pow(10,expValue);
		
		//instantiate linkedBag variable now that size of var  is known
		//myLinkedBag = new IntLinkedBag(powerOfTen);
		myLinkedBag = new IntLinkedBag();		//must be instantiated with empty constructor
		growLinkedBag(powerOfTen);
		
		linkedBagResults[exponentIndex][testIndex] =	test_constructor_linkedBag(expValue);
			testIndex++;
		
		linkedBagResults[exponentIndex][testIndex] =	test_countOccurrences_linkedBag(expValue);
			testIndex++;
		
		linkedBagResults[exponentIndex][testIndex] =	test_getCapacity_linkedBag(expValue);
			testIndex++;
		
		linkedBagResults[exponentIndex][testIndex] =	test_remove_linkedBag(expValue);
			testIndex++;
		
		linkedBagResults[exponentIndex][testIndex] =	test_size_linkedBag(expValue);
			testIndex++;
		
		linkedBagResults[exponentIndex][testIndex] =	test_trimtoSize_linkedBag(expValue);
			testIndex++;
			
		linkedBagResults[exponentIndex][testIndex] =	test_Union_linkedBag(expValue);
	}
	
	//Fill Bags with Data
	//==================================================
	
	//Need to grow the linked bag to the right size
	static void growLinkedBag(int powerOfTen)
	{
		for (int i = 0; i < powerOfTen; i++)
		{
			myLinkedBag.add(i);	//filling with value of counter
		}
	}
	
//***************************************************************
//ArrayBag Test Methods, all methods return longs that represent time passed for storage in result arrays
//***************************************************************

	static long test_constructor_arrayBag(int expValue)
	{
		return 11;
	}
	
	static long test_countOccurrences_arrayBag(int expValue)
	{
		return 12;
	}
	static long test_getCapacity_arrayBag(int expValue)
	{
		return 13;
	}
	static long test_remove_arrayBag(int expValue)
	{
		return 14;
	}
	
	static long test_size_arrayBag(int expValue)
	{
		return 15;
	}
	
	static long test_trimtoSize_arrayBag(int expValue)
	{
		return 16;
	}
	
	static long test_Union_arrayBag(int expValue)
	{
		return 17;
	}

//***************************************************************
//Linked Test Methods, all methods return longs that represent time passed for storage in result arrays
//***************************************************************	
	static long test_constructor_linkedBag(int expValue)
	{
		return 21;
	}
	
	static long test_countOccurrences_linkedBag(int expValue)
	{
		return 22;
	}
	
	static long test_getCapacity_linkedBag(int expValue)
	{
		return 23;
	}
	
	static long test_remove_linkedBag(int expValue)
	{
		return 24;
	}
	
	static long test_size_linkedBag(int expValue)
	{
		return 25;
	}
	
	static long test_trimtoSize_linkedBag(int expValue)
	{
		return 26;
	}
	
	static long test_Union_linkedBag(int expValue)
	{
		return 27;
	}
	
	//Helper Method
	static String repeatString(String myString, int numTimes)
	{
		String result = "";
	
		for (int i = 0; i < numTimes; i++)
				result += myString; 
				
		return result; 
	}

	//***************************************************************
	//end class
}
