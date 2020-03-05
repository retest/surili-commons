package de.retest.surili.commons.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.IdentifyingAttributes;
import de.retest.recheck.ui.descriptors.MutableAttributes;

class ClickOnActionTest {

	@Test
	void toString_should_be_helpful() {
		final Element targetElement = Element.create( "retestId", mock( Element.class ),
				new IdentifyingAttributes( Collections.emptyList() ), new MutableAttributes().immutable() );

		final Action cut = new ClickOnAction( targetElement );

		assertThat( cut ).hasToString( "ClickOnAction(targetElement=retestId)" );
	}

}
