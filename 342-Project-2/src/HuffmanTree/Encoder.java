package HuffmanTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Encoder 
{
	private HuffmanTree myTree;
	
	public Encoder(HuffmanTree newTree)
	{
		myTree = newTree;
	}
	public String encodeString(String input)
	{
		String encoded = "";
		try(BufferedWriter out = new BufferedWriter(new FileWriter(Paths.get("./HuffmanOut.txt").toAbsolutePath().toFile(), true))) 
		{
		Map<Character,String> bitMap = myTree.getTable().getBitMap();
		for(int i = 0; i < input.length() ; i++)
		{
			encoded += bitMap.get(input.charAt(i));
		}
		out.write("Encoded Bit Stream: " + encoded + "\n");
		System.out.println("Encoded Bit Stream: " + encoded);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return encoded;
	}
}
