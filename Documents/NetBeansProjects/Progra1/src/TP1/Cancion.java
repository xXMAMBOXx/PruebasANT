package TP1;

public class Cancion {
    /**
     * Estos son los atributos de la clase canción
     */
    String  Nombre,Artista,Album,genero,ruta,rutaI=null;
    int duracion;
    /**Creamos la clase necesaria para reproducir mp3
     */
    CustomPlayer reproducir=new CustomPlayer();
    /**Constructor de la clase canción
     * 
     * @param ruta 
     * con con la clase metadatos saca la información del archivo en ruta
     */
    Cancion(String ruta){
        this.ruta=ruta;
        MetaDatos datos=new MetaDatos();
        datos.meta(ruta);
        Artista=datos.getArtista();
        Album=datos.getAlbum();
        genero=datos.getgenero();
        duracion=datos.getduracion();
        Nombre=datos.getTitulo();
        try{
        datos.guardarImagen();
        rutaI=datos.getImagen();
        }catch(Exception e){}
    }
    /**
    Función get de la imagen(ruta)
     */
    public String getImagen(){
    return this.rutaI;
    }
    /**
    Función get del artista
     */
    public String getArtista(){
    return this.Artista;
    }
    /**
    Función get del titulo
     */
    public String getTitulo(){
    return this.Nombre;
    }
    /**
    Función get del album
     */
    public String getAlbum(){
    return this.Album;
    }
    /**
    Función get de la duración
     */
    public int getduracion(){
    return duracion;
    }
    /**
    Función get del género
     */
    public String getgenero(){
    return this.genero;
    }
    /**
    Función set del nombre que el usuario va a modificar
     */
    public void setNombre(String m){
    this.Nombre=m;
    }
    /**
    Función set del Artista que el usuario  va a modificar
     */
    public void setArtista(String m){
    this.Artista=m;
    }
    /**
    Función set del Album que el usuario  va a modificar
     */
    public void setAlbum(String m){
        this.Album=m;
    }
    /**
    Función set del Genero que el usuario  va a modificar
     */
    public void setGenero(String m){
        this.genero=m;
    }
    /**
    Función set de la ruta de la nueva imagen que el usuario va a modificar
     */
    public void setImage(String ruta){
        this.rutaI=ruta;
    }
    /**Funciones de play y stop de la canción
     * 
     */
    public void PLAY(){
        reproducir.setPath(this.ruta);
        reproducir.play(-1);
    }
    public void STOP(){
        reproducir.setPath(this.ruta);
        reproducir.pause();
    }
}
