package de.retest.surili.commons.ga;

import java.util.List;

import lombok.NonNull;
import lombok.Value;


@Value
@NonNull
public class MultiObjectiveFitness {
	List<Fitness> fitnessList;
}
