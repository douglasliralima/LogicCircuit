package circuitologico;

import java.io.*;

/**
 *
 * @author Douglas
 */
public class CircuitoLogico {
    
    /*
    Bom, temos 5 saidas y5, y4 y3, y2 e y1 que conectam todas as saidas de
    cada porta nela acredito que cada yAnd vai receber o resultado de um 
    grande or e esse or terá como entrada cada porta lógica
    Temos um total de 20 portas lógicas
    y5 = y1(and) e y2 = y4(or), y3 são xor
    Como vamos fazer isso? o laço acima consegue varrer uma tebela e 
    mosttrar uma yAnd dessa tabela
    */
    
    public static void main(String[] args) {
        int maxEntrada = 8;
        int entrada[], yAnd, yOr, yXor;
        try { //Vamos resetar o arquivo se estiver criado
            FileWriter arquivo = new FileWriter("tabela.txt", false);
            BufferedWriter escritor = new BufferedWriter(arquivo);
            escritor.write("");
            escritor.close();
            arquivo.close();
        } catch (IOException ex) {
            System.out.println("Erro de arquivo: " + ex.toString());
        }
        /*
        A função pow recebe dois doubles e retorna do primeiro parametro pelo 
        segundo, ele retorna um double também, por isso fiz o cast para int.
        Classe Math tem bastante métodos úteis :v
        */
        int maxLinhas = (int) Math.pow(2, maxEntrada); // O tamanho máximo de linhas em uma tabela é 2^maxEntrada
        entrada = new int[maxEntrada];
        String linha, tabela = "";
        boolean[] valorEntrada = new boolean[maxEntrada]; //Isso faz todas as maxEntrada serem configuradas como false naturalmente
        /*
        Para varrermos uma linha, cada valorEntrada precisará manter seu estado até 2^linhaAtual
        repetição daquele estado após chegar em seu valorEntrada especifíco, aquele estado muda
        */
        
        
        for (int linhaAtual = 1; linhaAtual <= maxLinhas; linhaAtual++) {
            linha = ""; //Vamos resetar a linha
            //Vamos ver agora o resultado booleano das nossas saidas nessa linha
            yAnd = (Porta.not(Porta.not(Porta.and(valorEntrada))) == true) ? 1 : 0;
            yOr = (Porta.not(Porta.not(Porta.or(valorEntrada))) == true) ? 1 : 0;
            yXor = (Porta.not(Porta.not(Porta.xor(valorEntrada))) == true) ? 1 : 0;
            
            for (int entradaAtual = maxEntrada - 1; entradaAtual >= 0; entradaAtual--) {
                /*
                Como a tabela verdade é com 0 e 1, vamos tranformar nosso true
                em 1 e o nosso false em 0 em nossa array de entradas
                */
                entrada[entradaAtual] = (valorEntrada[entradaAtual] == true) ? 1 : 0 ;
                linha += entrada[entradaAtual] + " ";
                /*
                Vamos ver se o valor booleano precisa mudar
                Logica: Para cada entrada, vamos ver se ela precisa ser alterada
                vendo se a linha atual corresponde a linha de mudança, isso 
                ocorre sempre que a linha atual (linhaAtual % 2^entradaAtual == 0)
                */
                int aux = (int) Math.pow(2, entradaAtual);
                if(linhaAtual % aux == 0) valorEntrada[entradaAtual] = !valorEntrada[entradaAtual]; 
            }
            String strLinhaAtual = String.valueOf(linhaAtual);//Essa e a proxima linha só servem para deixar bonitinho
            if(strLinhaAtual.length() == 1) strLinhaAtual = '0' + strLinhaAtual;
            linha = strLinhaAtual + ": " + linha + "|" + yAnd + 
            "|" + yOr + "|" + yXor + "|" + yOr + "|" + yAnd + "|";
            try {
                FileWriter arquivo = new FileWriter("tabela.txt", true);
                BufferedWriter escritor = new BufferedWriter(arquivo);
                escritor.write(linha);
                escritor.newLine();
                escritor.close();
                arquivo.close();
            } catch (IOException ex) {
                System.out.println("Erro de arquivo: " + ex.toString());
            }
        System.out.println(linha);
        }
    }
}
