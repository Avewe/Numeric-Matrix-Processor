package processor;

public class Determinant {
    Determinant() {
        System.out.print("Enter size of matrix: ");
        Matrix matrix = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter matrix:");
        matrix.setElements(Main.SRC);
        double determinant = Matrix.calcDeterminant(matrix);
        if (determinant == Double.NaN)
            System.out.println("The operation cannot be performed.");
        else {
            System.out.println("The result is:");
            System.out.println(determinant);
        }
        Main.menu.show();
    }

}
