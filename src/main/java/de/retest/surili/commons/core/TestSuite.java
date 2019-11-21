package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.Set;

/**
 * A test suite with a set (i.e. unordered) of {@link TestCase}s.
 */
public interface TestSuite extends Serializable {

	/**
	 * @return The set of test cases of this test suite.
	 */
	Set<? extends TestCase> getTestCases();

	/**
	 * @return The number of test cases of this test suite.
	 */
	int getSize();

}
