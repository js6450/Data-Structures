class TreeNode<AnyType> implements Comparable<TreeNode>
{
    private AnyType element;
    TreeNode<AnyType> left;
    TreeNode<AnyType> right;
    double distance;
    
    public TreeNode( )
    
    {
        this( null, null, null, 0.0);
    }
    
    public TreeNode( AnyType theElement, TreeNode<AnyType> lt, TreeNode<AnyType> rt, double d )
    {
        element = theElement;
        distance = d;
        left    = lt;
        right   = rt;
    }


    public static <AnyType> int size( TreeNode<AnyType> t )
    {
        if( t == null )
            return 0;
        else
            return 1 + size( t.left ) + size( t.right );
    }

    /**
     * Return the height of the binary tree rooted at t.
     */
    public static <AnyType> int height( TreeNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );
    }

    // Print tree rooted at current node using preorder traversal.
    public void printPreOrder( )
    {
        System.out.println( element );       // Node
        if( left != null )
            left.printPreOrder( );           // Left
        if( right != null )
            right.printPreOrder( );          // Right
    }


    // Print tree rooted at current node using postorder traversal.
    public void printPostOrder( )
    {
        if( left != null )
            left.printPostOrder( );          // Left
        if( right != null )
            right.printPostOrder( );         // Right
        System.out.println( element );       // Node
    }

    // Print tree rooted at current node using inorder traversal.
    public void printInOrder( )
    {
        if( left != null )
            left.printInOrder( );            // Left
        System.out.println( element );       // Node
        if( right != null )
            right.printInOrder( );           // Right
    }


    /**
     * Return a reference to a node that is the root of a
     * duplicate of the binary tree rooted at the current node.
     */
    public TreeNode<AnyType> duplicate( )
    {
        TreeNode<AnyType> root = new TreeNode<AnyType>( element, null, null, 0.0 );

        if( left != null )            // If there's a left subtree
            root.left = left.duplicate( );    // Duplicate; attach
        if( right != null )          // If there's a right subtree
            root.right = right.duplicate( );  // Duplicate; attach
        return root;                      // Return resulting tree
    }
    
    public AnyType getElement( )
    {
        return element;
    }
    
    public TreeNode<AnyType> getLeft( )
    {
        return left;
    }
    
    public TreeNode<AnyType> getRight( )
    {
        return right;
    }
 
    public void setElement( AnyType x )
    {
        element = x;
    }
    
    public void setLeft( TreeNode<AnyType> t )
    {
        left = t;
    }
    
    public void setRight( TreeNode<AnyType> t )
    {
        right = t;
    }

	@Override
    public int compareTo(TreeNode tn) {
		if(this.distance < tn.distance){
			return -1;
		}
		if(this.distance > tn.distance){
			return 1;
		}
		return 0;
	}
}