package de.retest.surili.commons.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.retest.recheck.ui.descriptors.Attributes;
import de.retest.recheck.ui.descriptors.Element;
import de.retest.recheck.ui.descriptors.IdentifyingAttributes;
import de.retest.recheck.ui.descriptors.RootElement;
import de.retest.recheck.ui.descriptors.StringAttribute;
import de.retest.recheck.ui.descriptors.SutState;
import de.retest.recheck.ui.image.Screenshot;

public final class TestUtil {

	private TestUtil() {}

	/**
	 * Creates a new SutState which is equal to another SutState if they contain equal collections of root elements.
	 *
	 * @param rootElements
	 * 		The collection of root elements of the SutState.
	 * @return A new SutState.
	 */
	public static SutState createSutState( final RootElement... rootElements ) {
		return new SutState( Arrays.asList( rootElements ) );
	}

	/**
	 * Creates a new root element using the given identifying attributes value and number of child elements. Other root
	 * elements with the same identifying attributes value and number of children should be equal.
	 *
	 * @param identifyingAttributesValue
	 * 		Used as an identifying attributes value to ensure equality as long as the number of children is the same.
	 * @param numberOfChildren
	 * 		The number of contained components of the root element.
	 * @return A new root element.
	 */
	public static RootElement getRootElement( final String identifyingAttributesValue, final int numberOfChildren ) {
		final RootElement rootElement =
				new RootElement( "retestId", getIdentifyingAttributes( identifyingAttributesValue ),
						new Attributes(),
						new Screenshot( "prefix", new byte[] { 1, 2, 3 }, Screenshot.ImageType.PNG ), "screen0",
						0,
						"My Window" );
		if ( numberOfChildren > 0 ) {
			final List<Element> children = new ArrayList<>();

			for ( int i = 0; i < numberOfChildren; i++ ) {
				children.add( getElement( rootElement, i ) );
			}
			rootElement.addChildren( children );
		}

		return rootElement;
	}

	private static IdentifyingAttributes getIdentifyingAttributes( final String identifyingAttributesValue ) {
		return new IdentifyingAttributes( Arrays.asList( new StringAttribute( "a", identifyingAttributesValue ),
				new StringAttribute( "b", identifyingAttributesValue ),
				new StringAttribute( "c", identifyingAttributesValue ) ) );
	}

	private static Element getElement( final Element parent, final int index ) {
		return Element.create( "retestId", parent, getIdentifyingAttributes( "child" + index ), new Attributes(),
				new Screenshot( "prefix", new byte[] { 1, 2, 3 }, Screenshot.ImageType.PNG ) );
	}
}
