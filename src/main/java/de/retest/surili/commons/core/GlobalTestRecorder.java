package de.retest.surili.commons.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.retest.surili.commons.actions.Action;

/**
 * Records executed actions and allows exporting them as test suite. It can be shared by all driver instances. Note that
 * this class is not thread-safe. Tests should not be executed concurrently.
 */
public class GlobalTestRecorder {
	private static final GlobalTestRecorder self = new GlobalTestRecorder();
	private final Map<String, TestCase> testCases = new HashMap<>();
	private String testSuiteName;

	public static GlobalTestRecorder getInstance() {
		return self;
	}

	private GlobalTestRecorder() {}

	public void recordAction( final Action action ) {
		final TestClassInformation testClassInformation = new TestClassInformation();
		final String currentTestSuiteName = testClassInformation.getCurrentTestSuiteName();

		// Reset test cases for every test suite.
		if ( !currentTestSuiteName.equals( testSuiteName ) ) {
			testCases.clear();
		}

		testSuiteName = currentTestSuiteName;
		final String currentTestCaseName = testClassInformation.getCurrentTestCaseName();
		final TestCase existingTestCase = testCases.get( currentTestCaseName );
		if ( existingTestCase != null ) {
			existingTestCase.getActions().add( action );
		} else {
			final List<Action> actions = new LinkedList<>();
			actions.add( action );
			testCases.put( currentTestCaseName, new TestCaseImpl( currentTestCaseName, actions ) );
		}
	}

	public TestSuite getTestSuite() {
		return new TestSuiteImpl( testSuiteName, new HashSet<>( testCases.values() ) );
	}
}
