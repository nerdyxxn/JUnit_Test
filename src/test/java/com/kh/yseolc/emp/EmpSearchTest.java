package com.kh.yseolc.emp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;

import com.kh.yseolc.emp.model.dao.EmpDao;
import com.kh.yseolc.emp.model.service.EmpService;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpSearchTest {
	private static final Logger logger = LoggerFactory.getLogger(EmpSearchTest.class);	
	/*Mock 사용 안 한 경우
	@Autowired
	private EmpService service;

	@Autowired
	private EmpDao dao;

	@Autowired
	private SqlSessionTemplate sqlSession;
	*/
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;	// MockMvc 형태, 의존성 주입할 객체
	
	//@Test의 메소드가 수행되기 전에 수행되는 메소드
	//before 어노테이션 사용할 때, 반드시 org.junit에 있는 것 사용해야함!
	@Before
	public void setup() {
		//mockMvc에 객체를 만들어 넣어줌!!!!!!!
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("=====EmpSearchTest setup()================");
	}
	
	@Test
	public void testEmpSearch() {
		logger.info("=====EmpSearchTest testEmpSearch()================");		
		/* Mock 사용 안 한 경우
		 * 아래 mock~~~~ 한 문장으로 이 행위가 없어도 됌!!!!!!!!!!!!!!!!!!!
		//HashMap<String, String> paramMap = new HashMap<String, String>();
		//paramMap.put("deptno", "10");
		//paramMap.put("job", "SALESMAN");
		
		//테스트범위 service부터
		//List<HashMap<String, String>> empList = service.empSearch(paramMap);
		
		//테스트범위 dao부터
		//List<HashMap<String, String>> empList2 = dao.empSearch(paramMap);
		
		//테스트범위 mybatis sqltemplate부터
		sqlSession.selectList("searchList", paramMap);
		assertEquals()
		*/
		
		
		// Mock 사용 한 경우
		try {
			//.perform("매핑url") : 해당 url로 request 함! (가게됌..우리가 만들어놓은 컨트롤러로 슝 가지)
			// 						아래 코드는 post 방식으로 param (~~~)을 들고 간다는 뜻!
			//.andDo() : 처리된 내용을 출력함!
			//.andExpect() : 상태값을 검증함! --> 정상인 경우 값은 200임
//			mockMvc.perform(post("/empsearch.action").param("deptno", "10").param("job", "SALESMAN"))
//			.andDo(print())
//			.andExpect(status().isOk());
			
			mockMvc.perform(post("/empinsert.action").param("deptno", "10").param("job", "SALESMAN").param("empno", "2060").param("ename", "박주영"))
			.andDo(print())
			.andExpect(status().isOk());
			logger.info("=====EmpSearchTest testEmpSearch()================");
			
			mockMvc.perform(post("/empinsert.action").param("deptno", "20").param("job", "SALESMAN").param("empno", "2070").param("ename", "설윤성"))
			.andDo(print())
			.andExpect(status().isOk());
			logger.info("=====EmpSearchTest testEmpSearch()================");
			
			mockMvc.perform(post("/empinsert.action").param("deptno", "30").param("job", "SALESMAN").param("empno", "2080").param("ename", "설지은"))
			.andDo(print())
			.andExpect(status().isOk());
			logger.info("=====EmpSearchTest testEmpSearch()================");
			
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(">>>>>>> 테스트 실패 " + e.getMessage() + "<<<<<<<<");
		}
		
		
	}
}
