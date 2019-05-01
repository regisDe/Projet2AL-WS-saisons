package fr.afcepf.al33.citron.ws.saison.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
public class TestHamcrest {

	@Test
	@Tag("not-included-in-project")
	void assertWithHamcrestMatcher() {
		assertThat(39 + 3, equalTo(42));
		assertThat("toto", notNullValue());
		assertThat("tito", containsString("ti"));		
	}
	
}