package java0.conc0303;

import java.util.concurrent.Callable;

public class CallableC implements Callable {
	@Override
	public Object call() throws Exception{
		//在run方法填写要执行的操作
		long start=System.currentTimeMillis();
		int result = sum(); //这是得到的返回值
        
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);
         
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        return null;
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
