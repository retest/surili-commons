package de.retest.surili.commons.actionselection;

import de.retest.recheck.ui.descriptors.Element;

/**
 * Suggests possible text inputs for the given element. The implementation may depend on the given technology like
 * HTML/JavaScript, Swing etc.
 */
@FunctionalInterface
public interface ActionInputGenerator {
	CharSequence[] getCharSequences( Element element );
}
