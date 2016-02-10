 class ListNode{
	 ListNode( String theElement ){
		 this( theElement, null );
	 }
	 ListNode( Object x, ListNode n ){
		 element = x;
		 next    = n;
	 }
	 Object element;
	 ListNode next;
 }