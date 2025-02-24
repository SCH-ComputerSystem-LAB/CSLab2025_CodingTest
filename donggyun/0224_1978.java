import java.io.*;
import java.lang.*;
import java.util.*;

/*
Baekjoon #1978 소수 찾기
2025-02-22
- 알고리즘: 수 계산
- 문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

- 입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

- 출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1
4
1 3 5 7

예제 출력 1
3
- etc
에라토스테네스의 체 => 주어진 범위 내에서 모든 소수를 구하는 방법
상수 n이 소수인지 찾는 알고리즘
1. 2부터 n까지 모든 자연수를 나열 ex) n = 10 => 2 3 4 5 6 7 8 9 10
2. 나열되어 있는 남은 수 중에 처리하지 않은 가장 작은 수 i를 찾는다 ex) 2
3. 남은 수 중에서 i를 제외한 i의 배수를 제거한다 ex) 4 6 8 10 은 제거
4. 더 이상 반복할 수 없을 때까지 2번 3번과정을 반복
*/

public class Main1978 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());                                     // 첫째 줄 소수의 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());                     // 둘때 줄 소수인지 확인 할 상수들 입력

        int count = 0;                                                               // 소수 개수 카운트 변수

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());                              // 소수 판별 로직
            if (num < 2) {
                continue;                                                           // 1, 2 제외
            }
            boolean isPrime = true;                                                 // 소수인지 체크하기 위한 boolean
            for (int j = 2; j * j <= num; j++) {                                    // j++ 하면서 j^2이 num하고 같으면 소수아님
                if (num % j == 0) {                                                 // 소수가 아님
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {                                                          // 소수 맞음
                count++;
            }
        }

        System.out.println(count);  // 결과 출력
    }
}
