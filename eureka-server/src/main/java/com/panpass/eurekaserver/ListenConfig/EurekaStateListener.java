package com.panpass.eurekaserver.ListenConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class EurekaStateListener {
    private static Logger logger = LogManager.getLogger(EurekaStateListener.class);

//    @Autowired
//    private JavaMailSender javaMailSender;

    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceCanceledEvent event) {
        String msg="服务"+event.getAppName()+"\n"+event.getServerId()+"已下线";
        logger.info(msg);
//        this.send(msg);
    }

//    @EventListener(condition = "#event.replication==false")
//    public void listen(EurekaInstanceRegisteredEvent event) {
//        InstanceInfo instanceInfo = event.getInstanceInfo();
//        String msg="服务"+instanceInfo.getAppName()+"\n"+  instanceInfo.getHostName()+":"+ instanceInfo.getPort()+ " \nip: " +instanceInfo.getIPAddr() +"进行注册";
//        logger.info(msg);
//        this.send(msg);
//
//    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.info("服务{}进行续约", event.getServerId() +"  "+ event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.info("注册中心启动,{}", System.currentTimeMillis());
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.info("注册中心服务端启动,{}", System.currentTimeMillis());
    }

//    private  void send(String msg){
//        //用于封装邮件信息的实例
//        SimpleMailMessage smm=new SimpleMailMessage();
//        //由谁来发送邮件
//        smm.setFrom("发件邮箱与application中一致");
//        //邮件主题
//        smm.setSubject("Eureka-Server");
//        //邮件内容
//        smm.setText(msg);
//        //接受邮件
//        smm.setTo(new String[]{"收件邮箱"});
//        try {
//            javaMailSender.send(smm);
//        } catch (Exception e) {
//            logger.info(msg+"错误",e);
//        }
//    }

}
