import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class CentroEsteticoGUI extends JFrame {

    public CentroEsteticoGUI(String url, String user, String password) {


        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            System.out.println("LookAndFeel " + UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("ERRORE nel set lookandfeel" + e);
        }

        this.url = url;
        this.user = user;
        this.password = password;
        database = new CentroEsteticoDB(url, user, password);
        tabbedPane = new JTabbedPane();
        font = new Font("Newfont", Font.BOLD, 25);
        setTitle("Centro Estetico");
        add(maker());
    }

    public JPanel maker() {

        JPanel south = new JPanel();
        south.setBorder(new EtchedBorder());
        south.setLayout(new BorderLayout());


        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
        menuPanel.setLayout(new BorderLayout());
        JMenuBar barraMenu = new JMenuBar();

        JMenu menu = new JMenu("Inserisci");

        JButton prenotazioni = new JButton("Prenotazioni");

        JMenuItem estetiste = new JMenuItem("Estetiste");

        JMenuItem cliente = new JMenuItem("Aggiungi cliente");
        JMenuItem macchinario = new JMenuItem("Aggiungi macchinario");
        JMenuItem interrogazioni = new JMenuItem("Invia Query al db");

        prenotazioni.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Prenotazioni") == -1) {
                tabbedPane.addTab("Prenotazioni", Prenotazione());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Prenotazioni"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Prenotazioni")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Prenotazioni"), panel);
            }
        });

        estetiste.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Estetiste") == -1) {
                tabbedPane.addTab("Estetiste", estetiste());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Estetiste"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Estetiste")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Estetiste"), panel);
            }
        });

        cliente.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Aggiungi cliente") == -1) {
                tabbedPane.addTab("Aggiungi cliente", aggiungiCliente());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Aggiungi cliente"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Aggiungi cliente")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Aggiungi cliente"), panel);
            }
        });

        macchinario.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Aggiungi macchinario") == -1) {
                tabbedPane.addTab("Aggiungi macchinario", aggiungiMacchianario());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Aggiungi macchinario"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Aggiungi macchinario")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Aggiungi macchinario"), panel);
            }
        });

        interrogazioni.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Interrogazioni") == -1) {
                tabbedPane.addTab("Interrogazioni", interrogazioni());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Interrogazioni"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Interrogazioni")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Interrogazioni"), panel);
            }
        });


        menu.add(estetiste);
        menu.add(new JSeparator());
        menu.add(cliente);
        menu.add(macchinario);
        menu.add(new JSeparator());
        menu.add(interrogazioni);

        barraMenu.add(menu);

        JPanel flow = new JPanel();
        JButton visualizza = new JButton("Visualizza");
        visualizza.addActionListener(e -> {
            if (tabbedPane.indexOfTab("Visualizza") == -1) {
                tabbedPane.addTab("Visualizza", visualizza());
                JPanel panel = new JPanel();
                panel.add(new JLabel("Visualizza"));
                JButton x = new JButton("x");
                x.addActionListener(e1 -> tabbedPane.remove(tabbedPane.indexOfTab("Visualizza")));
                panel.add(x);
                tabbedPane.setTabComponentAt(tabbedPane.indexOfTab("Visualizza"), panel);
            }
        });
        flow.add(prenotazioni);
        flow.add(visualizza);
        flow.add(barraMenu);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(flow, BorderLayout.WEST);

        menuPanel.add(panel, BorderLayout.WEST);


        JPanel tabsPanel = new JPanel();
        tabsPanel.setLayout(new GridLayout(1, 1));
        tabsPanel.add(tabbedPane);


        south.add(menuPanel, BorderLayout.NORTH);
        south.add(tabsPanel, BorderLayout.CENTER);

        return south;
    }

    public JPanel interrogazioni() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JLabel queryLabel = new JLabel("Inserisci la query :");
        queryLabel.setFont(new Font("queryfont", Font.ITALIC, 15));
        top.add(queryLabel, BorderLayout.NORTH);
        JTextArea query = new JTextArea();
        JScrollPane queryScroll = new JScrollPane(query);
        top.add(queryScroll, BorderLayout.CENTER);


        JPanel bot = new JPanel();
        bot.setLayout(new BorderLayout());
        JLabel resultLabel = new JLabel("Risposta del DB :");
        resultLabel.setFont(new Font("queryfont", Font.ITALIC, 15));
        bot.add(resultLabel, BorderLayout.NORTH);
        JTextArea result = new JTextArea();
        JScrollPane resultScroll = new JScrollPane(result);
        bot.add(resultScroll, BorderLayout.CENTER);

        JPanel inviaPanel = new JPanel();
        JButton invia = new JButton("invia");
        invia.addActionListener(e -> {
            try {

                result.setText(result.getText() + "\n" + database.sendQuery(query.getText()) + "\n");

            } catch (SQLException er) {
                result.setText(result.getText() + "Errore provenienete da JDBC\n");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                result.setText(result.getText() + "Errore generico\n");
                System.out.println(er);
                er.printStackTrace();
            }


        });
        inviaPanel.add(invia);
        top.add(inviaPanel, BorderLayout.SOUTH);


        panel.add(top);
        panel.add(bot);

        return panel;
    }

    public JPanel visualizza() {

        JPanel visualizza = new JPanel();
        visualizza.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());

        JPanel northNorth = new JPanel();
        northNorth.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 2));
        panel1.setBorder(new TitledBorder(new EtchedBorder(), "Opzioni"));

        radio11 = new JRadioButton("Verifica appuntamento per un determinato giorno e ora");
        radio11.setSelected(true);
        radio12 = new JRadioButton("Appuntamenti effettuati per tipo");
        radio13 = new JRadioButton("Estetista che ha lavorato di piu sui macchianari in questo anno");
        radio14 = new JRadioButton("Ore occupazione sale in un anno");
        radio15 = new JRadioButton("Visualizzazione dei macchinari che può utilizzare un’estetista");
        radio16 = new JRadioButton("Verifica orari per un determinato giorno");
        radio17 = new JRadioButton("Verifica giorni per un determinato orario");
        radio18 = new JRadioButton("Verifica primo appuntamento per un determinato macchinario");
        radio19 = new JRadioButton("Visualizzazione dei macchinari che sono stati utilizzati per più di 2 ore in un anno");

        panel12 = new JPanel();

        radio11.addActionListener(e -> radioListener());
        radio12.addActionListener(e -> radioListener());
        radio13.addActionListener(e -> radioListener());
        radio14.addActionListener(e -> radioListener());
        radio15.addActionListener(e -> radioListener());
        radio16.addActionListener(e -> radioListener());
        radio17.addActionListener(e -> radioListener());
        radio18.addActionListener(e -> radioListener());
        radio19.addActionListener(e -> radioListener());

        ButtonGroup group = new ButtonGroup();
        group.add(radio12);
        group.add(radio11);
        group.add(radio13);
        group.add(radio14);
        group.add(radio15);
        group.add(radio16);
        group.add(radio17);
        group.add(radio18);
        group.add(radio19);

        panel1.add(radio12);
        panel1.add(radio11);
        panel1.add(radio13);
        panel1.add(radio14);
        panel1.add(radio15);
        panel1.add(radio16);
        panel1.add(radio17);
        panel1.add(radio18);
        panel1.add(radio19);

        mesePanel = new JPanel();
        JLabel meseLabel = new JLabel("Mese :");
        JTextField meseField = new JTextField(3);
        mesePanel.add(meseLabel);
        mesePanel.add(meseField);
        mesePanel.setVisible(false);

        annoPanel = new JPanel();
        JLabel annoLabel = new JLabel("Anno :");
        JTextField annoField = new JTextField(3);
        annoPanel.add(annoLabel);
        annoPanel.add(annoField);
        annoPanel.setVisible(false);

        durataPanel = new JPanel();
        JLabel durataLabel = new JLabel("Durata :");
        JTextField durataField = new JTextField(8);
        durataField.setText("hh:mm:ss");
        durataPanel.add(durataLabel);
        durataPanel.add(durataField);

        dataPanel = new JPanel();
        JLabel dataLabel = new JLabel("Data :");
        JTextField dataField = new JTextField(8);
        dataField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                mesePanel.setVisible(false);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        dataField.setText("yyyy-mm-dd");
        dataPanel.add(dataLabel);
        dataPanel.add(dataField);

        oraPanel = new JPanel();
        JLabel oraLabel = new JLabel("Ora :");
        JTextField oraField = new JTextField(8);
        oraField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!oraField.getText().equals("hh:mm:ss") || dataField.getText().equals("yyyy-mm-dd") || dataField.getText().equals(""))
                    mesePanel.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (oraField.getText().equals("hh:mm:ss") || !dataField.getText().equals("yyyy-mm-dd"))
                    mesePanel.setVisible(false);
            }
        });
        oraField.setText("hh:mm:ss");
        oraPanel.add(oraLabel);
        oraPanel.add(oraField);

        JTextArea log = new JTextArea();
        JScrollPane logScroll = new JScrollPane(log);

        macchinario = new JComboBox();
        caricaDati(macchinario, "Macchinari");
        macchinario.setVisible(false);

        ricMacchinario = new JCheckBox("Richiedi macchinario");
        ricMacchinario.addActionListener(e -> {
            if (ricMacchinario.isSelected())
                macchinario.setVisible(true);
            else
                macchinario.setVisible(false);
        });

        estetistaPanel = new JPanel();
        JComboBox estetistaBox = new JComboBox();
        caricaDati(estetistaBox, "Estetiste Specializzate");
        estetistaPanel.add(estetistaBox);
        estetistaPanel.setVisible(false);

        verifica = new JButton("verifica");
        verifica.addActionListener(e -> {

            //mesePanel.setVisible(false);

            try {

                if (radio11.isSelected()) {

                    boolean result;
                    LocalTime orario = LocalTime.parse(oraField.getText());
                    LocalTime durata = LocalTime.parse(durataField.getText());
                    LocalDate data = LocalDate.parse(dataField.getText());


                    if (ricMacchinario.isSelected()) {
                        String[] fields = macchinario.getSelectedItem().toString().split("-");
                        result = database.verificaDataOraMacchinario(data.toString(), orario.toString(), durata.toString(), fields[1], fields[0]);
                    } else
                        result = database.verificaDataOra(data.toString(), orario.toString(), durata.toString());


                    if (result)
                        log.setText(log.getText() + "E' POSSIBILE PRENOTARE\n");
                    else
                        log.setText(log.getText() + "NON E' POSSIBILE PRENOTARE\n");

                } else if (radio12.isSelected()) {
                    ArrayList<String> result = database.numeroAppuntamentiPerTipo(annoField.getText());
                    log.setText(log.getText() + "NUMERO APPUNTAMENTI IN BASE AL TIPO \n");
                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");
                } else if (radio13.isSelected()) {

                    String result = database.estetistaOreMaxMacchinari();

                    log.setText(log.getText() + "RICERCA DELL' ESTETISTA VHE HA UTILIZZATO PER PIU' I MACCHINARI \n");
                    log.setText(log.getText() + "ESTETISTA : " + result + "\n\n");

                } else if (radio14.isSelected()) {

                    ArrayList<String> result = database.oreUtilizzoPerSala();
                    log.setText(log.getText() + "ORE DI OCCUPAZIONE DELLE SALE IN UN ANNO\n");
                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");

                } else if (radio15.isSelected()) {
                    String cf = estetistaBox.getSelectedItem().toString();
                    ArrayList<String> result = database.estetistaSaUtilizzare(cf);
                    log.setText(log.getText() + "L'estetista " + cf + " SA USARE : \n");
                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");
                } else if (radio16.isSelected()) {

                    ArrayList<String> result;

                    LocalDate data = LocalDate.parse(dataField.getText());
                    LocalTime durata = LocalTime.parse(durataField.getText());

                    if (durata.toString().compareTo("05:00") >= 0)
                        throw new RuntimeException("Durata non cosiderabile");

                    if (ricMacchinario.isSelected()) {
                        String[] fields = macchinario.getSelectedItem().toString().split("-");
                        result = database.verificaOrariInUnGiornoMacchinario(data.toString(), durata.toString(), fields[1], fields[0]);
                        log.setText(log.getText() + "RICERCA DI UN'ORA DISPONIBILE IN BASE ALLA DATA PER IL MACCHINARIO :" + macchinario.getSelectedItem().toString() + "\n");
                    } else {
                        result = database.verificaOrariInUnGiorno(data.toString(), durata.toString());
                        log.setText(log.getText() + "RICERCA DI UN'ORA DISPONIBILE IN BASE ALLA DATA :\n");
                    }


                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");

                } else if (radio17.isSelected()) {
                    ArrayList<String> result;

                    LocalTime orario = LocalTime.parse(oraField.getText());
                    LocalTime durata = LocalTime.parse(durataField.getText());

                    if (ricMacchinario.isSelected()) {
                        String[] fields = macchinario.getSelectedItem().toString().split("-");
                        result = database.verificaOraMacchinario(Integer.parseInt(meseField.getText()), orario.toString(), durata.toString(), fields[1], fields[0]);
                        log.setText(log.getText() + "RICERCA DI UNA DATA DISPONIBILE IN BASE ALL'ORA PER IL MACCHINARIO : " + macchinario.getSelectedItem().toString() + "\n");
                    } else {
                        result = database.verificaOra(Integer.parseInt(meseField.getText()), orario.toString(), durata.toString());
                        log.setText(log.getText() + "RICERCA DI UNA DATA DISPONIBILE IN BASE ALL'ORA\n");
                    }


                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");

                } else if (radio18.isSelected()) {

                    String[] fields = macchinario.getSelectedItem().toString().split("-");
                    String result = database.verificaPrimaDataMacchinario(Integer.parseInt(meseField.getText()), oraField.getText(), durataField.getText(), fields[1], fields[0]);


                    log.setText(log.getText() + "RICERCA DELLA PRIMA DATA PER IL MACCHINARIO : " + macchinario.getSelectedItem().toString() + "\n");
                    log.setText(log.getText() + "PRIMA DATA DISPONIBILE : " + result + "\n\n");
                } else {
                    ArrayList<String> result = database.macchinariUsatiPiuDiOre();

                    log.setText(log.getText() + "RICERCA DEI MACCHINARI CHE SONO STATI UTILIZZATI PIU' DI 2 ORE\n");
                    log.setText(log.getText() + "MACCHINARI : \n");

                    for (int i = 0; i < result.size(); i++)
                        log.setText(log.getText() + result.get(i) + "\n");
                    log.setText(log.getText() + "\n");
                }

            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore nella ricerca dati.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati.");
                System.out.println(er);
                er.printStackTrace();
            }

        });


        panel12.add(dataPanel);
        panel12.add(oraPanel);
        panel12.add(mesePanel);
        panel12.add(annoPanel);
        panel12.add(durataPanel);
        panel12.add(macchinario);
        panel12.add(ricMacchinario);
        panel12.add(verifica);

        JPanel panel113 = new JPanel();
        panel113.setLayout(new GridLayout(2, 1));


        panel113.add(panel12);
        panel113.add(estetistaPanel);

        northNorth.add(panel1);
        northNorth.add(panel113);

        north.add(northNorth);


        visualizza.add(north, BorderLayout.NORTH);
        visualizza.add(logScroll, BorderLayout.CENTER);


        return visualizza;
    }

    public JPanel Prenotazione() {

        JPanel panel = new JPanel();

        OverlayLayout overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);

        //primo
        JButton prenota = new JButton("Nuova prenotazione");
        JButton modifica = new JButton("Modifica prenotazione");
        JPanel panelTop = new JPanel();
        panelTop.add(prenota);
        panelTop.add(modifica);

        //secondo

        JPanel inserisci = new JPanel();
        inserisci.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(2, 3));

        JPanel clientePanel = new JPanel();
        JLabel clienteLabel = new JLabel("Cliente :");
        JComboBox clienteBox = new JComboBox();
        caricaDati(clienteBox, "Clienti");
        clientePanel.add(clienteLabel);
        clientePanel.add(clienteBox);

        JPanel durataPanel = new JPanel();
        JLabel durataLabel = new JLabel("Durata :");
        JTextField durataField = new JTextField(8);
        durataField.setText("hh:mm:ss");
        durataPanel.add(durataLabel);
        durataPanel.add(durataField);

        JPanel dataPanel = new JPanel();
        JLabel dataLabel = new JLabel("Data :");
        JTextField dataField = new JTextField(8);
        dataField.setText("yyyy-mm-dd");
        dataPanel.add(dataLabel);
        dataPanel.add(dataField);

        JPanel oraPanel = new JPanel();
        JLabel oraLabel = new JLabel("Ora :");
        JTextField oraField = new JTextField(8);
        oraField.setText("hh:mm:ss");
        oraPanel.add(oraLabel);
        oraPanel.add(oraField);

        JPanel macchinarioPanel = new JPanel();
        macchinarioPanel.setLayout(new BorderLayout());
        JComboBox macchinario = new JComboBox();
        caricaDati(macchinario, "Macchinari");
        macchinarioPanel.add(macchinario, BorderLayout.WEST);
        macchinarioPanel.setVisible(false);

        JCheckBox ricMacchinario = new JCheckBox("Richiedi macchinario");
        ricMacchinario.addActionListener(e -> {
            if (ricMacchinario.isSelected())
                macchinarioPanel.setVisible(true);
            else
                macchinarioPanel.setVisible(false);
        });

        north.add(clientePanel);
        north.add(dataPanel);
        north.add(ricMacchinario);
        north.add(oraPanel);
        north.add(durataPanel);
        north.add(macchinarioPanel);

        inserisci.add(north, BorderLayout.NORTH);
        inserisci.setVisible(false);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        JPanel descrizionePanel = new JPanel();
        descrizionePanel.setLayout(new BorderLayout());
        JTextArea descrizoneArea = new JTextArea();
        JScrollPane descrizioneScroll = new JScrollPane(descrizoneArea);
        descrizionePanel.add(new JLabel("Descrizione :"), BorderLayout.NORTH);
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(2, 1));
        areaPanel.add(descrizioneScroll);
        JPanel logPanel = new JPanel();
        JLabel log = new JLabel();
        log.setVisible(false);
        log.setFont(font);
        logPanel.add(log);
        areaPanel.add(logPanel);
        descrizionePanel.add(areaPanel, BorderLayout.CENTER);
        center.add(descrizionePanel, BorderLayout.CENTER);

        JPanel inviaPanel = new JPanel();
        JButton invia = new JButton("Prenota");
        invia.addActionListener(e -> {
            try {

                String[] fields = clienteBox.getSelectedItem().toString().split("-");

                boolean flag;

                String decrizione = descrizoneArea.getText();
                if (decrizione.equals(""))
                    decrizione = null;

                if (ricMacchinario.isSelected()) {
                    String[] macchinari = macchinario.getSelectedItem().toString().split("-");
                    flag = database.addAppuntamentoMacchinario(fields[2], dataField.getText(), oraField.getText(), durataField.getText(), macchinari[1], macchinari[0], decrizione);
                } else
                    flag = database.addAppuntamento(fields[2], dataField.getText(), oraField.getText(), durataField.getText(), decrizione);

                log.setVisible(true);

                if (flag)
                    log.setText("Appuntamento inserito correttamente");
                else
                    log.setText("Appuntamento non inserito");

            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati nel database.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Controllare i dati inseriti.");
                System.out.println(er);
                er.printStackTrace();
            }
        });
        inviaPanel.add(invia);
        center.add(inviaPanel, BorderLayout.EAST);

        inserisci.add(center, BorderLayout.CENTER);

        //secondo
        JPanel modificaPanel = new JPanel();
        JLabel risposta = new JLabel();
        risposta.setFont(font);
        JPanel pannel1 = new JPanel();
        pannel1.add(risposta);
        JPanel pannelloDestra = new JPanel();

        //parte sinistra
        JPanel pannelloSinistra = new JPanel();

        JComboBox appuntamento = new JComboBox();
        JPanel Pappuntamento = new JPanel();
        Pappuntamento.add(appuntamento);

        JComboBox cliente1 = new JComboBox();
        cliente1.addActionListener(e -> {
            caricaAppuntamenti(appuntamento, (String) cliente1.getSelectedItem());
            if (appuntamento.getItemCount() == 0) {
                Pappuntamento.setVisible(false);
                pannelloDestra.setVisible(false);
            } else {
                Pappuntamento.setVisible(true);
                pannelloDestra.setVisible(true);
            }

        });
        JPanel Pcliente = new JPanel();
        caricaDati(cliente1, "Clienti");
        Pcliente.add(cliente1);

        pannelloSinistra.setLayout(new GridLayout(2, 1));
        pannelloSinistra.add(Pcliente);
        pannelloSinistra.add(Pappuntamento);

        //pannello destra


        JPanel durataPanel2 = new JPanel();
        JLabel durataLabel2 = new JLabel("Durata :");
        JTextField durataField2 = new JTextField(8);
        durataField.setText("hh:mm:ss");
        durataPanel2.add(durataLabel2);
        durataPanel2.add(durataField2);

        JPanel dataPanel2 = new JPanel();
        JLabel dataLabel2 = new JLabel("Data :");
        JTextField dataField2 = new JTextField(8);
        dataField.setText("yyyy-mm-dd");
        dataPanel2.add(dataLabel2);
        dataPanel2.add(dataField2);

        JPanel oraPanel2 = new JPanel();
        JLabel oraLabel2 = new JLabel("Ora :");
        JTextField oraField2 = new JTextField(8);
        oraField.setText("hh:mm:ss");
        oraPanel2.add(oraLabel2);
        oraPanel2.add(oraField2);

        JPanel macchinarioPanel2 = new JPanel();
        JComboBox macchinario2 = new JComboBox();
        caricaDati(macchinario2, "Macchinari");
        macchinarioPanel2.add(macchinario2);
        macchinarioPanel2.setVisible(false);

        JPanel ricMacchinarioPanel = new JPanel();
        JCheckBox ricMacchinario2 = new JCheckBox("Richiedi macchinario");
        ricMacchinario2.addActionListener(e -> {
            if (ricMacchinario2.isSelected())
                macchinarioPanel2.setVisible(true);
            else
                macchinarioPanel2.setVisible(false);
        });
        ricMacchinarioPanel.add(ricMacchinario2);


        JPanel panelbuttone = new JPanel();
        JButton bottone = new JButton("Modifica");
        bottone.addActionListener(e -> {
            try {

                String[] fields = cliente1.getSelectedItem().toString().split("-");
                String data = appuntamento.getSelectedItem().toString().substring(0, 10);
                String ora = appuntamento.getSelectedItem().toString().substring(11);

                boolean flag;

                if (ricMacchinario2.isSelected()) {
                    String[] macchinari = macchinario2.getSelectedItem().toString().split("-");
                    flag = database.modAppuntamentoMacchinario(fields[2], dataField2.getText(), oraField2.getText(), durataField2.getText(), data, ora, macchinari[1], macchinari[0]);
                } else
                    flag = database.modAppuntamento(fields[2], dataField2.getText(), oraField2.getText(), durataField2.getText(), data, ora);

                caricaAppuntamenti(appuntamento, (String) cliente1.getSelectedItem());

                log.setVisible(true);

                if (flag)
                    risposta.setText("Appuntamento modificato correttamente");
                else
                    risposta.setText("Appuntamento non modificato");

            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati nel database.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Controllare i dati inseriti.");
                System.out.println(er);
                er.printStackTrace();
            }
        });
        panelbuttone.add(bottone);


        pannelloDestra.setLayout(new GridLayout(6, 1));
        pannelloDestra.add(dataPanel2);
        pannelloDestra.add(oraPanel2);
        pannelloDestra.add(durataPanel2);
        pannelloDestra.add(ricMacchinarioPanel);
        pannelloDestra.add(macchinarioPanel2);
        pannelloDestra.add(panelbuttone);

        JPanel Complessivo = new JPanel();
        Complessivo.setLayout(new GridLayout(1, 2));
        Complessivo.add(pannelloSinistra);
        Complessivo.add(pannelloDestra);


        modificaPanel.setLayout(new BorderLayout());
        modificaPanel.add(Complessivo, BorderLayout.NORTH);
        modificaPanel.add(pannel1, BorderLayout.CENTER);
        modificaPanel.setVisible(false);


        panel.add(panelTop);
        panel.add(inserisci);
        panel.add(modificaPanel);
        prenota.addActionListener(e -> {
            inserisci.setVisible(true);
            panelTop.setVisible(false);
            modificaPanel.setVisible(false);
        });
        modifica.addActionListener(e -> {
            inserisci.setVisible(false);
            panelTop.setVisible(false);
            modificaPanel.setVisible(true);
        });

        return panel;

    }

    public JPanel aggiungiMacchianario() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(2, 3));

        JPanel nomePanel = new JPanel();
        JLabel nomeLabel = new JLabel("Nome :");
        JTextField nomeField = new JTextField(10);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeField);

        JPanel marcaPanel = new JPanel();
        JLabel marcaLabel = new JLabel("Marca :");
        JTextField marcaField = new JTextField(10);
        marcaPanel.add(marcaLabel);
        marcaPanel.add(marcaField);

        JPanel modelloPanel = new JPanel();
        JLabel modelloLabel = new JLabel("Modello :");
        JTextField modelloField = new JTextField(10);
        modelloPanel.add(modelloLabel);
        modelloPanel.add(modelloField);

        JPanel salaPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        salaPanel.setLayout(new BorderLayout());
        JLabel salaLabel = new JLabel("Sala :");
        JComboBox salaBox = new JComboBox();
        leftPanel.add(salaLabel);
        leftPanel.add(salaBox);
        salaPanel.add(leftPanel, BorderLayout.WEST);


        JCheckBox attributi = new JCheckBox("Antinvecchiamento");

        JPanel tipoPanel = new JPanel();
        JComboBox tipoBox = new JComboBox();

        tipoBox.addActionListener(e -> {
            if (tipoBox.getSelectedIndex() == 0) {

                attributi.setText("Antinvecchiamento");
                caricaDati(salaBox, "Codici Sala per antinvecchiamento");
            } else {
                attributi.setText("Dimagrimento");
                caricaDati(salaBox, "Codici Sala per dimagrimento");
            }

        });

        tipoBox.addItem("VISO");
        tipoBox.addItem("CORPO");
        JLabel tipoLabel = new JLabel("Tipo :");
        tipoPanel.add(tipoLabel);
        tipoPanel.add(tipoBox);

        north.add(nomePanel);
        north.add(marcaPanel);
        north.add(salaPanel);
        north.add(modelloPanel);
        north.add(tipoPanel);
        north.add(attributi);

        north.setBorder(new EmptyBorder(10, 0, 15, 0));


        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        JPanel descrizionePanel = new JPanel();
        descrizionePanel.setLayout(new BorderLayout());
        JTextArea descrizoneArea = new JTextArea();
        JScrollPane descrizioneScroll = new JScrollPane(descrizoneArea);
        descrizionePanel.add(new JLabel("Descrizione :"), BorderLayout.NORTH);
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(2, 1));
        areaPanel.add(descrizioneScroll);
        JPanel logPanel = new JPanel();
        JLabel log = new JLabel();
        log.setVisible(false);
        log.setFont(font);
        logPanel.add(log);
        areaPanel.add(logPanel);
        descrizionePanel.add(areaPanel, BorderLayout.CENTER);
        center.add(descrizionePanel, BorderLayout.CENTER);

        JPanel aggiungiPanel = new JPanel();
        JButton aggiungi = new JButton("Aggiungi");
        aggiungi.addActionListener(e -> {
            try {
                database.addMacchinario(nomeField.getText(), modelloField.getText(), marcaField.getText(), tipoBox.getSelectedItem().toString(), salaBox.getSelectedItem().toString(), descrizoneArea.getText(), attributi.isSelected());
                log.setVisible(true);
                log.setText("Macchinario inserito correttamente");

            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati nel database.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Controllare i dati inseriti.");
                System.out.println(er);
                er.printStackTrace();
            }
        });

        aggiungiPanel.add(aggiungi);

        center.add(aggiungiPanel, BorderLayout.EAST);


        panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);


        return panel;
    }

    public JPanel aggiungiCliente() {


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(2, 2));

        JPanel nomePanel = new JPanel();
        JLabel nomeLabel = new JLabel("Nome :");
        JTextField nomeField = new JTextField(10);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeField);

        JPanel cognomePanel = new JPanel();
        JLabel cognomeLabel = new JLabel("Cognome :");
        JTextField cognomeField = new JTextField(10);
        cognomePanel.add(cognomeLabel);
        cognomePanel.add(cognomeField);

        JPanel etaPanel = new JPanel();
        JLabel etaLabel = new JLabel("Eta' :");
        JTextField etaField = new JTextField(10);
        etaPanel.add(etaLabel);
        etaPanel.add(etaField);

        JPanel sessoPanel = new JPanel();
        JComboBox sessoBox = new JComboBox();

        sessoBox.addItem("M");
        sessoBox.addItem("F");
        JLabel tipoLaber = new JLabel("Sesso :");
        sessoPanel.add(tipoLaber);
        sessoPanel.add(sessoBox);

        north.add(nomePanel);
        north.add(cognomePanel);
        north.add(etaPanel);
        north.add(sessoPanel);
        north.setBorder(new EmptyBorder(10, 0, 15, 0));


        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new GridLayout(2, 1));
        JPanel logPanel = new JPanel();
        JLabel log = new JLabel();
        log.setVisible(false);
        log.setFont(font);
        logPanel.add(log);
        JPanel aggiungiPanel = new JPanel();
        JButton aggiungi = new JButton("Aggiungi");
        aggiungi.addActionListener(e -> {
            try {

                database.addCliente(nomeField.getText(), cognomeField.getText(), Integer.parseInt(etaField.getText()), sessoBox.getSelectedItem().toString());
                log.setVisible(true);
                log.setText("Cliente inserito correttamente");

            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati nel database.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Controllare i dati inseriti.");
                System.out.println(er);
                er.printStackTrace();
            }
        });

        aggiungiPanel.add(aggiungi);

        areaPanel.add(aggiungiPanel);
        areaPanel.add(logPanel);


        center.add(areaPanel, BorderLayout.CENTER);


        panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);


        return panel;

    }

    public JPanel estetiste() {

        JPanel panel = new JPanel();

        OverlayLayout overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);

        //primo
        JButton prenota = new JButton("Inserisci nuova estetista");
        JButton modifica = new JButton("Modifica estetista");
        JPanel panelTop = new JPanel();
        panelTop.add(prenota);
        panelTop.add(modifica);

        JPanel inserisci = new JPanel();
        inserisci.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new GridLayout(3, 4));

        JPanel nomePanel = new JPanel();
        JLabel nomeLabel = new JLabel("Nome :");
        JTextField nomeField = new JTextField(10);
        nomePanel.add(nomeLabel);
        nomePanel.add(nomeField);

        JPanel cognomePanel = new JPanel();
        JLabel cognomeLabel = new JLabel("Cognome :");
        JTextField cognomeField = new JTextField(10);
        cognomePanel.add(cognomeLabel);
        cognomePanel.add(cognomeField);

        JPanel stipendioPanel = new JPanel();
        JLabel stipendioLabel = new JLabel("Stipendio :");
        JTextField stipendioField = new JTextField(10);
        stipendioPanel.add(stipendioLabel);
        stipendioPanel.add(stipendioField);

        JPanel giorniPanel = new JPanel();
        JLabel giorniLabel = new JLabel("Giorni lavorativi :");
        JTextField giorniField = new JTextField(10);
        giorniPanel.add(giorniLabel);
        giorniPanel.add(giorniField);

        JPanel contrattoPanel = new JPanel();
        JLabel contrattoLabel = new JLabel("Tipo contratto :");
        JTextField contrattoField = new JTextField(10);
        contrattoPanel.add(contrattoLabel);
        contrattoPanel.add(contrattoField);

        JPanel assunzionePanel = new JPanel();
        JLabel assunzioneLabel = new JLabel("Data assunzione :");
        JTextField assunzioneField = new JTextField(10);
        assunzionePanel.add(assunzioneLabel);
        assunzionePanel.add(assunzioneField);

        JPanel codiceFiscalePanel = new JPanel();
        JLabel codiceFiscaleLabel = new JLabel("Codice fiscale :");
        JTextField codiceFiscaleField = new JTextField(10);
        codiceFiscalePanel.add(codiceFiscaleLabel);
        codiceFiscalePanel.add(codiceFiscaleField);

        JPanel etaPanel = new JPanel();
        JLabel etaLabel = new JLabel("Eta :");
        JTextField etaField = new JTextField(10);
        etaPanel.add(etaLabel);
        etaPanel.add(etaField);

        JPanel oraInizioPanel = new JPanel();
        JLabel oraInizioLabel = new JLabel("Ora inizio :");
        JTextField oraInizioField = new JTextField(10);
        oraInizioPanel.add(oraInizioLabel);
        oraInizioPanel.add(oraInizioField);

        JPanel oraFinePanel = new JPanel();
        JLabel oraFineLabel = new JLabel("Ora fine :");
        JTextField oraFineField = new JTextField(10);
        oraFinePanel.add(oraFineLabel);
        oraFinePanel.add(oraFineField);

        JPanel specializzazionePanel = new JPanel();
        JLabel specializzazioneLabel = new JLabel("Specializzazione :");
        JTextField specializzazioneField = new JTextField(10);
        specializzazionePanel.add(specializzazioneLabel);
        specializzazionePanel.add(specializzazioneField);

        JPanel tipoPanel = new JPanel();
        JComboBox tipoBox = new JComboBox();
        tipoBox.addActionListener(e -> {
            if (tipoBox.getSelectedIndex() == 0)
                specializzazionePanel.setVisible(true);
            else
                specializzazionePanel.setVisible(false);

        });
        tipoBox.addItem("SPECIALIZZATA");
        tipoBox.addItem("NON SPECIALIZZATA");
        tipoPanel.add(tipoBox);


        north.add(nomePanel);
        north.add(cognomePanel);
        north.add(stipendioPanel);
        north.add(giorniPanel);
        north.add(contrattoPanel);
        north.add(assunzionePanel);
        north.add(codiceFiscalePanel);
        north.add(etaPanel);
        north.add(oraInizioPanel);
        north.add(oraFinePanel);
        north.add(tipoPanel);
        north.add(specializzazionePanel);

        inserisci.add(north, BorderLayout.NORTH);
        inserisci.setVisible(false);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());

        JPanel logPanel = new JPanel();
        logPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        JLabel log = new JLabel();
        logPanel.add(log);
        log.setFont(font);
        center.add(logPanel, BorderLayout.CENTER);

        JPanel inviaPanel = new JPanel();
        JButton invia = new JButton("invia");
        invia.addActionListener(e -> {
            try {
                database.addEstetista(codiceFiscaleField.getText(), nomeField.getText(), cognomeField.getText(), Double.parseDouble(stipendioField.getText()), Integer.parseInt(giorniField.getText()), contrattoField.getText(), tipoBox.getSelectedItem().toString(), assunzioneField.getText(), oraInizioField.getText(), oraFineField.getText(), Integer.parseInt(etaField.getText()), specializzazioneField.getText());
                log.setText("INSERIMENTO COMPLETATO");
            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore nella ricerca dati.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati.");
                System.out.println(er);
                er.printStackTrace();
            }
        });
        inviaPanel.add(invia);
        center.add(inviaPanel, BorderLayout.NORTH);

        inserisci.add(center, BorderLayout.CENTER);

        //secondo

        JPanel modificaPanel = new JPanel();
        modificaPanel.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 4));


        JLabel selezionaLabel = new JLabel("Seleziona estetista :");
        JPanel selezionaPanel = new JPanel();
        JComboBox selezionaBox = new JComboBox();
        caricaDati(selezionaBox, "Estetiste");
        selezionaPanel.add(selezionaLabel);
        selezionaPanel.add(selezionaBox);

        JPanel tipoContrattoPanel = new JPanel();
        JLabel tipoContrattoLabel = new JLabel("Tipo contratto :");
        JTextField tipoContrattoField = new JTextField(10);
        tipoContrattoPanel.add(tipoContrattoLabel);
        tipoContrattoPanel.add(tipoContrattoField);

        JPanel licenziamentoPanel = new JPanel();
        JLabel licenziamentoLabel = new JLabel("Data licenziamento :");
        JTextField licenziamentoField = new JTextField(10);
        licenziamentoPanel.add(licenziamentoLabel);
        licenziamentoPanel.add(licenziamentoField);

        JPanel licenziaPanel = new JPanel();
        JCheckBox licenziaCheck = new JCheckBox("Licenzia");
        licenziaPanel.add(licenziaCheck);

        licenziamentoPanel.setVisible(false);

        top.add(selezionaPanel);
        top.add(tipoContrattoPanel);
        top.add(licenziamentoPanel);
        top.add(licenziaPanel);


        licenziaCheck.addActionListener(e -> {
            if (licenziaCheck.isSelected())
                licenziamentoPanel.setVisible(true);
            else
                licenziamentoPanel.setVisible(false);
        });

        JPanel center2 = new JPanel();
        center2.setLayout(new BorderLayout());

        JPanel logPanel2 = new JPanel();
        logPanel2.setBorder(new EmptyBorder(10, 0, 0, 0));
        JLabel log2 = new JLabel();
        logPanel2.add(log2);
        log2.setFont(font);
        center2.add(logPanel2, BorderLayout.CENTER);

        JPanel inviaPanel2 = new JPanel();
        JButton invia2 = new JButton("invia");
        invia2.addActionListener(e -> {

            try {

                if (licenziaCheck.isSelected())
                    database.modEstetista(licenziamentoField.getText(), tipoContrattoField.getText(), selezionaBox.getSelectedItem().toString());
                else
                    database.modEstetista(null, tipoContrattoField.getText(), selezionaBox.getSelectedItem().toString());

                log2.setText("INSERIMENTO COMPLETATO");
            } catch (SQLException er) {
                JOptionPane.showMessageDialog(null, "Errore nella ricerca dati.");
                System.out.println(er);
                er.printStackTrace();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, "Errore inserimento dati.");
                System.out.println(er);
                er.printStackTrace();
            }

        });
        inviaPanel2.add(invia2);
        center2.add(inviaPanel2, BorderLayout.NORTH);

        modificaPanel.add(top, BorderLayout.NORTH);
        modificaPanel.add(center2, BorderLayout.CENTER);

        modificaPanel.setVisible(false);


        panel.add(panelTop);
        panel.add(inserisci);
        panel.add(modificaPanel);
        prenota.addActionListener(e -> {
            inserisci.setVisible(true);
            panelTop.setVisible(false);
            modificaPanel.setVisible(false);
        });
        modifica.addActionListener(e -> {
            inserisci.setVisible(false);
            panelTop.setVisible(false);
            modificaPanel.setVisible(true);
        });

        return panel;
    }

    private void caricaDati(JComboBox comboBox, String parametro) {

        comboBox.removeAllItems();

        try {
            ArrayList<String> data;

            if (parametro.equals("Codici Sala per antinvecchiamento"))
                data = database.getCodiceSalePerViso();

            else if (parametro.equals("Codici Sala per dimagrimento"))
                data = database.getCodiceSalePerCorpo();
            else if (parametro.equals("Estetiste"))
                data = database.getEstetiste();
            else if (parametro.equals("Clienti"))
                data = database.getClienti();
            else if (parametro.equals("Estetiste Specializzate"))
                data = database.getEstetisteSpecializzate();
            else
                data = database.getMacchinari();

            for (String i : data)
                comboBox.addItem(i);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore proveniente da JDBC\nimpossibile caricare i dati");
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore generico\nimpossibile caricare i dati");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private void caricaAppuntamenti(JComboBox comboBox, String cliente) {

        comboBox.removeAllItems();

        String[] fields = cliente.split("-");
        try {
            ArrayList<String> data;
            data = database.getAppuntamenti(fields[2]);

            for (String i : data)
                comboBox.addItem(i);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Errore proveniente da JDBC\nimpossibile caricare i dati");
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore generico\nimpossibile caricare i dati");
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void radioListener() {

        if (radio11.isSelected()) {
            annoPanel.setVisible(false);
            panel12.setVisible(true);
            dataPanel.setVisible(true);
            oraPanel.setVisible(true);
            ricMacchinario.setVisible(true);
            estetistaPanel.setVisible(false);
            macchinario.setVisible(false);
            durataPanel.setVisible(true);
            mesePanel.setVisible(false);
        } else if (radio12.isSelected()) {
            annoPanel.setVisible(true);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(false);
            ricMacchinario.setVisible(false);
            dataPanel.setVisible(false);
            oraPanel.setVisible(false);
            mesePanel.setVisible(false);
        } else if (radio13.isSelected()) {
            annoPanel.setVisible(false);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(false);
            oraPanel.setVisible(false);
            dataPanel.setVisible(false);
            ricMacchinario.setVisible(false);
            mesePanel.setVisible(false);
        } else if (radio14.isSelected()) {
            annoPanel.setVisible(false);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(false);
            ricMacchinario.setVisible(false);
            dataPanel.setVisible(false);
            oraPanel.setVisible(false);
            mesePanel.setVisible(false);
        } else if (radio15.isSelected()) {
            macchinario.setVisible(false);
            panel12.setVisible(true);
            oraPanel.setVisible(false);
            dataPanel.setVisible(false);
            ricMacchinario.setVisible(false);
            estetistaPanel.setVisible(true);
            durataPanel.setVisible(false);
            mesePanel.setVisible(false);
        } else if (radio16.isSelected()) {
            annoPanel.setVisible(false);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            dataPanel.setVisible(true);
            oraPanel.setVisible(false);
            ricMacchinario.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(true);
            mesePanel.setVisible(false);
        } else if (radio17.isSelected()) {
            annoPanel.setVisible(false);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            dataPanel.setVisible(false);
            oraPanel.setVisible(true);
            ricMacchinario.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(true);
            mesePanel.setVisible(true);
        } else if (radio18.isSelected()) {
            annoPanel.setVisible(false);
            panel12.setVisible(true);
            dataPanel.setVisible(false);
            oraPanel.setVisible(true);
            ricMacchinario.setVisible(false);
            macchinario.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(true);
            mesePanel.setVisible(true);
        } else { //radio19
            annoPanel.setVisible(false);
            macchinario.setVisible(false);
            panel12.setVisible(true);
            estetistaPanel.setVisible(false);
            durataPanel.setVisible(false);
            oraPanel.setVisible(false);
            dataPanel.setVisible(false);
            ricMacchinario.setVisible(false);
            mesePanel.setVisible(false);
        }


    }

    private JTabbedPane tabbedPane;
    private JPanel panel12;
    private JPanel estetistaPanel;
    private Font font;
    private JRadioButton radio11;
    private JRadioButton radio12;
    private JRadioButton radio13;
    private JRadioButton radio14;
    private JRadioButton radio15;
    private JRadioButton radio16;
    private JRadioButton radio17;
    private JRadioButton radio18;
    private JRadioButton radio19;
    private JButton verifica;
    private JPanel mesePanel;
    private JPanel annoPanel;
    private JPanel dataPanel;
    private JPanel oraPanel;
    private JPanel durataPanel;
    private JCheckBox ricMacchinario;
    private JComboBox macchinario;

    private String url;
    private String user;
    private String password;
    private CentroEsteticoDB database;
}
