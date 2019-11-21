package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.List;

import de.retest.surili.commons.actions.Action;

/**
 * A test suite with a list (i.e. ordered) of {@link Action}s.
 */
public interface TestCase extends Serializable {

	/**
	 * @return The list of actions of this test case.
	 */
	List<Action> getActions();

	/**
	 * @return The number of actions of this test case.
	 */
	int getSize();

}
