package nmm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.File;

/**
 * Created by Matt on 5/05/2016.
 */
public class Event extends JFrame implements MouseListener {

    Game game;
    Menu menu;

    //UI
    private JPanel controlPanel;
    private JPanel gamePanel;
    private JLabel statusLabel;
    private JPanel boardPanel;
    private JButton newGameButton;
    private JCheckBox computerCheckBox;
    private Image boardImage;

    static final int PADDING = 40;
    static final int CIRCLE_RADIUS = 15;
    static final int CIRCLE_DIAMETER = CIRCLE_RADIUS*2;
    static final int TOKEN_RADIUS = 17;
    static final int TOKEN_DIAMETER = TOKEN_RADIUS * 2;

    //Intersection locations
    Point a1;
    Point a4;
    Point a7;
    Point b2;
    Point b4;
    Point b6;
    Point c3;
    Point c4;
    Point c5;
    Point d1;
    Point d2;
    Point d3;
    Point d5;
    Point d6;
    Point d7;
    Point e3;
    Point e4;
    Point e5;
    Point f2;
    Point f4;
    Point f6;
    Point g1;
    Point g4;
    Point g7;

    public Event(Menu menu) {
        super("Nine Man's Morris");

        this.menu = menu;

        //Control panel
        controlPanel = new JPanel(new FlowLayout());
        add(controlPanel, BorderLayout.PAGE_START);
        newGameButton = new JButton("NEW GAME");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.newGame();
            }
        });
        computerCheckBox = new JCheckBox("COMPUTER PLAYER");
        controlPanel.add(newGameButton, BorderLayout.PAGE_START);
        controlPanel.add(computerCheckBox, BorderLayout.PAGE_START);

        //Game panel
        gamePanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel("STATUS: ");
        boardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                //int x = (this.getWidth() - boardImage.getWidth(null)) / 2;
                //int y = (this.getHeight() - boardImage.getHeight(null)) / 2;
                //g.drawImage(boardImage, x, y, null);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(10));

                //Vertical Lines
                g2.draw(new Line2D.Double(a1.getX(), a1.getY(), a7.getX(), a7.getY()));
                g2.draw(new Line2D.Double(b2.getX(), b2.getY(), b6.getX(), b6.getY()));
                g2.draw(new Line2D.Double(c3.getX(), c3.getY(), c5.getX(), c5.getY()));
                g2.draw(new Line2D.Double(d1.getX(), d1.getY(), d3.getX(), d3.getY()));
                g2.draw(new Line2D.Double(d5.getX(), d5.getY(), d7.getX(), d7.getY()));
                g2.draw(new Line2D.Double(e3.getX(), e3.getY(), e5.getX(), e5.getY()));
                g2.draw(new Line2D.Double(f2.getX(), f2.getY(), f6.getX(), f6.getY()));
                g2.draw(new Line2D.Double(g1.getX(), g1.getY(), g7.getX(), g7.getY()));

                //Horizontal Lines
                g2.draw(new Line2D.Double(a1.getX(), a1.getY(), g1.getX(), g1.getY()));
                g2.draw(new Line2D.Double(b2.getX(), b2.getY(), f2.getX(), f2.getY()));
                g2.draw(new Line2D.Double(c3.getX(), c3.getY(), e3.getX(), e3.getY()));
                g2.draw(new Line2D.Double(a4.getX(), a4.getY(), c4.getX(), c4.getY()));
                g2.draw(new Line2D.Double(e4.getX(), e4.getY(), g4.getX(), g4.getY()));
                g2.draw(new Line2D.Double(c5.getX(), c5.getY(), e5.getX(), e5.getY()));
                g2.draw(new Line2D.Double(b6.getX(), b6.getY(), f6.getX(), f6.getY()));
                g2.draw(new Line2D.Double(a7.getX(), a7.getY(), g7.getX(), g7.getY()));

                //Draw Intersections
                g2.fillOval((int) a1.getX() - CIRCLE_RADIUS, (int) a1.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) a4.getX() - CIRCLE_RADIUS, (int) a4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) a7.getX() - CIRCLE_RADIUS, (int) a7.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) b2.getX() - CIRCLE_RADIUS, (int) b2.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) b4.getX() - CIRCLE_RADIUS, (int) b4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) b6.getX() - CIRCLE_RADIUS, (int) b6.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) c3.getX() - CIRCLE_RADIUS, (int) c3.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) c4.getX() - CIRCLE_RADIUS, (int) c4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) c5.getX() - CIRCLE_RADIUS, (int) c5.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d1.getX() - CIRCLE_RADIUS, (int) d1.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d2.getX() - CIRCLE_RADIUS, (int) d2.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d3.getX() - CIRCLE_RADIUS, (int) d3.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d5.getX() - CIRCLE_RADIUS, (int) d5.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d6.getX() - CIRCLE_RADIUS, (int) d6.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) d7.getX() - CIRCLE_RADIUS, (int) d7.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) e3.getX() - CIRCLE_RADIUS, (int) e3.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) e4.getX() - CIRCLE_RADIUS, (int) e4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) e5.getX() - CIRCLE_RADIUS, (int) e5.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) f2.getX() - CIRCLE_RADIUS, (int) f2.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) f4.getX() - CIRCLE_RADIUS, (int) f4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) f6.getX() - CIRCLE_RADIUS, (int) f6.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) g1.getX() - CIRCLE_RADIUS, (int) g1.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) g4.getX() - CIRCLE_RADIUS, (int) g4.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
                g2.fillOval((int) g7.getX() - CIRCLE_RADIUS, (int) g7.getY() - CIRCLE_RADIUS, CIRCLE_DIAMETER, CIRCLE_DIAMETER);

                //Draw Tokens
                if (game != null) {
                    for (Intersection intersection : game.getBoard().getIntersections()) {
                        if (intersection.getToken() != null) {
                            if (intersection.getToken().isPlayer1()) {
                                g2.setColor(Color.RED);
                                g2.fillOval((int) getPoint(intersection.getPoint()).getX() - TOKEN_RADIUS, (int) getPoint(intersection.getPoint()).getY() - TOKEN_RADIUS, TOKEN_DIAMETER, TOKEN_DIAMETER);
                            } else {
                                g2.setColor(Color.BLUE);
                                g2.fillOval((int) getPoint(intersection.getPoint()).getX() - TOKEN_RADIUS, (int) getPoint(intersection.getPoint()).getY() - TOKEN_RADIUS, TOKEN_DIAMETER, TOKEN_DIAMETER);
                            }
                        }
                    }
                }
            }
        };
        boardPanel.addMouseListener(this);
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.add(statusLabel, BorderLayout.PAGE_START);
        gamePanel.add(boardPanel, BorderLayout.CENTER);


        try {
            boardImage = ImageIO.read(new File("src\\Images\\Board.png"));
        } catch (Exception e) {
            System.out.println("An error has occured: " + e);
        }

        //Window
        setSize(650, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        //Set Points
        a1 = new Point(PADDING, boardPanel.getHeight() - PADDING);
        a4 = new Point(PADDING, boardPanel.getHeight() / 2);
        a7 = new Point(PADDING, PADDING);

        b2 = new Point((boardPanel.getWidth() - (PADDING*2))/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*5/6 + PADDING);
        b4 = new Point((boardPanel.getWidth() - (PADDING*2))/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/2 + PADDING);
        b6 = new Point((boardPanel.getWidth() - (PADDING*2))/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/6 + PADDING);

        c3 = new Point((boardPanel.getWidth() - (PADDING*2))*2/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*4/6 + PADDING);
        c4 = new Point((boardPanel.getWidth() - (PADDING*2))*2/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/2 + PADDING);
        c5 = new Point((boardPanel.getWidth() - (PADDING*2))*2/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*2/6 + PADDING);

        d1 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING, boardPanel.getHeight() - PADDING);
        d2 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING,(boardPanel.getHeight() - (PADDING*2))*5/6 + PADDING);
        d3 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING,(boardPanel.getHeight() - (PADDING*2))*4/6 + PADDING);
        d5 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING,(boardPanel.getHeight() - (PADDING*2))*2/6 + PADDING);
        d6 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING,(boardPanel.getHeight() - (PADDING*2))/6 + PADDING);
        d7 = new Point((boardPanel.getWidth() - (PADDING*2))/2 + PADDING, PADDING);

        e3 = new Point((boardPanel.getWidth() - (PADDING*2))*4/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*4/6 + PADDING);
        e4 = new Point((boardPanel.getWidth() - (PADDING*2))*4/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/2 + PADDING);
        e5 = new Point((boardPanel.getWidth() - (PADDING*2))*4/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*2/6 + PADDING);

        f2 = new Point((boardPanel.getWidth() - (PADDING*2))*5/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))*5/6 + PADDING);
        f4 = new Point((boardPanel.getWidth() - (PADDING*2))*5/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/2 + PADDING);
        f6 = new Point((boardPanel.getWidth() - (PADDING*2))*5/6 + PADDING, (boardPanel.getHeight() - (PADDING*2))/6 + PADDING);

        g1 = new Point(boardPanel.getWidth() - PADDING, boardPanel.getHeight() - PADDING);
        g4 = new Point(boardPanel.getWidth() - PADDING, boardPanel.getHeight() / 2);
        g7 = new Point(boardPanel.getWidth() - PADDING, PADDING);
    }

    public void newGame(Game game) {
        this.game = game;
    }

    public Boolean isComputer() {
        return computerCheckBox.isSelected();
    }

    public Boolean inCircle(Point p, Point circle) {
        return (p.getX() - circle.getX())*(p.getX() - circle.getX()) + (p.getY() - circle.getY())*(p.getY() - circle.getY()) < CIRCLE_RADIUS*CIRCLE_RADIUS;
    }

    public Point getPoint(Point p) {
        if (p.getX() == 1 && p.getY() == 1) {
            return a1;
        }
        if (p.getX() == 1 && p.getY() == 4) {
            return a4;
        }
        if (p.getX() == 1 && p.getY() == 7) {
            return a7;
        }
        if (p.getX() == 2 && p.getY() == 2) {
            return b2;
        }
        if (p.getX() == 2 && p.getY() == 4) {
            return b4;
        }
        if (p.getX() == 2 && p.getY() == 6) {
            return b6;
        }
        if (p.getX() == 3 && p.getY() == 3) {
            return c3;
        }
        if (p.getX() == 3 && p.getY() == 4) {
            return c4;
        }
        if (p.getX() == 3 && p.getY() == 5) {
            return c5;
        }
        if (p.getX() == 4 && p.getY() == 1) {
            return d1;
        }
        if (p.getX() == 4 && p.getY() == 2) {
            return d2;
        }
        if (p.getX() == 4 && p.getY() == 3) {
            return d3;
        }
        if (p.getX() == 4 && p.getY() == 5) {
            return d5;
        }
        if (p.getX() == 4 && p.getY() == 6) {
            return d6;
        }
        if (p.getX() == 4 && p.getY() == 7) {
            return d7;
        }
        if (p.getX() == 5 && p.getY() == 3) {
            return e3;
        }
        if (p.getX() == 5 && p.getY() == 4) {
            return e4;
        }
        if (p.getX() == 5 && p.getY() == 5) {
            return e5;
        }
        if (p.getX() == 6 && p.getY() == 2) {
            return f2;
        }
        if (p.getX() == 6 && p.getY() == 4) {
            return f4;
        }
        if (p.getX() == 6 && p.getY() == 6) {
            return f6;
        }
        if (p.getX() == 7 && p.getY() == 1) {
            return g1;
        }
        if (p.getX() == 7 && p.getY() == 4) {
            return g4;
        }
        if (p.getX() == 7 && p.getY() == 7) {
            return g7;
        }
        return null;
    }

    public Point getIntersection(Point p) {
        if (inCircle(p, a1)) {
            return new Point(1, 1);
        }
        if (inCircle(p, a4)) {
            return new Point(1, 4);
        }
        if (inCircle(p, a7)) {
            return new Point(1, 7);
        }
        if (inCircle(p, b2)) {
            return new Point(2, 2);
        }
        if (inCircle(p, b4)) {
            return new Point(2, 4);
        }
        if (inCircle(p, b6)) {
            return new Point(2, 6);
        }
        if (inCircle(p, c3)) {
            return new Point(3, 3);
        }
        if (inCircle(p, c4)) {
            return new Point(3, 4);
        }
        if (inCircle(p, c5)) {
            return new Point(3, 5);
        }
        if (inCircle(p, d1)) {
            return new Point(4, 1);
        }
        if (inCircle(p, d2)) {
            return new Point(4, 2);
        }
        if (inCircle(p, d3)) {
            return new Point(4, 3);
        }
        if (inCircle(p, d5)) {
            return new Point(4, 5);
        }
        if (inCircle(p, d6)) {
            return new Point(4, 6);
        }
        if (inCircle(p, d7)) {
            return new Point(4, 7);
        }
        if (inCircle(p, e3)) {
            return new Point(5, 3);
        }
        if (inCircle(p, e4)) {
            return new Point(5, 4);
        }
        if (inCircle(p, e5)) {
            return new Point(5, 5);
        }
        if (inCircle(p, f2)) {
            return new Point(6, 2);
        }
        if (inCircle(p, f4)) {
            return new Point(6, 4);
        }
        if (inCircle(p, f6)) {
            return new Point(6, 6);
        }
        if (inCircle(p, g1)) {
            return new Point(7, 1);
        }
        if (inCircle(p, g4)) {
            return new Point(7, 4);
        }
        if (inCircle(p, g7)) {
            return new Point(7, 7);
        }
        return null;
    }

    public void updateUI() {
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (game != null) {
            if (game.getCurrentAction().getPlayer().isTurn()) {
                Point intersectionClicked;

                //find which circle was selected if any
                intersectionClicked = getIntersection(e.getPoint());
                if (intersectionClicked != null) {
                    game.getCurrentAction().updateAction(intersectionClicked);
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
