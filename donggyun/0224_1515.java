import java.io.*;
import java.lang.*;
import java.util.*;

/*
Baekjoon #1515 수 이어 쓰기
2025-02-22
- 알고리즘: 투 포인터, 그리디 알고리즘
- 문제
세준이는 1부터 N까지 모든 수를 차례대로 공백없이 한 줄에 다 썼다. 그리고 나서, 세준이가 저녁을 먹으러 나간 사이에
다솜이는 세준이가 쓴 수에서 마음에 드는 몇 개의 숫자를 지웠다.
세준이는 저녁을 먹으러 갔다 와서, 자기가 쓴 수의 일부가 지워져있는 모습을 보고 충격받았다.
세준이는 수를 방금 전과 똑같이 쓰려고 한다. 하지만, N이 기억이 나지 않는다.
남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램을 작성하시오. 아무것도 지우지 않을 수도 있다.)

- 입력
첫째 줄에 지우고 남은 수를 한 줄로 이어 붙인 수가 주어진다. 이 수는 최대 3,000자리다.

- 출력
가능한 N 중에 최솟값을 출력한다.

예제 입력 1
234092

예제 출력 1
20
- etc
StringTokenizer 는 문자열에 공백 또는 구분자가 존재 시 사용
charAt()    는 한 글자씩 접근해야 하는 경우 사용
charAt(i) // i 는 문자열의 각 인덱스
두 변수룰 사용해 상수를 세어가며 문제를 해결
입력받은 상수들을 매치하며 세는 pointer, 나열되어 비교하는 상수 base
https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-1515-%EC%9E%90%EB%B0%94-%EC%88%98-%EC%9D%B4%EC%96%B4-%EC%93%B0%EA%B8%B0-BOJ-1515-JAVA
*/

public class Main1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();                                               // 입력받은 상수들 input 변수
        int pointer = 0;                                                            // input 상수들의 하나하나 가리키는 포인터 변수
        int base = 1;                                                               // N을 찾기위해 비교하며 1씩 증가하며 세면서 비교하는 변수
        while (base <= 30000) {
            String temp = String.valueOf(base);
            for (int i = 0; i < temp.length(); i++) {                               // base 즉 상수가 1부터 N까지 쓰니까
                if (temp.charAt(i) == input.charAt(pointer)) {                      // 234092 에서 ex) 10의 경우 i = 0 => 1 / i = 1 => 0
                    pointer++;                                                      // i는 지워진 문자를 하나씩 쪼개 비교할 때 즉 자릿 수
                    // 동시에 base의 length()에도 사용
                }
                if (pointer == input.length()){
                    System.out.println(base);
                    return;
                }
            }
            base++;
        }
    }
}
