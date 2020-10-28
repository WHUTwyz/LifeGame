package next;

import java.util.Timer;
import java.util.TimerTask;

public abstract class LifeTimer {
	private Timer timer;
	private TimerTask timerTask;
	public LifeTimer() {
		timer=new Timer();
		
	}
	public void start() {
		timerTask = new TimerTask() {
			public void run() {
				updateButons();
			}
		};
		timer.schedule(timerTask,0,1000);
	}
	public abstract void updateButons();
	public void end() {
        timerTask.cancel();
        timerTask = null;
	}
}
