public class testDB {
    public static void main(String[] args) {
        Username checker = new Username();

        System.out.println("Testing 'abc': " + checker.valid("abc"));

        System.out.println("Testing 'newuser88': " + checker.valid("newuser88"));

        System.out.println("Testing 'student123': " + checker.valid("student123"));
    }
}
