package com.lorne.tx.service.impl;

import com.lorne.tx.Constants;
import com.lorne.tx.model.TxServer;
import com.lorne.tx.mq.service.NettyServerService;
import com.lorne.tx.service.InitService;
import com.netflix.eureka.EurekaServerContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by lorne on 2017/7/4.
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private NettyServerService nettyServerService;

    @Value("${socket.port}")
    private int socketPort;

    @Value("${socket.max.connection}")
    private int maxConnection;

    @Override
    public void start() {
        /**加载本地服务信息**/

        Constants.socketPort = socketPort;
        Constants.maxConnection = maxConnection;
        nettyServerService.start();
    }

    @Override
    public void close() {
        nettyServerService.close();
    }
}
