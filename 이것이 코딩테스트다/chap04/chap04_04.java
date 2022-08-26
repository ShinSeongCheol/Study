package chap04;

import java.util.Scanner;

public class chap04_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();

        int[][] d = new int[N][M];
        d[x][y] = 1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        int cnt = 1;
        int turnTime = 0;
        while(true) {
            direction = turnLeft(direction);
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(d[nx][ny] == 0 && map[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt ++;
                turnTime = 0;
                continue;
            }
            else {
                turnTime ++;
            }

            if(turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                }
                else {
                    break;
                }
                turnTime = 0;
            }
        }
        System.out.println(cnt);
    }

    public static int turnLeft(int direction) {
        direction--;
        if(direction == -1) {
            direction = 3;
        }
        return direction;
    }
}
