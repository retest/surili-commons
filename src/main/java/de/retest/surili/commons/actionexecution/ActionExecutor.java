package de.retest.surili.commons.actionexecution;

import de.retest.surili.commons.actions.Action;

/**
 * Executes one or more given {@link Action}s.
 */
@FunctionalInterface
public interface ActionExecutor {

	void execute();

}
