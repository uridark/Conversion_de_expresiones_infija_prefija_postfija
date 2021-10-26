public class ListaVacia  extends RuntimeException
{
    // constructor sin argumentos
    public ListaVacia()
    {
        this( "Lista" ); // llama al otro constructor de ListaVacia
    } // fin del constructor de ListaVacia sin argumentos

    // constructor con un argumento
    public ListaVacia( String nombre )
    {
        super( nombre + " esta vacia" ); // llama al constructor de la superclase
    } // fin del constructor de ExcepcionListaVacia con un argumento
}

