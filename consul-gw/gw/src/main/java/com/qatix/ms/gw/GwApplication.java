package com.qatix.ms.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@Configuration
@SpringBootApplication
public class GwApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        //ok
//		StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
//		config.setParts(1);
//		return builder.routes()
//				.route("host_route", r -> r.path("/a/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:7201"))
//				.route("host_route", r -> r.path("/b/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:7202"))
//				.build();

        return builder.routes()
                .route("path_route", r -> r.path("/a1/**").filters(f -> f.stripPrefix(1))
                        .uri("lb://app1"))
                .route("path_route", r -> r.path("/a2/**").filters(f -> f.stripPrefix(1))
                        .uri("lb://APP2"))
//                .route("host_route", r -> r.host("app.myhost.org").and()
//                        .path("/app3/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://app3"))
//				.route("rewrite_route", r -> r.host("*.rewrite.org")
//						.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
//						.uri("http://httpbin.org"))
//				.route("hystrix_route", r -> r.host("*.hystrix.org")
//						.filters(f -> f.hystrix(c -> c.setName("slowcmd")))
//						.uri("http://httpbin.org"))
//				.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
//						.filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
//						.uri("http://httpbin.org"))
                .route("limit_route", r -> r
                        .host("*.myhost.org").and().path("/a11/**")
                        .filters(f -> f.stripPrefix(1))
//                        .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
                        .uri("lb://app1"))
                .build();
    }

    public RedisRateLimiter redisRateLimiter() {
        //replenish和burstCapatity的解释
//        https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.0.2.RELEASE/single/spring-cloud-gateway.html#_requestratelimiter_gatewayfilter_factory
        return new RedisRateLimiter(10, 2);
    }


    /**
     * 自定义限流标志的key，多个维度可以从这里入手
     * exchange对象中获取服务ID、请求信息，用户信息等
     */
    @Primary
    @Bean
    KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * IP限流
     *
     * @return
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 用户限流
     * 使用这种方式限流，请求路径中必须携带userId参数
     *
     * @return
     */
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * 接口限流
     * 获取请求地址的uri作为限流key
     *
     * @return
     */
    @Bean
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }
}

