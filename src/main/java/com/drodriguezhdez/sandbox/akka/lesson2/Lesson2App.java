package com.drodriguezhdez.sandbox.akka.lesson2;

import java.util.logging.Logger;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.dispatch.OnComplete;
import akka.dispatch.OnSuccess;
import akka.japi.Creator;
import scala.concurrent.Future;

public class Lesson2App {
	
	private static final Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		
		final ActorSystem actorSystem = ActorSystem.create("actorSystem");
		
		final Creator<MyTypedActorImpl> creator = new Creator<MyTypedActorImpl>(){
			public MyTypedActorImpl create() throws Exception {
				return new MyTypedActorImpl(logger);
			}
		};
		
		final TypedProps<MyTypedActorImpl> props = new TypedProps<MyTypedActorImpl>(MyTypedActor.class, creator);
		final MyTypedActor myTypedActor = TypedActor.get(actorSystem).typedActorOf(props);
		
		myTypedActor.greeter("Dani");
		final Future<Integer> sumOne = myTypedActor.sum(10, 10);
		final Future<Integer> sumTwo = myTypedActor.sum(1000, 1000);
		final Future<Integer> sumThree = myTypedActor.sum(10000, 10000);
		final Future<Integer> sumFour = myTypedActor.sum(100000, 100000);
		
		final OnComplete onComplete = new OnComplete<Integer>() {
			@Override
			public void onComplete(Throwable error, Integer sum) throws Throwable {
				logger.info(Integer.toString(sum));
			}
		};
				
		sumOne.onComplete(onComplete, actorSystem.dispatcher());
		sumTwo.onComplete(onComplete, actorSystem.dispatcher());
		sumThree.onComplete(onComplete, actorSystem.dispatcher());
		sumFour.onComplete(onComplete, actorSystem.dispatcher());
		
		logger.info("**************** Ends!");
		
	}
}
