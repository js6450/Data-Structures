public class BinarySearchTree
{

	  /** The tree root. */
	private TreeNode root;
	
	/**
	 * Construct the tree.
	 */
	public BinarySearchTree( )
	{
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * @param x the item to insert.
	 */
	public void insert( Comparable x )
	{
		root = insert( x, root );
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	public void remove( Comparable x )
	{
		root = remove( x, root );
	}

 
	/**
	 * Find the smallest item in the tree.
	 * @return smallest item or null if empty.
	 */
	public Comparable findMin( )
	{
		return elementAt( findMin( root ) );
	}

	/**
	 * Find the largest item in the tree.
	 * @return the largest item of null if empty.
	 */
	public Comparable findMax( )
	{
		return elementAt( findMax( root ) );
	}

	/**
	 * Find an item in the tree.
	 * @param x the item to search for.
	 * @return the matching item or null if not found.
	 */
	public Comparable find( Comparable x )
	{
		return elementAt( find( x, root ) );
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty( )
	{
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return root == null;
	}

 
	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}

	/**
	 * Internal method to get element field.
	 * @param t the node.
	 * @return the element field or null if t is null.
	 */
	private Comparable elementAt( TreeNode t )
	{
		return (Comparable) (t == null ? null : t.getElement());
	}

	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private TreeNode insert( Comparable x, TreeNode t )
	{
/* 1*/	  if( t == null )
/* 2*/		  t = new TreeNode();
/* 3*/	  else if( x.compareTo(t) < 0 )
/* 4*/		  t.setLeft(insert( x, t.getLeft() ));
/* 5*/	  else if( x.compareTo(t) > 0 )
/* 6*/		  t.setRight(insert( x, t.getRight() ));
/* 7*/	  else
/* 8*/		  ;  // Duplicate; do nothing
/* 9*/	  return t;
	}

 
	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private TreeNode remove( Comparable x, TreeNode t )
	{
		if( t == null )
			return t;   // Item not found; do nothing
		if( x.compareTo(t) < 0 )
			t.setLeft(remove( x, t.getLeft() ));
		else if( x.compareTo(t) > 0 )
			t.setRight(remove( x, t.getRight() ));
		else if( t.getLeft() != null && t.getRight() != null ) // Two children
		{
			t.setElement(findMin( t.getRight() ).getElement());
			t.setRight(remove( (Comparable)t.getElement(), t.getRight() ));
		}
		else
			t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
		return t;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	private TreeNode findMin( TreeNode t )
	{
		if( t == null )
			return null;
		else if( t.getLeft() == null )
			return t;
		return findMin( t.getLeft() );
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private TreeNode findMax( TreeNode t )
	{
		if( t != null )
			while( t.getRight() != null )
				t = t.getRight();

		return t;
	}
 

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private TreeNode find( Comparable x, TreeNode t )
	{
		if( t == null )
			return null;
		if( x.compareTo( t.getElement() ) < 0 )
			return find( x, t.getLeft() );
		else if( x.compareTo( t.getElement() ) > 0 )
			return find( x, t.getRight() );
		else
			return t;	// Match
	}
	
	private void printTree(TreeNode t )
	{
		if( t != null )
		{
			printTree( t.getLeft() );
			System.out.println( t.getElement() );
			printTree( t.getRight() );
		}
	}
	
	 public TreeNode findClosest(TreeNode root, Object target) throws UnderflowException
	 {
		 root = this.root;
		 BinaryHeap heap = new BinaryHeap();
		 heap.insert(root);
		 TreeNode q = new TreeNode();
		 q = (TreeNode) heap.findMin();
		 while(!heap.isEmpty()){
			 while(q != null && q.getElement() != target){
				 q.getLeft().distance += q.distance;
				 q.getRight().distance += q.distance;
				 heap.insert(q.getLeft());
				 heap.insert(q.getRight());
				 
			 }
		 }
		 return q;
	 }
	 

}

