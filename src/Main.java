import com.domain.Personne;
import com.persistence.proxy.ListPersonneFactory;
import com.persistence.proxy.PersonneFactory;
import com.persistence.proxy.VirtualProxyBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Throwable{
//        Personne p = new ProxyPersonne();
//        Personne p2 = new ProxyPersonne();
        PersonneFactory pf = new PersonneFactory();
        Personne p = new VirtualProxyBuilder<Personne>(Personne.class , pf).getProxy();
        ListPersonneFactory lp = new ListPersonneFactory();
        List<Personne> amis = new VirtualProxyBuilder<List<Personne>>(List.class , lp).getProxy();
        System.out.println(amis.get(0).getNom());
        /*
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
            // Je change le prenom de p
            p.setPrenom("Georgette");
            // En changeant p2, je change p
//            if ( p2.getId() != null)
//                p2.setPrenom("Jey");

            UnitOfWork.getInstance().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }
}
