package de.retest.surili.commons.core;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.surili.commons.actions.Action;
import lombok.Value;

class NamedTestSuitesTest {

	@Test
	void should_rename_all_with_unique_names() throws Exception {
		final Action action0 = new MockedAction( 0 );
		final Action action1 = new MockedAction( 1 );

		final TestCase testCase00 = new TestCaseImpl( Arrays.asList( action0, action0 ) );
		final TestCase testCase01 = new TestCaseImpl( Arrays.asList( action1, action1 ) );

		final TestSuite testSuite0 = new TestSuiteImpl( orderedSet( testCase00, testCase01 ) );

		final TestCase testCase10 = new TestCaseImpl( Arrays.asList( action0, action1 ) );
		final TestCase testCase11 = new TestCaseImpl( Arrays.asList( action1, action0 ) );

		final TestSuite testSuite1 = new TestSuiteImpl( orderedSet( testCase10, testCase11 ) );

		final Set<TestSuite> testSuites = orderedSet( testSuite0, testSuite1 );

		final Set<NamedTestSuite> renamed = NamedTestSuites.of( testSuites );

		Approvals.verify( renamed );
	}

	@SuppressWarnings( "unchecked" )
	private <E> Set<E> orderedSet( final E... e ) {
		return new LinkedHashSet<>( Arrays.asList( e ) );
	}

	@Value
	private class MockedAction implements Action {

		private static final long serialVersionUID = 1L;

		private int id;

		@Override
		public Optional<Element> getTargetElement() {
			return Optional.empty();
		}
	}

}
