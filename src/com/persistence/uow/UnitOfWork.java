package com.persistence.uow;

import com.domain.Personne;
import com.persistence.mapper.PersonneMapper;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by baptiste on 20/11/16.
 * Hi
 * But: memoriser la liste des objets ayant besoin d'un update en BD
 */
public class UnitOfWork implements Observateur {
    // Set c'est comme une liste, sauf que si l'objet existe déjà dedans, ça n'y ajoute pas !
    // Donc c'est cool !
    Set<IDomainObject> dirty;
    static UnitOfWork inst = null;
    public UnitOfWork() {
        dirty = new HashSet<IDomainObject>();
    }
    public static UnitOfWork getInstance() {
        if (inst == null)
            inst = new UnitOfWork();
        return inst;
    }

    /**
     * But: enregister l'objet dans la liste des objets modifies
     * @param o
     */
    public void action(IDomainObject o) {
        System.out.println("UOW.action(): Enregistrer l'objet dans la liste des objets modifiés");
        dirty.add(o);
    }
    public void commit() throws SQLException {
        Visiteur v = new Committer();
        for (IDomainObject o : dirty) {
            v.visiter(o);
            System.out.println("COMMIT");
        }
        dirty.clear();
        System.out.println("UOW.commit(): On a effectué le commit & vidé la liste des objets modifiés");
    }
}
