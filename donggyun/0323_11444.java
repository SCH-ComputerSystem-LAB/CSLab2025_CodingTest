import java.io.*;
import java.util.*;
import java.lang.*;

/*
Baekjoon #11444
- 알고리즘: 분할정복 알고리즘
- 문제
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n=17일때 까지 피보나치 수를 써보면 다음과 같다.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

- 입력
첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
- 출력
첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.

예제 입력 1
1000
예제 출력 1
517691607
- etc
분할정복과 행렬의 곱셈을 통해 문제를 해결
( Fn+2 ) = (1 1) * (Fn+1)
( Fn+1 )   (1 0)   (Fn)
 */

public class Main {

    static final int MOD = 1_000_000_007;                                    // 나눌 때 사용할 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] arr = {{1, 1}, {1, 0}};                             // 행렬에 곱에 사용될 이중배열 {}
        long[][] initial = { {1}, {0} };                             // 곱할 벡터
        int n = Integer.parseInt(br.readLine());                    // 입력값 n

        if (n >= 3) {
            long[][] temp = divideConquer(n - 1, arr);
            long[][] result = matrixMultiply(2, 2, 1, temp, initial);
            System.out.println(result[0][0]);
        }
        else {
            System.out.println(1);
        }

    }

    // 행렬의 곱 함수
    public static long[][] matrixMultiply(int row1, int col1_row2, int col2, long[][] A, long[][] B) {
        long[][] result = new long[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1_row2; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return result;
    }
    public static long[][] divideConquer(int n, long[][] matrix){
        if (n == 1) return matrix;                                  // 입력한 n이 1인 경우

        long[][] half = divideConquer(n / 2, matrix);
        long[][] squared = matrixMultiply(2, 2, 2, half, half);

        if (n % 2 == 0) {
            return squared;
        } else {
            return matrixMultiply(2, 2, 2, squared, matrix);
        }
    }
}
