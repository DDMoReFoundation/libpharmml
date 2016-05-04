/*******************************************************************************
 * Copyright (c) 2014-2016 European Molecular Biology Laboratory,
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
package eu.ddmore.libpharmml.dom.modellingsteps;

import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.ddmore.libpharmml.dom.commontypes.Matrix;
import eu.ddmore.libpharmml.dom.commontypes.PharmMLRootType;
import eu.ddmore.libpharmml.dom.dataset.ExternalFile;
import eu.ddmore.libpharmml.util.ChainedList;


/**
 * Type defining the prior.
 * 
 * <p>Java class for PriorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/pharmml/0.7/CommonTypes}PharmMLRootType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.pharmml.org/pharmml/0.7/CommonTypes}Matrix"/>
 *         &lt;element name="File" type="{http://www.pharmml.org/pharmml/0.7/Dataset}ExternalFileType"/>
 *       &lt;/choice>
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/pharmml/0.7/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @since PharmML 0.7.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriorType", propOrder = {
    "matrix",
    "file"
})
public class Prior
    extends PharmMLRootType
{

    @XmlElement(name = "Matrix", namespace = NS_DEFAULT_CT)
    protected Matrix matrix;
    @XmlElement(name = "File")
    protected ExternalFile file;
    @XmlAttribute(name = "symbId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String symbId;

    /**
     * Gets the value of the matrix property.
     * 
     * @return
     *     possible object is
     *     {@link Matrix }
     *     
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Sets the value of the matrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matrix }
     *     
     */
    public void setMatrix(Matrix value) {
        this.matrix = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalFile }
     *     
     */
    public ExternalFile getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalFile }
     *     
     */
    public void setFile(ExternalFile value) {
        this.file = value;
    }

    /**
     * Gets the value of the symbId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbId() {
        return symbId;
    }

    /**
     * Sets the value of the symbId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbId(String value) {
        this.symbId = value;
    }
    
    @Override
    protected List<TreeNode> listChildren() {
    	return new ChainedList<TreeNode>(super.listChildren())
    			.addIfNotNull(matrix)
    			.addIfNotNull(file);
    }
    
    /**
     * Creates a new empty {@link Matrix} matrix element, adds it to the current object and returns it.
     * @return The created {@link Matrix} object.
     */
    public Matrix createMatrix(){
    	Matrix el = new Matrix();
    	this.matrix = el;
    	return el;
    }
    
    /**
     * Creates a new empty {@link Matrix} matrix element, adds it to the current object and returns it.
     * @param type The type of the matrix
     * @return The created {@link Matrix} object.
     */
    public Matrix createMatrix(Matrix.Type type){
    	Matrix el = new Matrix(type);
    	this.matrix = el;
    	return el;
    }

    /**
     * Creates a new empty {@link ExternalFile} file element, adds it to the current object and returns it.
     * @return The created {@link ExternalFile} object.
     */
    public ExternalFile createFile(){
    	ExternalFile el = new ExternalFile();
    	this.file = el;
    	return el;
    }

    /**
     * Creates a new {@link ExternalFile} file element, adds it to the current object and returns it.
     * @param oid
     * @param path
     * @param format
     * @param delimiter
     * @return The created {@link ExternalFile} object.
     */
    public ExternalFile createFile(String oid, String path, String format, String delimiter){
    	ExternalFile el = new ExternalFile(oid,path,format,delimiter);
    	this.file = el;
    	return el;
    }
    
    @Override
    public String toString() {
    	return super.toString()+" symbId:"+String.valueOf(symbId);
    }

}
