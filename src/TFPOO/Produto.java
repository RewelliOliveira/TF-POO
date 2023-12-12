package TFPOO;

class Produto {
    private String nomeProduto, tipoProduto;
    private int qntProduto, cdgProduto;
    private Double valorProduto;

    public Produto(int cdgProduto, String nomeProduto, String tipoProduto, int qntProduto,Double valorProduto){
        setCdgProduto(cdgProduto);
        setNomeProduto(nomeProduto);
        setTipoProduto(tipoProduto);
        setQntProduto(qntProduto);
        setValorProduto(valorProduto);
    }

    public Produto() {
    }

    //Getters e Setters
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQntProduto() {
        return qntProduto;
    }
    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getCdgProduto() {
        return cdgProduto;
    }
    public void setCdgProduto(int cdgProduto) {
        this.cdgProduto = cdgProduto;
    }
}
