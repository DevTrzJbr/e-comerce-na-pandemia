import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedidos {
    private String pedidoNome;
    private int pedidoID;
    private String dataEmissao;
    private float valorTotalCalculado;


    public Pedidos() {
    }

    public Pedidos(String nome) {
        this.pedidoNome = nome;
    }

    public Pedidos(String nome, int id) {
        this.pedidoNome = nome;
        this.pedidoID = id;
        this.valorTotalCalculado = 0;
        gerarDataEmissao();        
    }

    public Pedidos(String nome, int id, float valor) {
        this.pedidoNome = nome;
        this.pedidoID = id;
        this.valorTotalCalculado = valor;     
        gerarDataEmissao();
    }

    public Pedidos(int id) {
        this.pedidoNome = "nome";
        this.pedidoID = id;
        this.valorTotalCalculado = 0;        
    }

    public String getPedidoNome() {
        return this.pedidoNome;
    }

    public void setPedidoNome(String pedidoNome) {
        this.pedidoNome = pedidoNome;
    }

    public int getPedidoID() {
        return this.pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getDataEmissao() {
        
        return this.dataEmissao;
    }

    public void gerarDataEmissao() {
        LocalDateTime myDateObj = LocalDateTime.now();
        this.dataEmissao = myDateObj.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public float getValorTotalCalculado() {
        return this.valorTotalCalculado;
    }

    public void setValorTotalCalculado(float valorTotalCalculado) {
        this.valorTotalCalculado = valorTotalCalculado;
    }
    // Por definição Pedido retorna o nome.
    @Override
    public String toString(){
        return this.pedidoNome;
    }

}
