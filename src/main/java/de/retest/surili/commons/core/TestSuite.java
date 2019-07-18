package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.Set;

/**
 * A test suite with a set (i.e. unordered) of {@link TestCase}s.
 */
public interface TestSuite extends Serializable {

	/**
	 * @return The display name of this test suite.
	 */
	String getName();

	/**
	 * @return The set of test cases of this test suite.
	 */
	Set<TestCase> getTestCases();

	/**
	 * @return The number of test cases of this test suite.
	 */
	int getSize();

}
