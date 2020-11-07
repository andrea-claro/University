import javax.swing.*;

class Tester {
    public static void main(String args[]) {

        // String url ="jdbc:mysql://127.0.0.1:3306/centroestetico?autoReconnect=true&useSSL=false&serverTimezone=GMT";


        String ip = JOptionPane.showInputDialog("Inserisci l'ip del DB :");
        String port = JOptionPane.showInputDialog("Inserisci la porta del DB :");
        String user = JOptionPane.showInputDialog("Inserisci l'user per il DB :");
        String password = JOptionPane.showInputDialog("Inserisci la password per il DB :");

        String url = "jdbc:mysql://" + ip + ":" + port + "/centroestetico?autoReconnect=true&useSSL=false&serverTimezone=GMT";

        JFrame centroEsteticoGUI = new CentroEsteticoGUI(url, user, password);
        centroEsteticoGUI.setVisible(true);
        centroEsteticoGUI.setSize(1000, 700);
        centroEsteticoGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
