package HuffmanTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanFrequencyTable 
{
	private Map<Character,Integer> frequencyMap;
	private Map<Character,String> bitMap;
	private List<Character> order;
	
	public HuffmanFrequencyTable()
	{
		frequencyMap = new HashMap<>();
		bitMap = new TreeMap<>();
		order = new ArrayList<>();
	}
	public void generateTable(String theString)
	{
		for(int i = 0 ; i < theString.length() ; i++)
		{
			Character temp = theString.charAt(i);
			if(!frequencyMap.containsKey(temp))
			{
				frequencyMap.put(temp,1);
				order.add(temp);
			}
			else
			{
				frequencyMap.put(temp,frequencyMap.get(temp) +1);
			}
		}
		if(frequencyMap.keySet().size() < 2)
		{
			throw new IllegalArgumentException();
		}
		
	}
	public void generateBit(HuffmanTreeNode<Character> huffmanTreeNode, String bitString)
	{
		Character temp = huffmanTreeNode.getElement();
		if(temp != null)
		{
			bitMap.put(huffmanTreeNode.getElement(),bitString);
		}
		else
		{
			generateBit(huffmanTreeNode.getLeft(), bitString + '0');
			generateBit(huffmanTreeNode.getRight(), bitString + '1');
		}
	}
	public void displayTable()
	{
		try(BufferedWriter out = new BufferedWriter(new FileWriter(Paths.get("./HuffmanOut.txt").toAbsolutePath().toFile(), true))) 
		{
			int unCodedSize = 0;
			int enCodedSize = 0;
			for(Character s: frequencyMap.keySet())
			{
				unCodedSize += frequencyMap.get(s) * 8;
			}
			for(Character s: bitMap.keySet())
			{
				enCodedSize += frequencyMap.get(s) * bitMap.get(s).length();
			}
			out.write("======================================\n");
			out.write("char      frequency      code         \n");
			out.write("--------------------------------------\n");
			System.out.println("======================================");
			System.out.println("char      frequency      code         ");
			System.out.println("--------------------------------------");
			for(int i = 0 ; i < order.size(); i++)
			{
				out.write(String.format("%-10c",order.get(i)) + String.format("%-15d", frequencyMap.get(order.get(i))) + String.format("%-10s", bitMap.get(order.get(i))) + "\n");
				System.out.println(String.format("%-10c",order.get(i)) + String.format("%-15d", frequencyMap.get(order.get(i))) + String.format("%-10s", bitMap.get(order.get(i))));
			}
			out.write("======================================\n");
			out.write("Total number of bits without Huffman coding (8 bits per character): " + unCodedSize + "\n");
			out.write("Total number of bits with Huffman coding: " + enCodedSize + "\n");
			System.out.println("======================================");
			System.out.println("Total number of bits without Huffman coding (8 bits per character): " + unCodedSize);
			System.out.println("Total number of bits with Huffman coding: " + enCodedSize);
			double ratio = (double)enCodedSize / (double)unCodedSize;
			System.out.println("Compression Ratio: " + String.format("%.2f",ratio));
			out.write("Compression Ratio: " + String.format("%.2f",ratio) + "\n");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public Map<Character,Integer> getFrequencyMap()
	{
		return frequencyMap;
	}
	public Map<Character,String> getBitMap()
	{
		return bitMap;
	}
}
