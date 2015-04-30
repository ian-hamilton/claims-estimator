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
		defaultValues.put("claimItemDesc", null);
		defaultValues.put("totalAmount", null);
		defaultValues.put("removeAmount", null);
		defaultValues.put("replaceAmount", null);
		defaultValues.put("category", null);
		defaultValues.put("sel", null);
		defaultValues.put("defaultCalculation", null);
		defaultValues.put("notes", null);
		defaultValues.put("claimType", null);
		
		otherValues.put("id", "123456");
		otherValues.put("claimItemName", "test-name");
		otherValues.put("totalAmount", 1000.01D);
		otherValues.put("claimItemDesc", "test-desc");
		otherValues.put("removeAmount", 1000.01D);
		otherValues.put("replaceAmount", 1000.01D);
		otherValues.put("category", "test-cat");
		otherValues.put("sel", "test-sel");
		otherValues.put("defaultCalculation", "test-calc");
		otherValues.put("notes", "test-notes");
		otherValues.put("claimType", "test-claimType");

	}
	
	@Test
	public void test() {
		BeanLikeTester beanLikeTester = new BeanLikeTester(ClaimItem.class);
		
		beanLikeTester.testDefaultValues(defaultValues);
		beanLikeTester.testMutatorsAndAccessors(defaultValues, otherValues);
		beanLikeTester.testToString(defaultValues, otherValues);
	}
}
