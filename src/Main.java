import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.controller.ModelAndView;
import com.domain.Personne;
import com.domain.criteria.Criteria;
import com.domain.criteria.PersonneCriteria;
import com.persistence.proxy.Factory;
import com.persistence.proxy.ListPersonneFactory;
import com.persistence.proxy.VirtualProxyBuilder;
import com.vue.Fenetre;
import com.vue.jpan.JP_Connexion;
import com.vue.jpan.JPanelPerso;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Throwable {
//        Factory<List<Personne>> lp = new ListPersonneFactory();
//        int iddupere = 0;
//        Criteria critere = new PersonneCriteria(iddupere);
//        List<Personne> fils = new VirtualProxyBuilder<List<Personne>>(List.class , lp, critere).getProxy();
//        for (Personne p : fils) {
//            System.out.println(p.getId() + " " + p.getNom() + " " + p.getPrenom() + " " + p.getTel() + " " + p.getEvaluation());
//        }
        final ModelAndView mav = new ModelAndView();
        mav.setVue(new JP_Connexion(mav));
        mav.getVue().start();
    }
}
