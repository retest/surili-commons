package de.retest.surili.commons.core;

/**
 * A {@link TestCase} with a display name.
 */
public interface NamedTestCase extends TestCase {

	/**
	 * @return The display name of this test case.
	 */
	String getName();

}
