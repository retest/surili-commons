package de.retest.surili.commons.core;

import java.util.List;
import java.util.Optional;

import de.retest.surili.commons.actions.Action;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class TestCaseImpl implements TestCase {

	private static final long serialVersionUID = 1L;

	private final String name;
	@NonNull
	private final List<Action> actions;

	public TestCaseImpl( final List<Action> actions ) {
		this( null, actions );
	}

	@Override
	public Optional<String> getName() {
		return Optional.ofNullable( name );
	}

	@Override
	public int getSize() {
		return actions.size();
	}

}
