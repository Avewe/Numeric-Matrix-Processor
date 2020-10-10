package processor;

public class Constant {
    Constant() {
        System.out.print("Enter size of matrix: ");
        Matrix matrixA = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter matrix:");
        matrixA.setElements(Main.SRC);
        System.out.print("Enter constant: ");
        double k = Main.SRC.nextDouble();
        Matrix scalar = Matrix.scalar(matrixA, k);
        System.out.println("The result is:");
        scalar.print();
        Main.menu.show();
    }
}
