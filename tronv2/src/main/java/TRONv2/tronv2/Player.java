package TRONv2.tronv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Player extends GamePhysics {

	Color				color;

	boolean				alive		= true;

	int					startVel	= 0;

	static int			WIDTH		= 5;
	static int			HEIGHT		= 5;
	static int			JUMPHEIGHT	= 16;

	ArrayList<Shape>	lines		= new ArrayList<Shape>();

	public Player(final int randX, final int randY, final int velx, final int vely, final Color color) {
		super(randX, randY, velx, vely, WIDTH, HEIGHT);
		this.startVel = Math.max(Math.abs(velx), Math.abs(vely));

		this.color = color;
	}

	@Override
	public void accelerate() {
		if ((this.x < 0) || (this.x > this.rightBound)) {
			this.velocityX = 0;
			this.alive = false;
		}
		if ((this.y < 0) || (this.y > this.bottomBound)) {
			this.velocityY = 0;
			this.alive = false;
		}
	}

	@Override
	public void draw(final Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x - (WIDTH / 2), this.y - (HEIGHT / 2), WIDTH, HEIGHT);
		for (final Shape k : this.lines) {
			k.draw(g);
		}
	}

	@Override
	public boolean getAlive() {
		return this.alive;
	}

	@Override
	public ArrayList<Shape> getPath() {
		return this.lines;
	}

	public void crash(final Intersection i) {
		if (i == Intersection.UP) {
			this.velocityX = 0;
			this.velocityY = 0;
			this.alive = false;
		}
	}

	@Override
	public abstract void move();

	abstract void addPlayers(final Player[] players);

}
