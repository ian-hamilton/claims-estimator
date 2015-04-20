/**
 * 
 */
package com.inertia.solutions.claims.mvc.repository.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.inertia.solutions.claims.mvc.app.config.SpringConfiguration;
import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.repository.ClaimItemRepository;

/**
 * @author ihamilto
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@TestPropertySource("classpath:database.test.properties")
//@ContextConfiguration(classes={SpringConfiguration.class}, loader=AnnotationConfigContextLoader.class)
//@ActiveProfiles("integration")
public class ClaimItemRepositoryTest {
	
	@Autowired
	ClaimItemRepository repoUnderTest;
	
//	@Test
	public void testSaveClaimItem() {
		ClaimItem item = new ClaimItem();
		item.setClaimItemAmount(new Double(10));
		item.setClaimItemDesc("Test Desc");
		item.setClaimItemName("Test Name");
		
		try {
		repoUnderTest.save(item);
		
		} finally {
			repoUnderTest.delete(item);
		}
		
	}
	
}
