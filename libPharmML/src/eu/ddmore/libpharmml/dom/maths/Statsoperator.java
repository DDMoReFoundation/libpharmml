package eu.ddmore.libpharmml.dom.maths;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Description of the possible operators for statistics operations in PharmML, handled in the {@link Statsop} class.
 * @author F. Yvon
 * @since PharmML 0.8
 * @see Statsop
 */
@XmlEnum
public enum Statsoperator {
	
	@XmlEnumValue("centredMoment")
	CENTRED_MOMENT("centredMoment"),
	@XmlEnumValue("coefficientOfVariation")
	COEFFICIENT_OF_VARIATION("coefficientOfVariation"),
	@XmlEnumValue("correlation")
	CORRELATION("correlation"),
	@XmlEnumValue("decile")
	DECILE("decile"),
	@XmlEnumValue("geometricMean")
	GEOMETRIC_MEAN("geometricMean"),
	@XmlEnumValue("kurtosis")
	KURTOSIS("kurtosis"),
	@XmlEnumValue("mean")
	MEAN("mean"),
	@XmlEnumValue("median")
	MEDIAN("median"),
	@XmlEnumValue("mode")
	MODE("mode"),
	@XmlEnumValue("moment")
	MOMENT("moment"),
	@XmlEnumValue("percentile")
	PERCENTILE("percentile"),
	@XmlEnumValue("quantile")
	QUANTILE("quantile"),
	@XmlEnumValue("quartile")
	QUARTILE("quartile"),
	@XmlEnumValue("range")
	RANGE("range"),
	@XmlEnumValue("skewness")
	SKEWNESS("skewness"),
	@XmlEnumValue("standardDeviation")
	STANDARD_DEVATION("standardDeviation"),
	@XmlEnumValue("variance")
	VARIANCE("variance");
	
	private final String value;
	
	private Statsoperator(String value){
		this.value = value;
	}
	
	/**
	 * Gets the {@link String} value if this enum instance, as it is written in a PharmML file.
	 * @return The {@link String} value of this enum.
	 */
	public String value(){
		return value;
	}
	
	@Override
	public String toString() {
		return value();
	}
	
	/**
	 * Constructs a {@link Statsoperator} object from the given {@link String} value. The value must be valid 
	 * (compliant with the PharmML specification), otherwise an {@link IllegalArgumentException} is thrown.
	 * @param value The {@link String} version of a stats operator, compliant with the PharmML specification.
	 * @return A {@link Statsoperator} instance.
	 * @throws IllegalArgumentException If the input value is not compliant with the PharmML specification.
	 */
	public static Statsoperator fromValue(String value){
		for(Statsoperator statsop : values()){
			if(value.equals(statsop.value())){
				return statsop;
			}
		}
		throw new IllegalArgumentException(value);
	}

}
