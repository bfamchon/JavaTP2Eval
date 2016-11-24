import com.domain.Personne;
import com.persistence.ProxyPersonne;
import com.persistence.uow.UnitOfWork;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Personne p = new ProxyPersonne();
        try {
            System.out.println("Prénom: " + p.getPrenom() + " Nom: " + p.getNom());
            UnitOfWork.getInstance().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
