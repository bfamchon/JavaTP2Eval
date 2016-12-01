package com.controller;

import java.sql.SQLException;

import com.metier.SMValiderModification;

public class ValiderControler {


    public static ModelAndView doPost(ModelAndView mav) {
        mav.viderRequest();
        SMValiderModification smvm = new SMValiderModification();
        try {
			smvm.process();
		} catch (SQLException e) {
            mav.addErreur("Problème accès BDD");
		}
        return mav;
    }
}
