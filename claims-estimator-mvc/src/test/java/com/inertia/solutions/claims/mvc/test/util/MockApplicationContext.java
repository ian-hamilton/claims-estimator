/**
 * 
 */
package com.inertia.solutions.claims.mvc.test.util;

import java.nio.charset.Charset;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.inertia.solutions.claims.mvc.domain.service.ClaimItemService;

/**
 * @author ihamilto
 *
 */
@Configuration
public class MockApplicationContext {

	public static final MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype());
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Bean
	public ClaimItemService claimItemService() {
		return Mockito.mock(ClaimItemService.class);
	}
}
