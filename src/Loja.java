import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja{
    
    private List <Pedidos> listaPedidos = new ArrayList<>();
    
    public Funcionario dono = new Funcionario("Vinicius", 123); // Melhorar sistema de funcionários (Perguntar ao professor)
    public Pedidos produto = new Pedidos();
    
    public void menu(){
        boolean rodando = true;
        Scanner sc = new Scanner(System.in);

        while(rodando == true){
            System.out.println("");
            System.out.println("---------MENU----------");
            System.out.println("Fazer pedido[1] Bucar pedido[2] Remover pedido[3] Sair[0]");
            System.out.println("Digite as opções:");
            int opcao = sc.nextInt();
            switch(opcao)
            {
                case 0:
                System.out.println("Obrigado pela preferencia. Volte sempre!");
                System.out.println("Saindo...");
                rodando = false;
                break;
                
                case 1:
                System.out.println("Pedido");
                inserirPedido();
                break;

                case 2:
                System.out.println("");
                System.out.println("Buscar pedido\n");
                buscarPedido();
                break;

                case 3:
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
        Scanner sc = new Scanner(System.in); // Consertar fechamento dos scanners (Perguntar ao professor)
        int n = 1;
        
        while(n != 0){
            System.out.println("Preencha os dados do pedido: ");
            
            System.out.println("Nome: ");
            String nomeProduto = sc.next();
            listaPedidos.add(new Pedidos(nomeProduto));
            produto.setPedidoNome(nomeProduto);
            
            System.out.println("Código de Identificação: ");
            int idProduto = sc.nextInt();
            produto.setPedidoID(idProduto);
            
            System.out.println("Valor: ");
            float valorProduto = sc.nextFloat();
            produto.setValorTotalCalculado(valorProduto);
            
            System.out.println("Seu pedido de "+ nomeProduto +" foi confirmado.");
            System.out.println("Novo pedido[1]    Voltar[0]");
            n = sc.nextInt();
        }
        // sc.close();
    };
    // Tentar fezer sistema de emumeração da lista
    public void buscarPedido(){
        System.out.println("---------Lista---------");
        for(Pedidos listaPedidos: listaPedidos)
        System.out.println(listaPedidos);
    };
    
    public void removerPedido(){
        // System.out.println("Seu pedido de "+ pedido +" foi removido.");
        Scanner sc = new Scanner(System.in);
        int n = 2;
        
        while(n != 0){
            System.out.println("");
            System.out.println("Remover Pedido");
            Pedidos pedido = listaPedidos.get(sc.nextInt() - 1);
            listaPedidos.remove(listaPedidos.indexOf(pedido));
            buscarPedido();
            System.out.println("----Remover outro[1] -------- Voltar[0]----");
            n = sc.nextInt();
            
            // Fazer logica caso a lista esteja vazia
        }
        // sc.close();
    };
    
    public void metodos(){};
    
    public static void main(String[] args) {
        Loja i = new Loja();
        

        // i.inserirPedido();
        // // i.inserirPedido("Maça");
        // // i.inserirPedido("Clovis");
        
        // i.buscarPedido();
        
        // i.inserirPedido();
        // // i.removerPedido("Clovis");
        // i.buscarPedido();
        
        // i.buscarPedido();

        // System.out.println(dono.getNome());
        // System.out.println(dono.getMatricula());

        i.menu();
        
    }
}
