package de.retest.surili.commons.ga;

import de.retest.surili.commons.core.TestSuite;
import lombok.Value;

/**
 * Summarized length of all test cases from a test suite.
 */
@Value
public class TestSuiteLength implements Costs {

	private final int length;

	public TestSuiteLength( final TestSuite testSuite ) {
		this( testSuite.getSize() );
	}

	public TestSuiteLength( final int length ) {
		this.length = length;
	}

	@Override
	public double getFitness() {
		return length;
	}

}
