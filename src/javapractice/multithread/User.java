package javapractice.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class User implements Callable {

    private Task task;
    public User(int time, String name){
        task = new Task(time, name);
    }

    @Override
    public Object call() {
        task.doSafely();
        return task.getTime();
    }

    public static void main(String[] args) throws InterruptedException{

        ExecutorService service = Executors.newCachedThreadPool();
        int[] times = {1,2,3,4,5,6,7,8,9,10};

        for(int time: times){
            Callable callable = new User(time, String.format("Task%s", time));
            service.submit(callable);
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) service;

        while(true){
            long taskCount = threadPoolExecutor.getTaskCount();
            int queueSize = threadPoolExecutor.getQueue().size();
            int activeCount = threadPoolExecutor.getActiveCount();
            long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
            String message = String.format(
                    "task count is: %1$s; queue size is : %2$s; active count is: %3$s; completedTaskCount is: %4$s.",
                    taskCount, queueSize, activeCount, completedTaskCount
            );

            System.out.println(message);
            if(activeCount == 0){
                break;
            }
            Thread.sleep(300);

        }

        service.shutdown();
    }
}
