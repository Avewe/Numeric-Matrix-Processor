package processor;

/**
 * The menu class will show Menu and read choice
 */
public class Menu {
    /**
     * show menu
     */
    public void show() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix by constant");
        System.out.println("3. Multiply matrix");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");

        System.out.print("Your choice: ");
        choose(Main.SRC.nextInt());
    }

    /**
     * call the detail operation for user's choice
     *
     * @param id user's choice
     */
    public void choose(int id) {
        switch (id) {
            case 1:
                new Add();
                break;
            case 2:
                new Constant();
                break;
            case 3:
                new Multiply();
                break;
            case 4:
                new Transpose();
                break;
            case 5:
                new Determinant();
                break;
            case 6:
                new Inverse();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice, try again!\n");
                Main.menu.show();
        }
    }

}
