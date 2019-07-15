package de.retest.surili.commons.ga;

import java.util.List;
import lombok.Value;


@Value
public class MultiObjectiveFitness {
	List<Fitness> fitnessList;
}
