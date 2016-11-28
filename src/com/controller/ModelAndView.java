package com.controller;

import java.util.HashMap;

import com.constante.*;

import com.vue.Vue;

/**
 * @author laurent
 *
 */
public class ModelAndView {

	private Vue vue;
	private final HashMap<String,Object> request;
	private final HashMap<String,Object> session;

	public ModelAndView() {
		super();
		this.vue = null;
		this.request = new HashMap<String,Object>();
		this.session = new HashMap<String,Object>();
	}

	public Vue getVue() {
		return this.vue;
	}

	public void setVue(final Vue vue) {
		this.vue = vue;
	}

	public HashMap<String, Object> getRequest() {
		return this.request;
	}

	public HashMap<String, Object> getSession() {
		return this.session;
	}

	public void viderSession(){
		this.getSession().clear();
	}

	public void viderRequest(){
		this.getRequest().clear();
	}

	public Object recupRequest(final String key){
		return this.getRequest().get(key);
	}

	public Object recupSession(final String key){
		return this.getSession().get(key);
	}

	public Object addRequest(final String key, final Object value){
		return this.getRequest().put(key, value);
	}

	public Object addSession(final String key, final Object value){
		return this.getSession().put(key, value);
	}

	public Object deleteRequest(final String key){
		return this.getRequest().remove(key);
	}

	public Object deleteSession(final String key){
		return this.getSession().remove(key);
	}

	public String getErreur() {
		return (String) this.recupRequest(Constante.MESSAGE_ERREUR);
	}

	public void addErreur(final String message) {
		this.addRequest(Constante.MESSAGE_ERREUR, message);
	}

}
