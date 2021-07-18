package java0.conc0303;

import java.io.Console;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ������ҵ����������˼���ж����ַ�ʽ����main��������һ�����̻߳��̳߳أ�
 * �첽����һ���������õ���������ķ���ֵ���˳����̣߳�
 * д����ķ�����Խ��Խ�ã��ύ��github��
 *
 * һ���򵥵Ĵ���ο���
 */
public class HomeWork03 {

	 public static void main(String[] args) {
	        
	       
/*�����̷߳�ʽ1���̳�Thread��
 * 
 */
//	        ThreadA a = new ThreadA();
//	        a.start();					//�첽������Ϊ��24157817  ʹ��ʱ�䣺51 ms
		 
/*�����̷߳�ʽ2��ʵ��Runnable�ӿ�
 * 	        
 */
//		 RunnableB b = new RunnableB();
//		 Thread t = new Thread(b);
//	        t.start();					//�첽������Ϊ��24157817  ʹ��ʱ�䣺52 ms

 /*�����̷߳�ʽ3��ʵ��Callable�ӿ�
  * 	        
  */		 
//		 FutureTask<String> futureTask = new FutureTask<String>(new CallableC());
//	     new Thread(futureTask).start();
/*�����̷߳�ʽ4��ֱ���ں�����ʹ��
 * 	        
 */
//	        Thread thread = new Thread(new Runnable(){
//	        	@Override
//	        	public void run(){
//	        		 long start=System.currentTimeMillis();
//	        			int result = sum(); //���ǵõ��ķ���ֵ
//	        	        
//	        	        System.out.println("�첽������Ϊ��"+result);
//	        	         
//	        	        System.out.println("ʹ��ʱ�䣺"+ (System.currentTimeMillis()-start) + " ms");
//
//	        	}
//	        });
//	        thread.start();
		 
/*
 * �����̳߳ط�ʽ5������һ���ɻ�����̳߳�
 */
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			try {
//				Thread.sleep(index * 1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			cachedThreadPool.execute(new Runnable() {
//		 		@Override
//				public void run() {
//					long start = System.currentTimeMillis();
//					int result = sum(); // ���ǵõ��ķ���ֵ
//
//					System.out.println("�첽������Ϊ��" + result);
//
//					System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");
//
//				}
//			});
//		}

/*
 * �����̳߳ط�ʽ6������һ���������̳߳�
 */
//		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		 for (int i = 0; i < 10; i++) {
//		     final int index = i;
//		     fixedThreadPool.execute(new Runnable() {
//		  
//		    	 @Override
//					public void run() {
//						long start = System.currentTimeMillis();
//						int result = sum(); // ���ǵõ��ķ���ֵ
//
//						System.out.println("�첽������Ϊ��" + result);
//
//						System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");
//
//					}
//		     });
//		 }

/*
 * �����̳߳ط�ʽ7������һ�������̳߳أ�֧�ֶ�ʱ������������ִ��
 */
//		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("delay 3 seconds");
//				long start = System.currentTimeMillis();
//				int result = sum(); // ���ǵõ��ķ���ֵ
//
//				System.out.println("�첽������Ϊ��" + result);
//
//				System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");
//			}
//		}, 1, 3, TimeUnit.SECONDS);
		 
/*
 * �����̳߳ط�ʽ8������һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ������	 
 */
//		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			singleThreadExecutor.execute(new Runnable() {
//				@Override
//				public void run() {
//					// ��run������дҪִ�еĲ���
//					long start = System.currentTimeMillis();
//					int result = sum(); // ���ǵõ��ķ���ֵ
//
//					// ȷ�� �õ�result �����
//					System.out.println("�첽������Ϊ��" + result);
//
//					System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");
//				}
//			});
//		}
//	        
	}
	    
	    private static int sum() {
	        return fibo(36);
	    }
	    
	    private static int fibo(int a) {
	        if ( a < 2) 
	            return 1;
	        return fibo(a-1) + fibo(a-2);
	    }
    
    
}