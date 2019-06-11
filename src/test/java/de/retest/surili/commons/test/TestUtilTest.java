package de.retest.surili.commons.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.IdentifyingAttributes;
import de.retest.recheck.ui.descriptors.RootElement;
import de.retest.recheck.ui.descriptors.SutState;

class TestUtilTest {

	@Test
	void created_sut_state_should_contain_given_root_elements() throws Exception {
		final RootElement re0 = mock( RootElement.class );
		final RootElement re1 = mock( RootElement.class );

		final SutState sutState = TestUtil.createSutState( re0, re1 );

		assertThat( sutState.getRootElements() ).containsExactly( re0, re1 );
	}

	@Test
	void created_identifying_attributes_should_TODO() throws Exception {
		final String id = "foo";

		final IdentifyingAttributes identifyingAttributes = TestUtil.getIdentifyingAttributes( id );

		// TODO Add assertion and adapt test case name.
		fail();
	}

	@Test
	void created_root_element_should_TODO() throws Exception {
		final String id = "foo";
		final int numberOfChildren = 3;

		final RootElement rootElement = TestUtil.getRootElement( id, numberOfChildren );

		final List<Element> containedElements = rootElement.getContainedElements();
		assertThat( containedElements ).hasSize( numberOfChildren );

		// TODO Add assertion and adapt test case name.
		fail();
	}

	@Test
	void created_element_should_TODO() throws Exception {
		final Element parent = mock( Element.class );
		final int index = 1;

		final Element element = TestUtil.getElement( parent, index );

		assertThat( element.getParent() ).isEqualTo( parent );

		// TODO Add assertion and adapt test case name.
		fail();
	}

}
