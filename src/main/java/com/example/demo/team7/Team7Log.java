package com.example.demo.team7;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Team7Log {
	
	@Around("execution (* com.example.demo.team7.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		try {
			System.out.println("開始");
			log.info("メソッド開始： " + jp.getSignature());
			log.info("送ったデータ： " + Arrays.toString(jp.getArgs()));
			Object result = jp.proceed();
			return result;
		} catch(Exception e) {
			return "error";
			
		}
	}
	
	@AfterReturning("execution (* com.example.demo.team7.*.*(..))")
	public void returningLog(JoinPoint jp) {
		log.info("メソッド正常終了：" + jp.getSignature());
	}
	
	@AfterThrowing("execution (* com.example.demo.team7.*.*(..))")
	public void throwingLog(JoinPoint jp) {
		log.error("エラー発生：" + jp.getSignature());
	}
	
	

}
