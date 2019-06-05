package de.retest.surili.commons.core;

import de.retest.recheck.TestCaseFinder;

/**
 * Allows the extraction of information about the current test class. Hence, it can only be used inside of a test
 * method.
 */
public class TestClassInformation {

	public String getCurrentTestSuiteName() {
		return getClassName( getStackTraceElementOrThrow().getClassName() );
	}

	public String getCurrentTestCaseName() {
		return getStackTraceElementOrThrow().getMethodName();
	}

	public String getCurrentPackageName() {
		return getPackageName( getStackTraceElementOrThrow().getClassName() );
	}

	private String getPackageName( final String fullClassName ) {
		return fullClassName.substring( 0, fullClassName.lastIndexOf( '.' ) );
	}

	private StackTraceElement getStackTraceElementOrThrow() {
		final StackTraceElement stackTraceElement = TestCaseFinder.findTestCaseMethodInStack();
		if ( stackTraceElement == null ) {
			throw new RuntimeException(
					"Could not determine test case method. Extracting information is only possible from test methods!" );
		}
		return stackTraceElement;
	}

	private String getClassName( final String fullClassName ) {
		final int beginIndex = fullClassName.lastIndexOf( '.' ) + 1;
		return fullClassName.substring( beginIndex );
	}
}
