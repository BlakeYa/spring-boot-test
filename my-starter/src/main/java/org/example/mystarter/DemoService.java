package org.example.mystarter;

import com.sun.xml.internal.ws.client.AsyncResponseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.util.concurrent.ExecutionException;

@Service
public class DemoService {

    @Autowired
    private ThreadPoolTaskExecutor myThread;

    public void asyncMethod(AsyncHandler<String> handler) {
        myThread.execute(() -> {
            // 异步处理逻辑
            String result = "hello world";
            // 调用回调函数传递执行结果
            Response<String> response = new AsyncResponseImpl<String>(null,handler);
            handler.handleResponse(response);
        });
    }
}

@Component
class DemoHandler implements AsyncHandler<String> {

    @Override
    public void handleResponse(Response<String> res) {
        // 处理异步任务的执行结果
        try {
            System.out.println((String) res.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

@RestController
class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoHandler demoHandler;

    @PostConstruct
    public String async() {
        demoService.asyncMethod(demoHandler);
        return "success";
    }
}
