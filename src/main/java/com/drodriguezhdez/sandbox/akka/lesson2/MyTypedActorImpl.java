package com.drodriguezhdez.sandbox.akka.lesson2;

import java.util.logging.Logger;

import akka.dispatch.Futures;
import scala.concurrent.Future;

public class MyTypedActorImpl implements MyTypedActor{
	
	private final Logger logger;
	
	public MyTypedActorImpl(final Logger logger) {
		this.logger = logger;
	}

	public void greeter(String name) {
		logger.info("Hello "+name+" from a Typed Actor!");
	}

	public Future<Integer> sum(Integer a, Integer b) {
		return Futures.successful(a + b);
	}

	
}
