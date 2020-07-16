package HuffmanTree;

import java.util.Map;


public class HuffmanTree 
{
	private HuffmanFrequencyTable myTable;
	private HuffmanTreeNode<Character> root;
	public HuffmanTree(HuffmanFrequencyTable newTable)
	{
		myTable = newTable;
		root = null;
	}
	public void generateTree()
	{
		Map<Character,Integer> frequencyMap = myTable.getFrequencyMap();
		HuffmanTreeNode<Character> root2;
		PriorityQueue<PriorityQueueNode<HuffmanTreeNode<Character>>> theQueue = new PriorityQueue<>();
		for(Character a : frequencyMap.keySet())
		{
			HuffmanTreeNode<Character> temp = new HuffmanTreeNode<>(a,frequencyMap.get(a));
			PriorityQueueNode<HuffmanTreeNode<Character>> temp2 = new PriorityQueueNode<>(temp,frequencyMap.get(a));
			theQueue.addElement(temp2, temp2.getPriority());
		}
		while(theQueue.getSize() > 1)
		{
			HuffmanTreeNode<Character> left = theQueue.removeNext().getElement();
			HuffmanTreeNode<Character> right = theQueue.removeNext().getElement();
			int sum = left.getPriority() + right.getPriority();
			root2 = new HuffmanTreeNode<Character>(null , sum);
			root2.setLeft(left);
			root2.setRight(right);
			PriorityQueueNode<HuffmanTreeNode<Character>> temp2 = new PriorityQueueNode<>(root2,sum);
			theQueue.addElement(temp2, sum);
		}
		root = theQueue.removeNext().getElement();
	}
	public HuffmanTreeNode<Character> getRoot()
	{
		return this.root;
	}
	public HuffmanFrequencyTable getTable()
	{
		return myTable;
	}
}
