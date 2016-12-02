import java.lang.reflect.InvocationTargetException;

import com.controller.ModelAndView;
import com.vue.jpan.JP_Connexion;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, Throwable {
        final ModelAndView mav = new ModelAndView();
        mav.setVue(new JP_Connexion(mav));
        mav.getVue().start();
    }
}
