package eu.ddmore.libpharmml.impl;

/**
 * @deprecated Namespace filtering is now handled by {@link NamespaceFilter}.
 */
@Deprecated
public class XMLFilter extends NamespaceFilter {

	public XMLFilter(PharmMLVersion writtenVersion) {
		super(writtenVersion);
	}

}
