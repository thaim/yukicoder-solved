import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No424 {
    static final int[][] move = {
            {0, 1},
            {-1, 0},
            {0, -1},
            {1, 0}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[] pos = new int[4];
        pos[0] = sc.nextInt();
        pos[1] = sc.nextInt();
        pos[2] = sc.nextInt();
        pos[3] = sc.nextInt();

        String[] b = new String[h];
        for (int i=0; i<h; i++) {
            b[i] = sc.next();
        }
        int[][] board = new int[h+2][w+2];
        for (int i=1; i<=h; i++) {
            for (int j=1; j<=w; j++) {
                board[i][j] = b[i-1].charAt(j-1) - '0';
            }
        }

        String result = solve(h, w, pos, board);

        System.out.println(result);
    }

    public static String solve(int h, int w, int[] pos, int[][] board) {
        boolean[][] reachable = new boolean[h+2][w+2];

        reachable[pos[0]][pos[1]] = true;
        List<Pos> list = new ArrayList<Pos>();
        list.add(new Pos(pos[0], pos[1]));

        while (!reachable[pos[2]][pos[3]] && list.size() > 0) {
            Pos current = list.remove(0);
//            System.err.println("current:" + current.toString());
            for (int i=0; i<4; i++) {
                Pos next = new Pos(current.x + move[i][0], current.y + move[i][1]);
                Pos next2 = new Pos(next.x + move[i][0], next.y + move[i][1]);
//                System.err.println("\tmove:" + move[i][0] + ", " + move[i][1] + ", next:" + next + ", next2:" + next2);

                if (next.x> h || next.x == 0
                        || next.y > w
                        || next.y == 0) {
                    continue;
                }

//                System.err.println("\tcheck start");
                if (!reachable[next.x][next.y] &&
                        Math.abs(board[current.x][current.y]-board[next.x][next.y]) <= 1) {
                    reachable[next.x][next.y] = true;
//                    System.err.println("\tboard: current=" + board[current.x][current.y] + ", next=" + board[next.x][next.y]);
                    list.add(next);
//                    System.err.println(next);
                }

//                System.err.println("\tcheck2 start");
                if (board[current.x][current.y] > board[next.x][next.y]
                        && next2.x <= h && next2.x > 0
                        && next2.y <= w && next2.y > 0
                        && !reachable[next2.x][next2.y]
                        && board[current.x][current.y] == board[next2.x][next2.y]) {
                    reachable[next2.x][next2.y] = true;
                    list.add(new Pos(next2.x, next2.y));
//                    System.err.println(next2);
                }
            }
        }

        if (reachable[pos[2]][pos[3]]) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static class Pos {
        int x;
        int y;
        public Pos(int a, int b) {
            x = a;
            y = b;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
