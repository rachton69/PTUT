package com.me.cheetah;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
 
public class Block {
 
    static final float SIZE = 1f;
 
    Vector2     position = new Vector2();
    Rectangle   bounds = new Rectangle();
 
    public Block(Vector2 pos) {
        this.position = pos;
        this.bounds.width = SIZE;
        this.bounds.height = SIZE;
        this.bounds.x = this.position.x;
        this.bounds.y = this.position.y;
    }

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
    
}