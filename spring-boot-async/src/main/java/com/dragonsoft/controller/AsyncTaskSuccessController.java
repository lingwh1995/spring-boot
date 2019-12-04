package com.dragonsoft.controller;

import com.dragonsoft.schedul.AsyncServiceWithReturnResult;
import com.dragonsoft.schedul.AsyncTaskServiceWithNoReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试异步调度成功
 * @author ronin
 */
@Controller
@RequestMapping("/async")
public class AsyncTaskSuccessController {

    /**
     * 不带有返回结果的异步调用
     */
    @Autowired
    private AsyncTaskServiceWithNoReturnResult asyncTaskServiceWithNoReturnResult;

    /**
     * 带有返回结果的异步调用
     */
    @Autowired
    private AsyncServiceWithReturnResult asyncServiceWithReturnResult;

    /**
     * 测试:
     *      http://localhost:8080/async/test-async-success-noresult
     * 此种情况下异步调度成功
     *      异步的代码要放在Service层中(将异步部分代码放入另一个类中)
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("/test-async-success-noresult")
    public Map<String,String> doTaskSuccessNoResult() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        asyncTaskServiceWithNoReturnResult.task1();
        asyncTaskServiceWithNoReturnResult.task2();
        asyncTaskServiceWithNoReturnResult.task3();
        long currentTimeMillis1 = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        map.put("message","task任务总耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
        return map;
    }

    /**
     * 测试:
     *      http://localhost:8080/async/test-async-success-withresult
     * 此种情况下异步调度成功
     *      异步的代码要放在Service层中(将异步部分代码放入另一个类中)
     * @throws InterruptedException
     */
    @ResponseBody
    @RequestMapping("/test-async-success-withresult")
    public Map<String,String> doTaskSuccessWithResult() throws InterruptedException, ExecutionException {
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = asyncServiceWithReturnResult.task1();
        Future<String> task2 = asyncServiceWithReturnResult.task2();
        Future<String> task3 = asyncServiceWithReturnResult.task3();
        while (true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            //配合while(true)实现每隔1000ms判断一次是否所有方法都执行完成
            Thread.sleep(1000);
        }
        //注意:异步调用在执行这个代码的时候会导致阻塞,睡眠5000ms后才会去执行下面的代码
        Thread.sleep(5000);
        long currentTimeMillis1 = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        map.put("message","task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return map;
    }
}
