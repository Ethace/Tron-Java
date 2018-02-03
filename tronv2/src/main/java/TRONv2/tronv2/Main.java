package TRONv2.tronv2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main implements Runnable {

	public void run() {

		final JFrame frame = new JFrame("Tron");
		frame.setBackground(Color.BLACK);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.setResizable(false);
		frame.setLocation(600, 400);

		final TwoPlayer level = new TwoPlayer(2);
		level.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		frame.setLayout(new BorderLayout());
		frame.add(level, BorderLayout.CENTER);
		frame.update(frame.getGraphics());
		level.requestFocusInWindow();
		level.revalidate();

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		level.reset();
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Main());

	}

}
