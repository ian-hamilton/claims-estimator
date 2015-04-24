package com.inertia.solutions.claims.mvc.domain.entity;

import org.junit.Test;
import org.outsideMyBox.testUtils.BeanLikeTester;
import org.outsideMyBox.testUtils.BeanLikeTester.PropertiesAndValues;


public class ClaimItemTest {

	@Test
	public void test() {
		PropertiesAndValues defaultValues = new PropertiesAndValues();
		defaultValues.put("id", null);
		defaultValues.put("claimItemName", null);
		defaultValues.put("claimItemAmount", null);
		defaultValues.put("claimItemDesc", null);
		
		BeanLikeTester blt = new BeanLikeTester(ClaimItem.class);
		blt.testDefaultValues(defaultValues);
	}
}
