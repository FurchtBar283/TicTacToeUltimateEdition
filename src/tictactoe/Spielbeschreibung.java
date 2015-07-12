package tictactoe;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Spielbeschreibung extends JDialog {
	private static final long serialVersionUID = 4;
	
	Hauptfenster hauptfenster;
	
	JEditorPane editorPane;
	JScrollPane editorScrollPane;
	JButton closeButton;
	
	public Spielbeschreibung(Hauptfenster fenster){
		hauptfenster = fenster;
		editorPane = new JEditorPane();
		editorPane.setText("Dies ist die Spielbeschreibung dieses weirdo-Games!");
		editorPane.setEditable(false);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		editorScrollPane = new JScrollPane(editorPane);
		//editorScrollPane.setVerticalScrollBar(new JScrollBar());
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(editorScrollPane);
		closeButton = new JButton("Schlieﬂen");
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				Spielbeschreibung.this.dispose();
			}
		});
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosed(WindowEvent arg0) {
				hauptfenster.getMenuebar().enableDescription();
			}
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub	
			}
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub	
			}
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub	
			}
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		this.add(closeButton, "South");
		this.setSize(200, 200);
		this.setResizable(true);
		// Fokus nicht zwingend auf dem Fenster
		this.setModal(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
