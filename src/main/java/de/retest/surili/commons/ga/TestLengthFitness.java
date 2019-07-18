package de.retest.surili.commons.ga;

import de.retest.surili.commons.core.TestCase;
import de.retest.surili.commons.core.TestSuite;
import lombok.NonNull;
import lombok.Value;

/**
 * Length of all test cases of one test suite. Smaller tests produce a greater fitness value which is better.
 */
@Value
public class TestLengthFitness implements Fitness {

	@NonNull
	TestSuite testSuite;

	@Override
	public double getFitness() {
		return -1 * testSuite.getTestCases().stream() //
				.mapToInt( TestCase::getSize ) //
				.sum();
	}
}
