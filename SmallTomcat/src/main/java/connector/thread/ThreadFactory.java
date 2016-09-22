package connector.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadFactory {
	private static ThreadPoolExecutor executor = null;
	
	private static void createExecutor() {
		LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>(5);
		executor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.MICROSECONDS, taskQueue);
	}
	
	public static void handle(Runnable task) {
		if (executor == null) {
			createExecutor();
		}
		executor.execute(task);
		System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
	             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
		
	} 

}
