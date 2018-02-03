package TRONv2.tronv2;

import java.awt.Graphics;

public interface Shape {

	public void draw(Graphics gc);

	public boolean isVertical();

	public int getStartX();

	public int getStartY();

	public int getEndX();

	public int getEndY();

}

class Line implements Shape {

	private final int	x;
	private final int	y;
	private final int	x2;
	private final int	y2;

	public Line(final int x, final int y, final int x2, final int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(final Graphics gc) {
		gc.drawLine(this.x, this.y, this.x2, this.y2);
	}

	public boolean isVertical() {
		return (this.x == this.x2);
	}

	public int getStartX() {
		return this.x;
	}

	public int getStartY() {
		return this.y;
	}

	public int getEndX() {
		return this.x2;
	}

	public int getEndY() {
		return this.y2;
	}
}