public class testDB {
    public static void main(String[] args) {
        Username checker = new Username();

        // בדיקה 1: שם קצר מדי (בדיקת לוגיקה פנימית)
        System.out.println("Testing 'abc': " + checker.valid("abc"));

        // בדיקה 2: שם תקין אבל לא קיים ב-DB
        System.out.println("Testing 'newuser88': " + checker.valid("newuser88"));

        // בדיקה 3: השם שהכנסנו קודם ל-MySQL (בדיקת החיבור ל-DB)
        System.out.println("Testing 'student123': " + checker.valid("student123"));
    }
}
