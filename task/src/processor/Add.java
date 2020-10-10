package processor;

public class Add {
    Add() {
        System.out.print("Enter size of first matrix: ");
        Matrix matrixA = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter first matrix:");
        matrixA.setElements(Main.SRC);
        System.out.print("Enter size of second matrix: ");
        Matrix matrixB = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter second matrix:");
        matrixB.setElements(Main.SRC);
        Matrix sum = Matrix.add(matrixA, matrixB);
        if(sum == null)
            System.out.println("The operation cannot be performed.");
        else{
            System.out.println("The result is:");
            sum.print();
        }
        Main.menu.show();
    }
}
