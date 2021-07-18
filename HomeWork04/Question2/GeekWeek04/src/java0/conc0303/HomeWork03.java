package java0.conc0303;

import java.io.Console;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class HomeWork03 {

	 public static void main(String[] args) {
	        
	       
/*启动线程方式1：继承Thread类
 * 
 */
//	        ThreadA a = new ThreadA();
//	        a.start();					//异步计算结果为：24157817  使用时间：51 ms
		 
/*启动线程方式2：实现Runnable接口
 * 	        
 */
//		 RunnableB b = new RunnableB();
//		 Thread t = new Thread(b);
//	        t.start();					//异步计算结果为：24157817  使用时间：52 ms

 /*启动线程方式3：实现Callable接口
  * 	        
  */		 
//		 FutureTask<String> futureTask = new FutureTask<String>(new CallableC());
//	     new Thread(futureTask).start();
/*启动线程方式4：直接在函数体使用
 * 	        
 */
//	        Thread thread = new Thread(new Runnable(){
//	        	@Override
//	        	public void run(){
//	        		 long start=System.currentTimeMillis();
//	        			int result = sum(); //这是得到的返回值
//	        	        
//	        	        System.out.println("异步计算结果为："+result);
//	        	         
//	        	        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
//
//	        	}
//	        });
//	        thread.start();
		 
/*
 * 启动线程池方式5：创建一个可缓存的线程池
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
//					int result = sum(); // 这是得到的返回值
//
//					System.out.println("异步计算结果为：" + result);
//
//					System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
//
//				}
//			});
//		}

/*
 * 启动线程池方式6：创建一个定长的线程池
 */
//		 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		 for (int i = 0; i < 10; i++) {
//		     final int index = i;
//		     fixedThreadPool.execute(new Runnable() {
//		  
//		    	 @Override
//					public void run() {
//						long start = System.currentTimeMillis();
//						int result = sum(); // 这是得到的返回值
//
//						System.out.println("异步计算结果为：" + result);
//
//						System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
//
//					}
//		     });
//		 }

/*
 * 启动线程池方式7：创建一个定长线程池，支持定时及周期性任务执行
 */
//		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("delay 3 seconds");
//				long start = System.currentTimeMillis();
//				int result = sum(); // 这是得到的返回值
//
//				System.out.println("异步计算结果为：" + result);
//
//				System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
//			}
//		}, 1, 3, TimeUnit.SECONDS);
		 
/*
 * 启动线程池方式8：创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务	 
 */
//		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//		for (int i = 0; i < 10; i++) {
//			final int index = i;
//			singleThreadExecutor.execute(new Runnable() {
//				@Override
//				public void run() {
//					// 在run方法填写要执行的操作
//					long start = System.currentTimeMillis();
//					int result = sum(); // 这是得到的返回值
//
//					// 确保 拿到result 并输出
//					System.out.println("异步计算结果为：" + result);
//
//					System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
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