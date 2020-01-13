package de.retest.surili.commons.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.retest.recheck.ui.descriptors.Element;

class ChangeValueOfActionTest {

	@Test
	void toString_should_be_helpful() {
		final Element targetElement = mock( Element.class, Mockito.RETURNS_DEEP_STUBS );
		when( targetElement.getIdentifyingAttributes().getPath() ).thenReturn( "/foo[1]/bar[2]" );
		final CharSequence[] keysToSend = { "keys to send" };

		final Action cut = new ChangeValueOfAction( targetElement, keysToSend );

		assertThat( cut ).hasToString( "ChangeValueOfAction(path=/foo[1]/bar[2], keysToSend=[keys to send])" );
	}

}
