package com.zerock.myapp.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestSqlSessionFactory {
	
//	@Resource(type=FQCN)
//	@Resource
//	@Autowired
//	@Inject
//	@Setter(onMethod_= {@Autowired(required=true)})
//	private SqlSessionFactory sqlSessionFactory;
	
// 생성자를 통한 의존성 주입의 조건:
// (1) 주입받을 필드가 1개여야 함
// (2) 생성자의 매개변수도 1개여야 함(매개변수 타입 = 필드 타입)	
	
	@Setter(onMethod_= {@Autowired})
	private SqlSession sqlSession;
	
	@Before
	public void doBefore() {
		log.info("doBefore() invoked.");
		
//		assertNotNull(sqlSessionFactory);
		assertNotNull(sqlSession);
		
//		log.info(">>>>> sqlSessionFactory: " + sqlSessionFactory);
		log.info(">>>>> sqlSession: " + sqlSession);
	} // doBefore
	
	
	@Test
	public void testSqlSession() {
		log.info("testSqlSession() invoked.");

	} // testSqlSession
	
//	@Test
//	public void testSqlSessionFactory() {
////		log.info("SqlSessionFactory() invoked.");
//		
//		try(
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		) {
//			log.info("**** sqlSession: " + sqlSession);
//		} // try-with-resources
//	} // testSqlSessionFactory
	
	
	@After
	public void doAfter() {
		log.info("doAfter() invoked.");
		
		// 사용한 자원을 해제
		
	} // doAfter
} // end class