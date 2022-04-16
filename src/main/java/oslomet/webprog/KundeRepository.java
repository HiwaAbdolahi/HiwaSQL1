package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository         //repo klassen. du sier til spring at denne klassen brukes som repo
public class KundeRepository {

    @Autowired  //også JDBS Tamplate (en sånn Auto wired sak)
    private JdbcTemplate db;   // add spring starter jdbc til class pad

    //nå skal vi ha metodene en for lagre ny kunde, en for å hente alle kunde, en for slette kunde en for
    // så må implementere de :

    public void lagreKunde (Kunde kunde){
        String sql = "INSERT INTO Kunde (navn,adresse) VALUES(?,?)";
        db.update(sql, kunde.getNavn(),kunde.getAdresse());
    }

    //en metode for alle kundrene som leger inn i tabellen

    public List<Kunde> hentAlleKunder(){
        String sql = "SELECT * FROM Kunde";
        List<Kunde> alleKunder = db.query(sql, new BeanPropertyRowMapper<>(Kunde.class));
        return alleKunder;
    }

    //nå mulighet til å slette alle

    public void slettAlleKunder () {
        String sql = "DELETE FROM Kunde";
        db.update(sql);
    }

}
