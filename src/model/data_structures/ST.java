package model.data_structures;


public class ST<Key,Value> {

	 private int n;         
	    private Node first;
	    
	    private class Node {
	        private Key key;
	        private Value val;
	        private Node next;

	        public Node(Key key, Value val, Node next)  {
	            this.key  = key;
	            this.val  = val;
	            this.next = next;
	        }
	    }  
	    
	    public ST()
	    {
	    }
	    
	    public boolean contains(Key key) {
	        return get(key) != null;
	    }
	    
	    public Value get(Key key) {
	        for (Node x = first; x != null; x = x.next) {
	            if (key.equals(x.key))
	                return x.val;
	        }
	        return null;
	    }
	    
	    public void put(Key key, Value val) {
	        if (val == null) {
	            delete(key);
	            return;
	        }

	        for (Node x = first; x != null; x = x.next) {
	            if (key.equals(x.key)) {
	                x.val = val;
	                return;
	            }
	        }
	        first = new Node(key, val, first);
	        n++;
	    }
	    
	    public void delete(Key key) {
	        first = delete(first, key);
	    }
	    
	    private Node delete(Node x, Key key) {
	        if (x == null) return null;
	        if (key.equals(x.key)) {
	            n--;
	            return x.next;
	        }
	        x.next = delete(x.next, key);
	        return x;
	    }
	    
	    //Falta iterator

}
