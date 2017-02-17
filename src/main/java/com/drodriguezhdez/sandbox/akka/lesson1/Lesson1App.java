package com.drodriguezhdez.sandbox.akka.lesson1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Lesson1App {

	public static void main(String[] args) {
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		
		final ActorRef myActorRef = actorSystem.actorOf(Props.create(MyActor.class));
		myActorRef.tell("Dani", ActorRef.noSender());
		
	}
}
