import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja{
    Scanner sc = new Scanner(System.in);
    private List <Pedidos> listaPedidos = new ArrayList<>();
    
    public Funcionario dono = new Funcionario("Vinicius", 123); // Melhorar sistema de funcionários (Perguntar ao professor)
    public Pedidos produto = new Pedidos();
    
    public void menu(){
        boolean rodando = true;
        Scanner sc = new Scanner(System.in);

        while(rodando == true){
            System.out.println("");
            System.out.println("---------MENU----------");
            System.out.println("Fazer pedido[1] Listar pedido [2] Bucar pedido[3] Remover pedido[4] Sair[0]");
            System.out.println("Digite as opções:");
            int opcao = sc.nextInt();
            switch(opcao)
            {
                case 0:
                System.out.println("\nObrigado pela preferencia. Volte sempre!");
                System.out.println("Saindo...");
                rodando = false;
                break;
                
                case 1:
                System.out.println("Pedido");
                inserirPedido();
                break;

                case 2:
                System.out.println("\nListar pedido\n");
                listarPedido();
                break;

                case 3:
                System.out.println("\nBuscar pedido");
                buscarPedido();
                break;

                case 4:
                removerPedido();
                break;
                
                // case 4:
                // System.out.println("Pedido");
                // break;
                
                default:
                System.out.println("Opção inesistente.");
            }
        }
        sc.close();
    };
    
    public void inserirPedido(){
         // Consertar fechamento dos scanners (Perguntar ao professor)
        int n = 1;
        
        while(n != 0){
            System.out.println("Preencha os dados do pedido: ");
            
            System.out.println("Nome: ");
            String nomeProduto = sc.next();
            listaPedidos.add(new Pedidos(nomeProduto));
            produto.setPedidoNome(nomeProduto);
            
            // System.out.println("Código de Identificação: ");
            // int idProduto = sc.nextInt();
            // produto.setPedidoID(idProduto);
            
            // System.out.println("Valor: ");
            // float valorProduto = sc.nextFloat();
            // produto.setValorTotalCalculado(valorProduto);
            
            System.out.println("Seu pedido de "+ nomeProduto +" foi confirmado.");
            System.out.println("Novo pedido[1]    Voltar[0]");
            n = sc.nextInt();
        }
        // sc.close();
    };
    // Tentar fezer sistema de emumeração da lista
    public void listarPedido(){
        System.out.printf("\n--------Lista de pedidos--------\n");
        int i = 1;
        for (Pedidos numlista: listaPedidos) {
          System.out.printf("Pedido %d- %s\n", i, numlista);
          i++;
        }
    }

    public void buscarPedido(){
        int n = sc.nextInt() - 1;
            if (listaPedidos.isEmpty()){
                System.out.println("Lista vazia!");
                return;
            } else if(n >= listaPedidos.size() || n < 0) {
                System.out.println("Erro: Este pedido não está na lista.\n");
            } else {
                // Pedidos pedido = listaPedidos.get(n);
                System.out.println(listaPedidos.get(n));
            }
    }
    
    public void removerPedido(){
        int fazer = 1;
        int n;
        
        do{
            System.out.println("\nRemover Pedido");
            n = sc.nextInt() - 1;
            if (listaPedidos.isEmpty()){
                System.out.println("Lista vazia!");
                return;
            } else if(n >= listaPedidos.size() || n < 0) {
                System.out.println("Erro: Este pedido não está na lista.\n");
            } else {
                Pedidos pedido = listaPedidos.get(n);
                listaPedidos.remove(listaPedidos.indexOf(pedido));
                listarPedido();
                System.out.println("\nSeu pedido ["+ pedido +"] foi removido.\n");
            }
            System.out.println("----Remover outro[1] -------- Voltar[0]----");
            fazer = sc.nextInt();
        } while (fazer == 1);
    };
    
    public void metodos(){
        listaPedidos.add(new Pedidos("nomeProduto"));
        listaPedidos.add(new Pedidos("roger"));
        listaPedidos.add(new Pedidos("rebeca"));
        listaPedidos.add(new Pedidos("renata"));
    };
    
    public static void main(String[] args) {
        Loja i = new Loja();
        

        // i.inserirPedido();
        // // i.inserirPedido("Maça");
        // // i.inserirPedido("Clovis");
        
        // i.listarPedido();
        
        // i.inserirPedido();
        // // i.removerPedido("Clovis");
        // i.listarPedido();
        
        // i.listarPedido();

        // System.out.println(dono.getNome());
        // System.out.println(dono.getMatricula());
        i.metodos();
        i.menu();
        
    }
}
