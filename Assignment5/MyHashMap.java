
public class MyHashMap {
	private long key[];  //assume key[] data type as "long"
	private Object value[];
	private boolean state[]; // full: true, free: false
	
	private final float loadFactor;
	private int threshold;
	private transient int size;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 31; //a prime
	private static final int MAXIMUM_CAPACITY = 281; //a prime again
	private static final float DEFAULT_LOAD_FACTOR = 0.75f; //same as HashMap
	
	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public MyHashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity, float loadFactor) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal initial capacity: " 
		                                                 + initialCapacity);
		}
		if (initialCapacity > MAXIMUM_CAPACITY) {
			initialCapacity = MAXIMUM_CAPACITY;
		}
		if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
			throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
		}
		
		int capacity = initialCapacity;
		this.loadFactor = loadFactor;
		this.key = new long[capacity];
		this.value = new Object[capacity];
		this.state = new boolean[capacity];
		this.threshold = (int) (capacity * loadFactor);
	}
	
	public Object put(long key, Object value) {
		int i = indexFor(key);
		if (i < 0) {   //avoid the situation: i < 0
			i = - i - 1;
		}
		if (this.key[i] == key && state[i] == true) {
			Object oldValue = this.value[i];
			this.value[i] = value;
			return oldValue;
		}
		size++;
		if (size >= threshold) {
			rehash();
		}
		this.key[i] = key;
		this.value[i] = value;
		this.state[i] = true;
		return null;
	}
	
	private void rehash() {
		int oldCapacity = key.length;
		long oldKey[] = key;
		Object oldValue[] = value;
		boolean oldState[] = state;
		
		int newCapacity = nextPrime(oldCapacity);
		long newKey[] = new long[newCapacity];
		Object newValue[] = new Object[newCapacity];
		boolean newState[] = new boolean[newCapacity];
		
		threshold = (int) (newCapacity * loadFactor);
		this.key = newKey;
		this.value = newValue;
		this.state = newState;
		
		for (int i = oldCapacity; i-- > 0; ) {
			if (oldState[i] == true) {
				int index = indexFor(oldKey[i]);
				newKey[index] = oldKey[i];
				newValue[index] = oldValue[i];
				newState[index] = true;
			}
		}
	}

	public Object get(long key) {
		int i = indexFor(key);
		if (i < 0) {
			return null;
		}
		if (this.key[i] == key && state[i] == true) {
			return value[i];
		}
		return null;
	}
	
	public boolean containsKey(long key) {
		int i = indexFor(key);
		if (i < 0) {
			return false;
		}
		if (this.key[i] == key && state[i] == true) {
			return true;
		}
		return false;
	}

	private int indexFor(long key) {
		final long k[] = this.key;
		final boolean state[] = this.state;
		final int length = this.key.length;
		
		final int hash = ((int)(key ^ (key >> 32))) & 0x7FFFFFFF;
		int i = hash % (length - 1);
		
		int decre = hash % (length - 2);    //re-find decrement
		if (decre == 0) {
			decre = 1; 
			}
		while (state[i] == true && k[i] != key) { //re-find
			i -= decre;
			if (i < 0) {
				i += length;
			}
		}
		return i;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object remove(long key) {
		int i = indexFor(key);
		if (i < 0) {
			return null;
		}
		if (this.key[i] == key) {
			size--;
			this.key[i] = 0;
			Object oldValue = this.value[i];
			this.value[i] = null;
			this.state[i] = false;
			return oldValue;
		}
		return null;
	}
	
	public void clear() {
		for (int i = 0; i < this.key.length; i++) {
			key[i] = 0;
			value[i] = null;
			state[i] = false;
		}
		size = 0;
	}
	
	public boolean containsValue(Object value) {
		if (value == null) {
			for (int i = 0; i < key.length; i++) {
				if (this.value[i] == null) {
					return true;
				}
			}
		}
		for (int i = 0; i < key.length; i++) {
			if (value.equals(this.value[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	protected int nextPrime(int currentPrime) {
		int nextPrime = currentPrime + 2;
		while (nextPrime < MAXIMUM_CAPACITY) {
			int i = 2;
			while (i * i <= nextPrime) {
				if (nextPrime % i == 0) {
					break;
				} 
				i++;
			}
			if (i * i > nextPrime) {
				return nextPrime;
			}
			nextPrime++;
		}
		return currentPrime;
	}
}
