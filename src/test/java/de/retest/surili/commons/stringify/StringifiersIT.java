package de.retest.surili.commons.stringify;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.retest.surili.commons.actions.Action;
import de.retest.surili.commons.actions.NavigateBackAction;
import de.retest.surili.commons.actions.NavigateForwardAction;
import de.retest.surili.commons.core.TestCase;
import de.retest.surili.commons.core.TestCaseImpl;
import de.retest.surili.commons.core.TestSuite;
import de.retest.surili.commons.core.TestSuiteImpl;

class StringifiersIT {

	Action action;
	TestCase testCase;
	TestSuite testSuite;

	@BeforeEach
	void setUp() throws Exception {
		action = new NavigateForwardAction();
		final Action otherAction = new NavigateBackAction();

		testCase = new TestCaseImpl( Arrays.asList( action, otherAction ) );
		final TestCase otherTestCase = new TestCaseImpl( Arrays.asList( otherAction, action ) );

		final Set<TestCase> testCases = new LinkedHashSet<>( Arrays.asList( testCase, otherTestCase ) );

		testSuite = new TestSuiteImpl( testCases );
	}

	@Test
	void should_handle_actions() throws Exception {
		final Stringifier<Action> cut = new ActionStringifier();

		final String stringified = cut.toString( action );

		Approvals.verify( stringified );
	}

	@Test
	void should_handle_test_cases() throws Exception {
		final Stringifier<TestCase> cut = new TestCaseStringifier();

		final String stringified = cut.toString( testCase );

		Approvals.verify( stringified );
	}

	@Test
	void should_handle_test_suites() throws Exception {
		final Stringifier<TestSuite> cut = new TestSuiteStringifier();

		final String stringified = cut.toString( testSuite );

		Approvals.verify( stringified );
	}

	@Test
	void should_handle_empty_test_cases() throws Exception {
		final Stringifier<TestCase> cut = new TestCaseStringifier();

		final String stringified = cut.toString( new TestCaseImpl( Collections.emptyList() ) );

		Approvals.verify( stringified );
	}

	@Test
	void should_handle_empty_test_suites() throws Exception {
		final Stringifier<TestSuite> cut = new TestSuiteStringifier();

		final String stringified = cut.toString( new TestSuiteImpl( Collections.emptySet() ) );

		Approvals.verify( stringified );
	}

	@Test
	void should_handle_empty_test_suites_with_empty_test_cases() throws Exception {
		final TestCase emptyTestCase = new TestCaseImpl( Collections.emptyList() );
		final Set<TestCase> testCases = new LinkedHashSet<>( Arrays.asList( testCase, emptyTestCase ) );
		final TestSuite testSuite = new TestSuiteImpl( testCases );
		final Stringifier<TestSuite> cut = new TestSuiteStringifier();

		final String stringified = cut.toString( testSuite );

		Approvals.verify( stringified );
	}

}
