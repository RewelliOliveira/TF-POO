package TFPOO;

public enum Beneficios {
    SALARIOEST(1500.78),
    SALARIOVEN(1320.34),
    VALEREFE(489.89),
    VALETRANSP(234.67);
    private double vale;

    private Beneficios( double vale){
        this.vale = vale;
    }


    //Getters e Setters
    public double getVale() {
        return vale;
    }
    public void setVale(double vale) {
        this.vale = vale;
    }
}
