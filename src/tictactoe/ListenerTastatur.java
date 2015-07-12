package tictactoe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenerTastatur implements KeyListener {

	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		Hauptfenster hauptfenster = (Hauptfenster) event.getSource();

		char keyChar = event.getKeyChar();

		if (keyChar == '1') {
			hauptfenster.getTicTacToeLogic().setField(2, 0);
		} else if (keyChar == '2') {
			hauptfenster.getTicTacToeLogic().setField(2, 1);
		} else if (keyChar == '3') {
			hauptfenster.getTicTacToeLogic().setField(2, 2);
		} else if (keyChar == '4') {
			hauptfenster.getTicTacToeLogic().setField(1, 0);
		} else if (keyChar == '5') {
			hauptfenster.getTicTacToeLogic().setField(1, 1);
		} else if (keyChar == '6') {
			hauptfenster.getTicTacToeLogic().setField(1, 2);
		} else if (keyChar == '7') {
			hauptfenster.getTicTacToeLogic().setField(0, 0);
		} else if (keyChar == '8') {
			hauptfenster.getTicTacToeLogic().setField(0, 1);
		} else if (keyChar == '9') {
			hauptfenster.getTicTacToeLogic().setField(0, 2);
		} else {
			System.out.println();
			System.out.println("Ungueltige Taste gedrueckt!");
		}
		System.out.println();
		hauptfenster.getTicTacToeLogic().printBoard();
	}
}
