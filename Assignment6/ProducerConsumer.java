import java.util.LinkedList;

public class ProducerConsumer {
	public static void main(String[] args) {
		Storage storage = new Storage();
		
        //Initialize consumers
		Consumer[] consumers = new Consumer[4];
		for (int i = 0; i < 4; i++) {
			consumers[i] = new Consumer((4-i) * 10, storage);
			consumers[i].start();
		}
		
		//Initialize producers
		Producer[] producers = new Producer[6];
		for (int i = 0; i < 6; i++) {
			producers[i] = new Producer(i * 10, storage);
			producers[i].start();
		}
		
	}
}

class Storage {
	//Maximum storage
	private final int MAX_SIZE = 100;
	private LinkedList<Object> list = new LinkedList<Object>();
	
	//Produce n products
	public void produce (int n) {
		synchronized (list) {
			//Exceed storage limit
			while (list.size() + n > MAX_SIZE) {
				System.out.println(n + " exceed storage limit, pause producing");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			//Meet storage condition, begin producing
			for (int i = 0; i < n; i++) {
				list.add(new Object());
			}
			System.out.println(n + " items have been produced, now storage becomes: " + list.size());
			list.notifyAll();
		}
	}
	
	//Consume n products
	public void consume (int n) {
		synchronized (list) {
			//Storage not enough
			while(list.size() < n) {
				System.out.println("Storage not enough to "+ n +", pause consuming");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < n; i++) {
				list.removeLast();
			}
			System.out.println(n + " items have been consumed, now storage becomes: " + list.size());
			list.notifyAll();
		}
	}
}

class Producer extends Thread {
	//Number of products each production
	private int n;
	private Storage storage;
	//Constructor for storage
	public Producer(int n, Storage storage) {
		this.n = n;
		this.storage = storage;
	}
	
	@Override
	public void run() {
		//Invoke Storage produce method
		storage.produce(n);
	}
}

class Consumer extends Thread {
	private int n;
	private Storage storage;
	
	public Consumer(int n, Storage storage) {
		this.n = n;
		this.storage = storage;
	}
	
	@Override
	public void run() {
		//Invoke Storage consume method
		storage.consume(n);
	}
}