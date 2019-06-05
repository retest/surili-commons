package de.retest.surili.commons.actions;

import java.util.Optional;

import de.retest.recheck.ui.descriptors.Element;
import lombok.NonNull;
import lombok.Value;

@Value
public class ChangeValueOfAction implements Action {

	private static final long serialVersionUID = 1L;

	@NonNull
	Element targetElement;
	@NonNull
	CharSequence[] keysToSend;

	@Override
	public Optional<Element> getTargetElement() {
		return Optional.of( targetElement );
	}

}
