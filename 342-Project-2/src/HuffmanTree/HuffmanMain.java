package HuffmanTree;

import java.util.Scanner;

public class HuffmanMain 
{
	public static void main(String[] args) 
	{	
		Tester test = new Tester();
		Scanner in = new Scanner(System.in);
		System.out.print("Input string:");
		String line = in.nextLine();
		test.run(line);
		in.close();
	}
}
