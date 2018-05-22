package curso.seccion08.seccion08navigationdrawer.Models;

/**
 * Created by Rust on 20/05/2018.
 */

public class Place {
    public String namePlace;
    public int imgPlace;

    public Place(){

    }
    
    public Place(String namePlace, int imgPlace) {
        this.namePlace = namePlace;
        this.imgPlace = imgPlace;
    }

    public int getImgPlace() {
        return imgPlace;
    }

    public void setImgPlace(int imgPlace) {
        this.imgPlace = imgPlace;
    }

    public String getNombre() {
        return namePlace;
    }

    public void setNombre(String namePlace) {
        this.namePlace = namePlace;
    }

}

