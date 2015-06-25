/*******************************************************************************
 * Copyright (c) 2014,2015 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 * 
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 * 
 *  		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 ******************************************************************************/
package eu.ddmore.libpharmml.dom.modeldefn.pkmacro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Class providing convenience for dealing with transfer rates.
 * 
 * <p>In PharmML, tranfer rates are formatted following the format <tt>kij</tt> or <tt>k_i_j</tt>, when
 * the transfer occurs from a compartment <tt>i</tt> (origin) to a compartment <tt>j</tt> (destination).
 * 
 * <p>The most robust way to create a TransferRate object is to use the construct {@link #TransferRate(Integer, Integer)}.
 * However it is also possible to construct a TransferRate from a string with {@link #TransferRate(String)}.
 * 
 * <p>The method {@link #toString()} is implemented in this class and may be used to translate the
 * transfer rate to a format compliant with PharmML definition (kij or k_i_j).
 * 
 * @author F. Yvon
 */
@XmlTransient
public class TransferRate {

	private Integer from;
	private Integer to;
	
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
	 * @param from Number of the inbound compartment (i).
	 * @param to Number of the outbound compartment (j).
	 */
	public TransferRate(Integer from, Integer to){
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Creates a transfer rate from a string. The string must be formatted as kij or k_i_j, otherwise
	 * an {@link IllegalArgumentException} will be thrown. In order to use this constructor without
	 * any risk, one should use the static method {@link #isValid(String)} to test the validity of the
	 * input string before.
	 * @param transferRate The transfer rate as a {@link String}.
	 * @throws IllegalArgumentException If the format of the transfer rate is incorrect.
	 */
	public TransferRate(String transferRate){
		for(String stringPattern : stringPatterns){
			Pattern p = Pattern.compile(stringPattern);
			Matcher m = p.matcher(transferRate);
			if(m.find()){
				this.from = Integer.valueOf(m.group(1));
				this.to = Integer.valueOf(m.group(2));
				break;
			}
		}
		if(this.from == null || this.to == null){
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
	 * Gets the number of the origin compartment of this transfer rate.
	 * @return The origin compartment number as an {@link Integer}.
	 */
	public Integer getFrom() {
		return from;
	}
	
	/**
	 * Sets the origin compartment number value.
	 * @param from The value must be between 0 and 99.
	 */
	public void setFrom(Integer from) {
		this.from = from;
	}
	
	/**
	 * Gets the number of the destination compartment of this transfer rate.
	 * @return The destination compartment number as an {@link Integer}.
	 */
	public Integer getTo() {
		return to;
	}
	
	/**
	 * Sets the destination compartment number value.
	 * @param to The value must be between 0 and 99.
	 */
	public void setTo(Integer to) {
		this.to = to;
	}
	
	/**
	 * Gets a standardised representation of the transfer rate, following the <tt>kij</tt> or 
	 * <tt>k_i_j</tt> format. If both origin and destination compartment numbers are only 1 digit,
	 * the <tt>kij</tt> format is used. Otherwise, the <tt>k_i_j</tt> format is used.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("k");
		if(from > 9 || to > 9){
			sb.append("_");
			sb.append(String.format("%02d", from));
			sb.append("_");
			sb.append(String.format("%02d", to)); 
		} else {
			sb.append(from);
			sb.append(to);
		}
		return sb.toString();
	}
	
}
