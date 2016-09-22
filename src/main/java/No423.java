import java.util.Scanner;

public class No423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        String result = solve(input);

        System.out.println(result);
    }

    public static String solve(String input) {
        if (input.equals("ham")) {
            return input;
        }
        return input + "ham";
    }
}
