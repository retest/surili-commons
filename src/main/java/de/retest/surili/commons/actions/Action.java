package de.retest.surili.commons.actions;

import java.io.Serializable;
import java.util.Optional;

import de.retest.recheck.ui.descriptors.Element;

public interface Action extends Serializable {

	Optional<Element> getTargetElement();

}
