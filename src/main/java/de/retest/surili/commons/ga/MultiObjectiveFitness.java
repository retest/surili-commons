package de.retest.surili.commons.ga;

import java.util.List;

import lombok.NonNull;
import lombok.Value;

@Value
public class MultiObjectiveFitness {
	@NonNull
	List<Fitness> fitnessList;
}
