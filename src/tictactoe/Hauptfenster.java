package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import de.fhwgt.tictactoe.TicTacToeLogic;

public class Hauptfenster extends JFrame {
	private static final long serialVersionUID = 1;
	
	// Spielfelddimension
	private int fieldSize = 3;
	// ListenerFlag, wird bei Spielende auf "false" gesetzt
	private boolean listenerEnabled = true;
	
	// Useless static counter for amount of games played -- whoop whoop
	private static int playCount = 0;

	Spielfeld spielfeld;
	TicTacToeLogic ticTacToeLogic;

	public Hauptfenster(){
		super("TicTacToe");
		// Fenstergröße nicht verstellbar
		this.setResizable(false);
		// Fenster sichtbar schalten
		this.setVisible(true);
		// Speicher wieder freigeben, falls das Fenster geschlossen wird
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initTicTacToeLogic();
		initSpielfeld();
		
		this.pack();
		// Fenster in der Bildschirm-Mitte positionieren, allerdings erst nach dem pack()
		this.setLocationRelativeTo(null);
	}
	
	// Init-Methode für das Spielfeld
	public void initSpielfeld(){
		spielfeld = new Spielfeld(this);
		this.add(spielfeld);
	}
	
	// Get-Methode für das Spielfeld
	public Spielfeld getSpielfeld(){
		return spielfeld;
	}
	
	// Init-Methode für die Spielelogik von TicTacToe
	public void initTicTacToeLogic(){
		ticTacToeLogic = new TicTacToeLogic(fieldSize);
		ticTacToeLogic.addTicTacToeListener(new ListenerTicTacToe(this));
	}
	
	
	// Get-Methode für die Spielelogik von TicTacToe
	public TicTacToeLogic getTicTacToeLogic(){
		return ticTacToeLogic;
	}
	
	
	// Main-Methode des Spiels
	public static void main(String[] args) {
		// SELFMADE Block Anfang
		System.out.println("Ihre Eingabe bitte:");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
	    try {
			input = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(input);

		try {
			Integer.valueOf(input);
		} catch (NumberFormatException e){
			System.out.println("Fehler beim Konvertieren Baby");
	    }
		// SELFMADE Block Ende
		
		new Hauptfenster();
		playCount++;
	}
	
	// Restart-Methode für TicTacToe
	public void restartTicTacToe(){
		this.dispose();
		// I'm lovin it
		if(playCount >= 3){
			System.out.println();
			if((playCount % 3) == 0){
				System.out.println("Hör gefälligst auf so rumzusuchten!");
			}else if((playCount % 3) == 1){
				System.out.println("Komm schon, so gut ist das Spiel auch wieder nicht!");
			}else{
				System.out.println("Die KI ist so schlecht, unfassbar, dass Du immernoch spielst!");
			}
			System.out.println();
		}
		new Hauptfenster();
		playCount++;
	}
	
	// Get-Methode für Listener Flag
	public boolean getListenerEnabled(){
		return listenerEnabled;
	}
	
	// Set-Methode für Listener Flag
	public void setListenerEnabled(boolean b){
		listenerEnabled = b;
	}
	
	// Get-Methode für playCount
	public int getPlayCount(){
		return playCount;
	}
}
