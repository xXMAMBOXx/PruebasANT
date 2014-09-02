package tareaprogramada1;
public class ListaCanciones {
    /** atributos de la clase lista de canciones*/
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private Nodo nodoActual;
    private Nodo nodoAnterior;
    private int size;
    /** clase privada Nodo*/
     private class Nodo
    {

        private Cancion dato;
        private Nodo siguiente;
        private Nodo anterior;
        
        /** Constructor sin parametros */
        public Nodo()
        {
            this.dato = null;
            this.siguiente = null;
           
        }
        /** Constructor con parametro Canción */
        public Nodo(Cancion inputDato)
        {
            this.dato = inputDato;
            this.siguiente = null;
            this.anterior=null;
           
        }
        /** Devuelve el dato del nodo */
        public Cancion obtenerDato()
        {
            return dato;
        }
        /** Establece el dato del nodo*/
        public void establecerDato(Cancion dato)
        {
            this.dato = dato;
        }
        /** Devuelve el dato del nodo siguiente */
        public Nodo obtenerSiguiente()
        {
            return siguiente; 
        }
        /** Establece el dato del nodo siguiente */
        public void establecerSiguiente(Nodo siguiente)
        {
            this.siguiente = siguiente;
        }    
    }
           

    /** Constructor de lista de canciones */
    public ListaCanciones() {
        primerNodo=null;
        ultimoNodo=null;
        nodoActual=null;
        nodoAnterior=null;
        this.size=0;
    }
    /** Agrega un nodo con la canción ingresada por parametro */
    public void agregar(Cancion i){
        Nodo nodo=new Nodo(i);
        if(primerNodo==null){
            primerNodo=nodo;
            ultimoNodo=nodo;
            nodoActual=nodo;
            nodoAnterior=null; 
        }else{
            ultimoNodo.establecerSiguiente(nodo);
            nodoAnterior=nodoActual;
            nodoActual=nodo;
            ultimoNodo=nodo;
        }
        size++;
    }
    
    public int getsize(){
        return this.size;
    }
    public void setsize(){
        if(this.size==0){
            return;
        }
        this.size--;
    }
    /** Mueve el puntero de nodo actual al principio*/
    public void moverAlPrincipio(){
        nodoActual=primerNodo;
    }
    /** Obtiene la canción del nodo actual(puntero)*/
    public Cancion obtenerCancion(){
        return nodoActual.obtenerDato();
    }
    /** Mueve el puntero del nodo actual al siguiente nodo*/
    public  void SiguienteNodo(){
        nodoAnterior=nodoActual;
        nodoActual=nodoActual.obtenerSiguiente(); 
    }    
    /** convierte la lista en un array para presentarlo al usuario*/
    public ArrayList ListatoArray(){
        ArrayList artistas=new ArrayList(this.size);
        int sizet=this.size;
        this.moverAlPrincipio();
        while(sizet--!=0){
            System.out.println(obtenerCancion().getArtista());
            artistas.add(obtenerCancion());
            nodoActual=nodoActual.obtenerSiguiente();
        }
        nodoActual=primerNodo;
        return artistas;
          
    }
    /** Elimina la cancion que el usuario decida
     */
    public ListaCanciones eliminar(Cancion x){
        this.moverAlPrincipio();
        ListaCanciones temporal=new ListaCanciones();
        int i=0;
        while(i!=this.size){
            System.out.println("es "+this.nodoActual.obtenerDato().getTitulo()+"igual a "+x.getTitulo());
            if (this.obtenerCancion()!=x){
                temporal.agregar(this.nodoActual.obtenerDato());}
            
                this.SiguienteNodo();
            i++;
        }
        return temporal;


    }
   

   
        
    
        
    }

    

