package HuffmanTree;

public class Tester 
{
	public void run(String theString)
	{
		HuffmanFrequencyTable myTable = new HuffmanFrequencyTable();
		HuffmanTree myTree = new HuffmanTree(myTable);
		myTable.generateTable(theString);
		myTree.generateTree();
		myTable.generateBit(myTree.getRoot(), "");
		myTable.displayTable();
		Encoder myEncoder = new Encoder(myTree);
		Decoder myDecoder = new Decoder(myTree);
		String encoded = myEncoder.encodeString(theString);
		String decoded = myDecoder.decode(encoded);
	}
}
