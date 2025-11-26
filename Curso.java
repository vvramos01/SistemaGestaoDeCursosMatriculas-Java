package Atv;


public abstract class Curso implements Inscrevivel {


   protected String codigo;
   protected String titulo;
   protected double valorBase;


   public Curso(String codigo, String titulo, double valorBase) {
       this.codigo = codigo;
       this.titulo = titulo;
       this.valorBase = valorBase;
   }


   public String getCodigo() {
       return codigo;
   }


   public String getTitulo() {
       return titulo;
   }


   public double getValorBase() {
       return valorBase;
   }


   public abstract void aplicarDesconto(double percentual);


   @Override
   public double calcularValorTotal(int quantidade) {
       return valorBase * quantidade;
   }


   @Override
   public void inscrever(int quantidade) {
       double total = calcularValorTotal(quantidade);
       System.out.println("matriculas realizadas: " + quantidade);
       System.out.println("vvalor total: R$ " + total);
   }


   @Override
   public String toString() {
       return codigo + " - " + titulo + " (R$ " + valorBase + ")";
   }
}
