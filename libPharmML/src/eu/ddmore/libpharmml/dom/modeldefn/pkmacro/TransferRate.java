package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Class providing convenience for dealing with transfer rates.
 * 
 * <p>In PharmML, tranfer rates are formatted following the format <tt>kij</tt> or <tt>k_i_j</tt>, when
 * the transfer occurs from a compartment <tt>j</tt> (output) to a compartment <tt>i</tt> (input).
 * 
 * @author F. Yvon
 */
@XmlTransient
public class TransferRate {

	private Integer inbound;
	private Integer outbound;
	
	/**
	 * Patterns of valid transfer rates. These patterns correspond to the ones in the PharmML-0.5
	 * schema.
	 */
	private static final String[] stringPatterns = {
			"^k([0-9])([0-9])$",
			"^k([0-9][0-9])([0-9][0-9])$",
			"^k_([0-9])_([0-9])$",
			"^k_([0-9][0-9])_([0-9][0-9])$"
	};
	
	/**
	 * Creates a transfer rate from the given inbound compartment number and the given
	 * outbound compartment number.
	 * @param inbound Number of the inbound compartment (i).
	 * @param outbound Number of the outbound compartment (j).
	 */
	public TransferRate(Integer inbound, Integer outbound){
		this.inbound = inbound;
		this.outbound = outbound;
	}
	
	/**
	 * Creates a transfer rate from a string. The string must be formatted as kij or k_i_j, otherwise
	 * an {@link IllegalArgumentException} will be thrown. In order to use this constructor without
	 * any risk, one should use the static method {@link #isValid(String)} to test the validity of the
	 * input string before.
	 * @param transferRate The transfer rate as a {@link String}.
	 */
	public TransferRate(String transferRate){
		for(String stringPattern : stringPatterns){
			Pattern p = Pattern.compile(stringPattern);
			Matcher m = p.matcher(transferRate);
			if(m.find()){
				this.inbound = Integer.valueOf(m.group(1));
				this.outbound = Integer.valueOf(m.group(2));
				break;
			}
		}
		if(this.inbound == null || this.outbound == null){
			throw new IllegalArgumentException("String \""+transferRate+"\" is not a valid transfer rate");
		}
	}
	
	/**
	 * Checks if the input string is compliant with the transfer rate format (kij or k_i_j).
	 * The string must be compliant with 1 of the following regex:
	 * <p><pre>
	 * ^k([0-9])([0-9])$,
	 * ^k([0-9][0-9])([0-9][0-9])$,
	 * ^k_([0-9])_([0-9])$,
	 * ^k_([0-9][0-9])_([0-9][0-9])$
	 * </pre>
	 * 
	 * @param transferRate The string to test.
	 * @return true if the string is valid, false if not.
	 */
	public static boolean isValid(String transferRate){
		for(String stringPattern : stringPatterns){
			Pattern p = Pattern.compile(stringPattern);
			Matcher m = p.matcher(transferRate);
			if(m.find()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the number of the inbound compartment of this transfer rate.
	 * @return The inbound compartment number as an {@link Integer}.
	 */
	public Integer getInbound() {
		return inbound;
	}
	
	/**
	 * Sets the inbound compartment number value.
	 * @param outbound The value must be between 0 and 99.
	 */
	public void setInbound(Integer inbound) {
		this.inbound = inbound;
	}
	
	/**
	 * Gets the number of the outbound compartment of this transfer rate.
	 * @return The outbound compartment number as an {@link Integer}.
	 */
	public Integer getOutbound() {
		return outbound;
	}
	
	/**
	 * Sets the outbound compartment number value.
	 * @param outbound The value must be between 0 and 99.
	 */
	public void setOutbound(Integer outbound) {
		this.outbound = outbound;
	}
	
	/**
	 * Gets a standardised representation of the transfer rate, following the <tt>kij</tt> or <tt>k_i_j</tt> 
	 * format. If both inbound and outbound compartment numbers are only 1 digit, the <tt>kij</tt> form is used. 
	 * Otherwise, the <tt>k_i_j</tt> form is used.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("k");
		if(inbound > 9 || outbound > 9){
			sb.append("_");
			sb.append(String.format("%02d", inbound));
			sb.append("_");
			sb.append(String.format("%02d", outbound)); 
		} else {
			sb.append(inbound);
			sb.append(outbound);
		}
		return sb.toString();
	}
	
}
