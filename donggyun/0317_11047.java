import java.io.*;
import java.lang.*;
import java.util.*;

/*
Baekjoon #11047 동전 0
- 알고리즘: 그리디 알고리즘
- 문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

- 입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.
(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

- 출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

예제 입력 1
10 4200
1
5
10
50
100
500
1000
5000
10000
50000

예제 출력 1
6

- etc
동전 종류가 N: 10 동전 합 K: 4200
그리디 알고리즘 => 숫자, 합을 이루는 방법의 최소 수 문제
가치가 큰 동전부터 최대한 사용하며 개수를 줄이면서 접근
동전 가치가 작은 것 부터 오름차순 입력 => 배열에 순서를 변경할 필요 X
ex) 4200 => 1000 * 4 + 100 * 2 = 4200;
 */

public class Main11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());            // st로 입력 받음
        String N = st.nextToken();                          // " " 띄어쓰기로 분류 / N 입력받음
        String String_K = st.nextToken();                          // K 입력받음
        int K = Integer.parseInt(String_K);
        ArrayList<Integer> coin_list = new ArrayList<>();   // 동전 배열

        for (int i = 0; i < Integer.parseInt(N); i++) {
            coin_list.add(Integer.parseInt(br.readLine())); // 동전 배열에 입력받은 동전의 가치를 대입
        }

        int count = 0;                                      // 결과 횟수 변수

        // 가치가 큰 동전부터 최대한 사용하면서 개수 줄여가며 접근
        for (int i = Integer.parseInt(N) - 1; i >= 0 ; i--) {    // 동전 배열의 큰 수부터 비교
            int coin = coin_list.get(i);
            if (K >= coin) {   // 반복해서 계산해야 함으로 k (동전 합) 보다 작은 동전 가치를 쓰기 위해
                count = count + (K / coin);
                K = K % coin;
            }
        }

        System.out.println(count);
    }
}
