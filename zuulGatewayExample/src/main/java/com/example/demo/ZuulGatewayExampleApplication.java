package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import filters.ErrorFilter;
import filters.PostFilter;
import filters.PreFilter;
import filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulGatewayExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayExampleApplication.class, args);
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
