/*******************************************************************************
 * Copyright (c) 2014 European Molecular Biology Laboratory,
 * Heidelberg, Germany.
 *
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of
 * the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations 
 * under the License.
 *******************************************************************************/
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

    private final static QName _Table_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "Table");
    private final static QName _Definition_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "Definition");
    private final static QName _TargetToolData_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "TargetToolData");
    private final static QName _ColumnRef_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "ColumnRef");
    private final static QName _ImportData_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "ImportData");
    private final static QName _DataSet_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "DataSet");
    private final static QName _ImportTargetData_QNAME = new QName("http://www.pharmml.org/2013/08/Dataset", "ImportTargetData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.ddmore.libpharmml.dom.dataset
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ImportTargetDataType }
     * 
     */
    public ImportTargetDataType createImportTargetDataType() {
        return new ImportTargetDataType();
    }

    /**
     * Create an instance of {@link TargetToolDataSetType }
     * 
     */
    public TargetToolDataSetType createTargetToolDataSetType() {
        return new TargetToolDataSetType();
    }

    /**
     * Create an instance of {@link DataSet }
     * 
     */
    public DataSet createDataSetType() {
        return new DataSet();
    }

    /**
     * Create an instance of {@link DataSetTableType }
     * 
     */
    public DataSetTableType createDataSetTableType() {
        return new DataSetTableType();
    }

    /**
     * Create an instance of {@link ImportDataType }
     * 
     */
    public ImportDataType createImportDataType() {
        return new ImportDataType();
    }

    /**
     * Create an instance of {@link ColumnsDefinitionType }
     * 
     */
    public ColumnsDefinitionType createColumnsDefinitionType() {
        return new ColumnsDefinitionType();
    }

    /**
     * Create an instance of {@link ColumnRefType }
     * 
     */
    public ColumnRefType createColumnRefType() {
        return new ColumnRefType();
    }

    /**
     * Create an instance of {@link DatasetRowType }
     * 
     */
    public DatasetRowType createDatasetRowType() {
        return new DatasetRowType();
    }

    /**
     * Create an instance of {@link CategoryMapping }
     * 
     */
    public CategoryMapping createCategoryMappingType() {
        return new CategoryMapping();
    }

    /**
     * Create an instance of {@link CommonColumnDefnType }
     * 
     */
    public CommonColumnDefnType createCommonColumnDefnType() {
        return new CommonColumnDefnType();
    }

    /**
     * Create an instance of {@link ColumnMappingType }
     * 
     */
    public ColumnMappingType createColumnMappingType() {
        return new ColumnMappingType();
    }

    /**
     * Create an instance of {@link ColumnDefnType }
     * 
     */
    public ColumnDefnType createColumnDefnType() {
        return new ColumnDefnType();
    }

    /**
     * Create an instance of {@link MapType }
     * 
     */
    public MapType createMapType() {
        return new MapType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSetTableType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "Table")
    public JAXBElement<DataSetTableType> createTable(DataSetTableType value) {
        return new JAXBElement<DataSetTableType>(_Table_QNAME, DataSetTableType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnsDefinitionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "Definition")
    public JAXBElement<ColumnsDefinitionType> createDefinition(ColumnsDefinitionType value) {
        return new JAXBElement<ColumnsDefinitionType>(_Definition_QNAME, ColumnsDefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetToolDataSetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "TargetToolData")
    public JAXBElement<TargetToolDataSetType> createTargetToolData(TargetToolDataSetType value) {
        return new JAXBElement<TargetToolDataSetType>(_TargetToolData_QNAME, TargetToolDataSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ColumnRefType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "ColumnRef")
    public JAXBElement<ColumnRefType> createColumnRef(ColumnRefType value) {
        return new JAXBElement<ColumnRefType>(_ColumnRef_QNAME, ColumnRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "ImportData")
    public JAXBElement<ImportDataType> createImportData(ImportDataType value) {
        return new JAXBElement<ImportDataType>(_ImportData_QNAME, ImportDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "DataSet")
    public JAXBElement<DataSet> createDataSet(DataSet value) {
        return new JAXBElement<DataSet>(_DataSet_QNAME, DataSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImportTargetDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.pharmml.org/2013/08/Dataset", name = "ImportTargetData")
    public JAXBElement<ImportTargetDataType> createImportTargetData(ImportTargetDataType value) {
        return new JAXBElement<ImportTargetDataType>(_ImportTargetData_QNAME, ImportTargetDataType.class, null, value);
    }

}
