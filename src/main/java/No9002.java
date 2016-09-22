import java.util.Scanner;

public class No9002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] result = solve(N);

        for (int i=0; i<N; i++) {
            System.out.println(result[i]);
        }
    }

    public static String[] solve(int N) {
        String[] result = new String[N];

        for (int i=1; i<=N; i++) {
            if (i%3 != 0 && i%5 != 0) {
                result[i-1] = String.valueOf(i);
            } else if (i%3 == 0 && i%5 == 0) {
                result[i-1] = "FizzBuzz";
            } else if (i%3 == 0) {
                result[i-1] = "Fizz";
            } else if (i%5 == 0) {
                result[i-1] = "Buzz";
            }

        }

        return result;
    }
}
