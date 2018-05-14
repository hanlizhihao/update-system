package com.thinking.update.main.canal;

/**
 * @author Administrator
 * @create 2018/5/13
 */
import java.net.InetSocketAddress;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 单机模式的测试例子
 *
 * @author jianghang 2013-4-15 下午04:19:20
 * @version 1.0.4
 */
@ConfigurationProperties(prefix = "app")
@NoArgsConstructor
@Component
public class SimpleCanalClientTest extends AbstractCanalClient {

    public SimpleCanalClientTest(String destination){
        super(destination);
    }


    @Override
    public void afterPropertiesSet() {
//        // 根据ip，直接创建链接，无HA的功能
//        String destination = "example";
//        String ip = AddressUtils.getHostIp();
//        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("118.190.82.242", 11111),
//                destination,
//                "",
//                "");
//
//        final SimpleCanalClientTest clientTest = new SimpleCanalClientTest(destination);
//        clientTest.setConnector(connector);
//        clientTest.start();
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//
//            @Override
//            public void run() {
//                try {
//                    logger.info("## stop the canal client");
//                    clientTest.stop();
//                } catch (Throwable e) {
//                    logger.warn("##something goes wrong when stopping canal:", e);
//                } finally {
//                    logger.info("## canal client is down.");
//                }
//            }
//
//        });
    }

}
