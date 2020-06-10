package com.techChallenge.techgig.appconfig;

import com.techChallenge.techgig.beans.Answer;
import com.techChallenge.techgig.beans.Question;
import com.techChallenge.techgig.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

@EntityScan(basePackages = "com.techChallenge.techgig.beans")
@ComponentScan(basePackages = "com.techChallenge.techgig")
@ComponentScan(basePackages = "com.techChallenge.techgig.dbconfig")
@SpringBootApplication(scanBasePackages = "com.techChallenge.techgig")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TechgigApplication {


	public static void main(String[] args) {

		SpringApplication.run(TechgigApplication.class, args);




	}

}
