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

	/**
	 * Creates an empty {@link MatrixColumnRowNames} element for row names in that matrix and returns it.
	 * @return The created {@link MatrixColumnRowNames} object.
	 */
    public MatrixColumnRowNames createRowNames(){
    	MatrixColumnRowNames rowNames = new MatrixColumnRowNames();
    	this.rowNames = rowNames;
    	return rowNames;
    }
    
    /**
     * Creates an empty {@link MatrixColumnRowNames} element for column names in that matrix and returns it.
	 * @return The created {@link MatrixColumnRowNames} object.
     */
    public MatrixColumnRowNames createColumnNames(){
    	MatrixColumnRowNames columnNames = new MatrixColumnRowNames();
    	this.columnNames = columnNames;
    	return columnNames;
    }
    
    /**
     * Creates an empty matrix cell into that matrix and returns it.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(){
    	MatrixCell cell = new MatrixCell();
    	getListOfMatrixElements().add(cell);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(int rowIndex, int columnIndex){
    	return createMatrixCell(new MatrixVectorIndex(rowIndex), new MatrixVectorIndex(columnIndex));
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @param value The value of the cell as real, that will be wrapped into a {@link RealValue}.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(int rowIndex, int columnIndex, double value){
    	MatrixCell cell = createMatrixCell(rowIndex,columnIndex);
    	cell.createRealValue(value);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @param value The value of the cell as integer, that will be wrapped into a {@link IntValue}.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(int rowIndex, int columnIndex, int value){
    	MatrixCell cell = createMatrixCell(rowIndex,columnIndex);
    	cell.createIntValue(value);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @param value The value of the cell as boolean, that will be wrapped into a {@link BooleanValue}.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(int rowIndex, int columnIndex, boolean value){
    	MatrixCell cell = createMatrixCell(rowIndex,columnIndex);
    	cell.createBooleanValue(value);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @param value The value of the cell as string, that will be wrapped into a {@link StringValue}.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(int rowIndex, int columnIndex, String value){
    	MatrixCell cell = createMatrixCell(rowIndex,columnIndex);
    	cell.createStringValue(value);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(MatrixVectorIndex rowIndex, MatrixVectorIndex columnIndex){
    	MatrixCell cell = createMatrixCell();
    	cell.setCellRow(rowIndex);
    	cell.setCellColumn(columnIndex);
    	return cell;
    }
    
    /**
     * Creates a matrix cell into that matrix and returns it.
     * @param rowIndex The row index of the cell within the parent matrix.
     * @param columnIndex The column index of the cell within the parent matrix.
     * @param value The abstracted value of the cell. May be {@link Scalar} or {@link SymbolRefType}.
     * @return The create {@link MatrixCell} object.
     */
    public MatrixCell createMatrixCell(MatrixVectorIndex rowIndex, MatrixVectorIndex columnIndex, MatrixCellValue value){
    	MatrixCell cell = createMatrixCell(rowIndex,columnIndex);
    	cell.setValue(value);
    	return cell;
    }
    
    /**
     * Creates an empty {@link MatrixBlock} element into that matrix and returns it.
     * @return The created {@link MatrixBlock} object.
     */
    public MatrixBlock createMatrixBlock(){
    	MatrixBlock block = new MatrixBlock();
    	getListOfMatrixElements().add(block);
    	return block;
    }
    
    /**
     * Creates a {@link MatrixBlock} element into that matrix and returns it.
     * @param rowStartIndex The start row index of this block within the parent matrix.
     * @param columnStartIndex The start column index of this block within the parant matrix.
     * @return The created {@link MatrixBlock} object.
     */
    public MatrixBlock createMatrixBlock(MatrixVectorIndex rowStartIndex, MatrixVectorIndex columnStartIndex){
    	MatrixBlock block = createMatrixBlock();
    	block.setBlockStartRow(rowStartIndex);
    	block.setBlockStartColumn(columnStartIndex);
    	return block;
    }
    
    /**
     * Creates an empty {@link MatrixRow} element into that matrix and returns it.
     * @return The created {@link MatrixRow} element.
     */
    public MatrixRow createMatrixRow(){
    	MatrixRow row = new MatrixRow();
    	getListOfMatrixElements().add(row);
    	return row;
    }
    
    /**
     * Creates a {@link MatrixRow} element with default value into that matrix and returns it.
     * @param defaultValue Default value of the row elements.
     * @return The created {@link MatrixRow} element.
     */
    public MatrixRow createMatrixRow(double defaultValue){
    	MatrixRow row = createMatrixRow();
    	row.setDefault(defaultValue);
    	return row;
    }
    
    /**
     * Creates a {@link MatrixRow} element with default value at the given index and returns it.
     * @param index Index of that row within the parent matrix.
     * @param defaultValue Default value of the row elements.
     * @return The created {@link MatrixRow} element.
     */
    public MatrixRow createMatrixRow(MatrixVectorIndex index, double defaultValue){
    	MatrixRow row = createMatrixRow(defaultValue);
    	row.setRowIndex(index);
    	return row;
    }
    
    /**
     * Creates a {@link MatrixRow} element with specified elements and returns it.
     * @param values Elements of the row.
     * @return The created {@link MatrixRow} element.
     */
    public MatrixRow createMatrixRow(VectorValue[] values){
    	MatrixRow row = createMatrixRow();
    	for(VectorValue value : values){
    		row.getListOfValues().add(value);
    	}
    	return row;
    }
    
    /**
     * Creates a {@link MatrixRow} element with specified elements at the given index and returns it.
     * @param index Index of that row within the parent matrix.
     * @param values Elements of the row.
     * @return The created {@link MatrixRow} element.
     */
    public MatrixRow createMatrixRow(MatrixVectorIndex index, VectorValue[] values){
    	MatrixRow row = createMatrixRow(values);
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
