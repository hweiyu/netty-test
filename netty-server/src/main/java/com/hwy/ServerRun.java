package com.hwy;

import com.hwy.server.DemoNettyServer;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/6/1 15:17
 **/
public class ServerRun {

    public static void main(String[] args) {
        new DemoNettyServer(1001).start();
    }
}
