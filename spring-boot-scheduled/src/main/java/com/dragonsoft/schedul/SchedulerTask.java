package com.dragonsoft.schedul;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author ronin
 */
@Component
public class SchedulerTask {

    /**
     * on the second, minute, hour, day of month(每个月的多少号), month, and day of week
     * *            , *     , *   , *                         , *    , *
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
