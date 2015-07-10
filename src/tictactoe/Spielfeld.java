package tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.fhwgt.tictactoe.TicTacToeEvent;
import de.fhwgt.tictactoe.TicTacToeLogic;

public class Spielfeld extends JPanel {
	private static final long serialVersionUID = 2;

	// Fenstergröße
		// Spalten
	private int x = 3;
		// Zeilen
	private int y = 3;
	// Spielfeld
	private JLabel labelarray[][];
	
	// Alternative Listenererzeugung mit Namensgebung als mögliche Referenz auf die Listener
	//private ListenerMaus listenerArray[][];

	Hauptfenster hauptfenster;

	public Spielfeld(Hauptfenster fenster) {
		hauptfenster = fenster;
		// Spalten, Zeile bzw y dann x
		this.setLayout(new GridLayout(y, x));
		initSpielfeld();
		// Grenze des Panels
		// this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	// Methode zur Initialisierung des Spielfelds
	public void initSpielfeld() {
		labelarray = new JLabel[x][y];
		// Alternative Listenerinitialisierung mit möglicher Referenz
		//listenerArray = new ListenerMaus[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				labelarray[i][j] = new JLabel();
				labelarray[i][j].setPreferredSize(new Dimension(70, 70));
				labelarray[i][j].setOpaque(true);
				// labelarray[i][j].setBackground(Color.gray);
				labelarray[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				// Anonyme Listenererzeugung
				labelarray[i][j].addMouseListener(new ListenerMaus(hauptfenster));
				// Alternative Listenererzeugung mit Listenername, um sie über Namen entfernen zu können
				//labelarray[i][j].addMouseListener(listenerArray[i][j] = new ListenerMaus(hauptfenster));
				this.add(labelarray[i][j]);
			}
		}
	}

	// Get-Methode für das Spielfeld Label Array
	public JLabel[][] getSpielfeldArray() {
		return labelarray;
	}

	// Markierung setzen
	public void setMark(TicTacToeEvent event) {
		if (event.getSpieler() == TicTacToeLogic.SPIELER) {
			labelarray[hauptfenster.getTicTacToeLogic().getactivePoint().x][hauptfenster.getTicTacToeLogic().getactivePoint().y].setText("O");
			labelarray[hauptfenster.getTicTacToeLogic().getactivePoint().x][hauptfenster.getTicTacToeLogic().getactivePoint().y].setHorizontalAlignment(JLabel.CENTER);
		}
		if (event.getSpieler() == TicTacToeLogic.TicTacToe) {
			labelarray[hauptfenster.getTicTacToeLogic().getactivePoint().x][hauptfenster.getTicTacToeLogic().getactivePoint().y].setText("X");
			labelarray[hauptfenster.getTicTacToeLogic().getactivePoint().x][hauptfenster.getTicTacToeLogic().getactivePoint().y].setHorizontalAlignment(JLabel.CENTER);
		}
	}

	// Hintergrund bei Spielende einfärben
	public void setGameEndBackground(Color color) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				labelarray[i][j].setBackground(color);
			}
		}
	}
	
	// NOT IN USE
	// Listener bei Spielende deaktivieren
	public void disableListener(){
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				// Alternative Listenerdeaktivierung via removeListener
				//labelarray[i][j].removeMouseListener(listenerArray[i][j]);
			}
		}
	}
}
