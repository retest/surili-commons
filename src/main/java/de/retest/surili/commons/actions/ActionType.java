package de.retest.surili.commons.actions;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.Value;

/**
 * Every {@link Action} instance belongs to a certain action type. This abstraction helps to limit the number of
 * possible action types in a {@code SutState}. Target elements are represented by the unique path (e.g. XPath) of an
 * element.
 */
@Value
public class ActionType implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String EMPTY_TARGET_ELEMENT_PATH = "";

	@NonNull
	String elementPath;
	@NonNull
	String type;

	public static ActionType fromAction( final Action action ) {
		final String elementPath = action.getTargetElement()
				.map( element -> element.getIdentifyingAttributes().getPath() ).orElse( EMPTY_TARGET_ELEMENT_PATH );
		final String type = action.getClass().getName();
		return new ActionType( elementPath, type );
	}

	public static Set<ActionType> fromCollection( final Collection<Action> actions ) {
		return actions.stream().map( ActionType::fromAction ).collect( Collectors.toSet() );
	}
}
