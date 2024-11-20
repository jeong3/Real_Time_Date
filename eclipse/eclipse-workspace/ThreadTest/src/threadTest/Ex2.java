package threadTest;

public class Ex2   {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread("1");
		MyThread thread2 = new MyThread("2");
		MyThread thread3 = new MyThread("3");
		MyThread thread4 = new MyThread("4");
	
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		
	}
}

class MyThread extends Thread {
	String name;
	public MyThread(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		long beforeTime = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += i;
			System.out.println(name);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(sum);

		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime)/1000 ;
		System.out.println("시간차이(s) : " + secDiffTime);
	}
}
