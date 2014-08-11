package eu.ddmore.libpharmml.dom.commontypes;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * The type specifies the content of a matrix.
 * 
 * 
 * <p><h3>Encoding:</h3>
 * The definition of matrixes is similar to the definition of vectors (see {@link Vector}).
 * It is possible to define a matrix row-by-row using {@link MatrixRow} elements or to define
 * a sparse matrix with a few elements such as {@link MatrixBlock} objects or {@link MatrixCell}
 * objects.
 * 
 * <p>Some attributes allow to simplify the matrix encoding by only specifying explictly
 * a few values:
 * <p><ul>
 * <li><b>matrixType</b> (see {@link MatrixType.Type}):
 * 		<ul>
 * 		<li><b>Any</b>: no requirement on the matrix.</li>
 * 		<li><b>Diagonal</b>: only the diagonal values have to be specified, the rest is by definition zero.</li>
 * 		<li><b>LowerTriangular/UpperTriangular</b>: only diagonal and off-diagonal matrix elements
 * below or above the diagonal are non-zero and have to be specified, respectively.</li>
 * 		<li><b>Symmetric</b>: due to simmetry only the off-diagonal matrix elements below or above
 * the diagonal have to be specified.</li>
 * 		</ul>
 * </li>
 * <li><b>diagDefault</b>: sets all the diagonal values to a given default value.</li>
 * <li><b>offDiagDefault</b>: sets all the off-diagonal values to a given default value.</li>
 * </ul> 
 * 
 * <p><h3>Reading:</h3>
 * Any reference to the matrix can be done using a symbol reference (see {@link SymbolRefType}). It is
 * then mandatory to specifify a symbolId to that matrix.
 * It is also possible to refer to a subpart of a matrix using a {@link MatrixSelector} object. The
 * selector must also refers to the symbol id of that matrix.
 *             
 * 
 * <p><h3>Schema:</h3>
 * The following schema fragment specifies the expected content contained within this class.
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
	
	/**
	 * Empty constructor
	 */
	public Matrix(){
		super(0);
	}
	
	/**
	 * Constructs a matrix with the minimal required attributes
	 * @param symbolId Symbol of the matrix (may be null).
	 * @param type Matrix type.
	 */
	public Matrix(String symbolId, Matrix.Type type){
		this();
		this.setSymbId(symbolId);
		this.setMatrixType(type);
	}
	
	/**
	 * Constructs a matrix with the minimal required attributes for a sparse matrix.
	 * @param symbolId Symbol of the matrix (may be null).
	 * @param type Matrix type.
	 * @param numbCols Number of columns.
	 * @param numbRows Number of rows.
	 */
	public Matrix(String symbolId, Matrix.Type type, int numbCols, int numbRows){
		this(symbolId,type);
		this.setNumbCols(BigInteger.valueOf(numbCols));
		this.setNumbRows(BigInteger.valueOf(numbRows));
	}
	
	/**
	 * Constructs a matrix with the minimal required attributes for a sparse matrix that contains
	 * matrix blocks and/or matrix cells.
	 * @param symbolId Symbol of the matrix (may be null).
	 * @param type Matrix type.
	 * @param numbCols Number of columns.
	 * @param numbRows Number of rows.
	 * @param diagDefault Default value on the diagonal.
	 * @param offDiagDefault Default off-diagonal value.
	 */
	public Matrix(String symbolId, Matrix.Type type, int numbCols, int numbRows, 
			double diagDefault, double offDiagDefault){
		this(symbolId,type,numbCols,numbRows);
		this.setDiagDefault(diagDefault);
		this.setOffDiagDefault(offDiagDefault);
	}
	
	public void setMatrixType(Matrix.Type type){
		setMatrixType(type.toString());
	}

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
    
    public MatrixRow createRow(MatrixVectorIndex index, double defaultValue){
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
    
    public MatrixRow createRow(MatrixVectorIndex index, VectorValue[] values){
    	MatrixRow row = createRow(values);
    	row.setRowIndex(index);
    	return row;
    }
    
    /**
     * Enumerates the possible types of a matrix.
     * @author F. Yvon
     */
    public static enum Type {
    	/**
    	 * "Any" - 
    	 * No requirement on the matrix.
    	 */
    	ANY("Any"),
    	/**
    	 * "Diagonal" - 
    	 * Only the diagonal values have to be specified, the rest is by definition zero.
    	 */
    	DIAGONAL("Diagonal"),
    	/**
    	 * "LowerTriangular" - 
    	 * Only diagonal and off-diagonal matrix elements below the diagonal are non-zero and have to be specified.
    	 */
    	LOWER_TRIANGULAR("LowerTriangular"),
    	/**
    	 * "UpperTriangular" - 
    	 * Only diagonal and off-diagonal matrix elements above the diagonal are non-zero and have to be specified.
    	 */
    	UPPER_TRIANGULAR("UpperTriangular"),
    	/**
    	 * "Symmetric" - 
    	 * Due to simmetry only the off-diagonal matrix elements below or above the diagonal have to be specified.
    	 */
    	SYMMETRIC("Symmetric");
    	
    	private String type;
    	
    	Type(String type){
    		this.type = type;
    	}
    	
    	/**
    	 * Converts the enum value to the string version that apperas in PharmML files.
    	 */
    	@Override
    	public String toString() {
    		return this.type;
    	}
    }
    
}
