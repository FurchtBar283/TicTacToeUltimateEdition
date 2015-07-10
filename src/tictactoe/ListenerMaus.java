package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ListenerMaus extends MouseAdapter implements ActionListener {
	
	private int x;
	private int y;
	
	private int fieldSize;
	
	private JLabel[][] spielfeldArray;
	
	Hauptfenster hauptfenster;
	
	public ListenerMaus (Hauptfenster fenster){
		hauptfenster = fenster;
		fieldSize = hauptfenster.getTicTacToeLogic().getSize();
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
	}
	
	public void mousePressed(MouseEvent event) {
		boolean enabled = hauptfenster.getListenerEnabled();
		
		if(enabled){
			// Linke Maustaste
			if(event.getButton() == 1){
				fieldSize = hauptfenster.getTicTacToeLogic().getSize();
				x = fieldSize;
				y = fieldSize;
				spielfeldArray = hauptfenster.getSpielfeld().getSpielfeldArray();
				/*
				Point point = hauptfenster.getTicTacToeLogic().getactivePoint();
				x = point.x;
				y = point.y;
				
				hauptfenster.getTicTacToeLogic().setField(x, y);
				*/
				for(int i = 0; i < x; i++){
					for(int j = 0; j < y; j++){
						if(event.getSource() == spielfeldArray[i][j]){
							hauptfenster.getTicTacToeLogic().setField(i, j);
						}
					}
				}
				
				// Ausgabe der ausgewählten Fenster in folgendem Format:
				// Legende: 0 = nicht ausgewählt ; 1 = Spielermarkierung ; 2 = Computermarkierung
				// 2 0 0
				// 0 1 0
				// 0 0 0
				hauptfenster.getTicTacToeLogic().printBoard();
				System.out.println();
				// Gleiche Ausgabe nur als String
				//System.out.println();
				//System.out.println(hauptfenster.getTicTacToeLogic().BoardtoString());
				
				
				// Feld schon genutzt worden (if)
				// Feld frei (if)
			}
		}
	}
}
