package com.drodriguezhdez.sandbox.akka.lesson1;

import java.util.logging.Logger;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Lesson1App {
	
	private static final Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		
		final ActorRef myActorRef = actorSystem.actorOf(Props.create(MyActor.class, logger));
		myActorRef.tell("Dani", ActorRef.noSender());
		
	}
}
