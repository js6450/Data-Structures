@SuppressWarnings("rawtypes")
public final class MyInteger implements Comparable, Hashable{
    public MyInteger( )
    {
        this( 0 );
    }
    public MyInteger( int x ){
        value = x;
    }
    public int intValue( ){
        return value;
    }
    @Override
    public String toString( ){
        return Integer.toString( value );
    }
    @Override
    public int compareTo( Object rhs ){
        return value < ((MyInteger)rhs).value ? -1 :
                value == ((MyInteger)rhs).value ? 0 : 1;
    }
    @Override
    public boolean equals( Object rhs ){
        return rhs != null && value == ((MyInteger)rhs).value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.value;
        return hash;
    }
    @Override
    public int hash( int tableSize ){
        if( value < 0 ){
            return -value % tableSize;
        }
        else{
            return value % tableSize;
        }
    }
    private int value;
}