package com.iotknowyou.HelloWorld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"application-bean.xml"})
public class ConfigClass {
}
