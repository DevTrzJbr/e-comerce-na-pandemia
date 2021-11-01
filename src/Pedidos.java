import java.sql.Date;

public class Pedidos {
    private String pedidoNome;
    private int pedidoID;
    private Date dataEmissao;
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
    }

    public Pedidos(String nome, int id, float valor) {
        this.pedidoNome = nome;
        this.pedidoID = id;
        this.valorTotalCalculado = valor;        
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

    public Date getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
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
