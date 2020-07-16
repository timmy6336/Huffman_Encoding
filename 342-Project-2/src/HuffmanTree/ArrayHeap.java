package HuffmanTree;

public class ArrayHeap<T> 
{
	Object myHeap[];
	int lastElement;
	public ArrayHeap()
	{
		myHeap = new Object[10];
		lastElement = 0;
	}
	public void addElement(T element)
	{
		if(lastElement == myHeap.length - 1)
		{
			resize();
		}
		myHeap[lastElement] = element;
		if(lastElement != 0)
		{
			int currElement = lastElement;
			boolean swap = true;
			while(swap && currElement != 0)
			{
				swap = false;
				Object node1 = myHeap[currElement];
				Object node2 = myHeap[(currElement-1)/2];
				if( ((Comparable<Object>) node1).compareTo(node2) < 0)
				{
					//System.out.println(((PriorityQueueNode<T>) node1).getElement() + " " + ((PriorityQueueNode<T>)node2).getElement());
					//System.out.println("swap");
					myHeap[currElement] =  node2;
					myHeap[(currElement-1)/2] =  node1 ;
					swap = true;
					currElement = (currElement-1)/2;
				}
			}
		}
		lastElement++;
	}
	public T removeMin()
	{
		lastElement--;
		Object temp = myHeap[0];
		Object temp2 = myHeap[lastElement];
		myHeap[0] = temp2;
		myHeap[lastElement] = null;
		boolean swap = true;
		int currentlocation = 0;
		int currElement = 2;
		while(swap && currElement <= lastElement)
		{
			swap = false;
			Object child1 = myHeap[currElement - 1];
			Object child2 = myHeap[currElement];
			if(child1 != null)
			{
				if((child2 == null || ((Comparable<Object>) child1).compareTo(child2) < 1) && ((Comparable<Object>) child1).compareTo(temp2) < 1  )
				{
					//System.out.println(lastElement);
					myHeap[currentlocation] = child1;
					myHeap[currElement -1] = temp2;
					swap = true;
					currentlocation = currElement - 1;
					currElement = currentlocation * 2 + 2;
				}
				else if(child2 != null && ((Comparable<Object>) child2).compareTo(child1) < 1 && ((Comparable<Object>) child2).compareTo(temp2) < 1)
				{
					myHeap[currentlocation] = child2;
					myHeap[currElement] = temp2;
					swap = true;
					currentlocation = currElement;
					currElement = currentlocation * 2 + 2;
				}
			}
		}
		return ((T) temp);
	}
	public void display()
	{
		while(lastElement>0)
		{
			System.out.println(this.removeMin());
		}
	}
	private void resize()
	{
		Object newHeap[] = new Object[myHeap.length * 2];
		for(int i = 0; i < myHeap.length; i++)
		{
			newHeap[i] = myHeap[i];
		}
		myHeap = newHeap;
	}
}