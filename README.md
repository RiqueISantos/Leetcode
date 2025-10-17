# 💻 LeetCode Solutions in Java

Repositório dedicado às minhas soluções para desafios do **LeetCode**, desenvolvidas em **Java**.  
Cada exercício contém:
- uma breve explicação do problema;
- a implementação em Java;
- a análise de **complexidade de tempo e espaço (Big O)**.

---

## 📚 O que é Big O?

A **notação Big O** é uma forma de descrever **a eficiência de um algoritmo**, mostrando **como ele se comporta à medida que o tamanho da entrada cresce**.  
Ela não mede tempo real de execução, mas sim **como o número de operações cresce em relação à entrada**.

| Notação | Nome | Descrição |
|----------|------|-----------|
| **O(1)** | Constante | O tempo não depende do tamanho da entrada |
| **O(log n)** | Logarítmica | Cresce lentamente, muito eficiente |
| **O(n)** | Linear | Cresce proporcionalmente ao tamanho da entrada |
| **O(n log n)** | Linearítmica | Um pouco mais lenta que linear |
| **O(n²)** | Quadrática | Cresce rapidamente; loops aninhados |
| **O(2ⁿ)** | Exponencial | Extremamente ineficiente para grandes entradas |

---

## 🧩 Problemas Resolvidos

### 1️⃣ Two Sum
**Link:** [LeetCode - Two Sum](https://leetcode.com/problems/two-sum/)

**Descrição:**
Dado um array de inteiros `nums` e um inteiro `target`, encontre **os índices de dois números** cuja soma seja igual a `target`.

**Exemplo:**
```text
Entrada: nums = [2,7,11,15], target = 9  
Saída: [0,1]  
Explicação: nums[0] + nums[1] = 9
```

**Solução em Java:**
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(n)

---

### 2️⃣ Reverse String
**Link:** [LeetCode - Reverse String](https://leetcode.com/problems/reverse-string/)

**Descrição:**
Dado um array de caracteres, inverta-o **in place** (sem criar outro array auxiliar).

**Exemplo:**
```text
Entrada: ["h","e","l","l","o"]  
Saída: ["o","l","l","e","h"]
```

**Solução em Java:**
```java
public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
    }
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(1)

---

### 3️⃣ Valid Anagram
**Link:** [LeetCode - Valid Anagram](https://leetcode.com/problems/valid-anagram/)

**Descrição:**
Verifique se duas strings são **anagramas**, ou seja, possuem as mesmas letras com as mesmas quantidades.

**Exemplo:**
```text
Entrada: s = "anagram", t = "nagaram"  
Saída: true
```

**Solução em Java:**
```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) {
        count[c - 'a']--;
        if (count[c - 'a'] < 0) return false;
    }
    return true;
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(1)

---

### 4️⃣ Same Tree
**Link:** [LeetCode - Same Tree](https://leetcode.com/problems/same-tree/)

**Descrição:**
Verifique se duas árvores binárias são **estruturalmente idênticas** e possuem os mesmos valores em todos os nós.

**Exemplo:**
```text
Entrada: p = [1,2,3], q = [1,2,3]  
Saída: true
```

**Solução em Java:**
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null || p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(h) (recursão na altura da árvore)

---

### 5️⃣ Invert Binary Tree
**Link:** [LeetCode - Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)

**Descrição:**
Inverta uma árvore binária, trocando todos os filhos esquerdo e direito de cada nó.

**Exemplo:**
```text
Entrada: root = [4,2,7,1,3,6,9]  
Saída: [4,7,2,9,6,3,1]
```

**Solução em Java:**
```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
    return root;
}

public void printTree(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    printTree(root.left);
    printTree(root.right);
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(h) (recursão na altura da árvore)

---

### 6️⃣ Climbing Stairs
**Link:** [LeetCode - Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

**Descrição:**
Você está subindo uma escada com `n` degraus.  
Cada vez, você pode subir **1 ou 2 degraus**.  
De quantas maneiras diferentes você pode chegar ao topo?

**Exemplo:**
```text
Entrada: n = 4  
Saída: 5  
Explicação: As formas são [1+1+1+1], [1+1+2], [1+2+1], [2+1+1], [2+2]
```

**Solução em Java:**
```java
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
```

**🧮 Análise de Complexidade:**
- **Tempo:** O(n)  
- **Espaço:** O(1)

---

## 🧾 Autor

Feito por **Henrique Santos**  
🎓 Estudante de **Bacharelado em Sistemas da Informação**  
📘 Apaixonado por algoritmos, Java e boas práticas de código.

