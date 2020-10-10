package processor;

public class Inverse {
    Inverse() {
        System.out.print("Enter size of matrix: ");
        Matrix matrixA = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter matrix:");
        matrixA.setElements(Main.SRC);
        Matrix inverse = Matrix.inverse(matrixA);
        System.out.println("The result is:");
        inverse.print();
    }
}
