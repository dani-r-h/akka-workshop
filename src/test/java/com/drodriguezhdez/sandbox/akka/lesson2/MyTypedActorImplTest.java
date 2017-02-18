package com.drodriguezhdez.sandbox.akka.lesson2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.Test;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class MyTypedActorImplTest {

	@Test
	public void should_greet() {
		//given
		final Logger logger = mock(Logger.class);
		final MyTypedActorImpl sut = new MyTypedActorImpl(logger);
		
		//when
		sut.greeter("Dani");
		
		//then
		verify(logger).info("Hello Dani from a Typed Actor!");
	}
	
	@Test
	public void should_calculate_sum_numbers() throws Exception {
		//given
		final Logger logger = mock(Logger.class);
		final MyTypedActorImpl sut = new MyTypedActorImpl(logger);
		
		//when
		final Future<Integer> sumFuture = sut.sum(10, 10);
		
		//then
		final Integer sum = Await.result(sumFuture, Duration.create(5, TimeUnit.SECONDS));
		assertThat(sum, is(equalTo(20)));
	}
}
