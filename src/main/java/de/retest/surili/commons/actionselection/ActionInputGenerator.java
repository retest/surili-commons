package de.retest.surili.commons.actionselection;

import de.retest.recheck.ui.descriptors.Element;

/**
 * Suggests possible text inputs for the given element.
 */
@FunctionalInterface
public interface ActionInputGenerator {

	CharSequence[] getCharSequences( Element element );

}
