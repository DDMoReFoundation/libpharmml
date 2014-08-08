package eu.ddmore.libpharmml.dom.commontypes;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 *                 The type specifies the content of a matrix.
 *             
 * 
 * <p>Java class for MatrixType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatrixType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.pharmml.org/2013/03/CommonTypes}PharmMLRootType">
 *       &lt;sequence>
 *         &lt;element name="RowNames" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixColumnRowNames" minOccurs="0"/>
 *         &lt;element name="ColumnNames" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixColumnRowNames" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="MatrixRow" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixRowType" maxOccurs="unbounded"/>
 *           &lt;element name="MatrixCell" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixCellType" maxOccurs="unbounded"/>
 *           &lt;element name="MatrixBlock" type="{http://www.pharmml.org/2013/03/CommonTypes}MatrixBlockType" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="diagDefault" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *       &lt;attribute name="offDiagDefault" type="{http://www.w3.org/2001/XMLSchema}double" default="0" />
 *       &lt;attribute name="numbCols" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="numbRows" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="matrixType" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}Name">
 *             &lt;enumeration value="Any"/>
 *             &lt;enumeration value="Diagonal"/>
 *             &lt;enumeration value="LowerTriangular"/>
 *             &lt;enumeration value="UpperTriangular"/>
 *             &lt;enumeration value="Symmetric"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="symbId" type="{http://www.pharmml.org/2013/03/CommonTypes}SymbolIdType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlTransient
public class Matrix extends MatrixType {

    public MatrixColumnRowNames createRowNames(){
    	MatrixColumnRowNames rowNames = new MatrixColumnRowNames();
    	this.rowNames = rowNames;
    	return rowNames;
    }
    
    public MatrixColumnRowNames createColumnNames(){
    	MatrixColumnRowNames columnNames = new MatrixColumnRowNames();
    	this.columnNames = columnNames;
    	return columnNames;
    }
    
    public MatrixCell createCell(){
    	MatrixCell cell = new MatrixCell();
    	getListOfMatrixElements().add(cell);
    	return cell;
    }
    
    public MatrixCell createCell(MatrixVectorIndex rowIndex, MatrixVectorIndex columnIndex){
    	MatrixCell cell = createCell();
    	cell.setCellRow(rowIndex);
    	cell.setCellColumn(columnIndex);
    	return cell;
    }
    
    public MatrixCell createCell(MatrixVectorIndex rowIndex, MatrixVectorIndex columnIndex, VectorCellValue value){
    	MatrixCell cell = createCell(rowIndex,columnIndex);
    	cell.setValue(value);
    	return cell;
    }
    
    public MatrixBlock createBlock(){
    	MatrixBlock block = new MatrixBlock();
    	getListOfMatrixElements().add(block);
    	return block;
    }
    
    public MatrixBlock createBlock(MatrixVectorIndex rowStartIndex, MatrixVectorIndex columnStartIndex){
    	MatrixBlock block = createBlock();
    	block.setBlockStartRow(rowStartIndex);
    	block.setBlockStartColumn(columnStartIndex);
    	return block;
    }
    
    public MatrixRow createRow(){
    	MatrixRow row = new MatrixRow();
    	getListOfMatrixElements().add(row);
    	return row;
    }
    
    public MatrixRow createRow(double defaultValue){
    	MatrixRow row = createRow();
    	row.setDefault(defaultValue);
    	return row;
    }
    
    public MatrixRow createRow(double defaultValue, MatrixVectorIndex index){
    	MatrixRow row = createRow(defaultValue);
    	row.setRowIndex(index);
    	return row;
    }
    
    public MatrixRow createRow(VectorValue[] values){
    	MatrixRow row = createRow();
    	for(VectorValue value : values){
    		row.getListOfValues().add(value);
    	}
    	return row;
    }
    
    public MatrixRow createRow(VectorValue[] values, MatrixVectorIndex index){
    	MatrixRow row = createRow(values);
    	row.setRowIndex(index);
    	return row;
    }
    
}
