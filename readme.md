# Classificador de Times com Rede Neural Perceptron

Este projeto implementa uma **Rede Neural Perceptron** em Java para classificação de times esportivos em duas categorias: **Time Azul** e **Time Vermelho**. O projeto utiliza um algoritmo de aprendizado supervisionado para treinar o perceptron com dados bidimensionais e realizar classificações binárias.

## 👥 Autores
- **Thiago Marzari**
- **Gabriel Pinheiro**

## 📋 Visão Geral

O projeto implementa um perceptron simples que:
- Treina com 30 amostras de dados bidimensionais (coordenadas x, y)
- Classifica novos pontos como pertencentes ao "Time Azul" (classe 1) ou "Time Vermelho" (classe -1)
- Utiliza função de ativação de sinal (sign function)
- Implementa o algoritmo de aprendizado do perceptron com ajuste de pesos

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       └── com/
│           └── thiago/
│               ├── Main.java          # Classe principal com interface do usuário
│               └── Perceptron.java    # Implementação da rede neural perceptron
├── pom.xml                           # Configuração do Maven
└── readme.md                         # Este arquivo
```

## 🧠 Algoritmo Perceptron

### Características Técnicas
- **Função de Ativação**: Função de sinal (sign function)
- **Taxa de Aprendizado**: 0.1
- **Máximo de Gerações**: 1000
- **Limiar (Bias)**: 1
- **Entrada**: Pontos bidimensionais (x, y) no intervalo [-1, 1]
- **Saída**: Classificação binária (-1 para Time Vermelho, 1 para Time Azul)

### Conjunto de Dados de Treinamento

O projeto utiliza 30 amostras de treinamento:
- **13 amostras** da classe -1 (Time Vermelho)
- **17 amostras** da classe 1 (Time Azul)

```java
// Exemplos de amostras
{0.72, 0.82} → Time Vermelho (-1)
{-0.16, 0.84} → Time Azul (1)
{-0.77, -0.76} → Time Azul (1)
```

## 🔧 Configuração e Execução

### Pré-requisitos
- **Java 17** ou superior
- **Maven** para gerenciamento de dependências

### Como Executar

1. **Clone ou baixe o projeto**

2. **Compile o projeto usando Maven:**
   ```bash
   mvn compile
   ```

3. **Execute a aplicação:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.thiago.Main"
   ```

   Ou compile e execute diretamente:
   ```bash
   javac -d target/classes src/main/java/com/thiago/*.java
   java -cp target/classes com.thiago.Main
   ```

## 💻 Interface do Usuário

O programa oferece uma interface interativa via console:

```
Exemplo de RNA Perceptron para classificação de equipes

Informe valor para x (-1 a 1): 0.5
Informe valor para y (-1 a 1): 0.3
Classe: -1 ou Time Vermelho
1 - Sair:
```

### Como Usar
1. Execute o programa
2. Aguarde o treinamento da rede neural (exibe número de gerações necessárias)
3. Insira coordenadas x e y (valores entre -1 e 1)
4. Veja a classificação resultante
5. Digite "1" para sair ou pressione Enter para continuar testando

## 🔍 Detalhes da Implementação

### Classe `Perceptron`

**Atributos principais:**
- `amostras[][]`: Matriz com os pontos de treinamento
- `saidas`: Lista com as classificações esperadas
- `pesos[]`: Vetor de pesos da rede neural
- `taxa_aprendizado`: Taxa de aprendizado (0.1)
- `geracoes`: Número máximo de iterações de treinamento

**Métodos principais:**
- `treinar()`: Implementa o algoritmo de treinamento do perceptron
- `testar(double[] amostra)`: Classifica uma nova amostra
- `funcao_ativacao_signal()`: Função de ativação de sinal

### Algoritmo de Treinamento

1. **Inicialização**: Pesos aleatórios e inserção do bias
2. **Iteração**: Para cada amostra de treinamento:
   - Calcula a soma ponderada (Σ peso × entrada)
   - Aplica função de ativação
   - Compara com saída desejada
   - Ajusta pesos se necessário: `novo_peso = peso_atual + taxa × erro × entrada`
3. **Convergência**: Para quando todos os exemplos são classificados corretamente ou atinge o limite de gerações

## 📊 Resultados Esperados

- A rede neural aprende a separar linearmente os dois grupos de dados
- Tempo de convergência varia (tipicamente < 100 gerações)
- Precisão depende da separabilidade linear dos dados

## 📝 Licença

Este projeto foi desenvolvido para fins educacionais como parte de um trabalho acadêmico sobre Redes Neurais.
