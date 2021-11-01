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
                metodosBuscarPedido();
                break;
                
                case 4:
                // removerPedido();
                metodosRemoverPedido();
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
            // produto.setPedidoNome(nomeProduto);
            
            System.out.println("Código de Identificação: ");
            int idProduto = sc.nextInt();
            // produto.setPedidoID(idProduto);
            
            System.out.println("Valor: ");
            float valorProduto = sc.nextFloat();
            // produto.setValorTotalCalculado(valorProduto);
            
            listaPedidos.add(new Pedidos(nomeProduto, idProduto, valorProduto));
            
            System.out.println("\nSeu pedido de ["+ nomeProduto +"] foi confirmado.");
            System.out.printf("\nNome: %s\nID: %d\nPreço: %.2f\n", nomeProduto, idProduto, valorProduto);
            System.out.println("\n----Novo pedido[1] ---- Voltar[0]----");
            n = sc.nextInt();
        }
        // sc.close();
    };
    // Tentar fezer sistema de emumeração da lista
    public void listarPedido(){
        System.out.printf("\n--------Lista de pedidos--------\n");
        int i = 1;
        for (Pedidos numlista: listaPedidos) {
            System.out.printf("Ordem %d- %s ID: %d\n", i, numlista, numlista.getPedidoID());
            i++;
        }
    }
    
    public void buscarPedido(){
        int fazer = 1;
        int n;
        
        do{
            System.out.println("\n--------Buscar pedido--------\n Ordem: ");
            n = sc.nextInt() - 1;
            if (listaPedidos.isEmpty()){
                System.out.println("Lista vazia!");
                return;
            } else if(n >= listaPedidos.size() || n < 0) {
                System.out.println("Erro: Este pedido não está na lista.\n");
            } else {
                // Pedidos pedido = listaPedidos.get(n);
                System.out.println("Pedido: " + listaPedidos.get(n) + " - ID: " + listaPedidos.get(n).getPedidoID());
            }
            System.out.println("\n----Buscar outro[1] -------- Voltar[0]----");
            fazer = sc.nextInt();
        } while(fazer == 1);
        metodosBuscarPedido();
    }

    public Pedidos buscarPedidoID(){
        System.out.println("\n--------Buscar Pedido--------\n ID:");
        int id = sc.nextInt();
        boolean pedido = false;

        for (Pedidos a : listaPedidos) 
        {
            if (a.getPedidoID() == id){
                pedido = true;
                System.out.println("\nPedido: [" + a + "]");
                break;
            };
        }
        // System.out.println(pedido);

        if (listaPedidos.isEmpty())
        {
            System.out.println("Lista vazia!");
        } 
        else if(pedido == false) 
        {
            System.out.println("Erro: Este pedido não está na lista.\n");
        } 
        metodosBuscarPedido();
        return null;
    }

    public void metodosBuscarPedido(){
        System.out.println("");
        System.out.println("- Buscar pela Ordem da lista [1]\n- Buscar pelo ID [2]\n- Menu [0]");
        int escolha = sc.nextInt();


        switch(escolha){

            case 0:
            return;
            
            case 1:
            buscarPedido();
            break;

            case 2:
            buscarPedidoID();
            break;

            default:
            System.out.println("\nErro: Tente novamente.\n");
            metodosBuscarPedido();
        }
    }

    // Criar um voltar caso digite sem querer removar pedido.
    public void removerPedido(){
        int fazer = 1;
        int n;
        
        do{
            System.out.println("\n--------Remover Pedido--------\n Ordem:");
            n = sc.nextInt() - 1;
            if (listaPedidos.isEmpty()){
                System.out.println("Lista vazia!");
                return;
            } else if(n >= listaPedidos.size() || n < 0) {
                System.out.println("Erro: Este pedido não está na lista.\n");
            } else {
                Pedidos pedido = listaPedidos.get(n);
                listaPedidos.remove(listaPedidos.indexOf(pedido));
                System.out.println("\nSeu pedido ["+ pedido +"] foi removido.\n");
                listarPedido();
            }
            System.out.println("\n----Remover outro[1] -------- Voltar[0]----");
            fazer = sc.nextInt();
        } while(fazer == 1);
        metodosRemoverPedido();
    };

    public Pedidos removerPedidoID(){
        int fazer = 1;

        do{
            System.out.println("\n--------Remover Pedido--------\n ID:");
            int id = sc.nextInt();
            boolean pedido = false;
    
            for (Pedidos a : listaPedidos) 
            {
                if (a.getPedidoID() == id){
                    pedido = true;
                    listaPedidos.remove(a);
                    System.out.println("Pedido: [" + a + "] removido com sucesso!");
                    listarPedido();
                    break; // kit kat
                };
            }    

            if (listaPedidos.isEmpty())
            {
                System.out.println("Lista vazia!");
            } 
            else if(pedido == false) 
            {
                System.out.println("Erro: Este pedido não está na lista.\n");
            }

            System.out.println("\n----Remover outro[1] -------- Voltar[0]----");
            fazer = sc.nextInt();
        }while(fazer == 1);
        metodosRemoverPedido();
        return null;
    }

    public void metodosRemoverPedido(){
        System.out.println("");
        System.out.println("- Remover pela Ordem da lista [1]\n- Remover pelo ID [2]\n- Menu [0]");
        int escolha = sc.nextInt();


        switch(escolha){

            case 0:
            return;
            
            case 1:
            removerPedido();
            break;

            case 2:
            removerPedidoID();
            break;

            default:
            System.out.println("\nErro: Tente novamente.\n");
            metodosRemoverPedido();
        }
    }
    
    public void metodos(){
        listaPedidos.add(new Pedidos("nomeProduto", 1));
        listaPedidos.add(new Pedidos("roger", 2));
        listaPedidos.add(new Pedidos("rebeca", 398));
        listaPedidos.add(new Pedidos("renata", 4));
    };

    public void metodosID(){
        listaPedidos.add(new Pedidos(000));
        listaPedidos.add(new Pedidos(001));
        listaPedidos.add(new Pedidos(12));
        listaPedidos.add(new Pedidos(123));
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
        // i.metodosID();
        i.menu();
        
    }
}
