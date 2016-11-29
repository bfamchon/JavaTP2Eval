import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.domain.Personne;
import com.domaine.criteria.Criteria;
import com.domaine.criteria.PersonneCriteria;
import com.persistence.proxy.Factory;
import com.persistence.proxy.ListPersonneFactory;
import com.persistence.proxy.VirtualProxyBuilder;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Throwable {
        Factory<List<Personne>> lp = new ListPersonneFactory();
        int iddupere = 0;
        Criteria critere = new PersonneCriteria(iddupere);
        List<Personne> fils = new VirtualProxyBuilder<List<Personne>>(List.class , lp, critere).getProxy();
        for (Personne p : fils) {
            System.out.println(p.getId() + " " + p.getNom() + " " + p.getPrenom() + " " + p.getTel() + " " + p.getEvaluation());
        }
    }
}
