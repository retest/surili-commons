package de.retest.surili.commons.actions;

import java.util.Optional;

import de.retest.recheck.ui.descriptors.Element;
import lombok.Value;

@Value
public class NavigateForwardAction implements Action {

	private static final long serialVersionUID = 1L;

	@Override
	public Optional<Element> getTargetElement() {
		return Optional.empty();
	}

}
