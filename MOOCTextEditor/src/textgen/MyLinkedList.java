package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 

 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
	
		this.size = 0 ;
		head = new LLNode( null ) ;
		tail = new LLNode( null ) ;
		head.next = tail ;
		tail.prev = head ;
		
	
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{

		if (element == null) {
			throw new  NullPointerException();
		}
		LLNode<E> newElement ;
		newElement = new LLNode( element ) ;
		
		newElement.prev = tail.prev ;
		tail.prev.next = newElement ;
		tail.prev = newElement ;
		newElement.next = tail ;
		
		size ++ ;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index >= this.size || index < 0 ) {
			 throw new IndexOutOfBoundsException();
		}
		
		
		LLNode<E> current = head ;
		for (int i = 0 ; i <= index ; i++) {
			current = current.next ;
		}
		return current.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{

		if(index > this.size || index < 0 ) {
			 throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new  NullPointerException();
		}
		LLNode<E> current = head ;
		for (int i = 0 ; i <= index ; i++) {
			current = current.next ;
		}
		LLNode<E> newElement ;
		newElement = new LLNode( element ) ;
		
		newElement.prev = current.prev ;
		current.prev.next = newElement ;
		current.prev = newElement ;
		newElement.next = current ;
		
		size ++ ;
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
	
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index > this.size || index < 0 ) {
			 throw new IndexOutOfBoundsException();
		}
		LLNode<E> current = head ;
		for (int i = 0 ; i <= index ; i++) {
			current = current.next ;
		}
		current.prev.next = current.next ;
		current.next.prev = current.prev ;
		size -- ;
		return current.data ;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{

		if(index > this.size || index < 0 ) {
			 throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new  NullPointerException();
		}
		LLNode<E> current = head ;
		for (int i = 0 ; i <= index ; i++) {
			current = current.next ;
		}
		E last = current.data ; 
		current.data = element ;
		return last;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;



	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
