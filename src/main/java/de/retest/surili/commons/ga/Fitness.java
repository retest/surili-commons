package de.retest.surili.commons.ga;

/**
 * Generic interface for representing fitness, be it variants of code coverage (e.g. statement coverage or branch
 * coverage) or something entirely different (e.g. found bugs or test length).
 */
@FunctionalInterface
public interface Fitness extends Comparable<Fitness> {

	/**
	 * @return Fitness measured in the corresponding problem domain's unit.
	 */
	double getFitness();

	/**
	 * @return Whether this objective should be maximized or minimized.
	 */
	default OptimizationType getOptimizationType() {
		return OptimizationType.MAXIMIZE;
	}

	@Override
	default int compareTo( final Fitness other ) {
		return Double.compare( getFitness(), other.getFitness() );
	}

}
