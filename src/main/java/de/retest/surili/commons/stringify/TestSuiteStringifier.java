package de.retest.surili.commons.stringify;

import java.util.Set;
import java.util.stream.Collectors;

import de.retest.surili.commons.core.TestCase;
import de.retest.surili.commons.core.TestSuite;

public class TestSuiteStringifier implements Stringifier<TestSuite> {

	private final String prefix;
	private final TestCaseStringifier testCaseStringifier;

	public TestSuiteStringifier() {
		this( 0 );
	}

	public TestSuiteStringifier( final int indentationLevel ) {
		this( indentationLevel, new TestCaseStringifier( indentationLevel + 1 ) );
	}

	public TestSuiteStringifier( final int indentationLevel, final TestCaseStringifier testCaseStringifier ) {
		prefix = Tabs.of( indentationLevel ) + "TestSuite:";
		this.testCaseStringifier = testCaseStringifier;
	}

	@Override
	public String toString( final TestSuite testSuite ) {
		final Set<? extends TestCase> testCases = testSuite.getTestCases();
		if ( testCases.isEmpty() ) {
			return prefix + " empty";
		}
		return prefix + "\n" + testCases.stream() //
				.map( testCaseStringifier::toString ) //
				.collect( Collectors.joining( "\n" ) );
	}

}
