import java.util.*;
public class BrushUpJava {
	public static void main(String[] args)	{
		// 1 
		System.out.println("This program was developed by Zhen Xu");
		
		// 2 
		System.out.println("having UWNetID zhenxu92");
		
		// 3 
		long seed = 0;
		Random rnd = new Random(seed);
		
		// 4 
		ArrayList<Double> list1 = new ArrayList();
		for (int i=0; i<10; i++)	{
			list1.add(rnd.nextDouble()*99);
		}
		// 5 
		System.out.println("The first 10 random numbers: ");
		
		// 6 
		for (int i=0; i<10; i++)	{
			System.out.print(list1.get(i) + ", ");

		}
		System.out.println();		
		// 7 
		Collections.sort(list1);
		
		// 8 
		System.out.println("The (sorted) first 10 random numbers: ");
		
		// 9 
		for (int i = 0; i < 10; i++)	{
			System.out.print(list1.get(i) + ", ");
		}
		System.out.println();		
		// 10 
		System.out.println("The last three digits of my student number: " + "943");
		
		// 11 
		long stuno = 943;
		Random rnd2 = new Random(stuno);
		
		// 12
		ArrayList<Double> list2 = new ArrayList();
		for (int i=0; i<10; i++)	{
			list2.add(rnd2.nextDouble()*99);
		}		
		
		// 13 
		System.out.println("Ten new random numbers: ");
		
		// 14 
		for (int i = 0; i < 10; i++)	{
			System.out.print(list2.get(i) + ", ");
		}
		System.out.println();		
		// 15 
		Collections.sort(list2);
		
		// 16 
		System.out.println("Now sorted: ");
		
		// 17
		for (int i = 0; i < 10; i++)	{
			System.out.print(list2.get(i) + ", ");
		}
      System.out.println();		
	}
}
