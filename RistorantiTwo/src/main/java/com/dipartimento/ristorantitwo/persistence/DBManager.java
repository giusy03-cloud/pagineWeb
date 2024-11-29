package com.dipartimento.ristorantitwo.persistence;

import com.dipartimento.ristorantitwo.persistence.dao.PiattoDao;
import com.dipartimento.ristorantitwo.persistence.dao.RistoranteDao;
import com.dipartimento.ristorantitwo.persistence.dao.impljdbc.PiattoDaoJDBC;
import com.dipartimento.ristorantitwo.persistence.dao.impljdbc.RistoranteDaoJDBC;

import java.sql.*;

//la classe DBMAnager è un singleton che gestisce la connessione al databse
//e fornisce l'accesso ai DAO per ristorante e piatto
//il singleton pattern garantisce che esiste una sola istanza di DBManager

public class DBManager {
    private static DBManager instance = null;

    private DBManager(){}
    private RistoranteDao ristoranteDao = null;
    private PiattoDao piattoDao = null;

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    Connection con = null;
    //stabilisco conessione al database PostgreSQL
    public Connection getConnection(){
        if (con == null){
            try {
                // Carica esplicitamente il driver JDBC PostgreSQL
                Class.forName("org.postgresql.Driver");

                // Ora possiamo ottenere la connessione al database
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ristorantitwo", "postgres", "root");
            } catch (ClassNotFoundException e) {
                // Gestisci l'errore se il driver non è trovato
                e.printStackTrace();
            } catch (SQLException e) {
                // Gestisci l'errore di connessione al database
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    //Accesso ai DAO: restituisce un'istanza di ristoranteDAOJDBC
    public RistoranteDao getRistoranteDao(){
        if (ristoranteDao == null) {
            ristoranteDao = new RistoranteDaoJDBC(getConnection());
        }
        return  ristoranteDao;
    }

    //restituisce un'istanza di piattoDAOJDBC
    public PiattoDao getPiattoDao(){
        if (piattoDao == null) {
            piattoDao = new PiattoDaoJDBC(getConnection());
        }
        return  piattoDao;
    }

    //nel main la classe si connete al database ed esegue una query per leggere
    //i dati della tabella utenti
    public static void main(String[] args) {
        Connection con = DBManager.getInstance().getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from utenti");
            if (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
