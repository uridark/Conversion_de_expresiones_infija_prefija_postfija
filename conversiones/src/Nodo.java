public class Nodo {
    char datos;
    Nodo siguienteNodo;
    Nodo( char objeto )
    {
        this( objeto, null );
    }
    Nodo( char objeto, Nodo nodo )
    {
        datos = objeto;
        siguienteNodo = nodo;
    }
    char obtenerChar()
    {
        return datos;
    }


    Nodo obtenerSiguiente()
    {
        return siguienteNodo;
    }
}
