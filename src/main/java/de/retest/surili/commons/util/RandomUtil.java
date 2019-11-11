package de.retest.surili.commons.util;

public class RandomUtil {

	public static double requireProbability( final double probability ) {
		if ( probability < 0.0 || probability > 1.0 ) {
			throw new IllegalArgumentException( "The given probability is not in the range [0, 1]: " + probability );
		}
		return probability;
	}

}
