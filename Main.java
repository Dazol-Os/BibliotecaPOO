import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    biblioteca.mostrarCategorias();
                    System.out.print("Código del libro: ");
                    int codigo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();

                    Libro libro = new Libro(codigo, titulo, autor, true);
                    biblioteca.agregarLibro(libro);

                    System.out.println("Libro registrado correctamente.");
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;
                
                case 3:
                    System.out.print("Ingrese el código del libro: ");
                    int codigoPrestamo = Integer.parseInt(scanner.nextLine());

                    try {
                        biblioteca.prestarLibro(codigoPrestamo);
                    } catch (LibroNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el código del libro: ");
                    int codigoDevolucion = Integer.parseInt(scanner.nextLine());

                    try {
                        biblioteca.devolverLibro(codigoDevolucion);
                    } catch (LibroNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Saliendo de la biblioteca...");
                    break;

                default:
                    System.out.println("Opción no valida.");
            }

        } while (opcion != 5);


    scanner.close();
    }
    
    
    
}
