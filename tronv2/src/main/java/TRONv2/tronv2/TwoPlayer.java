package TRONv2.tronv2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class TwoPlayer extends Map {

	private PlayerPh	player2;
	final Player		k1	= null;
	final Player		k2	= null;

	private boolean		p1	= false;
	private boolean		p2	= false;
	private boolean		tie	= false;

	public TwoPlayer(final int p) {
		super(p);

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(final KeyEvent e) {
				if (!TwoPlayer.this.player2.getAlive()) {
				}
				switch (e.getKeyCode()) {
				case KeyEvent.VK_Q:
					TwoPlayer.this.player2.setXVelocity(-TwoPlayer.this.VELOCITY);
					TwoPlayer.this.player2.setYVelocity(0);
					break;

				case KeyEvent.VK_D:
					TwoPlayer.this.player2.setXVelocity(TwoPlayer.this.VELOCITY);
					TwoPlayer.this.player2.setYVelocity(0);
					break;
				}

			}

			@Override
			public void keyReleased(final KeyEvent e) {
			}
		});
	}

	@Override
	void tick() {

		this.player1.setBounds(this.getWidth(), this.getHeight());
		this.player1.move();

		this.player2.setBounds(this.getWidth(), this.getHeight());
		this.player2.move();

		for (final Player k1 : this.player) {
			for (final Player k2 : this.player) {
				k1.crash(k1.intersects(k2));
			}
		}

		if (!this.player1.getAlive() || !this.player2.getAlive()) {
			this.timer.stop();
			this.run = false;
			this.addScore();
		}
		this.setScore();
		this.repaint();
	}

	public void restartGame() {
	}

	@Override
	public void reset() {
		this.p1 = false;
		this.p2 = false;
		this.tie = false;
		final int[] start1 = this.getStart();
		this.player1 = new PlayerPh(start1[0], start1[1], start1[2], start1[3], Color.BLUE);
		this.player[0] = this.player1;
		final int[] start2 = this.getStart();
		this.player2 = new PlayerPh(start2[0], start2[1], start2[2], start2[3], Color.ORANGE);
		this.player[1] = this.player2;
		this.timer.start();
		this.requestFocusInWindow();
	}

	@Override
	public void addScore() {
		if (!this.run) {
			if (this.player2.getAlive()) {
				this.p2 = true;
			} else if (this.player1.getAlive()) {
				this.p1 = true;
			} else {
				this.tie = true;
			}
		}

	}

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		if (this.p1) {
			try {
				final BufferedImage picture = ImageIO.read(new File("p1_wins.png"));
				g.drawImage(picture, (this.MAPWIDTH / 2) - 180, (this.MAPHEIGHT / 2) - 130, null);
			} catch (final IOException e) {
			}
		}
		if (this.p2) {
			try {
				final BufferedImage picture = ImageIO.read(new File("p2_wins.png"));
				g.drawImage(picture, (this.MAPWIDTH / 2) - 180, (this.MAPHEIGHT / 2) - 130, null);
			} catch (final IOException e) {
			}
		}
		if (this.tie) {
			try {
				final BufferedImage picture = ImageIO.read(new File("tie.png"));
				g.drawImage(picture, (this.MAPWIDTH / 2) - 120, (this.MAPHEIGHT / 2) - 130, null);
			} catch (final IOException e) {
			}
		}
	}

	@Override
	void setScore() {

	}
}