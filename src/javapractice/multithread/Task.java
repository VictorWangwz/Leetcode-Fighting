package javapractice.multithread;

import java.util.concurrent.Semaphore;

public class Task
{
    //use semaphore with the value of 2 to realize that
    //only two tasks could doSensitivePart at the same time
    private static final Semaphore sp = new Semaphore(2);

    //Two props to show the difference of tasks
    private int time;
    private String name;

    public Task(int time, String name)
    {
        this.time = time;
        this.name = name;
    }
    public void doSafely()
    {
        try{
            //acquire semaphore if available otherwise wait for it to be available
            sp.acquire();
            doSensitivePart();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            sp.release();
        }

    }
    private void doSensitivePart() throws InterruptedException
    {
        // At most two threads execute this part concurrently.

        //Show messages on doing sensitive part
        System.out.println(String.format("It takes %1$s s for Task %2$s to finish running", time, name));

        //simulate the process of doing sensitive part
        Thread.sleep(1000 * time);

    }

    public int getTime(){
        return time;
    }


}

