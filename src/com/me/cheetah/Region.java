package com.me.cheetah;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Region {
	
	private int id;
	private String name;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private SpriteBatch batch;
	
	public Region(int id, String name ){
		this.id=id;
		this.name=name;
		this.map= new TmxMapLoader().load("regions/map.tmx");
		renderer = new OrthogonalTiledMapRenderer(map, batch);
	}
	
	public void render(OrthographicCamera camera, SpriteBatch batch){
		renderer.setView(camera);
		renderer.render();
	}
	
	
	
	
	
	
	
	
	
	
}