package twentyOne.second;

import java.util.concurrent.*;

/**
 * 阿里巴巴Java开发手册 关于使用ThreadPoolExecutor来创建线程,记得需要调用的shutdown().
 * 4.
 * 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
 * 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors 返回的线程池对象的弊端如下：
 * 1）FixedThreadPool 和 SingleThreadPool :
 * 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
 * 2）CachedThreadPool 和 ScheduledThreadPool :
 * 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。
 * Created by james on 9/28/2018.
 */
public class ThreadPoolExecutorDemo implements Runnable{

    public void buildThread() {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        /*
        corePoolSize - the number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut
            is set
        maximumPoolSize - the maximum number of threads to allow in the pool
        keepAliveTime - when the number of threads is greater than the core, this is the maximum time that excess idle
            threads will wait for new tasks before terminating.
        unit - the time unit for the keepAliveTime argument
        workQueue - the queue to use for holding tasks before they are executed. This queue will hold only the Runnable
            tasks submitted by the execute method.
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(12));

    }


    @Override
    public void run() {
        System.out.println("-----------------------------================================");
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(12));
        threadPoolExecutor.execute(new ThreadPoolExecutorDemo());
        threadPoolExecutor.shutdown();

    }
}
