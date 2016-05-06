package nmm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * Created by Matt on 5/05/2016.
 */
public class Event extends JFrame implements MouseListener {

    private JPanel controls;
    private JPanel game;
    private JLabel status;
    private JPanel board;
    private JButton newGameButton;
    private JCheckBox computerSelection;
    private Image image;

    public Event() {
        super("Nine Man's Morris");

        //control panel
        controls = new JPanel(new FlowLayout());
        add(controls, BorderLayout.PAGE_START);
        newGameButton = new JButton("NEW GAME");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new game
            }
        });
        computerSelection = new JCheckBox("COMPUTER PLAYER");
        controls.add(newGameButton, BorderLayout.PAGE_START);
        controls.add(computerSelection, BorderLayout.PAGE_START);

        //game panel
        game = new JPanel(new BorderLayout());
        status = new JLabel("STATUS: ");
        board = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

            }
        };
        board.addMouseListener(this);
        add(game, BorderLayout.CENTER);
        game.add(status, BorderLayout.PAGE_START);
        game.add(board, BorderLayout.CENTER);


        try {
            image = ImageIO.read(new File("src\\Images\\Board.png"));
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
        }

        //window
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(Integer.toString(e.getX()) + ", " + Integer.toString(e.getY()));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
