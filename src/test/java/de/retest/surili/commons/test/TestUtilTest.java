package de.retest.surili.commons.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.RootElement;
import de.retest.recheck.ui.descriptors.SutState;

class TestUtilTest {

	@Test
	void created_sut_states_elements_should_be_equal() throws Exception {
		final int numberOfChildren = 3;

		final RootElement rootElement0 = TestUtil.getRootElement( "foo", numberOfChildren );
		final RootElement rootElement1 = TestUtil.getRootElement( "foo", numberOfChildren );

		final List<Element> containedElements0 = rootElement0.getContainedElements();
		assertThat( containedElements0 ).hasSize( numberOfChildren );

		final List<Element> containedElements1 = rootElement1.getContainedElements();
		assertThat( containedElements1 ).hasSize( numberOfChildren );

		final SutState sutState0 = TestUtil.createSutState( rootElement0 );
		final SutState sutState1 = TestUtil.createSutState( rootElement1 );

		assertThat( sutState0, equalTo( sutState1 ) );
	}

	@Test
	void created_sut_states_should_not_be_equal() throws Exception {
		final int numberOfChildren = 3;

		final RootElement rootElement0 = TestUtil.getRootElement( "foo", numberOfChildren );
		final RootElement rootElement1 = TestUtil.getRootElement( "bar", numberOfChildren );

		final List<Element> containedElements0 = rootElement0.getContainedElements();
		assertThat( containedElements0 ).hasSize( numberOfChildren );

		final List<Element> containedElements1 = rootElement1.getContainedElements();
		assertThat( containedElements1 ).hasSize( numberOfChildren );

		final SutState sutState0 = TestUtil.createSutState( rootElement0 );
		final SutState sutState1 = TestUtil.createSutState( rootElement1 );

		assertThat( sutState0, not( equalTo( sutState1 ) ) );
	}
}
