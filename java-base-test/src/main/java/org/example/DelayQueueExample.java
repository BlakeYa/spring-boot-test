package org.example;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建延迟队列
        DelayQueue<DelayedElement> queue = new DelayQueue<>();

        // 添加元素到队列中
        queue.put(new DelayedElement("Task 1", 5, TimeUnit.SECONDS));
        queue.put(new DelayedElement("Task 2", 10, TimeUnit.SECONDS));
        queue.put(new DelayedElement("Task 3", 15, TimeUnit.SECONDS));

        // 从队列中取出元素进行处理
        while (!queue.isEmpty()) {
            // 按照元素的过期时间排序，并取出延迟时间最短的元素进行处理
            DelayedElement element = queue.take();
            System.out.println("Process " + element.getName() + " at " + System.currentTimeMillis());
        }
    }
}

// 实现Delayed接口的元素类
class DelayedElement implements Delayed {
    private String name;
    private long delay;
    private long expire;

    public DelayedElement(String name, long delay, TimeUnit unit) {
        this.name = name;
        this.delay = TimeUnit.MILLISECONDS.convert(delay, unit);
        this.expire = System.currentTimeMillis() + this.delay;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.expire, ((DelayedElement) o).expire);
    }
}
