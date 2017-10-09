package circuitologico;

public class Porta {
    public static boolean and(boolean entradas[]){
        boolean aux = entradas[0]; //Pegará o valor da primeira interação
        //Como já temos o primeiro valor, vamos começar da segunda posição do array
        for(int i = 1; i < entradas.length; i++){
            aux = aux&&entradas[i]; //Logica simples de porta dupla poder se tornar qualquer outra
        }
        return aux;
    }
    
    public static boolean nand(boolean entradas[]){
        boolean aux = entradas[0];
        for(int i = 1; i < entradas.length; i++){
            /*
            Teorema de Morgan aplicado na prática, uma and será o inverso das 
            entradas da or, em java podemos pegar o inverso de um resultado boolean
            apenas colocando o '!' na frente
            */
            aux = !aux||!entradas[i]; 
        }
        return aux;
    }
    
    public static boolean or(boolean entradas[]){
        boolean aux = entradas[0];
        for(int i = 1; i < entradas.length; i++){
            aux = aux||entradas[i];
        }
        return aux;
    }
    
    public static boolean nor(boolean entradas[]){
        boolean aux = entradas[0]; 
        for(int i = 1; i < entradas.length; i++){
            aux = !aux&&!entradas[i]; //Teorema de mordan, só que dessa vez a relação da Nor
        }
        return aux;
    }
    
    public static boolean xor(boolean entradas[]){
        boolean aux = entradas[0];
        for(int i = 1; i < entradas.length; i++){
            aux = aux^entradas[i];
        }
        return aux;
    }
    
    public static boolean not(boolean entrada){
        return !entrada;
    }
    
}
