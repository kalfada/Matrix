/**
 * This class represents a matrix that represent by
 * two-dimensional array.
 * @author Daniel Kalfa
 * @version 15.04.2019
 */
public class Matrix {
	private int[][] _matrix;
	private final int BLACK = 255;
	/**
	 * Construct a size1 by size2 Matrix of zeroes.
	 * @param size1 the number of lines
	 * @param size2 the number of columns
	 */
	public Matrix(int size1, int size2) {
		_matrix = new int[size1][size2];
	}
	/**
	 * Constructs and initializes a Matrix array from a
	 * given array.
	 * @param array the given array for the initialize
	 */
	public Matrix(int[][] array) {
 		this._matrix = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				this._matrix[i][j] = array[i][j];
			}
		}
	}
	/**
	 * Returns a string representation of this Matrix object.
	 */
	public String toString(){
		String string = "";
		for (int i = 0; i < this._matrix.length; i++) {
			for (int j = 0; j < this._matrix[0].length; j++) {
				string += (this._matrix[i][j]);
				if (j != this._matrix[0].length - 1) {
					string += "\t";
				}
			}
			string += "\n";
		}
		return string;
	}
	/**
	 * Create a negative matrix from the original one.
	 * @return the new matrix that have been set negative
	 */
	public Matrix makeNegative(){
		Matrix negativeMatrix = new Matrix(this._matrix);
		for (int i = 0; i < negativeMatrix._matrix.length; i++) {
			for (int j = 0; j < negativeMatrix._matrix[i].length; j++) {
				negativeMatrix._matrix[i][j] = BLACK - negativeMatrix._matrix[i][j];
			}
		}
		return negativeMatrix;
	}
	/**
	 * Create an filter matrix from the original one.
	 * @return the new Matrix that have been filtered
	 */
	public Matrix imageFilterAverage(){
		Matrix filterMatrix = new Matrix(this._matrix);
		for (int i = 0; i < filterMatrix._matrix.length; i++) {
			for (int j = 0; j < filterMatrix._matrix[i].length; j++) {
				filterMatrix._matrix[i][j] = averageOfNeighbors(i, j);
			}
		}
		return filterMatrix;
	}
	/**
	 * Rotate the matrix 90 degrees to the right. 
	 * @return the new matrix that rotated
	 */
	public Matrix rotateClockwise(){
		Matrix rotateMatrix = new Matrix(this._matrix[0].length,this._matrix.length);
		for (int i = 0; i < rotateMatrix._matrix.length; i++) {
			for (int j = 0; j < rotateMatrix._matrix[i].length; j++) {
				rotateMatrix._matrix[i][j] = this._matrix[this._matrix.length - 1 - j][i];
			}
		}
		return rotateMatrix;
	}
	/**
	 * Rotate the matrix 90 degrees to the left.
	 * @return the new matrix that rotated
	 */
	public Matrix rotateCounterClockwise(){
		Matrix rotateMatrix = new Matrix(this._matrix[0].length,this._matrix.length);
		for (int i = 0; i < this._matrix.length; i++) {
			for (int j = 0; j < this._matrix[i].length; j++) {
					rotateMatrix._matrix[this._matrix[0].length -1 -j][i] = this._matrix[i][j];
			}
		}
		return rotateMatrix;
	}
	/**
	 * Made for imageFiltarAverage(), check how many cells
	 * around specific cell and calculate the average of them.
	 * @param x the line number in the array
	 * @param y the the column number in the array
	 * @return the average of the cell and the cells around him
	 */
	private int averageOfNeighbors(int x ,int y) {
		int numOfCells = 0;
		int sum = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x + i >= 0 && x + i < this._matrix.length && y + j >= 0 && y + j < this._matrix.length) {//check if the current neighbor is within borders
					sum += this._matrix[x + i][y + j];//add the current neighbor value to the sum of all cells
					numOfCells++;
				}
			}
		}
		return sum / numOfCells;//calculate the average and return
	}
}

