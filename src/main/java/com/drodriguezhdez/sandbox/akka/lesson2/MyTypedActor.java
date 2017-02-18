package com.drodriguezhdez.sandbox.akka.lesson2;

import scala.concurrent.Future;

public interface MyTypedActor {

	void greeter(final String name);

	Future<Integer> sum(final Integer a, final Integer b);
}
