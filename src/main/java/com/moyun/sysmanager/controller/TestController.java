package com.moyun.sysmanager.controller;



import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.annotation.entity.SysLog;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.utils.HttpContextUtil;
import com.moyun.sysmanager.utils.IPUtil;
import com.moyun.sysmanager.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("test")
@Async
public class TestController extends BaseController{



    @GetMapping("test")
    public VueResult testResult() throws InterruptedException {
        System.out.println("开始啦");
        testAsync();
        return VueResult.success();

    }
    @Async
    private void testAsync() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("结束啦");
    }


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
