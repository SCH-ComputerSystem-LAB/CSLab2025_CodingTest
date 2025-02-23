"""
Baekjoon #1991 트리 순회
- 알고리즘: 트리/재귀

- 문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)

- 입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .

- 출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
ABDCEFG
DBAECFG
DBEGFCA

- 오답노트
    - 리스트가 참조하는 크기를 생각하지 못해 런타임 에러 발생 > 구조를 딕셔너리로 변경
        - 리스트 구조를 버린 이유 > 최악의 경우 2**n 길이를 필요로 해서 비효율 + 메모리/시간초과
    - 알고리즘 상 문제될 부분이 없는데 자꾸 틀렸습니다가 뜸 > 확인용 출력 코드 안 빼고 제출해서...
"""

class Tree:
    def __init__(self):
        self.n = int(input())
        self.tree = dict()
        for _ in range(self.n):
            p, c1, c2 = input().split()
            if p not in self.tree.keys(): self.tree[p] = [0, 0]
            if c1 != '.': self.tree[p][0] = c1
            if c2 != '.': self.tree[p][1] = c2
        # for k, v in self.tree.items():
        #     print(k, v)
    def preorder(self, i):
        print(i, end='')
        if self.tree[i][0] != 0: self.preorder(self.tree[i][0])
        if self.tree[i][1] != 0: self.preorder(self.tree[i][1])
    def inorder(self, i):
        if self.tree[i][0] != 0: self.inorder(self.tree[i][0])
        print(i, end='')
        if self.tree[i][1] != 0: self.inorder(self.tree[i][1])
    def postorder(self, i):
        if self.tree[i][0] != 0: self.postorder(self.tree[i][0])
        if self.tree[i][1] != 0: self.postorder(self.tree[i][1])
        print(i, end='')

t = Tree()
t.preorder('A')
print()
t.inorder('A')
print()
t.postorder('A')