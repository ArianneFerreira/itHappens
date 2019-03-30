package grupoMateus.estoque.models;


import javax.persistence.*;

@Entity
@Table(name = "item_pedido_estoque")
public class ItemPedidoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_pedido_estoque")
    private PedidoEstoque pedidoEstoque;

    //-------------------------------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PedidoEstoque getPedidoEstoque() {
        return pedidoEstoque;
    }

    public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
        this.pedidoEstoque = pedidoEstoque;
    }
}
