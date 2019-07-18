package de.retest.surili.commons.ga;

import java.util.List;

import lombok.NonNull;
import lombok.Value;

/**
 * {@link Fitness} list to be optimized as part of a
 * <a href="https://en.wikipedia.org/wiki/Multi-objective_optimization">multi-objective optimization problem</a>.
 */
@Value
public class MultiObjectiveFitness {
	@NonNull
	List<Fitness> fitnessList;
}
