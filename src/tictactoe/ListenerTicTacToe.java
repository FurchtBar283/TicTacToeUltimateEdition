package tictactoe;

import java.awt.Color;

import javax.swing.JOptionPane;

import de.fhwgt.tictactoe.TicTacToeEvent;
import de.fhwgt.tictactoe.TicTacToeListener;
import de.fhwgt.tictactoe.TicTacToeLogic;

public class ListenerTicTacToe implements TicTacToeListener{

	Hauptfenster hauptfenster;
	int status = 0;
	
	public void ModelChanged(TicTacToeEvent event) {
		// TODO Auto-generated method stub
		hauptfenster.getSpielfeld().setMark(event);
	}

	public void StatusChanged(TicTacToeEvent event) {
		// TODO Auto-generated method stub
		status = event.getStatus();
		hauptfenster.getTicTacToeLogic();

		// Spiel l‰uft
		if(status == TicTacToeLogic.NOWINNER){
			System.out.println("Spiel laeuft noch");
		}else{
			// SELFMADE Block Anfang
			int decision = 0;
			String []choices = {"Neues Spiel", "Abbrechen"};
			//hauptfenster.getSpielfeld().disableListener();
			// SELFMADE Block Ende
			
			// Listener deaktivieren via Flag
			hauptfenster.setListenerEnabled(false);
			// Alternative Deaktivierung ¸ber removeMouseListener-Funktion in Spielfeld
			//hauptfenster.getSpielfeld().disableListener();
			
			status = hauptfenster.getTicTacToeLogic().getWinner();
			// Spieler hat gewonnen
			if(status == TicTacToeLogic.SPIELER){
				System.out.println("Spieler hat gewonnen!");
				hauptfenster.getSpielfeld().setGameEndBackground(Color.green);
				// SELFMADE
				decision = JOptionPane.showOptionDialog(hauptfenster, "Sie haben das Spiel gewonnen!", "Spiel gewonnen", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Neues Spiel");
			}
			
			// Computer hat gewonnen
			if(status == TicTacToeLogic.TicTacToe){
				System.out.println("Computer hat gewonnen!");
				hauptfenster.getSpielfeld().setGameEndBackground(Color.yellow);
				// SELFMADE
				decision = JOptionPane.showOptionDialog(hauptfenster, "Sie haben das Spiel verloren!", "Spiel verloren", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Neues Spiel");
			}
			
			// Keine Felder ¸brig, keiner hat gewonnen
			if(status == TicTacToeLogic.FINISH){
				System.out.println("Keiner hat gewonnen!");
				hauptfenster.getSpielfeld().setGameEndBackground(Color.red);
				// SELFMADE
				decision = JOptionPane.showOptionDialog(hauptfenster, "Sie konnten das Spiel nicht f¸r sich entscheiden!", "Unentschieden", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, "Neues Spiel");
			}
			
			// SELFMADE Block Anfang
			//System.out.println(decision);
			System.out.println();
			if(decision == 0){
				hauptfenster.restartTicTacToe();
			}else{
				if(hauptfenster.getPlayCount() >= 3){
					System.out.println("That was about damn time dude!");
					System.out.println();
				}
				System.out.println("Der wollte nicht nochmal!");
				System.out.println();
				// Spiel schlieﬂen
				//hauptfenster.dispose();
			}
			// SELFMADE Block Ende
		}
	}
	
	public ListenerTicTacToe(Hauptfenster fenster){
		hauptfenster = fenster;
	}

}
