import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();

    private String[] categorias = {"Novela", "Ciencia", "Historia"};

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println("--------------------");
            System.out.println("Código: " + libro.getCodigo());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Disponible: " + libro.isDisponible());
        }
    }

    public Libro buscarLibro(int codigo) throws LibroNoEncontradoException {
        for (Libro libro : libros) {
            if (libro.getCodigo() == codigo) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("No se encontró el libro");
    }

    public void prestarLibro(int codigo) throws LibroNoEncontradoException {
        Libro libro = buscarLibro(codigo);

        if (libro.isDisponible()) {
            libro.setDisponible(false);
            System.out.println("Libro prestado correctamente.");

        } else{
            System.out.println("El libro ya está prestado.");
        }
    }

    public void devolverLibro(int codigo) throws LibroNoEncontradoException {
    Libro libro = buscarLibro(codigo);

    if (!libro.isDisponible()) {
        libro.setDisponible(true);
        System.out.println("Libro devuelto correctamente.");
    } else {
        System.out.println("El libro ya estaba disponible.");
        }
    }

    public void mostrarCategorias() {
    for (String categoria : categorias) {
        System.out.println(categoria);
    }
}


}
