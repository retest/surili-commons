package de.retest.surili.commons.core;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.retest.surili.commons.actions.Action;

public class NamedTestSuites {

	public static Set<NamedTestSuite> of( final Set<TestSuite> testSuites ) {
		final Set<NamedTestSuite> namedTestSuites = new LinkedHashSet<>();
		int testSuiteCount = 0;

		for ( final TestSuite testSuite : testSuites ) {
			final Set<NamedTestCase> namedTestCases = new LinkedHashSet<>();
			int testCaseCount = 0;

			for ( final TestCase testCase : testSuite.getTestCases() ) {
				final List<Action> actions = testCase.getActions();
				final String testCaseName = "TestCase" + testCaseCount++;
				final NamedTestCase namedTestCase = new NamedTestCaseImpl( actions, testCaseName );

				namedTestCases.add( namedTestCase );
			}

			final String testSuiteName = "TestSuite" + testSuiteCount++;
			final NamedTestSuite namedTestSuite = new NamedTestSuiteImpl( namedTestCases, testSuiteName );

			namedTestSuites.add( namedTestSuite );
		}

		return namedTestSuites;
	}

}
