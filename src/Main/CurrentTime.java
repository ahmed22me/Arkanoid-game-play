package Main;

import java.util.Timer;
import java.util.TimerTask;

public class CurrentTime
{
    private int secondTime=0;
    public CurrentTime(){
        Timer time = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
                secondTime++;
            }

        };
        time.scheduleAtFixedRate(task,1000,1000);
    }
    public void setSecond(int number){
        secondTime=number;
    }
    public int getsecond(){
        return secondTime;
    }
}
