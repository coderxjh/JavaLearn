package com.xiao.bootwebadmin.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 0:39
 */
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {

    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("dockerInfo","docker started...");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stopped...");
    }
}
