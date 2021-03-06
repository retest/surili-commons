package de.retest.surili.commons.core;

import java.util.List;

import de.retest.surili.commons.actions.Action;
import lombok.NonNull;
import lombok.Value;

@Value
public class TestCaseImpl implements TestCase {

	private static final long serialVersionUID = 1L;

	@NonNull
	private final List<Action> actions;

	@Override
	public int getSize() {
		return actions.size();
	}

}
