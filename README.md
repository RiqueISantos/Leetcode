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
  O loop percorre o array uma única vez, e as operações de busca no `HashMap` ocorrem em tempo constante O(1).
- **Espaço:** O(n)  
  O mapa armazena no máximo `n` elementos (um para cada número do array).

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
  Cada caractere é visitado no máximo uma vez durante a troca.
- **Espaço:** O(1)  
  Não há criação de novas estruturas — apenas variáveis temporárias.

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
  Cada string é percorrida uma vez, e todas as operações no array são O(1).
- **Espaço:** O(1)  
  O array `count` tem tamanho fixo (26 letras), logo o espaço não depende da entrada.

---

## 🚀 Próximos Passos
- [ ] Adicionar novos desafios semanalmente  
- [ ] Criar testes unitários com JUnit  
- [ ] Adicionar explicações visuais (diagramas ou exemplos passo a passo)

---

## 🧾 Autor

Feito com por **Henrique Santos**  
🎓 Estudante de **Bacharelado em Sistemas da Informação**  
📘 Apaixonado por algoritmos, Java e boas práticas de código.
