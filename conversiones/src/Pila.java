public class Pila {
    private Lista listaPila;

    // constructor sin argumentos
    public Pila()
    {
        listaPila = new Lista( "pila" );
    }

    public void push( char objeto )
    {

        listaPila.insertarAlFrente( objeto );
    }
    public Object pop() throws ListaVacia
    {
        return listaPila.eliminarDelFrente();
    }
}
