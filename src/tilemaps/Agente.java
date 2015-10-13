/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilemaps;


import java.awt.Graphics2D;
import java.awt.Image;


public class Agente {
	
    
	private float x, y; //Posicion actual
	
	private Image image;
	
	private Map map;

	private float size = 0.3f;
	
	/**
	 * Create a new entity in the game
	 * 
	 * @param image The image to represent this entity (needs to be 32x32)
	 * @param map The map this entity is going to wander around
	 * @param x The initial x position of this entity in grid cells
	 * @param y The initial y position of this entity in grid cells
	 */
	public Agente(Image image, Map map, float x, float y) {
		this.image = image;
		this.map = map;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Move this entity a given amount. This may or may not succeed depending
	 * on collisions
	 * 
	 * @param dx The amount to move on the x axis
	 * @param dy The amount to move on the y axis
	 * @return True if the move succeeded
	 */
	public boolean move(float dx, float dy) {
		// work out what the new position of this entity will be

		float nx = x + dx;
		float ny = y + dy;
		
		// check if the new position of the entity collides with

		// anything

		if (validLocation(nx, ny)) {
			// if it doesn't then change our position to the new position

			x = nx;
			y = ny;
			
						
			return true;
		}
		
		// if it wasn'n't do anything apart from 
		// tell the caller

		return false;
	}
	
	/**
	 * Check if the entity would be at a valid location if its position
	 * was as specified
	 * 
	 * @param nx The potential x position for the entity
	 * @param ny The potential y position for the entity
	 * @return True if the new position specified would be valid
	 */
	public boolean validLocation(float nx, float ny) {
		// here we're going to check some points at the corners of

		// the player to see whether we're at an invalid location

		// if any of them are blocked then the location specified

		// isn't valid

		if (map.blocked(nx - size, ny - size)) {
			return false;
		}
		if (map.blocked(nx + size, ny - size)) {
			return false;
		}
		if (map.blocked(nx - size, ny + size)) {
			return false;
		}
		if (map.blocked(nx + size, ny + size)) {
			return false;
		}
		
		// if all the points checked are unblocked then we're in an ok

		// location

		return true;
	}
	
	/**
	 * Draw this entity to the graphics context provided.
	 * 
	 * @param g The graphics context to which the entity should be drawn
	 */
	public void paint(Graphics2D g) {
		
	}
}