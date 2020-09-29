package com.zerock.myapp.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

//*******************************************************************
//----------------------------LOMBOK--------------------------------*
@Log4j															//	*
@NoArgsConstructor(access=lombok.AccessLevel.PUBLIC)			//	*
//*******************************************************************

//*******************************************************************
//----------------------------SPRING--------------------------------*
@RunWith(SpringRunner.class)									//	*			
@ContextConfiguration(locations= {								//	*
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"	//	*
})																//	*
//*******************************************************************
public class TestDataSource {
	
//	@Setter(onMethod_= {@Autowired(required=true)})
//	@Setter(onMethod_= {@Autowired})	
//	@Resource(type=HikariDataSource.class)	// OK
//	@Resource(type=DriverManagerDataSource.class)	// OK
//	@Resource(type=SimpleDriverDataSource.class)	// OK
//	@Resource(type=OracleDataSource.class)			// OK
	@Resource(type=org.apache.tomcat.jdbc.pool.DataSource.class) // OK
	
	private DataSource dataSource;
	
	@Before
	public void doBefore() {
		log.info("doBefore() invoked.");
		
		assertNotNull(dataSource);
		
		log.info(">>>>> dataSource : " + dataSource);		
	} //doBefore
		
	
	@Test(timeout=1000)
	public void testDataSource() throws SQLException {
		log.info("testDataSource() invoked.");
		
		try(Connection conn = dataSource.getConnection();) {
			log.info("\t + conn: " + conn);
		} //try-with-resources
		
	} //testDataSource
	
	
	@After
	public void doAfter() {
		log.info("doAfter() invoked.");
		
	} //doAfter
	
} //end class