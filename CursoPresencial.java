package Atv;


public class CursoPresencial extends Curso {


   private int cargaHoraria;


   public CursoPresencial(String codigo, String titulo, double valorBase, int cargaHoraria) {
       super(codigo, titulo, valorBase);
       this.cargaHoraria = cargaHoraria;
   }


   @Override
   public void aplicarDesconto(double percentual) {
       if (percentual > 20) {
           percentual = 20;
       }


       double desconto = valorBase * (percentual / 100);
       valorBase -= desconto;
   }


   @Override
   public String toString() {
       return "[presencial] " + super.toString() +
               " |carga horaria: " + cargaHoraria + "h";
   }
}
