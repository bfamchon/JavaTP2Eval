import com.controller.ModelAndView;
import com.domain.Personne;
import com.persistence.proxy.ListPersonneFactory;
import com.persistence.proxy.VirtualProxyBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Throwable{
        ListPersonneFactory lp = new ListPersonneFactory();
        List<Personne> fils = new VirtualProxyBuilder<>(List.class , lp).getProxy();
        System.out.println(fils.get(0).getNom());
    }
}
