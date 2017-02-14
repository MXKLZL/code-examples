package example.observer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AllInOneApp extends JFrame implements ActionListener, KeyListener {

	private JPanel container;
	private JTextField textInput;
	private JButton searchButton;
	private AllInOneAppServer searchServer;
	private AllInOneAppServer suggServer;

	public AllInOneApp(AllInOneAppServer server1, AllInOneAppServer server2) {
		textInput = createTextField();
		searchButton = createSearchButton();
		setSearchServer(server1);
		setSuggServer(server2);
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		container.add(textInput);
		container.add(searchButton);

		setContentPane(container);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setSearchServer(AllInOneAppServer server) {
		searchServer = server;
	}
	
	private void setSuggServer(AllInOneAppServer server) {
		suggServer = server;
	}

	private JTextField createTextField(){
		JTextField txt = new JTextField(36);
		txt.addKeyListener(this);
		return txt; 
	}


	private JButton createSearchButton(){
		JButton btn = new JButton("Search");
		btn.addActionListener(this);
		return btn;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.searchButton){
			System.out.println("Need to perform a search (Query: " + this.textInput.getText() + ")");
			searchServer.updateServer(this.textInput.getText());
		} else {
			System.out.println("DEBUG: Ignoring event " + e);
		}
	}

	public void keyTyped(KeyEvent e) {
		// Ignore
	}


	public void keyPressed(KeyEvent e) {
		// Ignore
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == this.textInput){
			System.out.println("Need to offer auto-complete suggestions (Query: " + this.textInput.getText() + ")");
			suggServer.updateServer(this.textInput.getText());
		} else {
			System.out.println("DEBUG: Ignoring event " + e);
		}
	}


	// ========================================================================


	public static void main(String[] args) {
		AllInOneAppServer search = new AllInOneSearchServer();
		AllInOneAppServer sugg = new AllInOneSuggServer();
		AllInOneApp app = new AllInOneApp(search, sugg);

		//Display the window.
		app.pack();
		app.setVisible(true);
	}


}

