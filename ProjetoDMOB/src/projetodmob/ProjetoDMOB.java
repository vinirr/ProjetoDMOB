package projetodmob;

public class ProjetoDMOB extends AbstractListaExercicios {

    /**
     * String que será usada para gerar o menu
     */
    public static String menu = "" +
            "\n 1. Soma" +
            "\n 2. Subtração" +
            "\n 3. Divisão" +
            "\n 4. Faixa Etária" +
            "\n 5. Números primos" +
            "\n 6. Mudança de Base" +
            "\n";

    /**
     * Prefixo do nome dos métodos para a chamada através de Reflection
     * no método executaExercicio da classe AbstractListaExercicios
     */
    private static String nomeMetodo = "itemMenu";

    /**
     * Método principal que inicia a execução
     * @param args
     */
    public static void main(String[] args) {
        // Instanciando a classe
        ProjetoDMOB proj = new ProjetoDMOB();

        // Chama o método que irá criar o menu recursivamente
        proj.getCallExercicio(menu, 7, nomeMetodo);
    }

    /**
     * Imprime o resultado para o item 1. Soma
    */
    public void itemMenu1() {
        // Recebendo o primeiro valor do usuário
        System.out.println("Digite o primeiro número");
        float n1 = entrada.nextFloat();

        // Recebendo o segundo valor do usuário
        System.out.println("Digite o segundo número");
        float n2 = entrada.nextFloat();

        // Exibindo o resultado da soma dos valores
        System.out.println("RESULTADO:\n "+ (n1+n2));
    }

    /**
     * Imprime o resultado para o item 2. Subtração
     */
    public void itemMenu2() {
        // Recebendo o primeiro valor do usuário
        System.out.println("Digite o primeiro número");
        float n1 = entrada.nextFloat();

        // Recebendo o segundo valor do usuário
        System.out.println("Digite o segundo número");
        float n2 = entrada.nextFloat();

        // Exibindo o resultado da subtração dos valores
        System.out.println("RESULTADO:\n "+ (n1-n2));
    }

    /**
     * Imprime o resultado para o item 3. Divisão
     */
    public void itemMenu3() {
        // Recebendo o primeiro valor do usuário
        System.out.println("Digite o primeiro número");
        float n1 = entrada.nextFloat();

        // Recebendo o segundo valor do usuário
        System.out.println("Digite o segundo número");
        float n2 = entrada.nextFloat();

        if(n2 == 0) {
            System.out.println("RESULTADO:\n IMPOSSÍVEL DIVIDIR POR ZERO");
        } else {
            // Exibindo o resultado da divisão dos valores
            System.out.println("RESULTADO:\n "+ (n1/n2));
        }
    }

    /**
     * Imprime o resultado para o item 4. Faixa Etária
     * Calcula a média de idade de determinado sexo de uma quantidade de pessoas
     */
    public void itemMenu4() {
        // Recebendo do usuário a quantidade de pessoas a serem analisadas
        System.out.println("Digite a quantidade de pessoas");
        int qtdPessoas = entrada.nextInt();

        // Caso inserido 0 pessoas ou negativo, volta ao menu principal
        if(qtdPessoas < 1) getCallExercicio(menu, 7, nomeMetodo);

        // Inicializando as variaveis de contadores
        int qtdHomens = 0, qtdMulheres = 0, totalIdadesHomens = 0, totalIdadesMulheres = 0;

        // Executa o laço para cada pessoa
        for(int i = 1; i <= qtdPessoas; i++) {
            System.out.println("-- Dados da pessoa "+i+" --");

            // Recebendo a idade da pessoa atual
            System.out.println("Digite a idade:");
            int idade = entrada.nextInt();

            // Recebendo o sexo da pessoa atual
            System.out.println("Digite o sexo (1 = Masculino | 2 = Feminino):");
            int sexo = entrada.nextInt();

            // Se o sexo for masculino, incrementa o total das idades dos homens, e atualiza a quantidade de pessoas
            // do sexo masculino
            if (sexo == 1) {
                totalIdadesHomens += idade;
                qtdHomens++;

            // Se o sexo for feminino, incrementa o total das idades das mulheres, e atualiza a quantidade de pessoas
            // do sexo feminino
            } else if(sexo == 2) {
                totalIdadesMulheres += idade;
                qtdMulheres++;

            // Caso inserido valor inválido no sexo, voltar ao menu principal
            } else {
                getCallExercicio(menu, 7, nomeMetodo);
            }
        }

        // Soma o total das idades de todas as pessoas
        int totalIdades = totalIdadesHomens + totalIdadesMulheres;

        // Soma o total de pessoas
        int totalPessoas = qtdHomens + qtdMulheres;

        // O operador ternário abaixo irá atribuir a média 0 caso nenhuma pessoa de um determino sexo seja inserida

        // Calcula a média de idade do sexo masculino
        float mediaMasculina = qtdHomens == 0 ? 0 : (totalIdadesHomens / qtdHomens);

        // Calcula a média de idade do sexo feminino
        float mediaFeminina = qtdMulheres == 0 ? 0 : (totalIdadesMulheres / qtdMulheres);

        // Calcula a média geral sem distinção de sexo
        float mediaGeral = (totalIdades / totalPessoas);


        // Exibindo os resultados
        System.out.println("RESULTADO:");
        System.out.println("Média total das idades: "+ mediaGeral);
        System.out.println("Média das idades do sexo masculino: "+ mediaMasculina);
        System.out.println("Média das idades do sexo feminino: "+ mediaFeminina);
    }

    /**
     * Imprime o resultado para o item 5. Números primos
     * Soma todos os números primos de 1 até o número passado pelo usuário
     */
    public void itemMenu5() {
        // Recebendo o número limite
        System.out.println("Insira o número limite para calcular a soma dos números primos:");
        int limite = entrada.nextInt();

        // Inicializando contador da soma
        int totalSoma = 0;

        // Verificando se cada número da iteração é primo, caso sim, soma no contador
        for(int i = 1; i <= limite; i++){
            // Chama o método que verifica se o número atual na iteração é primo
            if(verificaNumeroPrimo(i)) totalSoma += i;
        }

        // Exibindo o resultado total
        System.out.println("RESULTADO:");
        System.out.println(totalSoma);
    }

    /**
     * Imprime o resultado para o item 6. Mudança de base
     * Recebe um número e converte de decimal para binário e vice-versa
     */
    public void itemMenu6() {
        // Recebendo o identificador do número, se é binário ou decimal
        System.out.println("Insira o identificador do número (b = binario | d = decimal):");
        String identificador = entrada.nextLine();

        // Recebendo o número a ser convertido
        System.out.println("Insira um número a ser convertida a base:");
        int numero = entrada.nextInt();
        

        // Exibindo o resultado
        System.out.println("RESULTADO:");
  
        if(identificador.equals("b") && (numero == 0 || numero == 1)){
            // Converte o valor binário para decimal
            Integer decimal = Integer.parseInt(String.valueOf(numero), 2);

            System.out.println("Número "+numero+" em decimal:");
            System.out.println(decimal);
        } else if(identificador.equals("d")){
            String binario = Integer.toBinaryString(numero);

            System.out.println("Número "+numero+" em binário:");
            System.out.println(binario);
        } else {
            // Volta ao menu principal caso identificador ou número inválido
            getCallExercicio(menu, 7, nomeMetodo);
        }
    }

    /**
     * Verifica se o número passado é primo
     * @param num
     * @return boolean
     */
    public boolean verificaNumeroPrimo(int num) {
        // 1 não é um número primo, porque ele tem apenas um divisor que é ele mesmo.

        // se um número primo é divisível apenas por 1 e ele mesmo, então pode-se considerar que para ser primo
        // o número tem 2 divosores

        // Inicializando o contador de divisores
        int qtdDivisores = 0;

        // Percorre todos os número até o número passado, e divido o número pelo número atual da iteração
        for(int i = 1; i <= num; i++) {
            // Se o número parâmetro dividido pelo número atual da iteração sobra 0, incremento o contador de divisores
            if(num % i == 0) qtdDivisores++;
        }

        // Retorna o booleano, true = primo
        return qtdDivisores == 2;
    }
}