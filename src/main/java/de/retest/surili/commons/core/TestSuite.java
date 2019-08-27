package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
	 * @implNote Sorted alphabetically according to {@link #getName()}.
	 * @return {@link #getTestCases()} as a list.
	 */
	default List<TestCase> getTestCasesAsList() {
		return getTestCases().stream() //
				.sorted( Comparator.comparing( TestCase::getName ) ) //
				.collect( Collectors.toList() );
	}

	/**
	 * @return The number of test cases of this test suite.
	 */
	int getSize();

}
