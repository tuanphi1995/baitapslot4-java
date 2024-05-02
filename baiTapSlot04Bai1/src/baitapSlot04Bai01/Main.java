package baitapSlot04Bai01;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseHelper dbHelper = new DatabaseHelper();

        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter author name:");
        String author = scanner.nextLine();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // clear buffer
        System.out.println("Enter publish date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        System.out.println("Enter status:");
        String status = scanner.nextLine();

        Book newBook = new Book(title, author, price, date, status);
        dbHelper.addBook(newBook);

        scanner.close();
    }
}
