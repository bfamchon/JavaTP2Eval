import com.domain.Personne;
import com.persistence.ProxyPersonne;
import com.persistence.uow.UnitOfWork;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Personne p = new ProxyPersonne();
        try {
            System.out.println("Id: " + p.getId() + " Prénom: " + p.getPrenom() + " Nom: " + p.getNom());
            if (p.getPere() != null) {
                System.out.println("Père: " + p.getPere().getId() + " " + p.getPere().getPrenom() + " " +p.getPere().getNom());
            }
            System.out.println("Évaluation: " + p.getEvaluation());
            if (p.getFils() != null) {
                for (Personne fils : p.getFils()) {
                    System.out.println("Fils: " + fils.getId() + " " + fils.getPrenom() + " " + fils.getNom());
                }
            }
//            UnitOfWork.getInstance().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
