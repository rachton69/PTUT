package com.me.cheetah;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
//import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Stage;


public class Cheetah implements ApplicationListener {

	private SpriteBatch batch;
	private Texture texture;
	private Personnage cheetah;
	//private Stage stage;
    private static Cheetah instance;
    private KeyListener KeyListener;
   // private Region map;
    //private OrthographicCamera camera;
	private Map maMap;
	
	
	
	@Override
	public void create() {	
		KeyListener= new KeyListener();
		Gdx.input.setInputProcessor(KeyListener);
		//float w = Gdx.graphics.getWidth();
		//float h = Gdx.graphics.getHeight();
		cheetah = new Personnage();
		//map= new Region(1,"Stage1");
		batch = new SpriteBatch();
		//camera = new OrthographicCamera (480, 320);
		maMap = new Map();
		
		/*		
        //Create a touchpad skin    
        touchpadSkin = new Skin();
        //Set background image
        touchpadSkin.add("touchBackground", new Texture(""));
        //Set knob image
        touchpadSkin.add("touchKnob", new Texture(""));
        //Create TouchPad Style
        touchpadStyle = new TouchpadStyle();
        //Create Drawable's from TouchPad skin
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        //Apply the Drawables to the TouchPad Style
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        //Create new TouchPad with the created style
        touchpad = new Touchpad(10, touchpadStyle);
        //setBounds(x,y,width,height)
        touchpad.setBounds(15, 15, 200, 200);
 
        //Create a Stage and add TouchPad
        stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true, batch);
        stage.addActor(touchpad);            
        Gdx.input.setInputProcessor(stage);
	*/
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}
 
	@Override
	public void render() {	
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		/*stage.act(Gdx.graphics.getDeltaTime());            
        stage.draw();
		cheetah.avancer(touchpad.getKnobPercentX()*100);*/

		batch.begin();
		//map.render(camera, batch);
		maMap.dessiner(batch);
		cheetah.dessiner(batch);
		cheetah.tick();
		cheetah.dessiner(batch);
		batch.end();
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
	
	public void quit() {
		Gdx.app.exit();
	}

	public static Cheetah getInstance() {
		return instance;
	}
	public SpriteBatch getBatch() {
		return batch;
	}
		

	/*public Region getRegion(){
		return map;
	}*/
}
