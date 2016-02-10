class QueueAr
    {

        public QueueAr( )
        {
            this( DEFAULT_CAPACITY );
        }


        public QueueAr( int capacity )
        {
            theArray = new Object[ capacity ];
            makeEmpty( );
        }


        public boolean isEmpty( )
        {
            return currentSize == 0;
        }


        public boolean isFull( )
        {
            return currentSize == theArray.length;
        }


        public void makeEmpty( )
        {
            currentSize = 0;
            front = 0;
            back = -1;
        }


        public Object getFront( )
        {
            if( isEmpty( ) )
                return null;
            return theArray[ front ];
        }

        public Object dequeue( )
        {
            if( isEmpty( ) )
                return null;
            currentSize--;

            Object frontItem = theArray[ front ];
            theArray[ front ] = null;
            front = increment( front );
            return frontItem;
        }


        public void enqueue( Object x )
        {
            if( isFull( ) )
            back = increment( back );
            theArray[ back + 1 ] = x;
            currentSize++;
        }

        private int increment( int x )
        {
            if( ++x == theArray.length )
                x = 0;
            return x;
        }

        private Object [ ] theArray;
        private int        currentSize;
        private int        front;
        private int        back;

        static final int DEFAULT_CAPACITY = 10;


  
    }