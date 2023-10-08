import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arvore arvore = new Arvore();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Remover elemento");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido:");
                    int valorInserir = scanner.nextInt();
                    arvore.insere(valorInserir);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser buscado:");
                    int valorBuscar = scanner.nextInt();
                    NodeArvore encontrado = arvore.busca(valorBuscar);
                    if (encontrado != null) {
                        System.out.println("Valor encontrado na árvore.");
                    } else {
                        System.out.println("Valor não encontrado na árvore.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor a ser removido:");
                    int valorRemover = scanner.nextInt();
                    arvore.remove(valorRemover);
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
