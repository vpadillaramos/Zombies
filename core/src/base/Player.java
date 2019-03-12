package base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import manager.R;

public class Player extends Character implements Disposable {

    // Constantes
    private final float VELOCIDAD_X = 5;
    private final float VELOCIDAD_Y = 5;

    // Atibutos

    // Animaciones
    public enum Estado{
        IDLE, RIGHT, LEFT, FRONT, BACK;
    }
    public Estado estado;
    public Animation<TextureAtlas.AtlasRegion> animationLeft;
    public Animation<TextureAtlas.AtlasRegion> animationRight;
    public Animation<TextureAtlas.AtlasRegion> animationFront;
    public Animation<TextureAtlas.AtlasRegion> animationBack;
    public float tiempo;

    public Player(TextureRegion imagen) {
        super(imagen);
        this.imagen = imagen;
        posicion = new Vector2(40, 40);
        //tamano = new Vector2(imagen.getRegionWidth(), imagen.getRegionHeight());
        //hb = new Rectangle(posicion.x, posicion.y, tamano.x, tamano.y);
        velocidad = new Vector2(VELOCIDAD_X, VELOCIDAD_X);
        hb.setPosition(posicion);


        // Carga de animaciones
        animationLeft = new Animation(0.1f, R.getAnimacion("walkLeft"), Animation.PlayMode.LOOP);
        animationRight = new Animation(0.1f, R.getAnimacion("walkRight"), Animation.PlayMode.LOOP);
        animationFront = new Animation(0.1f, R.getAnimacion("walkFront"), Animation.PlayMode.LOOP);
        animationBack = new Animation(0.1f, R.getAnimacion("walkBack"), Animation.PlayMode.LOOP);
        estado = Estado.IDLE;
    }

    // Metodos

    public void moverPlayer(){
        controles();
    }

    public void actualizarSprite(float delta){
        tiempo += delta;

        switch (estado){
            case RIGHT:
                imagen = animationRight.getKeyFrame(tiempo, false);
                break;
            case LEFT:
                imagen = animationLeft.getKeyFrame(tiempo, false);
                break;
            case FRONT:
                imagen = animationFront.getKeyFrame(tiempo, false);
                break;
            case BACK:
                imagen = animationBack.getKeyFrame(tiempo, false);
                break;
            case IDLE:
                imagen = R.getRegion("walkFront_1");
                break;
        }
    }

    public void controles(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            moveRight();
            estado = Estado.RIGHT;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            moveLeft();
            estado = Estado.LEFT;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            moveUp();
            estado = Estado.BACK;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            moveDown();
            estado = Estado.FRONT;
        }
        else{
            estado = Estado.IDLE;
        }
    }
}
