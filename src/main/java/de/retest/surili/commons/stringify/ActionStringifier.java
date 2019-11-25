package de.retest.surili.commons.stringify;

import de.retest.surili.commons.actions.Action;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ActionStringifier implements Stringifier<Action> {

	private final int indentationLevel;

	public ActionStringifier() {
		this( 0 );
	}

	@Override
	public String toString( final Action action ) {
		return Tabs.of( indentationLevel ) + action.toString();
	}

}
