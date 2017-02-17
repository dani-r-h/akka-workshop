package com.drodriguezhdez.sandbox.akka.lesson1;
import static org.mockito.Mockito.mock;

import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

public class MyActorTestIT {
	
	private static ActorSystem system;
	private final Logger logger = mock(Logger.class);
	
	@BeforeClass
	public static void staticSetup() {
		system = ActorSystem.create("testActorSystem");
	}
	
	@AfterClass
	public static void staticFinish(){
		JavaTestKit.shutdownActorSystem(system);
		system = null;
	}

	@Test
	public void should_greet_with_our_name() {
		
		new JavaTestKit(system){{
			//given
			final ActorRef sut = system.actorOf(Props.create(MyActor.class, logger));
			
			//when
			sut.tell("Dani", ActorRef.noSender());
			
			//then
			expectNoMsg();
		}};
	}
}
