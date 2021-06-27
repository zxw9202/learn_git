package jvm;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{

	public static void main(String[] args){
		try {
			Class<?> helloClass = new HelloClassLoader().findClass("Hello");
			Method helloMethod = helloClass.getMethod("hello");
				helloMethod.invoke(helloClass.newInstance());
		} catch(Exception e){
			e.printStackTrace();
		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Path path = Paths.get("F:\\GeekTime\\Week_01\\Hello\\Hello.xlass");
		byte[] bytes = new byte[0];
		try {
			bytes = Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<bytes.length;i++){
			bytes[i] = (byte) (255 - bytes[i]);
		}
		return defineClass(name,bytes,0,bytes.length);
	}
	
	
}
