package circuitologico;

/**
 *
 * @author Douglas
 */
public class EntradasTabelaVerdade {

    /*
    Bom, temos nossas portas.. agora precisamos montar a fucking tabela
    um bom plano é primeiro ver como monta uma tabela qualquer, vamos tester com uma and
    e depois montamos a tabela do jeito que o professor quer
    
    */
    public static void main(String[] args) {
        int maxEntrada = 4, valor = 0;
        /*
        A função pow recebe dois doubles e retorna do primeiro parametro pelo 
        segundo, ele retorna um double também, por isso fiz o cast para int.
        Classe Math tem bastante métodos úteis :v
        */
        int maxLinhas = (int) Math.pow(2, maxEntrada); // O tamanho máximo de linhas em uma tabela é 2^maxEntrada
        String linha;
        
        boolean entrada[] = new boolean[maxEntrada]; //Isso faz todas as maxEntrada serem configuradas como false naturalmente
        /*
        Para varrermos uma linha, cada valor precisará manter seu estado até 2^linhaAtual
        repetição daquele estado após chegar em seu valor especifíco, aquele estado muda
        */
        for (int linhaAtual = 1; linhaAtual <= maxLinhas; linhaAtual++) {
            linha = ""; //Vamos resetar a linha
            for (int entradaAtual = maxEntrada - 1; entradaAtual >= 0; entradaAtual--) {
                /*
                Como a tabela verdade é com 0 e 1, vamos tranformar nosso true
                em 1 e o nosso false em 0
                */
                valor = (entrada[entradaAtual] == true) ? 1 : 0 ;
                linha += valor + " ";
                /*
                Para cada entrada, vamos ver se ela precisa ser alterada
                vendo se a linha atual corresponde a linha de mudança, isso 
                ocorre sempre que a linha atual (linhaAtual % 2^entradaAtual == 0)
                */
                int aux = (int) Math.pow(2, entradaAtual);
                if(linhaAtual % aux == 0) entrada[entradaAtual] = !entrada[entradaAtual]; 
            }
            String strLinhaAtual = String.valueOf(linhaAtual);
            if(strLinhaAtual.length() == 1) strLinhaAtual = '0' + strLinhaAtual; //Só para deixar os primeiros alinhados
            System.out.println(strLinhaAtual + ": " + linha);
        }
    }
}
