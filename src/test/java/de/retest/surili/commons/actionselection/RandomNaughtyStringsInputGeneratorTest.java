package de.retest.surili.commons.actionselection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;

class RandomNaughtyStringsInputGeneratorTest {
	RandomNaughtyStringsInputGenerator cut;
	Element element;

	@BeforeEach
	void setUp() {
		cut = new RandomNaughtyStringsInputGenerator( 2L );
		element = mock( Element.class );
	}

	@Test
	void should_generate_random_input_for_element() {
		final CharSequence[] charSequences = cut.getCharSequences( element );
		assertThat( charSequences ).containsExactly( "<plaintext>" );
	}

}
