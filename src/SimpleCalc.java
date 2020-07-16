import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalc extends JFrame implements ActionListener {

    Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pajdzior\\Desktop\\icon2.jpg");
    JFrame frame = new JFrame("SimpleCalc");
    JPanel bp = new JPanel();
    JPanel dis = new JPanel();
    JTextArea text1 = new JTextArea();
    JTextArea text2 = new JTextArea();
    Font font = new Font("Arial", Font.BOLD, 25);
    Font disfont1 = new Font ("Arial", Font.BOLD + Font.ITALIC, 30);
    Font disfont2 = new Font ("Arial", Font.BOLD, 41);
    String n1, n2, n3;
    int sep;
    double res;




    public void Frame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocation(200, 200);
        frame.setIconImage(this.icon);
        frame.setLayout(new GridLayout(1, 2));
        frame.setVisible(true);
    }

    public void Display() {
        dis.setLayout(new GridBagLayout());
        text1.setFont(disfont1);
        text2.setFont(disfont2);
        GridBagConstraints discon1 = new GridBagConstraints();
        GridBagConstraints discon2 = new GridBagConstraints();


        discon1.fill = GridBagConstraints.HORIZONTAL;
        discon1.gridx = 3;
        discon1.gridy = 3;
        discon2.gridx = 3;
        discon2.gridy = 5;
        dis.add(text1, discon1);
        dis.add(text2, discon2);
        frame.add(dis);
    }

    public void ButtonPanel() {
        bp.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        JButton one = new JButton(Integer.toString(1));
        con.insets = new Insets(1, 1, 1, 1);
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridx = 0;
        con.gridy = 0;
        one.setFont(font);
        one.addActionListener(this);
        bp.add(one, con);
        JButton two = new JButton(Integer.toString(2));
        con.gridx = 1;
        con.gridy = 0;
        two.setFont(font);
        two.addActionListener(this);
        bp.add(two, con);
        JButton three = new JButton(Integer.toString(3));
        con.gridx = 2;
        con.gridy = 0;
        three.setFont(font);
        three.addActionListener(this);
        bp.add(three, con);
        JButton four = new JButton(Integer.toString(4));
        four.setFont(font);
        con.gridx = 0;
        con.gridy = 1;
        four.addActionListener(this);
        bp.add(four, con);
        JButton five = new JButton(Integer.toString(5));
        five.setFont(font);
        con.gridx = 1;
        con.gridy = 1;
        five.addActionListener(this);
        bp.add(five, con);
        JButton six = new JButton(Integer.toString(6));
        six.setFont(font);
        con.gridx = 2;
        con.gridy = 1;
        six.addActionListener(this);
        bp.add(six, con);
        JButton seven = new JButton(Integer.toString(7));
        seven.setFont(font);
        con.gridx = 0;
        con.gridy = 2;
        seven.addActionListener(this);
        bp.add(seven, con);
        JButton eight = new JButton(Integer.toString(8));
        eight.setFont(font);
        con.gridx = 1;
        con.gridy = 2;
        eight.addActionListener(this);
        bp.add(eight, con);
        JButton nine = new JButton(Integer.toString(9));
        nine.setFont(font);
        con.gridx = 2;
        con.gridy = 2;
        nine.addActionListener(this);
        bp.add(nine, con);
        JButton zero = new JButton(Integer.toString(0));
        zero.setFont(font);
        con.gridx = 0;
        con.gridy = 3;
        con.gridwidth = 2;
        zero.addActionListener(this);
        bp.add(zero, con);
        JButton sep = new JButton(".");
        sep.setFont(font);
        con.gridx = 2;
        con.gridy = 3;
        sep.addActionListener(this);
        bp.add(sep, con);
        JButton plus = new JButton("+");
        plus.setFont(font);
        con.gridx = 0;
        con.gridy = 4;
        con.gridwidth = 1;
        plus.addActionListener(this);
        bp.add(plus, con);
        JButton minus = new JButton("-");
        minus.setFont(font);
        con.gridx = 1;
        con.gridy = 4;
        minus.addActionListener(this);
        bp.add(minus, con);
        JButton multi = new JButton("*");
        multi.setFont(font);
        con.gridx = 0;
        con.gridy = 5;
        multi.addActionListener(this);
        bp.add(multi, con);
        JButton div = new JButton("/");
        div.setFont(font);
        con.gridx = 1;
        con.gridy = 5;
        div.addActionListener(this);
        bp.add(div, con);
        JButton eq = new JButton("=");
        eq.setFont(font);
        con.gridx = 0;
        con.gridy = 6;
        con.gridwidth = 3;
        eq.addActionListener(this);
        bp.add(eq, con);
        JButton c = new JButton("C");
        c.setFont(font);
        con.fill = GridBagConstraints.VERTICAL;
        con.gridx = 2;
        con.gridy = 4;
        con.ipadx = 0;
        con.gridwidth = 1;
        con.gridheight = 2;
        c.addActionListener(this);
        bp.add(c, con);

        frame.add(bp);
    }

    public void Calculator() {
        n1 = n2 = n3 = "";
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0)>='0' && s.charAt(0)<='9') || s.charAt(0) == '.') {

            if (s.charAt(0) == '.'){
                sep =+ 1;
            }

            if (sep != 1 && n2.equals("")) {
                n1 = n1 + s;
            } else if (sep != 1 && !n2.equals("")) n3 = n3 + s;

            if (sep == 1 && n2.equals("") && n1.equals("")) {
                n1 = 0 + s + n1;
                sep =- 1;
            } else if (sep == 1 && n3.equals("")) n3 = 0 + n3;

            if (sep == 1 && n2.equals("") && (Double.parseDouble(n1)<0 || Double.parseDouble(n1) >= 1)){
                n1 = n1 + s;
                sep =- 1;
            }

        }

        if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && !n1.equals("")){
            n2 = n2 + s;
        }

        if (s.equals("-") && n1.equals("")){
            n1 = n1 + s;
        }

        if (s.charAt(0) == 'C') {
            n1 = n2 = n3 = "";
            res = 0;
            text1.setText(n1 + n2 + n3);
            text2.setText("");
        }

        if (n2.equals("+") && !n3.equals("")){
            res = Double.sum(Double.parseDouble(n1),Double.parseDouble(n3));
        }

        if (n2.equals("-") && !n3.equals("")){
            res = Double.parseDouble(n1) - Double.parseDouble(n3);
        }

        if (n2.equals("*") && !n3.equals("")){
            res = Double.parseDouble(n1) * Double.parseDouble(n3);
        }

        if (n2.equals("/") && !n3.equals("")){
            res = Double.parseDouble(n1) / Double.parseDouble(n3);
        }


        if (s.equals("=")){

            if (!n1.equals("") && n2.equals("")){
             res =Double.parseDouble(n1);
            }

            text1.setText(n1 + n2 + n3 + " = ");
            text2.setText(Double.toString(res));
            n2 = n3 = "";
            n1 = Double.toString(res);
        }

        if (s.charAt(0) != '='){
            text1.setText(n1 + n2 + n3);
        }
    }

    public static void main(String[] args) {
SimpleCalc sc = new SimpleCalc();
sc.Display();
sc.ButtonPanel();
sc.Frame();
sc.Calculator();
    }
}
