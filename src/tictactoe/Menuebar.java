package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menuebar extends JMenuBar implements ActionListener{
	private static final long serialVersionUID = 3;
	
	Hauptfenster hauptfenster;
	
	JMenu start;
	JMenu help;
	
	JMenuItem newGame;
	JMenuItem gameDescription;

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getActionCommand() == "neuesSpiel"){
			hauptfenster.restartTicTacToe();
		}
		
		if(event.getSource() == gameDescription){
			disableDescription();
			showDescription();
		}
	}

	public Menuebar(Hauptfenster fenster){
		hauptfenster = fenster;
		
		start = new JMenu("Start");
		help = new JMenu("Hilfe");
		
		newGame = new JMenuItem("Neues Spiel");
		newGame.addActionListener(this);
		newGame.setActionCommand("neuesSpiel");
		newGame.setEnabled(false);
		start.add(newGame);
		
		gameDescription = new JMenuItem("Spielbeschreibung");
		gameDescription.addActionListener(this);
		help.add(gameDescription);
		
		this.add(start);
		this.add(help);
	}
	
	public void enableDescription(){
		gameDescription.setEnabled(true);
	}
	
	public void disableDescription(){
		gameDescription.setEnabled(false);
	}
	
	public void enableNewGame(){
		newGame.setEnabled(true);
	}
	
	public void disableNewGame(){
		newGame.setEnabled(false);
	}
	
	public void showDescription(){
		new Spielbeschreibung(hauptfenster);
	}
}
