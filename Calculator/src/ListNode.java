 class ListNode{
	 ListNode( String theElement ){
		 this( theElement, null );
	 }
	 ListNode( String theElement, ListNode n ){
		 element = theElement;
		 next    = n;
	 }
	 Object element;
	 ListNode next;
 }