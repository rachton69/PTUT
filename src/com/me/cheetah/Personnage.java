package com.me.cheetah;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch; 
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Personnage {
		float coordonneeX=20 ;//position du personnage
		float coordonneeY=50;
		float hauteur;
		float largeur;
		Texture image;
		private float temps=0;
		private float v0=120;
		private float gravite = 100f;
		private float y0=0;
		private int saut=0;
		private Texture sheetTexture;
		private TextureRegion[] tabRegion;
		private int nombre_image;
		private Animation animation;
		private float temps2;
	    private float duree_animation = 0.25f;
	    private TextureRegion regionCourante;
		private Texture imageSaut;
		private TextureRegion[] tabRegion2;
		private TextureRegion regionCourante2;
		private Animation animation2;
		private int nombre_image2;
		private float duree_animation2=1f;
		private int scores;
		
		public Personnage(){
			
			
			 
			hauteur=87;
			largeur=64;
			nombre_image=4;
			nombre_image2=3;
			scores=0;
			
			image= new Texture(Gdx.files.internal("perso3.png"));
			TextureRegion[][] tmp = TextureRegion.split(image, (int) largeur, (int) hauteur);
			tabRegion = new TextureRegion[nombre_image];
	        int index = 0;
	        // animation course 
	        for(int j = 3; j >= 0; j--) {
	        	tabRegion[index++] = tmp[0][j];
	        }
	        animation = new Animation(duree_animation, tabRegion);
	        temps2=0.0f;
	        
	        // animation saut          
	        imageSaut= new Texture(Gdx.files.internal("persoSaut.png"));
			TextureRegion[][] tmp2 = TextureRegion.split(imageSaut, (int) largeur, (int) hauteur);
			tabRegion2 = new TextureRegion[nombre_image2];
		    int index2 = 0;
		    for(int j = 2; j >= 0; j--) {
		    	tabRegion2[index2++] = tmp2[0][j];
		    }
		    animation2 = new Animation(duree_animation2, tabRegion2);
		    temps2=2.0f;
		    
		    
		    
		}
		
		public void dessiner(SpriteBatch batch){
			
			if (saut>0) {
				
				temps+= Gdx.graphics.getDeltaTime();
				coordonneeY=-(0.5f)*gravite*temps*temps+v0*temps+y0;
				
				if (coordonneeY<50) {
					
					coordonneeY=50;
					saut=0;

				}
			}
			duree_animation=duree_animation-0.f;
			temps2 += Gdx.graphics.getDeltaTime();                   
	        regionCourante = animation.getKeyFrame(temps2, true);  
	        regionCourante.setRegion(regionCourante, 0, 0,(int) largeur, (int) hauteur);
	        if (saut==0){
	        	batch.draw(regionCourante, coordonneeX, coordonneeY, largeur, hauteur);		
	        }
			regionCourante2 = animation2.getKeyFrame(temps2, true);  
	        regionCourante2.setRegion(regionCourante2, 0, 0,(int) largeur, (int) hauteur);
			if (saut>0){
				//temps2=5f;
				batch.draw(regionCourante2, coordonneeX, coordonneeY, largeur, hauteur);	
				
			}
		}
		
		public void tick(){
			 if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.Q)) {
				reculer(2);
				 
			 }
			 if(Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
				 avancer(2);
			 }
			 if(Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isTouched()) {
				 sauter();
				
				
			 }
		}
		
		public void avancer (float deplacement){
			coordonneeX+=deplacement;
		}

		public void reculer (float deplacement){
			coordonneeX-=deplacement;
		}
		
		public void sauter (){
			if (saut==0  || (saut<2 && temps>0.5f)  )
			{
				temps=0;
				y0=coordonneeY;
				saut++;
			}
				
				
			
		}
		
}
