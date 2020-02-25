package de.retest.surili.commons.actionselection;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import de.retest.recheck.ui.descriptors.Element;
import de.retest.surili.commons.actionselection.ActionInputGenerator;

public class RandomInputGenerator implements ActionInputGenerator {

	private final Random rand;
	private final int maxSequences;
	private final int maxCharacters;

	public RandomInputGenerator( final long seed, final int maxSequences, final int maxCharacters ) {
		rand = new Random( seed );
		this.maxSequences = maxSequences;
		this.maxCharacters = maxCharacters;
	}

	@Override
	public CharSequence[] getCharSequences( final Element element ) {
		final int number = rand.nextInt( maxSequences ) + 1;
		final CharSequence[] values = new CharSequence[number];

		for ( int i = 0; i < number; i++ ) {
			values[i] = RandomStringUtils.random( rand.nextInt( maxCharacters ) + 1, 0, 0, true, true, null, rand );
		}

		return values;
	}
}
