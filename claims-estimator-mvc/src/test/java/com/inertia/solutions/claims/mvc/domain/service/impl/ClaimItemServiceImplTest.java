package com.inertia.solutions.claims.mvc.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.inertia.solutions.claims.mvc.domain.entity.ClaimItem;
import com.inertia.solutions.claims.mvc.domain.repository.ClaimItemRepositoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ClaimItemServiceImplTest {

	@Mock
	ClaimItemRepositoryImpl mockClaimItemRepository;
	
	@InjectMocks
	ClaimItemServiceImpl serviceUnderTest;
	
	List<ClaimItem> listExpectation = new ArrayList<ClaimItem>();
	
	ClaimItem itemExpectation = new ClaimItem();
	
	@Before
	public void setupMocks() {		
		Mockito.when(mockClaimItemRepository.findAllByType(Mockito.anyString())).thenReturn(listExpectation);
		Mockito.when(mockClaimItemRepository.save(Mockito.any(ClaimItem.class))).thenReturn(itemExpectation);
	}
	
	@Test
	public void testFindAllClaimItems() throws Exception {
		final String type = "property";
		List<ClaimItem> result = serviceUnderTest.findAllClaimItems(type);
		Assert.assertSame("Claim Item List is not the same list as expectation", listExpectation, result);
		Mockito.verify(mockClaimItemRepository).findAllByType(type);
	}

	@Test
	public void testSaveClaimItem() throws Exception {
		ClaimItem item = new ClaimItem();
		ClaimItem result = serviceUnderTest.saveClaimItem(item);
		Assert.assertSame("Claim Item is not the same item as expected", itemExpectation, result);
		Mockito.verify(mockClaimItemRepository).save(item);
	}

	@Test
	public void testDeleteClaimItemClaimItem() throws Exception {
		ClaimItem item = new ClaimItem();
		serviceUnderTest.deleteClaimItem(item);
		Mockito.verify(mockClaimItemRepository).delete(item);
	}

	@Test
	public void testDeleteClaimItemString() throws Exception {
		String id = "123";
		serviceUnderTest.deleteClaimItem(id);
		Mockito.verify(mockClaimItemRepository).delete(id);
	}

	
}
