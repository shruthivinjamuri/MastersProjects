package selfPreparation;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> it;
    boolean isSet;
    Integer val;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    isSet = false;
	    val = 0;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(isSet){
            return val;
       }
       else {
           if(it.hasNext()){
               val = it.next();
               isSet = true;
               return val;
           }
           else return -1;
       }

	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int temp = -1;
	    if(isSet){
	        temp = val;
	        if(it.hasNext()){
	        	val = it.next();
	        }
	        else {
	        	isSet = false;
	        }
	    }
	    else {
	        if(it.hasNext()){
	        temp = it.next();
	        }
	    }
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return (isSet || it.hasNext());
	    
	}
}
