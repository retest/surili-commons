package de.retest.surili.commons.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.IdentifyingAttributes;
import de.retest.recheck.ui.descriptors.MutableAttributes;

class ChangeValueOfActionTest {

	@Test
	void toString_should_be_helpful() {
		final Element targetElement = Element.create( "retestId", mock( Element.class ),
				new IdentifyingAttributes( Collections.emptyList() ), new MutableAttributes().immutable() );
		final CharSequence[] keysToSend = { "keys to send" };

		final Action cut = new ChangeValueOfAction( targetElement, keysToSend );

		assertThat( cut ).hasToString( "ChangeValueOfAction(targetElement=retestId, keysToSend=[keys to send])" );
	}

}
