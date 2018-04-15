package listaexerciciodmob;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Classe abstrata com o intuito de gerar um menu recursivo com as opções
 * de cada método (exercício ou item) do Projeto da disciplina ou de listas de exercícios
 */
abstract class AbstractListaExercicios {

    /**
     * Atributo que verifica se já foi adicionado a opção Sair
     */
    public boolean opcaoSairAdicionado = false;


    /**
     * Atributo para armazenar o Scanner para ser usado nas classes filhas
     */
    Scanner entrada = new Scanner(System.in);

    /**
     * Método recursivo para apresentar a escolha do exercício
     * Recebe como param a String para ser usada como menu, o número que iŕa encerrar a execução,
     * e o prefixo dos nomes dos métodos em comum
     */
    public void getCallExercicio(String msgMenu, int numToExit, String methodPrefix){
        
        // Incluindo no menu a opção "Sair" de acordo com o numToExit recebido
        if(!opcaoSairAdicionado){
            msgMenu = msgMenu +" "+ numToExit + ". Sair";
            opcaoSairAdicionado = true;
        }

        // Exibe o menu e recebe a opção desejada
        System.out.println(msgMenu);
        int num = this.entrada.nextInt();

        // Verificando se a opção é para finalizar o programa
        if(num == numToExit) {
            System.out.println("Tchau tchau!");
            // Finaliza o programa
            System.exit(1);
        }

        // Executa o exercício escolhido
        executaExercicio(num, methodPrefix);

        // Chamada recursiva para sempre mostrar o menu após a finalização de um item
        getCallExercicio(msgMenu, numToExit, methodPrefix);
    }

    /**
     * Método que irá chamar o exercício(método) dinamicamente
     * através do número e seu nome(prefixo).
     * Utiliza as Reflections do Java para chamar o método através de uma String com seu nome
     */
    public void executaExercicio(int numExerc, String methodPrefix){
        try{
            // Recebendo o nome da classe que está sendo executada
            String nomeClasse = this.getClass().getCanonicalName();

            // Criando uma nova instância dessa classe
            Class cls = Class.forName(nomeClasse);
            Object obj = cls.newInstance();

            // Chamando o método do exercício um item passado como parâmetro através do seu nome e número
            Method method = cls.getDeclaredMethod(methodPrefix+numExerc);
            method.invoke(obj, null);
            System.out.println("\n----------------------------------------------");
        }catch(Exception ex){
            System.out.println("Erro ao utilizar Reflection. Não foi possível "
                    + "instanciar a classe ou chamar o método através de uma"
                    + " String");
        }
    };
}
