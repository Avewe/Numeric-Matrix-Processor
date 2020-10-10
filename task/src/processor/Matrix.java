package processor;

import java.util.Scanner;

/**
 * This class save basic information of a Matrix,
 * and have some methods for matrix operations.
 *
 * @author Avewei
 * @version 1.0
 */
public class Matrix {
    final private int row;
    final private int column;
    final private double[][] elements;

    /**
     * Construct a matrix by given elements
     *
     * @param r row of the matrix
     * @param c column of the matrix
     */

    public Matrix(int r, int c) {
        row = r;
        column = c;
        elements = new double[r][c];
    }

    /**
     * Set matrix elements from scanner
     *
     * @param scanner input source
     */
    public void setElements(Scanner scanner) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                elements[i][j] = scanner.nextDouble();
            }
        }
    }

    /**
     * Judge if the matrix is square
     *
     * @return true if the matrix is square
     */
    public boolean isSquare() {
        return column == row;
    }

    /**
     * Judge if the other matrix is the same dimension as this
     *
     * @param other the other Matrix
     * @return true if the same dimension
     */
    private boolean isSameDimension(Matrix other) {
        return other.column == column && other.row == row;
    }

    /**
     * Print the Matrix
     */
    public void print() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Return the Minor Matrix of a(i,j)
     *
     * @param i row index
     * @param j column index
     * @return the Minor Matrix
     */
    public Matrix getMinor(int i, int j) {
        Matrix minor = new Matrix(row - 1, column - 1);
        //The position in minor Matrix
        int posI = 0;
        int posJ = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < column; ++c) {
                if (r == i || c == j)
                    continue;
                minor.elements[posI][posJ] = elements[r][c];
                posJ++;
                if (posJ == minor.column) {
                    posJ = 0;
                    posI++;
                }
            }
        }
        return minor;
    }

    /**
     * Get the Adjoint of a matrix
     *
     * @return adj
     */
    public Matrix getAdj() {
        if (!isSquare())
            return null;
        Matrix adj = new Matrix(row, column);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                Matrix minor = getMinor(i, j);
                if((i + j) % 2 == 0)
                    adj.elements[j][i] = calcDeterminant(minor);
                else
                    adj.elements[j][i] = -calcDeterminant(minor);

            }
        }
        return adj;
    }

    /**
     * Return the cofactor of a(i,j)
     *
     * @param i row index
     * @param j column index
     * @return cofactor
     */
    public double getCofactor(int i, int j) {
        if ((i + j) % 2 == 0)
            return elements[i][j];
        return -elements[i][j];
    }

    /**
     * add two matrix
     *
     * @param a matrix a
     * @param b matrix b
     * @return a new matrix that save the sum of a and b
     */
    public static Matrix add(Matrix a, Matrix b) {
        //if not the same dimension
        if (!a.isSameDimension(b))
            return null;
        //Save the sum in a new Matrix
        Matrix sum = new Matrix(a.row, a.column);
        //Add up elements
        for (int i = 0; i < sum.row; ++i) {
            for (int j = 0; j < sum.column; ++j) {
                sum.elements[i][j] = a.elements[i][j] + b.elements[i][j];
            }
        }
        return sum;
    }

    /**
     * multiply two matrix if possible
     *
     * @param a Matrix a
     * @param b Matrix b
     * @return the multiple of matrix
     */
    public static Matrix multiply(Matrix a, Matrix b) {
        //judge if two matrix can multiply
        if (a.column != b.row)
            return null;
        Matrix multiple = new Matrix(a.row, b.column);
        for (int i = 0; i < multiple.row; ++i) {
            for (int j = 0; j < multiple.column; ++j) {
                multiple.elements[i][j] = 0;
                for (int k = 0; k < a.column; ++k) {
                    multiple.elements[i][j] += a.elements[i][k] * b.elements[k][j];
                }
            }
        }
        return multiple;
    }

    /**
     * Scalar a matrix by the constant
     *
     * @param matrix the matrix that will be operated on
     * @param k      the constant
     * @return the matrix after the operation
     */
    public static Matrix scalar(Matrix matrix, double k) {
        Matrix scalarMatrix = new Matrix(matrix.row, matrix.column);
        for (int i = 0; i < matrix.row; ++i) {
            for (int j = 0; j < matrix.column; ++j) {
                scalarMatrix.elements[i][j] = matrix.elements[i][j] * k;
            }
        }
        return scalarMatrix;
    }

    /**
     * Transpose the matrix along the main diagonal
     *
     * @param matrix the matrix to be operated on
     * @return the matrix to be operated on
     */
    public static Matrix mainDiaTranspose(Matrix matrix) {
        Matrix transpose = new Matrix(matrix.column, matrix.row);
        for (int i = 0; i < transpose.row; ++i) {
            for (int j = 0; j < transpose.column; ++j) {
                transpose.elements[i][j] = matrix.elements[j][i];
            }
        }
        return transpose;
    }

    /**
     * Transpose the matrix along the side diagonal
     *
     * @param matrix the matrix to be operated on
     * @return the matrix to be operated on
     */
    public static Matrix sideDiaTranspose(Matrix matrix) {
        int n = matrix.row;
        Matrix transpose = new Matrix(n, n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                transpose.elements[i][j] = matrix.elements[n - 1 - j][n - 1 - i];
            }
        }
        return transpose;
    }

    /**
     * Transpose the matrix along the vertical line
     *
     * @param matrix the matrix to be operated on
     * @return the matrix to be operated on
     */
    public static Matrix vertLineTranspose(Matrix matrix) {
        int n = matrix.row;
        Matrix transpose = new Matrix(n, n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                transpose.elements[i][j] = matrix.elements[i][n - 1 - j];
            }
        }
        return transpose;
    }

    /**
     * Transpose the matrix along the horizontal line
     *
     * @param matrix the matrix to be operated on
     * @return the matrix to be operated on
     */
    public static Matrix horizLineTranspose(Matrix matrix) {
        int n = matrix.row;
        Matrix transpose = new Matrix(n, n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                transpose.elements[i][j] = matrix.elements[n - 1 - i][j];
            }
        }
        return transpose;
    }

    /**
     * Calculate the determinant of the Matrix
     *
     * @param matrix the matrix to be calculated
     * @return determinant of the matrix
     */
    public static double calcDeterminant(Matrix matrix) {
        if (!matrix.isSquare())
            return Double.NaN;
        if (matrix.row == 2) {
            return matrix.elements[0][0] * matrix.elements[1][1] - matrix.elements[0][1] * matrix.elements[1][0];
        }
        double determinant = 0;
        for (int i = 0; i < matrix.row; ++i) {
            Matrix minor = matrix.getMinor(0, i);
            double cofactor = matrix.getCofactor(0, i);
            determinant += cofactor * calcDeterminant(minor);
        }
        return determinant;
    }

    public static Matrix createZeroMatrix(int n) {
        Matrix zero = new Matrix(n, n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                zero.elements[i][j] = 0;
            }
        }
        return zero;
    }

    public static Matrix inverse(Matrix matrix) {
        if (!matrix.isSquare())
            return null;
        double determinant = calcDeterminant(matrix);
        if (determinant == 0)
            return createZeroMatrix(matrix.row);
        Matrix adj = matrix.getAdj();
        return scalar(adj, 1 / determinant);
    }

}
