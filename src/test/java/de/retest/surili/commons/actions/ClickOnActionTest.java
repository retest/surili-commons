package de.retest.surili.commons.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.retest.recheck.ui.descriptors.Element;

class ClickOnActionTest {

	@Test
	void toString_should_be_helpful() {
		final Element targetElement = mock( Element.class, Mockito.RETURNS_DEEP_STUBS );
		when( targetElement.getIdentifyingAttributes().getPath() ).thenReturn( "/foo[1]/bar[2]" );

		final Action cut = new ClickOnAction( targetElement );

		assertThat( cut ).hasToString( "ClickOnAction(path=/foo[1]/bar[2])" );
	}

}
