package com.jiangdaxian.helloword.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.jiangdaxian.helloword.service.HellowordService;

public class HellowordJob implements SimpleJob {
	
	@Autowired
	private HellowordService hellowordService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HellowordJob.class);

	public void execute(ShardingContext context) {
		LOGGER.info("{},shardingItem:{},totalCount:{}", context.getJobName(), context.getShardingItem(),
				context.getShardingTotalCount());
		LOGGER.info("{},{}", context.getJobName(), context.toString());
		switch (context.getShardingItem()) {
		case 0:
			LOGGER.info("run time:{}",hellowordService.getNowTime());
			LOGGER.info("ElasticJobTask name:{} is start", context.getJobName());
		default:
			break;
		}
	}
}
