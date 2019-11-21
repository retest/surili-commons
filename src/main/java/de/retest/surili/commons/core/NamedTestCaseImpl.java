package de.retest.surili.commons.core;

import java.util.List;

import de.retest.surili.commons.actions.Action;
import lombok.NonNull;
import lombok.Value;

@Value
public class NamedTestCaseImpl implements NamedTestCase {

	private static final long serialVersionUID = 1L;

	@NonNull
	private final List<Action> actions;
	@NonNull
	private final String name;

	@Override
	public int getSize() {
		return actions.size();
	}

}
