import java.util.*;

public class Matrix {
	
	public static int TYPEFLOAT = 0x0002;
	public static int TYPEINT = 0x0001;
	
	int rowCount,columnCount;
	int [][]matrixIntData=null;
	float [][]matrixFloatData=null;
	
	//Add two matrix
	private static Matrix addIntMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException{
		if(matrixOne.getNumberOfRows() == matrixTwo.getNumberOfRows() && matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfColumn()){
			Matrix addedMatrix=new Matrix();
			addedMatrix.rowCount=matrixOne.getNumberOfRows();
			addedMatrix.columnCount=matrixOne.getNumberOfColumn();
			addedMatrix.createEmptyIntMatrix(addedMatrix.rowCount,addedMatrix.columnCount);
			for(int loopVariable = 0 ;loopVariable < addedMatrix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < addedMatrix.columnCount ;innerLoopVariable++){
						addedMatrix.matrixIntData[loopVariable][innerLoopVariable] = matrixOne.matrixIntData[loopVariable][innerLoopVariable] + matrixTwo.matrixIntData[loopVariable][innerLoopVariable];
				}
			}
			return addedMatrix;
		}
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0){
			throw new Matrix.MatrixException("Error adding matrix must have row and column > 0");
		}
		else{
			throw new Matrix.MatrixException("Error two matrix does not have same number of rows and column");
		}
	}
	
	private Matrix addIntMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		return (addIntMatrix(this,matrixTwo));
	}
	
	//Multiply int matrix
	private static Matrix multiplyIntMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException,Matrix.MatrixException.MatrixNullPointerException{
		if(matrixOne.matrixIntData == null || matrixTwo.matrixIntData == null)
			throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null.");
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0)
			throw new Matrix.MatrixException("Error adding matrix must have row and column > 0");
		else if(matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfRows()){
			Matrix multiplyMatix= new Matrix();
			multiplyMatix.rowCount=matrixOne.getNumberOfRows();
			multiplyMatix.columnCount=matrixTwo.getNumberOfColumn();
			multiplyMatix.createEmptyIntMatrix(multiplyMatix.rowCount,multiplyMatix.columnCount);
			int localMultiplyStorage = 0;
			for(int loopVariable = 0 ;loopVariable < multiplyMatix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < multiplyMatix.columnCount ;innerLoopVariable++){
					localMultiplyStorage=0;
					for(int mostinnerLoopVariable = 0 ;mostinnerLoopVariable < matrixOne.getNumberOfColumn() ;mostinnerLoopVariable++){
						localMultiplyStorage += matrixOne.matrixIntData[loopVariable][mostinnerLoopVariable] * matrixTwo.matrixIntData[mostinnerLoopVariable][innerLoopVariable];
					}
				multiplyMatix.matrixIntData[loopVariable][innerLoopVariable] = localMultiplyStorage;
				}
			}
			return multiplyMatix;
		}
		else
			throw new Matrix.MatrixException("First Matrix should have column equals to Second matrix row.");
	}
	
	private Matrix multiplyIntMatrix(Matrix matrixTwo)throws Matrix.MatrixException,Matrix.MatrixException.MatrixNullPointerException{
		return (multiplyIntMatrix(this,matrixTwo));
	}
	
	private static Matrix substractIntMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException{
		if(matrixOne.getNumberOfRows() == matrixTwo.getNumberOfRows() && matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfColumn()){
			Matrix addedMatrix=new Matrix();
			addedMatrix.rowCount=matrixOne.getNumberOfRows();
			addedMatrix.columnCount=matrixOne.getNumberOfColumn();
			addedMatrix.createEmptyIntMatrix(addedMatrix.rowCount,addedMatrix.columnCount);
			for(int loopVariable = 0 ;loopVariable < addedMatrix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < addedMatrix.columnCount ;innerLoopVariable++){
						addedMatrix.matrixIntData[loopVariable][innerLoopVariable] = matrixOne.matrixIntData[loopVariable][innerLoopVariable] - matrixTwo.matrixIntData[loopVariable][innerLoopVariable];
				}
			}
			return addedMatrix;
		}
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0){
			throw new Matrix.MatrixException("Error substracting matrix must have row and column > 0");
		}
		else{
			throw new Matrix.MatrixException("Error two matrix does not have same number of rows and column");
		}
	}
	
	private Matrix substractIntMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		return (substractIntMatrix(this,matrixTwo));
	}
	
	//Get ParsedMatrix
	public static Matrix parseIntMatrix(int [][]matrixIntData,int rowCount,int columnCount)throws Matrix.MatrixException{
		if(rowCount > 0 && columnCount > 0){
			Matrix newMatrix=new Matrix();
			newMatrix.matrixIntData=matrixIntData;
			newMatrix.rowCount=rowCount;
			newMatrix.columnCount=columnCount;
			return newMatrix;
		}
		else{
			throw new Matrix.MatrixException("Error cannot parse Matrix rowCount or columnCount is not > 0");
		}
	}
	
	public static Matrix parseIntMatrix(int [][]matrixIntData)throws Matrix.MatrixException{
		if(matrixIntData.length > 0 && matrixIntData[0].length > 0){
			Matrix newMatrix=new Matrix();
			newMatrix.matrixIntData=matrixIntData;
			newMatrix.rowCount=matrixIntData.length;
			newMatrix.columnCount=matrixIntData[0].length;
			return newMatrix;
		}
		else{
			throw new Matrix.MatrixException("Error cannot parse Matrix rowCount or columnCount is not > 0");
		}
	}

	private void traverseIntMatrix(){
		System.out.println("\nMatrix RxC = "+this.getNumberOfRows()+"x"+this.getNumberOfColumn());
		for(int loopVariable = 0 ;loopVariable < this.getNumberOfRows(); loopVariable++){
			for(int innerLoopVariable = 0 ;innerLoopVariable < this.getNumberOfColumn() ;innerLoopVariable++){
				System.out.print(this.matrixIntData[loopVariable][innerLoopVariable]+"   ");
			}
			System.out.println("");
		}
	}

	public void createEmptyIntMatrix(int rowCount,int columnCount){
		this.matrixIntData=new int[rowCount][columnCount];
	}
		
	//	Float Matrix
	public static Matrix parseFloatMatrix(float [][]matrixFloatData)throws Matrix.MatrixException{
		if(matrixFloatData.length > 0 && matrixFloatData[0].length > 0){
			Matrix newMatrix=new Matrix();
			newMatrix.matrixFloatData=matrixFloatData;
			newMatrix.rowCount=matrixFloatData.length;
			newMatrix.columnCount=matrixFloatData[0].length;
			return newMatrix;
		}
		else{
			throw new Matrix.MatrixException("Error cannot parse Matrix rowCount or columnCount is not > 0");
		}
	}

	//Get Parsed Float Matrix
	public static Matrix parseFloatMatrix(float [][]matrixFloatData,int rowCount,int columnCount)throws Matrix.MatrixException{
		if(rowCount > 0 && columnCount > 0){
			Matrix newMatrix=new Matrix();
			newMatrix.matrixFloatData=matrixFloatData;
			newMatrix.rowCount=rowCount;
			newMatrix.columnCount=columnCount;
			return newMatrix;
		}
		else{
			throw new Matrix.MatrixException("Error cannot parse Matrix rowCount or columnCount is not > 0");
		}
	}
	
	private void traverseFloatMatrix(){
		System.out.println("\nMatrix RxC = "+this.getNumberOfRows()+"x"+this.getNumberOfColumn());
		for(int loopVariable = 0 ;loopVariable < this.getNumberOfRows(); loopVariable++){
			for(int innerLoopVariable = 0 ;innerLoopVariable < this.getNumberOfColumn() ;innerLoopVariable++){
				System.out.print(this.matrixFloatData[loopVariable][innerLoopVariable]+"   ");
			}
			System.out.println("");
		}
	}	
	
	//Add two matrix
	private static Matrix addFloatMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException{
		if(matrixOne.getNumberOfRows() == matrixTwo.getNumberOfRows() && matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfColumn()){
			Matrix addedMatrix=new Matrix();
			addedMatrix.rowCount=matrixOne.getNumberOfRows();
			addedMatrix.columnCount=matrixOne.getNumberOfColumn();
			addedMatrix.createEmptyFloatMatrix(addedMatrix.rowCount,addedMatrix.columnCount);
			for(int loopVariable = 0 ;loopVariable < addedMatrix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < addedMatrix.columnCount ;innerLoopVariable++){
						addedMatrix.matrixFloatData[loopVariable][innerLoopVariable] = matrixOne.matrixFloatData[loopVariable][innerLoopVariable] + matrixTwo.matrixFloatData[loopVariable][innerLoopVariable];
				}
			}
			return addedMatrix;
		}
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0){
			throw new Matrix.MatrixException("Error adding matrix must have row and column > 0");
		}
		else{
			throw new Matrix.MatrixException("Error two matrix does not have same number of rows and column");
		}
	}
	
	private Matrix addFloatMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		return (addFloatMatrix(this,matrixTwo));
	}

		//Substract two matrix
	private static Matrix substractFloatMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException{
		if(matrixOne.getNumberOfRows() == matrixTwo.getNumberOfRows() && matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfColumn()){
			Matrix addedMatrix=new Matrix();
			addedMatrix.rowCount=matrixOne.getNumberOfRows();
			addedMatrix.columnCount=matrixOne.getNumberOfColumn();
			addedMatrix.createEmptyFloatMatrix(addedMatrix.rowCount,addedMatrix.columnCount);
			for(int loopVariable = 0 ;loopVariable < addedMatrix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < addedMatrix.columnCount ;innerLoopVariable++){
						addedMatrix.matrixFloatData[loopVariable][innerLoopVariable] = matrixOne.matrixFloatData[loopVariable][innerLoopVariable] - matrixTwo.matrixFloatData[loopVariable][innerLoopVariable];
				}
			}
			return addedMatrix;
		}
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0){
			throw new Matrix.MatrixException("Error adding matrix must have row and column > 0");
		}
		else{
			throw new Matrix.MatrixException("Error two matrix does not have same number of rows and column");
		}
	}
	
	private Matrix substractFloatMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		return (substractFloatMatrix(this,matrixTwo));
	}
	
	//Multiply int matrix
	private static Matrix multiplyFloatMatrix(Matrix matrixOne,Matrix matrixTwo)throws Matrix.MatrixException,Matrix.MatrixException.MatrixNullPointerException{
		if(matrixOne.matrixFloatData == null || matrixTwo.matrixFloatData == null)
			throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null.");
		else if(matrixOne.getNumberOfRows() == 0 || matrixTwo.getNumberOfRows() ==0 || matrixOne.getNumberOfColumn() == 0 || matrixTwo.getNumberOfColumn() == 0)
			throw new Matrix.MatrixException("Error adding matrix must have row and column > 0");
		else if(matrixOne.getNumberOfColumn() == matrixTwo.getNumberOfRows()){
			Matrix multiplyMatix= new Matrix();
			multiplyMatix.rowCount=matrixOne.getNumberOfRows();
			multiplyMatix.columnCount=matrixTwo.getNumberOfColumn();
			multiplyMatix.createEmptyFloatMatrix(multiplyMatix.rowCount,multiplyMatix.columnCount);
			float localMultiplyStorage = 0;
			for(int loopVariable = 0 ;loopVariable < multiplyMatix.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < multiplyMatix.columnCount ;innerLoopVariable++){
					localMultiplyStorage=0;
					for(int mostinnerLoopVariable = 0 ;mostinnerLoopVariable < matrixOne.getNumberOfColumn() ;mostinnerLoopVariable++){
						localMultiplyStorage += matrixOne.matrixFloatData[loopVariable][mostinnerLoopVariable] * matrixTwo.matrixFloatData[mostinnerLoopVariable][innerLoopVariable];
					}
				multiplyMatix.matrixFloatData[loopVariable][innerLoopVariable] = localMultiplyStorage;
				}
			}
			return multiplyMatix;
		}
		else
			throw new Matrix.MatrixException("First Matrix should have column equals to Second matrix row.");
	}
	
	private Matrix multiplyFloatMatrix(Matrix matrixTwo)throws Matrix.MatrixException,Matrix.MatrixException.MatrixNullPointerException{
		return (multiplyFloatMatrix(this,matrixTwo));
	}
	
	public void createEmptyFloatMatrix(int rowCount,int columnCount){
		this.matrixFloatData=new float[rowCount][columnCount];
	}
	
	//Add matrix
	public Matrix addMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		if(this.matrixFloatData == null && matrixTwo.matrixFloatData == null)
			return (addIntMatrix(this,matrixTwo));
		else if(this.matrixIntData == null && matrixTwo.matrixIntData == null)
			return (addFloatMatrix(this,matrixTwo));
		else
			throw new Matrix.MatrixException("Error cannot add different type of matrices.");
	}

	//Substract matrix
	public Matrix substractMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		if(this.matrixFloatData == null && matrixTwo.matrixFloatData == null)
			return (substractIntMatrix(this,matrixTwo));
		else if(this.matrixIntData == null && matrixTwo.matrixIntData == null)
			return (substractFloatMatrix(this,matrixTwo));
		else
			throw new Matrix.MatrixException("Error cannot substract different type of matrices.");
	}	
		
	//Multiply matrix
	public Matrix multiplyMatrix(Matrix matrixTwo)throws Matrix.MatrixException{
		if(this.matrixFloatData == null && matrixTwo.matrixFloatData == null)
			return (multiplyIntMatrix(this,matrixTwo));
		else if(this.matrixIntData == null && matrixTwo.matrixIntData == null)
			return (multiplyFloatMatrix(this,matrixTwo));
		else
			throw new Matrix.MatrixException("Error cannot multiply different type of matrices.");
	}
	
	//Traverse Matrix
	public void traverseMatrix()throws Matrix.MatrixException{
		if(this.matrixFloatData == null)
			this.traverseIntMatrix();
		else if(this.matrixIntData == null)
			this.traverseFloatMatrix();
		else
			throw new Matrix.MatrixException("Error cannot traverse empty matrix.");
	}

	//Trival matrix
	public boolean isTrivialMatrix(){
		boolean checkTrivial=true;
		if(this.matrixIntData == null){
			for(int loopVariable = 0 ;loopVariable < this.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < this.columnCount ;innerLoopVariable++){
					if(this.matrixFloatData[loopVariable][innerLoopVariable] != 0){
						checkTrivial=false;
						break;
					}
				}
				if(!checkTrivial)
					break;
			}
		return checkTrivial;
		}
		else{
			for(int loopVariable = 0 ;loopVariable < this.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < this.columnCount ;innerLoopVariable++){
					if(this.matrixIntData[loopVariable][innerLoopVariable] != 0){
						checkTrivial=false;
						break;
					}
				}
				if(!checkTrivial)
					break;
			}
		return checkTrivial;
		}
	}
	
	//is identity matrix
	public boolean isIdentityMatrix()throws Matrix.MatrixException{
		boolean checkIdentityMatrix = true;
		if(this.matrixIntData == null){
			if(this.rowCount != this.columnCount){
				throw new Matrix.MatrixException("Identity matrix must have same number of row and column");
			}
			for(int loopVariable = 0 ;loopVariable < this.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < this.columnCount ;innerLoopVariable++){
					if((this.matrixFloatData[loopVariable][innerLoopVariable] != 0 && loopVariable != innerLoopVariable) || (this.matrixFloatData[loopVariable][innerLoopVariable] != 1 && loopVariable == innerLoopVariable)){
						checkIdentityMatrix=false;
						break;
					}
				}
				if(!checkIdentityMatrix)
					break;
			}
		return checkIdentityMatrix;
		}
		else{
			if(this.rowCount != this.columnCount){
				throw new Matrix.MatrixException("Identity matrix must have same number of row and column");
			}
			for(int loopVariable = 0 ;loopVariable < this.rowCount; loopVariable++){
				for(int innerLoopVariable = 0 ;innerLoopVariable < this.columnCount ;innerLoopVariable++){
					if((this.matrixIntData[loopVariable][innerLoopVariable] != 0 && loopVariable != innerLoopVariable) || (this.matrixIntData[loopVariable][innerLoopVariable] != 1 && loopVariable == innerLoopVariable)){
						checkIdentityMatrix=false;
						break;
					}
				}
				if(!checkIdentityMatrix)
					break;
			}
		return checkIdentityMatrix;
		}
	}
	
	//Get particular item
	public int getIntItem(int positionRow, int positionColumn)throws Matrix.MatrixException.MatrixNullPointerException, ArrayIndexOutOfBoundsException{
		if(this.matrixIntData == null)
			throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null");
		return matrixIntData[positionRow][positionColumn];
	}
	
	public float getFloatItem(int positionRow, int positionColumn)throws Matrix.MatrixException.MatrixNullPointerException, ArrayIndexOutOfBoundsException{
		if(this.matrixFloatData == null)
			throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null");
		return matrixFloatData[positionRow][positionColumn];
	}
	
	//Get matrix Rows
	public int getNumberOfRows(){
		return this.rowCount;
	}
	
	//Get matrix Column
	public int getNumberOfColumn(){
		return this.columnCount;
	}
	
	public int[][] matrixToInt()throws Matrix.MatrixException.MatrixNullPointerException{
		if(this.matrixIntData == null)
		throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null. Is it float type of matrix?");
		return this.matrixIntData;
	}
	
	public float[][] matrixToFloat()throws Matrix.MatrixException.MatrixNullPointerException{
		if(this.matrixFloatData == null)
		throw new Matrix.MatrixException.MatrixNullPointerException("Matrix is null. Is it int type of matrix?");
		return this.matrixFloatData;
	}
	
	static class MatrixException extends Exception{
		MatrixException(String message){
			super(message);
		}
		static class MatrixNullPointerException extends MatrixException{
			MatrixNullPointerException(String message){
				super(message);
			}
		}
	}
}
