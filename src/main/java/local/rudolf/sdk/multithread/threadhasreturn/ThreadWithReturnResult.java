/**
 * Author : Yufei,T
 * Time : 3:39:01 PM
 * Description : Sometimes we need thread returns some value for future use. So we use 
 */
package local.rudolf.sdk.multithread.threadhasreturn;

import java.util.concurrent.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ThreadWithReturnResult {
	public static void main(String[] args) throws ExecutionException,
			InterruptedException {
		System.out.println("----BEGIN-----");
		Date date1 = new Date();

		int taskSize = 5;
		// create a thread pool , the size is taskSize vaule.
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// this list stores all the returned object from thread.Future class is defined to get thread return.
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " ");
			// this method let the class run.
			Future f = pool.submit(c);
			list.add(f);
		}
		// shut down the thread pool!!!
		pool.shutdown();

		for (Future f : list) {
			//get results from the Future List
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----EDN-----，RUNNING TIME IS["
				+ (date2.getTime() - date1.getTime()) + "ms]");
	}
}

class MyCallable implements Callable<Object> {
	private String taskNum;

	MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + " starts");
		Date dateTmp1 = new Date();
		Thread.sleep(1000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + " ends");
		return taskNum + " task returns the result , cost time is[" + time + "ms]";
	}
}
