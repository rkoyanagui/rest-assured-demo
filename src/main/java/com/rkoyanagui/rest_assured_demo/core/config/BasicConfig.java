package com.rkoyanagui.rest_assured_demo.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.rkoyanagui.rest_assured_demo"
})
@EnableAutoConfiguration
public class BasicConfig
{
}
