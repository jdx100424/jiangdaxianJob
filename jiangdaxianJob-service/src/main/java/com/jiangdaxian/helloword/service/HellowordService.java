package com.jiangdaxian.helloword.service;

import org.springframework.stereotype.Service;

@Service
public class HellowordService {

	
	public Long getNowTime() {
		return System.currentTimeMillis();
	}
}
