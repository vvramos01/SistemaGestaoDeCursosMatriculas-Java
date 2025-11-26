package Atv;


import java.util.ArrayList;
import java.util.List;


public class CatalogoCursos<T extends Curso> {
   private List<T> cursos = new ArrayList<>();


   public void adicionar(T curso) {
       cursos.add(curso);
   }
   public boolean removerPorCodigo(String codigo) {
       return cursos.removeIf(c -> c.getCodigo().equalsIgnoreCase(codigo));
   }


   public T buscarPorCodigo(String codigo) {
       return cursos.stream()
               .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("curso nao encontrado: " + codigo));
   }


   public List<T> getCursos() {
       return cursos;
   }


   public void listarCursos() {
       cursos.forEach(c -> System.out.println(c));
   }
}




