package de.retest.surili.commons.ga;

/**
 * Generic interface for representing fitness, be it variants of code coverage (e.g. statement coverage or branch
 * coverage) or something entirely different.
 */
public interface Fitness {

	/**
	 * @return fitness measured in the corresponding problem domain's unit
	 */
	double getFitness();

}
