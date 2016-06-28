package eu.ddmore.libpharmml.dom.tags;

import eu.ddmore.libpharmml.MathExpressionConverter;
import eu.ddmore.libpharmml.dom.PharmMLNode;

/**
 * Interface for any DOM object representing a math expression.
 * @author F. Yvon
 *
 */
public interface MathExpression extends PharmMLNode {
	
	/**
	 * Converts this object to a math expression. All its content is deeply converted via this method if it's available
	 * on children classes.
	 * @return A basic math expression as {@link String}.
	 */
	public String toMathExpression();
	
	/**
	 * Converts this object to a content MathML string. As this method is potentially executed as well on the children
	 * of this element, the returned MathML text is not wrapped into the root &lt;MathML> markup and contains 
	 * only the elements related to this object.
	 * @return This object as a content MathML {@link String}.
	 */
	public String toMathML();
	
	public String convert(MathExpressionConverter converter);
	
}
