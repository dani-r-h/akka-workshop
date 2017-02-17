package com.drodriguezhdez.sandbox.akka.lesson1;

import java.util.logging.Logger;

import akka.actor.UntypedActor;

public class MyActor extends UntypedActor{
	
	private final Logger logger;
	
	public MyActor(final Logger logger) {
		this.logger = logger;
	}

	@Override
	public void onReceive(Object nameObj) throws Throwable {
		greet((String) nameObj);
	}
	
	public void greet(final String name) {
		logger.info("Hello "+name+"!");
	}

}
