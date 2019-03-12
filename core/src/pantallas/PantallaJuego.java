package pantallas;

import base.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import manager.R;

public class PantallaJuego implements Screen {

    // Variables
    private SpriteBatch batch;

    // Camara
    private OrthographicCamera camera;
    private ExtendViewport viewport;

    // Player
    private Player player;

    @Override
    public void show() {
        batch = new SpriteBatch();

        // Player
        player = new Player(R.getRegion("idle"));

        // Camara

    }

    @Override
    public void render(float delta) {
        /////////////////////////
        /////////LOGICA//////////
        /////////////////////////
        player.moverPlayer();

        /////////////////////////
        /////////GRAFICO/////////
        /////////////////////////
        Gdx.gl.glClearColor(0.3f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        player.actualizarSprite(delta);
        //player.pintar(batch);
        System.out.println(player.imagen.getRegionWidth());
        //batch.draw(player.imagen, player.posicion.x, player.posicion.y);

        batch.end();
    }

    private void pintarPlayer(SpriteBatch batch, float delta){
        player.actualizarSprite(delta);
        player.pintar(batch);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
    }
}
