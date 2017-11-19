package me.indev0r.chatty;

import javax.swing.*;

import network.NetworkClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChattyClient extends JFrame {
	
	public static final String TITLE = "Chatty Client";
	private static ChattyClient instance;
	
	//List of users connected
	private JList listUsers;
	
	//Chat text
	private JTextPane textChat;
	
	//User input
	private JTextField fieldInput;
	
	private JButton buttonSend; 

	//Network client object
	private NetworkClient client;
	
	public ChattyClient() {
		createView();
		client = new NetworkClient("127.0.0.1", 1050);
		
		setTitle(TITLE);
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
		
	private void createView() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout());
		
		listUsers = new JList();
		JScrollPane listUsersSP = new JScrollPane(listUsers);
		listUsersSP.setPreferredSize(new Dimension(200, 0));
		panel.add(listUsersSP, BorderLayout.EAST);
		
		JPanel panelChat = new JPanel(new BorderLayout());
		panel.add(panelChat, BorderLayout.CENTER);
		
		textChat = new JTextPane();
		textChat.setEditable(false);
		JScrollPane textChatSP = new JScrollPane(textChat);
		panelChat.add(textChatSP, BorderLayout.CENTER);
		
		JPanel panelInput = new JPanel(new BorderLayout());
		panel.add(panelInput, BorderLayout.SOUTH);		
		fieldInput = new JTextField();
		panelInput.add(fieldInput, BorderLayout.CENTER);
		
		buttonSend = new JButton("Send");
		buttonSend.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO send chat message to server
			}
		});
		
		panelInput.add(buttonSend, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				instance = new ChattyClient();
				instance.setVisible(true);
			}
		});
	}
}
 