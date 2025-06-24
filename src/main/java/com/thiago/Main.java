package com.thiago;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Thiago Marzari
 * @author Gabriel Pinheiro
 */

public class Main {
  public static void main(String[] args) {
    System.out.println("Exemplo de RNA Perceptron para classificação de equipes");

    double[][] amostras = {
            {0.72, 0.82}, {0.91, -0.69}, {0.46, 0.80}, {0.03, 0.93},
            {0.12, 0.25}, {0.96, 0.47}, {0.8, -0.75}, {0.46, 0.98},
            {0.66, 0.24}, {0.72, -0.15}, {0.35, 0.01}, {-0.16, 0.84},
            {-0.04, 0.68}, {-0.11, 0.1}, {0.31, -0.96}, {0.0, -0.26},
            {-0.43, -0.65}, {0.57, -0.97}, {-0.47, -0.03}, {-0.72, -0.64},
            {-0.57, 0.15}, {-0.25, -0.43}, {0.47, -0.88}, {-0.12, -0.9},
            {-0.58, 0.62}, {-0.48, 0.05}, {-0.79, -0.92}, {-0.42, -0.09},
            {-0.76, 0.65}, {-0.77, -0.76}
    };

    List<Integer> saidas = new ArrayList<>();
    int[] saidasArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    for (int s : saidasArray) {
        saidas.add(s);
    }

    double taxa_aprendizado = 0.1;
    int geracoes = 1000;
    int limiar = 1;
    Perceptron p = new Perceptron(amostras, saidas, taxa_aprendizado, geracoes, limiar);

    p.treinar();

    Scanner scanner = new Scanner(System.in);
    String op;
    do {
      System.out.print("\n\nInforme valor para x (-1 a 1): ");
      double x = Double.parseDouble(scanner.nextLine());
      System.out.print("Informe valor para y (-1 a 1): ");
      double y = Double.parseDouble(scanner.nextLine());

      p.testar(new double[]{x, y});
      System.out.print("1 - Sair: ");
      op = scanner.nextLine();
    } while (!op.equals("1"));

    scanner.close();
  }
}