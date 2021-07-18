package java0.conc0303;

import java.util.concurrent.Callable;

public class CallableC implements Callable {
	@Override
	public Object call() throws Exception{
		//��run������дҪִ�еĲ���
		long start=System.currentTimeMillis();
		int result = sum(); //���ǵõ��ķ���ֵ
        
        // ȷ��  �õ�result �����
        System.out.println("�첽������Ϊ��"+result);
         
        System.out.println("ʹ��ʱ�䣺"+ (System.currentTimeMillis()-start) + " ms");
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