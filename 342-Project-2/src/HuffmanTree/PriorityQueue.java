package HuffmanTree;
/**
  * PriorityQueue demonstrates a priority queue using a Heap.
  * ArrayHeap can be implemented as discussed in class.
  *
*/

public class PriorityQueue<T> extends ArrayHeap<PriorityQueueNode<T>>
{
	private int size;
	PriorityQueueNode<Character> temp[] = new PriorityQueueNode[10];
   /**
    * Creates an empty priority queue.
   */
   public PriorityQueue()
   {
      super();
      size = 0;
   }

      
   /**
    * Adds the given element to this PriorityQueue.
    *
    * @param object the element to be added to the priority queue
    * @param priority the integer priority of the element to be added
   */
   public void addElement(T object, int priority)
   {
      PriorityQueueNode<T> node = new PriorityQueueNode<T> (object, priority);
      super.addElement(node);
      size++;
   }

   /**
    * Removes the next highest priority element from this priority
    * queue and returns a reference to it.
    *
    * @return a reference to the next highest priority element in this queue
   */
   public T removeNext()
   {
      PriorityQueueNode<T> temp = (PriorityQueueNode<T>)super.removeMin();
      size--;
      return temp.getElement();
   }
   public int getSize()
   {
	   return size;
   }
}