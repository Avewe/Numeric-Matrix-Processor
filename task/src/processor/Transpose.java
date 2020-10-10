package processor;

public class Transpose {
    Transpose() {
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
        System.out.print("Your choice: ");
        int choice = Main.SRC.nextInt();
        Matrix matrix = getMatrix();
        Matrix transpose = null;
        switch (choice) {
            case 1:
                transpose = Matrix.mainDiaTranspose(matrix);
                break;
            case 2:
                transpose = Matrix.sideDiaTranspose(matrix);
                break;
            case 3:
                transpose = Matrix.vertLineTranspose(matrix);
                break;
            case 4:
                transpose = Matrix.horizLineTranspose(matrix);
                break;
            default:
                System.out.println("Wrong choice, try again!\n");
        }
        System.out.println("The result is:");
        if(transpose != null)
            transpose.print();
        Main.menu.show();
    }
    private static Matrix getMatrix() {
        System.out.print("Enter matrix size: ");
        Matrix matrix = new Matrix(Main.SRC.nextInt(), Main.SRC.nextInt());
        System.out.println("Enter matrix:");
        matrix.setElements(Main.SRC);
        return matrix;
    }
}
