package com.hwy;

import com.hwy.client.DemoNettyClient;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/6/1 15:54
 **/
public class ClientRun {

    public static void main(String[] args) {
        new DemoNettyClient("127.0.0.1", 1001, "hello world").start();
    }
}
