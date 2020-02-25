package de.retest.surili.commons.actionselection;

import java.util.Random;

import de.retest.recheck.ui.descriptors.Element;

public class RandomNaughtyStringsInputGenerator implements ActionInputGenerator {

	private final Random rand;

	public RandomNaughtyStringsInputGenerator( final long seed ) {
		rand = new Random( seed );
	}

	@Override
	public CharSequence[] getCharSequences( final Element element ) {
		final int numberOfNaughtyStrings = BigListOfNaughtyStrings.getBigListOfNaughtStrings().size();
		final int randomIndex = rand.nextInt( numberOfNaughtyStrings );
		final String naughtyString = BigListOfNaughtyStrings.getNaughtyStringAt( randomIndex );
		return new CharSequence[] { naughtyString };
	}
}
