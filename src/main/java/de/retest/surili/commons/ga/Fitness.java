package de.retest.surili.commons.ga;

/**
 * Generic interface for representing fitness, be it variants of code coverage (e.g. statement coverage or branch
 * coverage) or something entirely different (e.g. found bugs or test length).
 */
public interface Fitness extends Comparable<Fitness> {

	/**
	 * @return Fitness measured in the corresponding problem domain's unit. As fitness is maximized, a higher value
	 *         indicates a better fitness.
	 */
	double getFitness();

	@Override
	default int compareTo( final Fitness other ) {
		return Double.compare( getFitness(), other.getFitness() );
	}

}
