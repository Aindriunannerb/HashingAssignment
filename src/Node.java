

public class Node <E>{

	//public MenuItem newItem;
	private Node<E> next;
	private E contents;

	//Constructors
	public Node()
	{
		
	}
	
	public Node(E newItem)
	{
		this.contents = newItem;
	}
	
	//getter
	public E getContents()
	{
		return contents;
	}
	
	public Node<E> getNext()
	{
		return next;
	}
	
	//setter
	public void setContents(E newContents)
	{
		this.contents = newContents;
	}
	
	public void setNext(Node<E> next)
	{
		this.next = next; 
	}

}
