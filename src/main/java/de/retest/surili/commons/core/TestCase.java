package de.retest.surili.commons.core;

import java.io.Serializable;
import java.util.List;

import de.retest.surili.commons.actions.Action;

public interface TestCase extends Serializable {

	String getName();

	List<Action> getActions();

}
