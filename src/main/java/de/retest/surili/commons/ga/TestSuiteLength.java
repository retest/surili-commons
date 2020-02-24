package de.retest.surili.commons.ga;

import de.retest.surili.commons.core.TestSuite;
import lombok.Value;

/**
 * Summarized length of all test cases from a test suite. Smaller tests produce a greater fitness, where the actual
 * value is always negative (unless the overall length is 0). Example:
 *
 * <pre>
 * Test Case 1: size 2
 * Test Case 2: size 4
 * =&gt; (2 + 4) * -1 = -6
 * </pre>
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
		return -1.0 * length;
	}

}
