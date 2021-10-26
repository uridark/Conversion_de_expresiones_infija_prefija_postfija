public class Lista {
        private Nodo primerNodo;
        private Nodo ultimoNodo;
        private Nodo actualNodo;
        private String nombre;


        public Lista() {
            this("lista");
        }

        public Lista(String nombreLista) {
            nombre = nombreLista;
            primerNodo = ultimoNodo = null;
        }

        public void insertarAlFrente(char elementoInsertar) {
            if (estaVacia())
                primerNodo = ultimoNodo = new Nodo(elementoInsertar);
            else
                primerNodo = new Nodo(elementoInsertar, primerNodo);
        }

        public Object eliminarDelFrente() throws ListaVacia {
            if (estaVacia())
                throw new ListaVacia(nombre);

            Object elementoEliminado = primerNodo;


            if (primerNodo == ultimoNodo)
                primerNodo = ultimoNodo = null;
            else
                primerNodo = primerNodo.siguienteNodo;

            return elementoEliminado;
        }


        public boolean estaVacia() {
            return primerNodo == null;
        }

    }
