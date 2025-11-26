package Atv;


public class CursoOnline extends Curso {


   private String plataforma;
   private boolean materialExtra;


   public CursoOnline(String codigo, String titulo, double valorBase,
                      String plataforma, boolean materialExtra) {
       super(codigo, titulo, valorBase);
       this.plataforma = plataforma;
       this.materialExtra = materialExtra;
   }


   @Override
   public void aplicarDesconto(double percentual) {
       if (percentual > 50) {
           percentual = 50;
       }


       double desconto = valorBase * (percentual / 100);
       valorBase -= desconto;
   }


   @Override
   public String toString() {
       return "[online] " + super.toString() +
               " | plataforma: " + plataforma +
               " | material extra: " + (materialExtra ? "sim" : "nao");
   }
}


