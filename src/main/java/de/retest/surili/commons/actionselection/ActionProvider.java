package de.retest.surili.commons.actionselection;

import java.util.List;

import de.retest.recheck.ui.descriptors.SutState;
import de.retest.surili.commons.actions.Action;

/**
 * Suggests possible actions for the current state.
 */
@FunctionalInterface
public interface ActionProvider {

	List<Action> getPossibleActions( SutState sutState );

}
