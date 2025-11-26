package Atv;


import java.util.*;
public class EscolaApp {


   public static void main(String[] args) {


       CatalogoCursos<Curso> catalogo = new CatalogoCursos<>();
       List<Curso> iniciais = Arrays.asList(
               new CursoPresencial("C001", "java fundamentos", 1200.00, 40),
               new CursoPresencial("C002", "desenvolvimento eeb", 1400.00, 50),
               new CursoPresencial("C003", "algoritmos e logica", 1000.00, 30),
               new CursoPresencial("C004", "estruturas de dados", 1500.00, 60),


               new CursoOnline("C005", "poo em Java", 900.00, "plataforma X", true),
               new CursoOnline("C006", "banco de dados", 800.00, "plataforma Y", false),
               new CursoOnline("C007", "desenvolvimento frontend", 950.00, "plataforma X", true),
               new CursoOnline("C008", "apis rest em java", 1100.00, "plataforma Z", true),
               new CursoOnline("C009", "devops basico", 1050.00, "plataforma Y", false),
               new CursoOnline("C010", "introdução a Python", 700.00, "plataforma X", true)
       );


       iniciais.forEach(catalogo::adicionar);


       System.out.println("===== cursos cadastrados inicialmente =====");
       catalogo.listarCursos();


       Scanner sc = new Scanner(System.in);


       try {
           System.out.println("\n--- cadastro de novo curso ---");
           System.out.print("tipo (P/O): ");
           String tipo = sc.nextLine().toUpperCase();


           System.out.print("codigo: ");
           String codigo = sc.nextLine();


           System.out.print("titulo: ");
           String titulo = sc.nextLine();


           System.out.print("valor base: ");
           double valor = Double.parseDouble(sc.nextLine());


           Curso novo = null;


           if (tipo.equals("P")) {
               System.out.print("carga horaria: ");
               int ch = Integer.parseInt(sc.nextLine());
               novo = new CursoPresencial(codigo, titulo, valor, ch);


           } else if (tipo.equals("O")) {
               System.out.print("plataforma: ");
               String plat = sc.nextLine();


               System.out.print("material extra (S/N): ");
               boolean extra = sc.nextLine().equalsIgnoreCase("S");


               novo = new CursoOnline(codigo, titulo, valor, plat, extra);


           } else {
               System.out.println("tipo invalido. curso nao sera criado");
           }


           if (novo != null) {
               catalogo.adicionar(novo);
               System.out.println("curso cadastradp");
           }


           System.out.println("\n===== lista atualziada =====");
           catalogo.listarCursos();


           System.out.println("\n--- fazer inscriçao ---");


           System.out.print("codigo do curso: ");
           String cod = sc.nextLine();


           Curso curso = catalogo.buscarPorCodigo(cod);


           System.out.println("curso encontrado:");
           System.out.println(curso);


           System.out.print("quanditdade de matriculas: ");
           int qtd = Integer.parseInt(sc.nextLine());


           if (qtd <= 0) {
               throw new IllegalArgumentException("quantidade precisa ser msior que zero.");
           }


           curso.inscrever(qtd);


           double total = curso.calcularValorTotal(qtd);
           System.out.println("total a pagar: R$ " + total);


           System.out.println("\n---aplicar desconto---");


           System.out.print("codigo do curso: ");
           String codDesc = sc.nextLine();


           Curso cDesc = catalogo.buscarPorCodigo(codDesc);


           System.out.print("percentuall: ");
           double perc = Double.parseDouble(sc.nextLine());


           if (perc <= 0) {
               throw new IllegalArgumentException("Percentual inválido.");
           }
           cDesc.aplicarDesconto(perc);


           System.out.println("desconto aplicado ");
           System.out.println("novo valor base R$ " + cDesc.getValorBase());


           System.out.println("\n===== lista final =====");
           catalogo.listarCursos();


       }
       catch (NumberFormatException e) {
           System.out.println("erro: valor numerico invalido.");
       }
       catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
       }
       catch (Exception e) {
           System.out.println("erro inesperado: " + e.getMessage());
       }
       finally {
           sc.close();
           System.out.println("\nsistema encerrrado");
       }
   }
}
