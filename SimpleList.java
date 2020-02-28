package cse360assign2;
/*
 * Author:	Allen Foust
 * ID: 110
 * Assignment#: 1
 * Description: This file contains the class SimpleList that does the following:
 * 		- adds elements to an array and shift them down with 10 max integers.
 * 		- removes elements from the array and shifts to cover blank space
 * 		- searches for an element and returns the position in the Array, -1 if not present.
 * 		- Help methods
 * 			- Converts the Array into a string
 * 			- return the amount of items in the array
 * 			- return the array object itself. Used mainly for testing.
 */



/**
 * This class has control methods for manipulating elements and getting information from an array.
 * @author Allen Foust
 * @version 1.0 
 */

public class SimpleList {
	private int list[];
	private	int	count;
	
	/**
	 *  Creates an array that holds 10 elements and
	 *  sets the count of the array to 0.
	 */
	public SimpleList() 
	{
		
		//Description:
		//	create array to hold 10 int
		//	set count = 0
		
		list = new int[10];
		count = 0;
	}
	
	/** 
	 * Move all elements in array over 1 element, and last element gets 
	 * deleted/falls off and then sets the passed in value to index 0. 
	 * @param param the number to add to index 0
	 */
	public void add(int param) 
	{
		
		 // Description:
 			//move all other ints in list over so there is room.
			//Add parameter to list at index 0
		//	if list is full, last element falls off
		int length = list.length;
		int newLength = length*2;
		
		if (count == length)
		{
			int temp[] = new int[list.length*2];
			System.arraycopy(list, 0, temp, 1, list.length);
			list = temp;
			list[0] = param;
			count++;
		}
		else
		{
			System.arraycopy(list, 0, list, 1, list.length-1); //move the array down 1
			list[0] = param;
			count++;
		}
	}
	
	/**
	 * If the passed in value matches an element, copy the elements over the 
	 * element which effectively removes it and shifts the array.
	 * @param param element to remove from list
	 */
	public void remove(int param)
	{
		
		if (count > 0)
		{
			for (int indexPosition = 0; indexPosition < count; indexPosition++) 
			{
				if (list[indexPosition] == param)
				{
					int length = list.length;
					int emptySpace = (length - count);
					float emptyPercent = (float)(emptySpace/(float)length);
					if (emptyPercent > 0.25 && list.length > 0) 
					{
						System.arraycopy(list, indexPosition+1, list, indexPosition, count - 1 - indexPosition);
						count --;
						//Resize array now
						int temp[] = new int[count];
						System.arraycopy(list, 0, temp, 0, temp.length);
						list = temp;
						return;
					}
					else
					{
						
						System.arraycopy(list, indexPosition+1, list, indexPosition, list.length - 1 - indexPosition);
						count--;
						return;
					}
					
				}
			}
			
			
		}
		else 
		{
			return;
		}
	}
	
	/**
	 * return the number of elements in the list
	 * @return the number of elements in the array
	 */
	public int count() 
	{
		return count;
	}
	
	/**
	 * Converts the array to a string seperated with a command and space. 
	 */
	public String toString()
	{
		//Return list as a string.
		//Elements need to be seperated by a space, but not on last int.	
		String output = "";
		for (int cursor = 0; cursor < count; cursor++)
		{
			if (cursor == 0)
			{
				output += Integer.toString(list[cursor]);
			}
			else 
			{
				output += " " + Integer.toString(list[cursor]);
			}			
		}
		return output;
	}
	
	/**
	 * Look through the array for the passed in number, and returns the index 
	 * if found and -1 if not.
	 * @param param value to search for.
	 * @return index position of found element, -1 if not found.
	 */
	public int search(int param) 
	{
		//return location of the parameter in the list. 
		//If parameter is not in the list, return -1
				
		if (count > 0)
		{
			for (int indexPosition = 0; indexPosition < count; indexPosition++)
			{
				if (list[indexPosition] == param)
				{
					return indexPosition;
				}
			}
		}
		//if not found
		return -1;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[] getArray() {
		return list;
	}
}
