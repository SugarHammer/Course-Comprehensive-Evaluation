package com.yxb.teaching_assessment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages ={"com.yxb.teaching_assessment","com.yxb.teaching_assessment.biz.intercepter"} )
@MapperScan("com.yxb.teaching_assessment.biz.mapper")
public class TeachingAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeachingAssessmentApplication.class, args);
	}

}
