package de.retest.surili.commons.actions;

import java.util.Optional;

import de.retest.recheck.ui.descriptors.Element;
import lombok.NonNull;
import lombok.Value;

@Value
public class NavigateToAction implements Action {

	private static final long serialVersionUID = 1L;

	@NonNull
	String url;

	@Override
	public Optional<Element> getTargetElement() {
		return Optional.empty();
	}

}
