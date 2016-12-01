package com.metier;

import java.sql.SQLException;

import com.exception.UtilisateurInconnuException;
import com.persistence.uow.UnitOfWork;

public class SMValiderModification {

    public void process() throws SQLException{
    	
    	UnitOfWork.getInstance().commit();
    }
}
