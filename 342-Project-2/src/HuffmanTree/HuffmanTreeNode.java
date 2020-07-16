package HuffmanTree;

public class HuffmanTreeNode<T>
{
	private T element;
	private int priority;
	private HuffmanTreeNode<T> left;
	private HuffmanTreeNode<T> right;
	
	public HuffmanTreeNode(T newElement,int newPriority)
	{
		element = newElement;
		priority = newPriority;
		left = null;
		right = null;
	}
	public void setLeft(HuffmanTreeNode<T> newLeft)
	{
		this.left = newLeft;
	}
	public void setRight(HuffmanTreeNode<T> newRight)
	{
		this.right = newRight;
	}
	public HuffmanTreeNode<T> getLeft()
	{
		return this.left;
	}
	public HuffmanTreeNode<T> getRight()
	{
		return this.right;
	}
	public T getElement()
	{
		return this.element;
	}
	public int getPriority()
	{
		return this.priority;
	}
}
