package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

import eu.ddmore.libpharmml.dom.maths.Equation;

/**
 * Interface for every element that contains an assign element.
 * @author F. Yvon
 *
 */
@XmlTransient
public interface Assignable {

	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param scalar The value of the assignment as a {@link Scalar}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Scalar scalar);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param equation The value of the assignment as a {@link Equation}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Equation equation);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param symbolRef The value of the assignment as a {@link SymbolRefType}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(SymbolRefType symbolRef);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param sequence The value of the assignment as a {@link SequenceType}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(SequenceType sequence);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param vector The value of the assignment as a {@link VectorType}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(VectorType vector);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param interpolation The value of the assignment as a {@link InterpolationType}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(InterpolationType interpolation);
	
	/**
	 * Creates a new {@link Rhs} element, assigns it to the current element and returns it.
	 * @param matrix The value of the assignment as a {@link Matrix}.
	 * @return The created {@link Rhs} assign element.
	 */
	public Rhs assign(Matrix matrix);
	
}
