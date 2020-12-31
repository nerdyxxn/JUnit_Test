package com.kh.yseolc.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component만 있어서는 스케줄 안 돌아가 servlet-context로 이동 -> 	<task:annotation-driven/> 추가 혹은 아래처럼 @En~~
@EnableScheduling

@Component
public class TestSchedule {
	
	//fixedRate = 3000L 3초마다 1번씩
	//fixedRateString = "3000" 3초마다 1번씩
	//fixedDelayString = "3000" 3초후에...?
	//initialDelayString = "3000" 얘는 서버 start하자마자 일 시작함. 따라서 3초 있다가 일을 시작했으면 해서 걸어주는 것...!
	
	
//	@Scheduled(initialDelayString = "5000", fixedRateString = "3000") // 5초 있다가 실행.. 3초마다 한번씩
	@Scheduled(fixedRateString = "3000")
	@Scheduled(cron = "0 0 02 * * ?")	// scheduled cron 표현식 - 초 / 분 / 시 / 일 / 월 / 요일
	// 초 0-59
	// 분 0-59
	// 시 0-23
	// 일 1-31
	// 월 1-12
	// 요일 1-7 or SUN-SAT
	// * 모든값
	// ? 값이 없음
	// - 범위를 지정함 (0-5 0부터 5까지)
	// ,
	// /
	// L 마지막 값! last를 의미함
	// W
	// # 몇번째를 의미함 (요일에 씀.. 
	
	// 각각은 띄어쓰기로 구분한다!
	public void doScheduleTask() {
		System.out.println("Hello~ doScheduleTask()");
		// DB가서 긁어올 수 있도록 해주는 코드 작성
		// 공공 API 긁어오기?
	}
}