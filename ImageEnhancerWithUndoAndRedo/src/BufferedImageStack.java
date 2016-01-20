/*
 * BufferedImageStack.java
 * 
 * Author: Zhen Xu
 * This class used methods from ArrayList class to work as stack,
 * which temporarily saved the previous version of picture.
 * 
 * January 19th 2016
 */

import java.util.*;
import java.awt.image.BufferedImage;
public class BufferedImageStack {
	// data field: list used as stack
	List<BufferedImage> imageBuffer;
	
	// Constructor
	public BufferedImageStack()	{
		imageBuffer = new ArrayList<BufferedImage>();
	}
	// enters the buffered image onto the stack and returns nothing
	public void push(BufferedImage bi)	{
		imageBuffer.add(bi);
	}
	// returns true if there are no items in the stack; false otherwise.
	public boolean isEmpty()	{
		return imageBuffer.isEmpty();
	}
	// returns the number elements currently in the stack.
	public int getSize()	{
		return imageBuffer.size();
	}
	// Throws an exception if the stack is empty; otherwise returns the top buffered image, removing it from the stack.
	// The exception should be an instance of java.util.EmptyStackException.
	public BufferedImage pop()	{
		if(this.isEmpty())	{
			throw new EmptyStackException();
		}
		BufferedImage bi = imageBuffer.remove(this.getSize() - 1);
		return bi;
	}
	// throws an exception if the stack is empty; otherwise returns the top element of the stack.
	public BufferedImage peek() {
		if(this.isEmpty())
			throw new EmptyStackException();
		BufferedImage bi = imageBuffer.get(this.getSize() - 1);
		return bi;
	}
	// makes the stack empty.
	public void clearAll() {
		imageBuffer.clear();
	}
	// Returns the buffered image at the position given by the index
	// If the index is out of range, the method should throw an IndexOutOfBounds exception.
	public BufferedImage get(int index) {
		int range =  this.getSize() - 1;
		if(index < 0 && index > range)
			throw new IndexOutOfBoundsException();
		return imageBuffer.get(index);
	}
}
