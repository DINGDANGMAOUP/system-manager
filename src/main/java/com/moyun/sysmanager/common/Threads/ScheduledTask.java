//package com.moyun.sysmanager.common.Threads;
//
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @author dzh
// */
//public class ScheduledTask {
//    volatile ScheduledFuture<?> future;
//
//    /**
//     *取消定时任务
//     */
//    public void cancel(){
//        ScheduledFuture<?>future=this.future;
//        if(future!=null){
//            future.cancel(true);
//        }
//    }
//}
