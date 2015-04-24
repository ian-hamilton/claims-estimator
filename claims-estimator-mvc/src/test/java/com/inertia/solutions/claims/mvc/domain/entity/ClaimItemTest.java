package com.inertia.solutions.claims.mvc.domain.entity;

import org.junit.Before;
import org.junit.Test;
import org.outsideMyBox.testUtils.BeanLikeTester;
import org.outsideMyBox.testUtils.BeanLikeTester.PropertiesAndValues;


public class ClaimItemTest {

	PropertiesAndValues defaultValues = new PropertiesAndValues();
	PropertiesAndValues otherValues = new PropertiesAndValues();
	
	@Before
	public void setup() {
		defaultValues.put("id", null);
		defaultValues.put("claimItemName", null);
		defaultValues.put("claimItemAmount", null);
		defaultValues.put("claimItemDesc", null);
		
		otherValues.put("id", "123456");
		otherValues.put("claimItemName", "test-name");
		otherValues.put("claimItemAmount", 1000.01D);
		otherValues.put("claimItemDesc", "test-desc");

	}
	
	@Test
	public void test() {
		BeanLikeTester beanLikeTester = new BeanLikeTester(ClaimItem.class);
		
		beanLikeTester.testDefaultValues(defaultValues);
		beanLikeTester.testMutatorsAndAccessors(defaultValues, otherValues);
		beanLikeTester.testToString(defaultValues, otherValues);
	}
}
