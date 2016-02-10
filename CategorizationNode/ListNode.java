 class ListNode{
	 ListNode( Object theElement ){
		 this( theElement, null );
	 }
	 ListNode( Object theElement, ListNode n ){
		 element = theElement;
		 next    = n;
	 }
	 public Object returnElement(){
		 return element;
	 }
	 Object element;
	 ListNode next;
 }