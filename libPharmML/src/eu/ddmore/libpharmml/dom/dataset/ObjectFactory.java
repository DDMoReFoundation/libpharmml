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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 03:18:36 PM GMT 
//


package eu.ddmore.libpharmml.dom.dataset;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import static eu.ddmore.libpharmml.impl.NamespaceFilter.NS_DEFAULT_DS;;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.ddmore.libpharmml.dom.dataset package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
	
	private final static ObjectFactory instance = new ObjectFactory();

    private final static QName _Table_QNAME = new QName(NS_DEFAULT_DS, "Table");
    private final static QName _Definition_QNAME = new QName(NS_DEFAULT_DS, "Definition");
    private final static QName _TargetToolData_QNAME = new QName(NS_DEFAULT_DS, "TargetToolData");
    private final static QName _ColumnRef_QNAME = new QName(NS_DEFAULT_DS, "ColumnRef");
    private final static QName _ImportData_QNAME = new QName(NS_DEFAULT_DS, "ImportData");
    private final static QName _DataSet_QNAME = new QName(NS_DEFAULT_DS, "DataSet");
    private final static QName _ImportTargetData_QNAME = new QName(NS_DEFAULT_DS, "ImportTargetData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.dataset
     * 
     */
    public ObjectFactory() {
    }
    
    public static ObjectFactory getInstance(){
    	return instance;
    }

    /**
     * Create an instance of {@link ImportTargetData }
     * 
     */
    public ImportTargetData createImportTargetDataType() {
        return new ImportTargetData();
    }

    /**
     * Create an instance of {@link TargetToolDataSet }
     * 
     */
    public TargetToolDataSet createTargetToolDataSetType() {
        return new TargetToolDataSet();
    }

    /**
     * Create an instance of {@link DataSet }
     * 
     */
    public DataSet createDataSetType() {
        return new DataSet();
    }

    /**
     * Create an instance of {@link DataSetTable }
     * 
     */
    public DataSetTable createDataSetTableType() {
        return new DataSetTable();
    }

    /**
     * Create an instance of {@link ExternalFile }
     * 
     */
    public ExternalFile createImportDataType() {
        return new ExternalFile();
    }

    /**
     * Create an instance of {@link ColumnsDefinitionType }
     * 
     */
    @Deprecated
    public ColumnsDefinitionType createColumnsDefinitionType() {
        return new ColumnsDefinitionType();
    }

    /**
     * Create an instance of {@link ColumnReference }
     * 
     */
    public ColumnReference createColumnRefType() {
        return new ColumnReference();
    }

    /**
     * Create an instance of {@link DatasetRow }
     * 
     */
    public DatasetRow createDatasetRowType() {
        return new DatasetRow();
    }

    /**
     * Create an instance of {@link CategoryMapping }
     * 
     */
    public CategoryMapping createCategoryMappingType() {
        return new CategoryMapping();
    }

    /**
     * Create an instance of {@link CommonColumnDefinition }
     * 
     */
    public CommonColumnDefinition createCommonColumnDefnType() {
        return new CommonColumnDefinition();
    }

    /**
     * Create an instance of {@link ColumnMapping }
     * 
     */
    public ColumnMapping createColumnMappingType() {
        return new ColumnMapping();
    }

    /**
     * Create an instance of {@link ColumnDefinition }
     * 
     */
    public ColumnDefinition createColumnDefnType() {
        return new ColumnDefinition();
    }

    /**
     * Create an instance of {@link MapType }
     * 
     */
    public MapType createMapType() {
        return new MapType();
    }
    
    /**
<<<<<<< HEAD
     * Create an instance of {@link MissingDataMap }
     * 
     */
    public MissingDataMap createMissingDataMapType() {
        return new MissingDataMap();
    }

    /**
     * Create an instance of {@link HeaderDefinition }
     * 
     */
    public HeaderDefinition createHeaderDefinition() {
        return new HeaderDefinition();
    }

    /**
     * Create an instance of {@link HeaderRow }
     * 
     */
    public HeaderRow createHeaderRow() {
        return new HeaderRow();
    }
    
    /**
     * Create an instance of {@link IgnoreLine }
     * 
     * @since PharmML 0.6.1
     */
    public IgnoreLine createIgnoreLine() {
        return new IgnoreLine();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSetTable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "Table")
    public JAXBElement<DataSetTable> createTable(DataSetTable value) {
        return new JAXBElement<DataSetTable>(_Table_QNAME, DataSetTable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderColumnsDefinition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "Definition")
    public JAXBElement<HeaderColumnsDefinition> createDefinition(HeaderColumnsDefinition value) {
        return new JAXBElement<HeaderColumnsDefinition>(_Definition_QNAME, HeaderColumnsDefinition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetToolDataSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "TargetToolData")
    public JAXBElement<TargetToolDataSet> createTargetToolData(TargetToolDataSet value) {
        return new JAXBElement<TargetToolDataSet>(_TargetToolData_QNAME, TargetToolDataSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "ColumnRef")
    public JAXBElement<ColumnReference> createColumnRef(ColumnReference value) {
        return new JAXBElement<ColumnReference>(_ColumnRef_QNAME, ColumnReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExternalFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "ImportData")
    public JAXBElement<ExternalFile> createImportData(ExternalFile value) {
        return new JAXBElement<ExternalFile>(_ImportData_QNAME, ExternalFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "DataSet")
    public JAXBElement<DataSet> createDataSet(DataSet value) {
        return new JAXBElement<DataSet>(_DataSet_QNAME, DataSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportTargetData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = NS_DEFAULT_DS, name = "ImportTargetData")
    public JAXBElement<ImportTargetData> createImportTargetData(ImportTargetData value) {
        return new JAXBElement<ImportTargetData>(_ImportTargetData_QNAME, ImportTargetData.class, null, value);
    }

}
