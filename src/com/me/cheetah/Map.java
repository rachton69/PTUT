package com.me.cheetah;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
	
	

	private static float deplacementEcran;
	private static int hauteurEcran;
	private static Texture background;
	private static int largeurEcran;
	private int largeur_bg;
	private int vitesse;
	
	

	public Map()
	{
		hauteurEcran=Gdx.graphics.getHeight();
		largeurEcran= Gdx.graphics.getWidth();
		background=new Texture(Gdx.files.internal("fond.png"));
		largeur_bg=largeurEcran*2;
		vitesse=2;
	}
	
	
	 void dessiner(SpriteBatch batch) {
		 deplacementEcran-=vitesse;
		if (-deplacementEcran>largeur_bg) {
			deplacementEcran= deplacementEcran+largeur_bg;
			vitesse++;
		}
		batch.draw(background, deplacementEcran, 0, largeur_bg, hauteurEcran);
		batch.draw(background, largeur_bg+deplacementEcran, 0, largeurEcran*2, hauteurEcran);
		
		
	}

}
