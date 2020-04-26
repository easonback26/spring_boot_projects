package com.example.SpringAnno;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.SpringAnno")
public class AppConfig
{
//    @Bean
//    public Samsung getPhone()
//    {
//        return new Samsung();
//    }

//    @Bean
//    public MobileProcessor getProcessor()
//    {
//        return new SnapDragon();
//    }
}
