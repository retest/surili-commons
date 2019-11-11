package de.retest.surili.commons.util;

import java.util.Random;

public class RandomUtil {

	public static double requireProbability( final double probability ) {
		if ( probability < 0.0 || probability > 1.0 ) {
			throw new IllegalArgumentException( "The given probability is not in the range [0, 1]: " + probability );
		}
		return probability;
	}

	public static boolean randomBoolean( final Random random, final double probability ) {
		return random.nextDouble() <= requireProbability( probability );
	}

}
