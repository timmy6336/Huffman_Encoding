package HuffmanTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Decoder 
{
	private HuffmanTree myTree;
	
	public Decoder(HuffmanTree newTree)
	{
		myTree = newTree;
	}
	public String decode(String input)
	{
		String decoded = "";
		try(BufferedWriter out = new BufferedWriter(new FileWriter(Paths.get("./HuffmanOut.txt").toAbsolutePath().toFile(), true))) 
		{
		HuffmanTreeNode<Character> traverse = myTree.getRoot();
		for(int i = 0; i < input.length() ; i++)
		{
			if(input.charAt(i) == '0')
			{
				traverse = traverse.getLeft();
			}
			else
			{
				traverse = traverse.getRight();
			}
			Character check = traverse.getElement();
			if(check != null)
			{
				decoded += check;
				traverse = myTree.getRoot();
			}
		}
		System.out.println("Decoded String: " + decoded);
		out.write("Decoded String: " + decoded + "\n");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return decoded;
	}
}
