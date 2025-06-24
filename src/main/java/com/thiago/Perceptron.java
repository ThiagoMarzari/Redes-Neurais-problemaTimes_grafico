package com.thiago;

import java.util.List;
import java.util.Random;

/**
 * @author Thiago Marzari
 * @author Gabriel Pinheiro
 */


public class Perceptron
    {
        public double[][] amostras;
        public List<Integer> saidas;
        public double taxa_aprendizado;
        public int geracoes;
        public int limiar;
        public int numeroAmostras;
        public int numeroAtributos;

        public double[] pesos;

        public Perceptron(double[][] amostras, List<Integer> saidas, double taxa_aprendizado,
            int geracoes, int limiar)
        {
            this.amostras = amostras;
            this.saidas = saidas;
            this.taxa_aprendizado = taxa_aprendizado;
            this.geracoes = geracoes;
            this.limiar = limiar;
            this.numeroAmostras = amostras.length;
            this.numeroAtributos = amostras[0].length + 1; // +1 para o limiar
            this.pesos = new double[this.numeroAtributos];
        }

        private int funcao_ativacao_signal(double soma)
        {
            if (soma >= 0) return 1;
            return -1;
        }


        public void treinar()
        {
            // Inserir o valor do limiar na posição limiar de cada ponto de cada amostra da lista "amostras"
            //            // Ex.: [[0.72, 0.82], ...] vira [[1, 0.72, 0.82], ...]
            //            // Cria uma nova matriz com o limiar adicionado
            double[][] amostrasComLimiar = new double[numeroAmostras][numeroAtributos];

            for (int i = 0; i < numeroAmostras; i++) {
                amostrasComLimiar[i][0] = this.limiar;
                for (int j = 0; j < amostras[i].length; j++) {
                    amostrasComLimiar[i][j + 1] = amostras[i][j];
                }
            }

            // Inicializa pesos aleatórios
            Random gerador = new Random();
            pesos[0] = limiar;
            pesos[1] = gerador.nextDouble(); // para o peso da entrada x
            pesos[2] = gerador.nextDouble(); // para o peso da entrada y

            int conta = 0;
            boolean aprendeu;
            double soma;
            int saida_gerada;

            while (true)
            {
                aprendeu = true;

                for (int i = 0; i < numeroAmostras; i++) {
                    soma = 0;
                    for (int j = 0; j < numeroAtributos; j++) {
                        soma +=  pesos[j] *  amostrasComLimiar[i][j];
                    }

                    //Obter a saída da rede considerando a função sinal
                    saida_gerada = funcao_ativacao_signal(soma);

                    //Verificar se a saída da rede é diferente da saída desejada
                    //se sim, calibrar ou treinar ou ajustar ou fazer aprender
                    if (saida_gerada != this.saidas.get(i))
                        {
                            aprendeu = false;
                            double erro = this.saidas.get(i) - saida_gerada;
                        for (int j = 0; j < numeroAtributos; j++) {
                            //Fazer o ajuste dos pesos para cada elemento da amostra ou SEJA UMA CALIBRAGEM DOS PESOS
                            pesos[j] = pesos[j] + this.taxa_aprendizado * erro * amostrasComLimiar[i][j];
                        }
                    }
                }
                //Atualizar contador de gerações
                conta++;

                if (aprendeu || conta > this.geracoes)
                {
                    System.out.println("Geracoes de treinamento: " + conta);
                    break;
                }
            }
        }

        //testes para "novas" amostras
        public void testar(double[] amostra)
        {
            //Inserir o valor do limiar na posição "0" para cada amostra da lista "amostras"
            double[] amostraComLimiar = new double[numeroAtributos];
            amostraComLimiar[0] = this.limiar;
            for (int i = 0; i < amostra.length; i++) {
                amostraComLimiar[i + 1] = amostra[i];
            }

            //Inicializar potencial de ativação
            double soma = 0;
            //# Para cada atributo...
            for (int i = 0; i < numeroAtributos; i++) {
                soma += amostraComLimiar[i] * pesos[i];

            }

            // Obter a saída da rede considerando g a função funcao_ativacao_signal
            double saida_gerada = this.funcao_ativacao_signal(soma);

            if (saida_gerada == 1) {
                System.out.println("Classe: " + saida_gerada + " ou Time Azul");
            } else {
                System.out.println("Classe: " + saida_gerada + " ou Time Vermelho");
            }
        }
    }
