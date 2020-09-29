package com.zerock.myapp.persistence;

import static org.junit.Assert.assertNotNull;

import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor(access=lombok.AccessLevel.PUBLIC)

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestSqlSessionTemplate {

//	@Inject
//	private SqlSession sqlSession;
	
	@Setter(onMethod_= {@Autowired})
	private TimeMapper timeMapper;
	
	
	@Before
	public void doBefore() {
		log.info("doBefore() invoked.");
		
		Objects.requireNonNull(timeMapper);
		
		log.info("> > > Mapper Type: " + timeMapper.getClass().getName());
		log.info("> > > timeMapper: " + timeMapper);
	} // doBefore
	
	
	@Test(timeout=1000)
	public void testTimeMapper() {
		log.info("testTimeMapper() invoked.");
		
		
		String now =
				timeMapper.getNow();
		log.info("> > > now: " + now);
	} // testSqlSession
	
	
	@After
	public void doAfter() {
		log.info("doAfter() invoked.");
		
		assertNotNull(timeMapper);
		
//		sqlSession.clearCache(); // 자원해제
	} // doAfter
} // end class