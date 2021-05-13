package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 用户端启动APP
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class EurekaApplication
{
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        // 客户端负载均衡
        return new RestTemplate();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println( "服务迁移系统多节点用户端启动!" );
    }
}
