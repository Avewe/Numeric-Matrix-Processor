package processor;

public class Test {
    public static void main(String[] args) {
        System.out.print("Enter size of matrix: ");
        Matrix matrixA = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter first matrix:");
        matrixA.setElements(Main.SRC);
        matrixA.getAdj().print();
    }
}
