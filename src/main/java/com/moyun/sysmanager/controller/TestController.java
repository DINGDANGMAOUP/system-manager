package com.moyun.sysmanager.controller;


import com.moyun.sysmanager.common.result.VueResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController extends BaseController{


//    @Async
    @GetMapping("test")
    public String testResult() throws InterruptedException {
        System.out.println("开始啦");
//        testAsync();
        System.out.println("test");
        return "hello";

    }
//    @Async
//    private void testAsync() throws InterruptedException {
//
//        /*Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2020);//年
//        calendar.set(Calendar.MONTH, 5);//月
//        calendar.set(Calendar.DATE , 18);//日
//        calendar.set(Calendar.HOUR_OF_DAY, 9);//时
//
//        calendar.set(Calendar.MINUTE, 20);//分
//
//        calendar.set(Calendar.SECOND, 0);//秒
//
//
//
//        Date time = calendar.getTime();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timeFormat = sdf.format(time);*/
//
//
//        Thread.sleep(5000);
//        System.out.println("结束啦");
//    }


//    @GetMapping("/startCron1")
//    public String startCron1() {
//        /**
//         * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
//         * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，
//         * Runnable（线程接口类） 和CronTrigger（定时任务触发器）
//         * YouXinConfiguration：自定义读取yml文件中数据的类，通过该类读取yml文件中cron时间表达式，从而可以达到定时时间可配置的效果。
//         * MyRunnable1与MyRunnable2类：这两个类都是实现了Runnable接口，重写了run方法，定时任务的逻辑代码就是在其中实现。
//         */
//        future1 = threadPoolTaskScheduler.schedule(new MyRunnable1(), new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                return new CronTrigger(cronTestConfiguration.getCron2()).nextExecutionTime(triggerContext);
//            }
//        });
//        System.out.println("DynamicTask.startCron1()");
//        return "success";
//    }
//    @GetMapping("/stopCron1")
//    public String stopCron1() {
//        if (future1 != null) {
//            future1.cancel(true);
//        }
//        System.out.println("DynamicTask.stopCron1()");
//        return "success";
//    }
}
