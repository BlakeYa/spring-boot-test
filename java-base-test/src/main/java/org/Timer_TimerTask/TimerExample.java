package org.Timer_TimerTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        // 创建一个Timer实例
        Timer timer = new Timer();

        // 创建一个定时任务，继承TimerTask类并实现run()方法
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行：" + LocalDateTime.now());
            }
        };

        // 将定时任务添加到定时器中，设置首次执行时间为1秒后，之后每隔2秒执行一次
        timer.schedule(task, 1000, 2000);
    }
}
