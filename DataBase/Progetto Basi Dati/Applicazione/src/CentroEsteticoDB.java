import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class CentroEsteticoDB {

    public CentroEsteticoDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName(NAMEDRIVER);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    public String sendQuery(String string) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(string);

        String resultString = "";
        while (rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                resultString += rs.getString(i) + " ";
            resultString += "\n";

        }
        con.close();

        return resultString;
    }

    public ArrayList<String> getCodiceSalePerViso() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceSala\n" +
                "from sala\n" +
                "where CodiceSala NOT IN (select CodiceSala\n" +
                "from macchinario NATURAL JOIN locazione\n" +
                "where tipo = 'CORPO')");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1));

        con.close();

        return resultString;
    }

    public ArrayList<String> getCodiceSalePerCorpo() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceSala\n" +
                "from sala\n" +
                "where CodiceSala NOT IN (select CodiceSala\n" +
                "from macchinario NATURAL JOIN locazione\n" +
                "where tipo = 'VISO')");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1));

        con.close();

        return resultString;
    }

    public ArrayList<String> getEstetiste() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceFiscale from estetista");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1));

        con.close();

        return resultString;
    }

    public ArrayList<String> getAppuntamenti(String cliente) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Data,Ora from appuntamento where CodiceCliente =" + cliente);

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2));

        con.close();

        return resultString;
    }

    public ArrayList<String> getClienti() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Nome,Cognome,CodiceCliente from cliente");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3));

        con.close();

        return resultString;
    }

    public ArrayList<String> getMacchinari() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Marca,Modello from macchinario");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2));

        con.close();

        return resultString;
    }

    public ArrayList<String> getEstetisteSpecializzate() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceFiscale from estetista where Tipo ='SPECIALIZZATA'");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1));

        con.close();

        return resultString;
    }

    public void addCliente(String nome, String cognome, int eta, String sesso) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO Cliente(Nome,Cognome,Eta,Sesso) VALUES " + "('" + nome + "','" + cognome + "'," + eta + ",'" + sesso + "');");
        con.close();

    }

    public void addEstetista(String codiceFiscale, String nome, String cognome, double stipendio, int giorniLavorativi, String tipoContratto, String tipo, String dataAssunzione, String oraioInizio, String orarioFine, int eta, String specializzazione) throws SQLException, ClassNotFoundException {

        String sql;
        if (tipo.equals("SPECIALIZZATA"))
            sql = "INSERT INTO Estetista (Nome,Cognome,DataTerminazione,Stipendio,GiorniLavorativi,TipoContratto,Tipo,DataAssunzione,CodiceFiscale,Eta,OrarioInizio,OrarioFine,Specializzazione,OreTotali) VALUES " +
                    "('" + nome + "','" + cognome + "',NULL," + stipendio + "," + giorniLavorativi + ",'" + tipoContratto + "','" + tipo + "','" + dataAssunzione + "','" + codiceFiscale + "'," + eta + ",'" + oraioInizio + "','" + orarioFine + "','" + specializzazione + "','00:00:00')";
        else
            sql = "INSERT INTO Estetista (Nome,Cognome,DataTerminazione,Stipendio,GiorniLavorativi,TipoContratto,Tipo,DataAssunzione,CodiceFiscale,Eta,OrarioInizio,OrarioFine) VALUES " +
                    "('" + nome + "','" + cognome + "',NULL," + stipendio + "," + giorniLavorativi + ",'" + tipoContratto + "','" + tipo + "','" + dataAssunzione + "','" + codiceFiscale + "'," + eta + ",'" + oraioInizio + "','" + orarioFine + "');";

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        con.close();

    }

    public void modEstetista(String dataTerminazione, String tipoContratto, String codiceFiscale) throws SQLException, ClassNotFoundException {

        String sql;

        if (dataTerminazione != null)
            sql = "update estetista set DataTerminazione= '" + dataTerminazione + "' , TipoContratto=' " + tipoContratto + "' where CodiceFiscale= '" + codiceFiscale + "';";
        else
            sql = "update estetista set TipoContratto=' " + tipoContratto + "' where CodiceFiscale= '" + codiceFiscale + "';";

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql);
        con.close();

    }

    public void addMacchinario(String nome, String modello, String marca, String tipo, String sala, String descrizione, boolean op) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();

        String sql;

        if (descrizione.equals(""))
            sql = "INSERT INTO Macchinario (Tipo,Descrizione,Nome,Modello,Marca,Dimagrimento,Antinvecchiamento) VALUES" +
                    "('" + tipo + "',NULL,'" + nome + "','" + modello + "','" + marca;
        else
            sql = "INSERT INTO Macchinario (Tipo,Descrizione,Nome,Modello,Marca,Dimagrimento,Antinvecchiamento) VALUES" +
                    "('" + tipo + "','" + descrizione + "','" + nome + "','" + modello + "','" + marca;

        if (tipo.equals("VISO") && op)
            sql += "',NULL,SI');";

        if (tipo.equals("CORPO") && op)
            sql += "',SI,NULL');";


        System.out.println(sql);

        stmt.executeUpdate(sql);
        stmt.executeUpdate("INSERT INTO Locazione (Modello,Marca,CodiceSala) VALUES" + "('" + modello + "','" + marca + "','" + sala + "');");
        con.close();

    }

    public boolean addAppuntamento(String codiceCliente, String data, String orario, String durata, String descrizione) throws SQLException, ClassNotFoundException {
        if (verificaDataOra(data, orario, durata)) {
            LocalTime t1 = LocalTime.parse(orario);
            LocalTime t2 = LocalTime.parse(durata);
            LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());
            Connection con = getConnection();
            Statement query = con.createStatement();
            ResultSet result = query.executeQuery("select CodiceSala " +
                    "from sala " +
                    "where CodiceSala NOT IN (select CodiceSala from appuntamento where Data = '" + data +
                    "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > " +
                    "'" + orario + "' and '" + totale + "' > ora )");

            result.next();
            String sala = result.getString("CodiceSala");

            result = query.executeQuery("select CodiceFiscale " +
                    "from estetista " +
                    "where CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and" +
                    " sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine");

            result.next();
            String codiceFiscale = result.getString("CodiceFiscale");

            String sql;

            if (descrizione == null)
                sql = "insert into appuntamento values(" + codiceCliente + ",'" + durata + "'," + null + ",'" + "NESSUNO" + "','" + data + "','" + orario + "','" + codiceFiscale + "'," + null + "," + null + ",'" + sala + "'," + null + ");";
            else
                sql = "insert into appuntamento values(" + codiceCliente + ",'" + durata + "','" + descrizione + "','" + "NESSUNO" + "','" + data + "','" + orario + "','" + codiceFiscale + "'," + null + "," + null + ",'" + sala + "'," + null + ");";

            int i = query.executeUpdate(sql);
            if (i != 0) {
                con.close();
                return true;
            }
        }
        return false;
    }

    public boolean addAppuntamentoMacchinario(String codiceCliente, String data, String orario, String durata, String modello, String marca, String descrizione) throws SQLException, ClassNotFoundException {
        if (verificaDataOraMacchinario(data, orario, durata, modello, marca)) {

            LocalTime t1 = LocalTime.parse(orario);
            LocalTime t2 = LocalTime.parse(durata);
            LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());

            Connection con = getConnection();
            Statement query = con.createStatement();

            ResultSet result = query.executeQuery("select CodiceSala,CodiceFiscale " +
                    "from (sala natural join locazione) inner join (impiego natural join estetista) on locazione.marca = impiego.marca and locazione.modello = impiego.modello " +
                    "where CodiceSala NOT IN(Select CodiceSala from appuntamento " +
                    "where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora)" +
                    "and locazione.Modello='" + modello + "' and locazione.Marca='" + marca + "'" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

            result.next();
            String sala = result.getString("CodiceSala");
            String codiceFiscale = result.getString("CodiceFiscale");

            result = query.executeQuery("Select tipo from macchinario where marca = '" + marca + "' and modello = '" + modello + "'");
            result.next();
            String tipo = result.getString("tipo");

            String sql;

            if (descrizione == null)
                sql = "insert into appuntamento values(" + codiceCliente + ",'" + durata + "'," + null + ",'" + tipo + "','" + data + "','" + orario + "','" + codiceFiscale + "','" + modello + "','" + marca + "','" + sala + "','" + durata + "');";
            else
                sql = "insert into appuntamento values(" + codiceCliente + ",'" + durata + "','" + descrizione + "','" + tipo + "','" + data + "','" + orario + "','" + codiceFiscale + "','" + modello + "','" + marca + "','" + sala + "','" + durata + "');";

            int i = query.executeUpdate(sql);
            if (i != 0) {
                i = query.executeUpdate("update estetista set OreTotali= sec_to_time(time_to_sec(OreTotali) + time_to_sec('" + durata + "')) where CodiceFiscale= '" + codiceFiscale + "' ;");
                if (i != 0) {
                    con.close();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean modAppuntamento(String codiceCliente, String data, String orario, String durata, String dataVecchia, String oraVecchia) throws SQLException, ClassNotFoundException {
        if (verificaDataOra(data, orario, durata)) {

            LocalTime t1 = LocalTime.parse(orario);
            LocalTime t2 = LocalTime.parse(durata);
            LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());
            Connection con = getConnection();
            Statement query = con.createStatement();
            ResultSet result = query.executeQuery("select CodiceSala " +
                    "from sala " +
                    "where CodiceSala NOT IN (select CodiceSala from appuntamento where Data = '" + data +
                    "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > " +
                    "'" + orario + "' and '" + totale + "' > ora )");

            result.next();
            String codiceSala = result.getString("CodiceSala");

            result = query.executeQuery("select CodiceFiscale " +
                    "from estetista " +
                    "where CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and" +
                    " sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine");

            result.next();
            String codiceFiscale = result.getString("CodiceFiscale");

            result = query.executeQuery("select CodiceFiscale,Tipo,TempoUtilizzo from appuntamento where data='" + dataVecchia + "' and ora='" + oraVecchia + "' and codiceCliente='" + codiceCliente + "';");
            result.next();
            String codiceFiscaleOld = result.getString("CodiceFiscale");
            String tipo = result.getString("Tipo");
            String tempoUtilizzo = result.getString("TempoUtilizzo");
            if (query.executeUpdate("update appuntamento set Modello = null ,Marca = null,TempoUtilizzo = null, Tipo = 'NESSUNO', CodiceSala= '" + codiceSala + "', CodiceFiscale ='" + codiceFiscale + "' , durata= '" + durata + "' , data= '" + data + "' , ora='" + orario + "' where data='" + dataVecchia + "' and CodiceCliente='" + codiceCliente + "' and CodiceFiscale='" + codiceFiscaleOld + "';") == 1)
                ;
            {

                if (!tipo.equals("NESSUNO"))
                    query.executeUpdate("update estetista set OreTotali = sec_to_time(time_to_sec(OreTotali) - time_to_sec('" + tempoUtilizzo + "')) where CodiceFiscale = '" + codiceFiscaleOld + "' ");

                con.close();
                return true;
            }
        }
        return false;
    }

    public boolean modAppuntamentoMacchinario(String codiceCliente, String data, String orario, String durata, String dataVecchia, String oraVecchia, String modello, String marca) throws SQLException, ClassNotFoundException {

        if (verificaDataOraMacchinario(data, orario, durata, modello, marca)) {

            LocalTime t1 = LocalTime.parse(orario);
            LocalTime t2 = LocalTime.parse(durata);
            LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());
            Connection con = getConnection();
            Statement query = con.createStatement();

            ResultSet result = query.executeQuery("select CodiceSala,CodiceFiscale " +
                    "from (sala natural join locazione) inner join (impiego natural join estetista) on locazione.marca = impiego.marca and locazione.modello = impiego.modello " +
                    "where CodiceSala NOT IN(Select CodiceSala from appuntamento " +
                    "where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora)" +
                    "and locazione.Modello='" + modello + "' and locazione.Marca='" + marca + "'" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

            result.next();
            String codiceSala = result.getString("CodiceSala");
            String codiceFiscale = result.getString("CodiceFiscale");


            result = query.executeQuery("select CodiceFiscale,TempoUtilizzo  from appuntamento where data='" + dataVecchia + "' and ora='" + oraVecchia + "' and codiceCliente='" + codiceCliente + "';");
            result.next();
            String codiceFiscaleOld = result.getString("CodiceFiscale");
            String tempoUtilizzo = result.getString("TempoUtilizzo");

            result = query.executeQuery("Select tipo from macchinario where marca = '" + marca + "' and modello = '" + modello + "'");
            result.next();
            String tipo = result.getString("tipo");


            if (query.executeUpdate("update appuntamento set Modello = '" + modello + "',Marca = '" + marca + "',TempoUtilizzo = '" + durata + "', Tipo = '" + tipo + "', CodiceSala= '" + codiceSala + "', CodiceFiscale ='" + codiceFiscale + "' , durata= '" + durata + "' , data= '" + data + "' , ora='" + orario + "' where data='" + dataVecchia + "' and CodiceCliente='" + codiceCliente + "' and CodiceFiscale='" + codiceFiscaleOld + "';") == 1)
                if (query.executeUpdate("update estetista set OreTotali = sec_to_time(time_to_sec(OreTotali) + time_to_sec('" + durata + "')) where CodiceFiscale = '" + codiceFiscale + "' ") == 1) {
                    if (tempoUtilizzo != null)
                        query.executeUpdate("update estetista set OreTotali = sec_to_time(time_to_sec(OreTotali) - time_to_sec('" + tempoUtilizzo + "')) where CodiceFiscale = '" + codiceFiscaleOld + "' ");
                    con.close();
                    return true;
                }


        }
        return false;
    }

    public ArrayList<String> macchinariUsatiPiuDiOre() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Modello,Marca,sec_to_time(sum(time_to_sec(TempoUtilizzo))) as TempoUtilizzo from appuntamento group by Modello,Marca having sec_to_time(sum(time_to_sec(TempoUtilizzo))) > '02:00:00'");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3));

        con.close();

        return resultString;

    }

    public ArrayList<String> estetistaSaUtilizzare(String codiceFiscale) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Marca,Modello from impiego natural join estetista where CodiceFiscale='" + codiceFiscale + "';");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2));

        con.close();

        return resultString;
    }

    public ArrayList<String> verificaOra(int mese, String orario, String durata) throws SQLException, ClassNotFoundException {

        LocalTime t1 = LocalTime.parse(orario);
        ArrayList<String> giorni = new ArrayList<String>();

        int n = 30;


        if (mese == 11 | mese == 4 | mese == 6 | mese == 9)
            n = 30;
        if (mese == 2)
            n = 28;
        if (mese == 1 | mese == 3 | mese == 5 | mese == 7 | mese == 8 | mese == 10 | mese == 12)
            n = 31;

        for (int i = 1; i <= n; i++) {
            if (i < 10)
                giorni.add("2020-" + mese + "-0" + i);
            else
                giorni.add("2020-" + mese + "-" + i);
        }


        LocalTime t2 = LocalTime.parse(durata);

        //somma+durata
        LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


        Connection con = getConnection();
        Statement query = con.createStatement();


        for (int j = 1, i = 0; j <= n && i < giorni.size(); j++) {
            ResultSet result = query.executeQuery("select CodiceSala " +
                    "from sala " +
                    "where CodiceSala NOT IN (select CodiceSala from appuntamento where Data = " +
                    "'2020-" + mese + "-" + j + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > " +
                    "'" + orario + "' and '" + totale + "' > ora )");

            if (result.next()) {

                result = query.executeQuery("select CodiceFiscale " +
                        "from estetista " +
                        "where CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '2018-" + mese + "-" + j + "' and" +
                        " sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                        "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

                if (!result.next())
                    giorni.remove(i);
                else
                    i++;
            } else
                giorni.remove(i);
        }

        if (giorni.size() == 0)
            giorni.add("NESSUNA DATA DISPONIBILE ");

        con.close();

        return giorni;
    }

    public ArrayList<String> verificaOraMacchinario(int mese, String orario, String durata, String modello, String marca) throws SQLException, ClassNotFoundException {

        LocalTime t1 = LocalTime.parse(orario);
        ArrayList<String> giorni = new ArrayList<String>();

        int n = 30;


        if (mese == 11 | mese == 4 | mese == 6 | mese == 9)
            n = 30;
        if (mese == 2)
            n = 28;
        if (mese == 1 | mese == 3 | mese == 5 | mese == 7 | mese == 8 | mese == 10 | mese == 12)
            n = 31;

        for (int i = 1; i <= n; i++) {
            if (i < 10)
                giorni.add("2020-" + mese + "-0" + i);
            else
                giorni.add("2020-" + mese + "-" + i);
        }


        LocalTime t2 = LocalTime.parse(durata);

        //somma+durata
        LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


        Connection con = getConnection();
        Statement query = con.createStatement();


        for (int j = 1, i = 0; j <= n; j++) {
            ResultSet result = query.executeQuery("select CodiceSala,CodiceFiscale " +
                    "from (sala natural join locazione) inner join (impiego natural join estetista) on locazione.marca = impiego.marca and locazione.modello = impiego.modello " +
                    "where CodiceSala NOT IN(Select CodiceSala from appuntamento " +
                    "where Data = '2020-" + mese + "-" + j + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '2020-" + mese + "-" + j + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora)" +
                    "and locazione.Modello='" + modello + "' and locazione.Marca='" + marca + "'" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

            if (!result.next() && i < giorni.size())
                giorni.remove(i);
            else
                i++;
        }

        if (giorni.size() == 0)
            giorni.add("NESSUNA DATA DISPONIBILE ");

        con.close();

        return giorni;
    }

    public String verificaPrimaDataMacchinario(int mese, String orario, String durata, String modello, String marca) throws SQLException, ClassNotFoundException {

        LocalTime t1 = LocalTime.parse(orario);
        ArrayList<String> giorni = new ArrayList<String>();

        int n = 30;


        if (mese == 11 | mese == 4 | mese == 6 | mese == 9)
            n = 30;
        if (mese == 2)
            n = 28;
        if (mese == 1 | mese == 3 | mese == 5 | mese == 7 | mese == 8 | mese == 10 | mese == 12)
            n = 31;

        for (int i = 1; i <= n; i++) {
            if (i < 10)
                giorni.add("2020-" + mese + "-0" + i);
            else
                giorni.add("2020-" + mese + "-" + i);
        }


        LocalTime t2 = LocalTime.parse(durata);

        //somma+durata
        LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


        Connection con = getConnection();
        Statement query = con.createStatement();


        for (int j = 1, i = 0; j <= n; j++) {
            ResultSet result = query.executeQuery("select CodiceSala,CodiceFiscale " +
                    "from (sala natural join locazione) inner join (impiego natural join estetista) on locazione.marca = impiego.marca and locazione.modello = impiego.modello " +
                    "where CodiceSala NOT IN(Select CodiceSala from appuntamento " +
                    "where Data = '2020-" + mese + "-" + j + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '2020-" + mese + "-" + j + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora)" +
                    "and locazione.Modello='" + modello + "' and locazione.Marca='" + marca + "'" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

            if (!result.next() && i < giorni.size())
                giorni.remove(i);
            else
                return giorni.get(i);
        }


        con.close();

        return "NESSUNA DATA DISPONIBILE ";
    }

    public ArrayList<String> numeroAppuntamentiPerTipo(String anno) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Tipo,count(*) from appuntamento where data like '" + anno + "%' group by tipo;");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2));

        con.close();

        if (resultString.size() == 0)
            resultString.add("NESSUN APPUNTAMENO EFFETTUATO NEL " + anno);

        return resultString;
    }

    public ArrayList<String> oreUtilizzoPerSala() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceSala ,sec_to_time(SUM(time_to_sec(durata))) from appuntamento group by CodiceSala");

        ArrayList resultString = new ArrayList<String>();

        while (rs.next())
            resultString.add(rs.getString(1) + "-" + rs.getString(2));

        con.close();

        return resultString;
    }

    public String estetistaOreMaxMacchinari() throws SQLException, ClassNotFoundException {

        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select CodiceFiscale,Nome,Cognome,OreTotali from estetista where OreTotali = (select max(OreTotali) from estetista)");

        rs.next();
        String resultString = rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4);

        con.close();

        return resultString;
    }

    public boolean verificaDataOra(String data, String orario, String durata) throws SQLException, ClassNotFoundException {

        LocalTime t1 = LocalTime.parse(orario);
        LocalTime t2 = LocalTime.parse(durata);

        //somma+durata
        LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


        Connection con = getConnection();
        Statement query = con.createStatement();


        ResultSet result = query.executeQuery("select CodiceSala " +
                "from sala " +
                "where CodiceSala NOT IN (select CodiceSala from appuntamento where Data = '" + data +
                "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > " +
                "'" + orario + "' and '" + totale + "' > ora )");

        if (!result.next()) {
            con.close();
            return false;
        } else {

            result = query.executeQuery("select CodiceFiscale " +
                    "from estetista " +
                    "where CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and" +
                    " sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                    "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");

            if (result.next()) {
                con.close();
                return true;
            }

        }


        con.close();

        return false;
    }

    public boolean verificaDataOraMacchinario(String data, String orario, String durata, String modello, String marca) throws SQLException, ClassNotFoundException {

        LocalTime t1 = LocalTime.parse(orario);
        LocalTime t2 = LocalTime.parse(durata);

        //somma+durata
        LocalTime totale = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


        Connection con = getConnection();
        Statement query = con.createStatement();

        ResultSet result = query.executeQuery("select CodiceSala,CodiceFiscale " +
                "from (sala natural join locazione) inner join (impiego natural join estetista) on locazione.marca = impiego.marca and locazione.modello = impiego.modello " +
                "where CodiceSala NOT IN(Select CodiceSala from appuntamento " +
                "where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora )" +
                "and CodiceFiscale NOT IN (select CodiceFiscale from appuntamento where Data = '" + data + "' and sec_to_time((time_to_sec(Ora)+time_to_sec(Durata))) > '" + orario + "' and '" + totale + "' > ora)" +
                "and locazione.Modello='" + modello + "' and locazione.Marca='" + marca + "'" +
                "and '" + orario + "'>= OrarioInizio and '" + totale + "'<= OrarioFine and dataTerminazione is null");


        if (result.next()) {
            con.close();
            return true;
        }

        con.close();

        return false;
    }

    public ArrayList<String> verificaOrariInUnGiorno(String data, String durata) throws SQLException, ClassNotFoundException {

        LocalTime tempo;
        ArrayList<String> sliceOfTime = new ArrayList<String>();

        for (tempo = LocalTime.parse("09:00:00"); !tempo.toString().equals("20:00"); tempo = tempo.plusMinutes(30))
            if (verificaDataOra(data, tempo.toString(), durata))
                sliceOfTime.add(tempo.toString());


        if (sliceOfTime.size() == 0)
            sliceOfTime.add("NON E' POSSIBILE PRENOTARE IN QUESTA DATA");

        return sliceOfTime;

    }

    public ArrayList<String> verificaOrariInUnGiornoMacchinario(String data, String durata, String modello, String marca) throws SQLException, ClassNotFoundException {

        LocalTime tempo;
        ArrayList<String> sliceOfTime = new ArrayList<String>();

        for (tempo = LocalTime.parse("09:00:00"); !tempo.toString().equals("20:00"); tempo = tempo.plusMinutes(30))
            if (verificaDataOraMacchinario(data, tempo.toString(), durata, modello, marca))
                sliceOfTime.add(tempo.toString());


        if (sliceOfTime.size() == 0)
            sliceOfTime.add("NON E' POSSIBILE PRENOTARE IN QUESTA DATA");

        return sliceOfTime;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String url;
    private String user;
    private String password;
    public static final String NAMEDRIVER = "com.mysql.cj.jdbc.Driver";

}
