package com.drodriguezhdez.sandbox.akka.lesson1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.Test;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;

public class MyActorTest {

	@Test
	public void should_greet_with_our_name() {
		//given
		final Logger logger = mock(Logger.class);
		final ActorSystem testActorSystem = ActorSystem.create("testActorSystem");
		final TestActorRef<MyActor> sutRef = TestActorRef.create(testActorSystem, Props.create(MyActor.class, logger));
		final MyActor sut = sutRef.underlyingActor();
		
		//when
		sut.greet("Dani");
		
		//then
		verify(logger).info("Hello Dani!");
		
	}
}
