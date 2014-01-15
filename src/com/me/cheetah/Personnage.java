package com.me.cheetah;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Personnage {
		float coordonneeX ;
		float coordonneeY;
		float hauteur;
		float largeur;
		Texture image;
		
		public Personnage(){
			hauteur=32;
			largeur=32;
			image= new Texture(Gdx.files.internal("droite1.png"));
		}
		
		public void dessiner(SpriteBatch batch){
			batch.draw(image, Gdx.graphics.getWidth()/2, 0, largeur, hauteur);
		}
		/*public void avancer (float deplacement){
			coordonneeX+=deplacement;
		}*/

}
