// DO NOT CHANGE



/*
 * There are only two things the student will change in this file.
 * These will be changed only when starting on TicTacToe.
 *
 * 1) private Node getTreeToDisplay() { ... }
 * 2) The imports to allow proper creation of the TicTacToe Tree.
 */


import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private static final int GAME = 1;

    private JScrollPane scroll = null;
	private GamePanel gamePanel;

    enum TreeType {
        BASE,
        BST,
        BST_EXTRA,
        TICTACTWO_TREE,
        GAME_TREE,
        HARD,
        EASY
    };

    public static void startGUI() throws InterruptedException {
        MainFrame theGUI = new MainFrame();

        // Starts the UI Thread and creates the the UI in that thread.
        // Uses a Lambda Expression to call the createFrame method.
        // Use theGUI as the semaphore object
        SwingUtilities.invokeLater( () -> theGUI.createFrame(theGUI) );


        synchronized (theGUI ) {
            theGUI.wait();
        }
    }
    public void createFrame(Object semaphore) {
        // Sets the title found in the Title Bar of the JFrame
        this.setTitle("Python");
        // Sets the size of the main Window
        this.setSize(WIDTH, HEIGHT);
        // Allows the application to properly close when the
        // user clicks on the Red-X.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //addMenuBar();

        
     
        // Set the size depending on the supposed Tree size
       
        // allow scroll panel to manage visibility of the Tree panel
     
     
      
        // create the game panel, but don't add it to the JFrame, yet.
        // The constructor will create the GameTree and learn.
        gamePanel = new GamePanel();
        gamePanel.setSize(WIDTH, HEIGHT);
        gamePanel.setVisible(true);
      //  gamePanel.setBounds(0,0,WIDTH,HEIGHT);
        scroll = new JScrollPane(gamePanel);
        
        scroll.setBounds(0,0,WIDTH,HEIGHT);
        scroll.setVisible(true);
        add(scroll);

        // don't pack. Leave the main frame at its original size.
        // Packing causes the main JFrame to be larger/smaller depending
        // on the size of its children components.
        //this.pack();

        // create a Tree to show in the Tree Panel by
        // setting the root of the treePanel
      

        // Set the current frame and this JFrame to be visible
        this.setVisible(true);

        // tell the main thread that we are done creating our stuff
        synchronized (semaphore) {
            semaphore.notify();
        }
    }

 }

