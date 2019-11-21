package de.retest.surili.commons.core;

import java.util.Set;

/**
 * A {@link TestSuite} with a display name.
 */
public interface NamedTestSuite extends TestSuite {

	@Override
	Set<? extends NamedTestCase> getTestCases();

	/**
	 * @return The display name of this test suite.
	 */
	String getName();

}
