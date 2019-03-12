package base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Character implements Disposable {
    // Atributos
    public Vector2 posicion;
    public Vector2 velocidad;
    public Vector2 tamano;
    public TextureRegion imagen;
    public Rectangle hb;

    // Constructor
    public Character(TextureRegion imagen){
        this.imagen = imagen;
        tamano = new Vector2(imagen.getRegionWidth(), imagen.getRegionHeight());
        posicion = new Vector2(0,0);
        hb = new Rectangle(posicion.x, posicion.y, tamano.x, tamano.y);

    }

    public void pintar(SpriteBatch batch){
        batch.draw(imagen, posicion.x, posicion.y);
    }

    public void moveRight(){
        posicion.add(velocidad);
        hb.setPosition(posicion);
    }

    public void moveLeft(){
        posicion.sub(velocidad);
        hb.setPosition(posicion);
    }

    public void moveUp(){
        posicion.add(velocidad);
        hb.setPosition(posicion);
    }

    public void moveDown(){
        posicion.sub(velocidad);
        hb.setPosition(posicion);
    }

    @Override
    public void dispose() {

    }
}
