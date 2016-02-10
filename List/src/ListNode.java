	public LinkedListItr find( Object x )
	{
            ListNode itr = header.next;
            int i = itr.length;
            
            
            while( itr != null && !itr.element.equals( x ) ){
                itr = itr.next;
            }
            return new LinkedListItr( itr );
	}

