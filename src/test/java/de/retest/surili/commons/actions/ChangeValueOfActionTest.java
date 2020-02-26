package de.retest.surili.commons.actions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.Path;
import de.retest.recheck.ui.descriptors.Attribute;
import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.IdentifyingAttributes;
import de.retest.recheck.ui.descriptors.MutableAttributes;
import de.retest.recheck.ui.descriptors.TextAttribute;

class ChangeValueOfActionTest {

	@Test
	void toString_should_be_helpful() {
		Collection<Attribute> identifying = IdentifyingAttributes.createList( Path.fromString( "/foo[1]/a[2]" ), "a" );
		identifying.add( new TextAttribute( "text", "Log In" ) );
		final Element targetElement = Element.create( "retestId", mock( Element.class ), new IdentifyingAttributes( identifying ), new MutableAttributes().immutable() );
		final CharSequence[] keysToSend = { "keys to send" };

		final Action cut = new ChangeValueOfAction( targetElement, keysToSend );

		assertThat( cut ).hasToString( "ChangeValueOfAction(targetElement=a [Log In], keysToSend=[keys to send])" );
	}

}
