/**
 * Author : Yufei,T
 * Time : 3:59:39 PM
 * Description :
 */
package local.rudolf.sdk.multithread.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class TaskWithTimer {
	public static void main(String args[]) {
		myTimer();
	}

	public static void myTimer() {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000, 1000);
	}

	static class MyTask extends TimerTask {
		public void run() {
			System.out.println("Time's up!");
		}
	}
}
