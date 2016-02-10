 class ListNode{
	 ListNode( Object theElement ){
		 this( theElement, null );
	 }
	 ListNode( Object theElement, ListNode n ){
		 element = theElement;
		 next    = n;
	 }
	 Object element;
	 ListNode next;
 }