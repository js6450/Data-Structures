import java.util.Comparator;

class ListNode
{
	ListNode( Comparable theElement )
	{
		this( theElement, null );
	}

	ListNode( Comparable theElement, ListNode n )
	{
		element = theElement;
		next	= n;
	}

	Comparable  element;
	ListNode next;
}



public class LinkedList
{
	/**
	 * Construct the list
	 */
	public LinkedList( )
	{
		header = new ListNode( null );
	}

	/**
	 * Test if the list is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return header.next == null;
	}

	/**
	 * Make the list logically empty.
	 */
	public void makeEmpty( )
	{
		header.next = null;
	}


	/**
	 * Return an iterator representing the header node.
	 */
	public LinkedListItr zeroth( )
	{
		return new LinkedListItr( header );
	}

	/**
	 * Return an iterator representing the first node in the list.
	 * This operation is valid for empty lists.
	 */
	public LinkedListItr first( )
	{
		return new LinkedListItr( header.next );
	}

	/**
	 * Insert after p.
	 * @param x the item to insert.
	 * @param p the position prior to the newly inserted item.
	 */
	public void insert( Object x, LinkedListItr p )
	{
		if( p != null && p.current != null )
			p.current.next = new ListNode( x, p.current.next );
	}

	/**
	 * Return iterator corresponding to the first node containing an item.
	 * @param x the item to search for.
	 * @return an iterator; iterator isPastEnd if item is not found.
	 */
	public LinkedListItr find( Object x )
	{
/* 1*/	  ListNode itr = header.next;

/* 2*/	  while( itr != null && !itr.element.equals( x ) )
/* 3*/		  itr = itr.next;

/* 4*/	  return new LinkedListItr( itr );
	}

	/**
	 * Return iterator prior to the first node containing an item.
	 * @param x the item to search for.
	 * @return appropriate iterator if the item is found. Otherwise, the
	 * iterator corresponding to the last element in the list is returned.
	 */
	public LinkedListItr findPrevious( Object x )
	{
/* 1*/	  ListNode itr = header;

/* 2*/	  while( itr.next != null && !itr.next.element.equals( x ) )
/* 3*/		  itr = itr.next;

/* 4*/	  return new LinkedListItr( itr );
	}

	/**
	 * Remove the first occurrence of an item.
	 * @param x the item to remove.
	 */
	public void remove( Object x )
	{
		LinkedListItr p = findPrevious( x );

		if( p.current.next != null )
			p.current.next = p.current.next.next;  // Bypass deleted node
	}

	// Simple print method
	public static void printList( LinkedList theList )
	{
		if( theList.isEmpty( ) )
			System.out.print( "Empty list" );
		else
		{
			LinkedListItr itr = theList.first( );
			for( ; !itr.isPastEnd( ); itr.advance( ) )
				System.out.print( itr.retrieve( ) + " " );
		}

		System.out.println( );
	}

	private ListNode header;


	public static void main( String [ ] args )
	{
		LinkedList	theList = new LinkedList( );
		LinkedListItr theItr;
		int i;

		theItr = theList.zeroth( );
		printList( theList );

		for( i = 0; i < 10; i++ )
		{
			theList.insert( new MyInteger( i ), theItr );
			printList( theList );
			theItr.advance( );
		}

		for( i = 0; i < 10; i += 2 )
			theList.remove( new MyInteger( i ) );

		for( i = 0; i < 10; i++ )
			if( ( i % 2 == 0 ) != ( theList.find( new MyInteger( i ) ).isPastEnd( ) ) )
				System.out.println( "Find fails!" );

		System.out.println( "Finished deletions" );
		printList( theList );
	}

}
