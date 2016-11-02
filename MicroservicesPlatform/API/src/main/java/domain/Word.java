package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Idorf
 */
public class Word {

	public String word ="test";

	public Word() {
		super();
	}	
	
	public Word(String word) {
		this();
		this.word = word;
	}

	public String getWord() {
		return word;
	}
	
	public String getString() {
		return getWord();
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}