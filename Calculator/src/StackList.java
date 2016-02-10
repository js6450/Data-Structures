class StackList{
	public StackList( ){
		topOfStack = null;
		}
	public boolean isFull( ){
		return false;
		}
	public boolean isEmpty( ){
		return topOfStack == null;
		}
	public void makeEmpty( ){
		topOfStack = null;
		}
	public String top( ){
		if( isEmpty( ) )
			return null;
		return (String) topOfStack.element;
		}
	public void pop( ) throws Underflow{
		if( isEmpty( ) ){
			throw new Underflow( );
		}
		topOfStack = topOfStack.next;
		}

	public String topAndPop( ){
		if( isEmpty( ) ){
			return null;
		}
		String topItem = (String) topOfStack.element;
		topOfStack = topOfStack.next;
		return topItem;
		}
	public void push( String x ){
		topOfStack = new ListNode( x, topOfStack );
		}
	private ListNode topOfStack;
	}