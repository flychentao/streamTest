package com.chen.kafka.service;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;

public class Kafkademo01 {

	public static void main(String[] args) {
		Properties props = new Properties();
		StreamsBuilder builder = new StreamsBuilder();
		StreamsConfig config = new StreamsConfig(props);
		Topology topology = builder.build();
		KafkaStreams streams = new KafkaStreams(topology, config);
		streams.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {
			  // here you should examine the throwable/exception and perform an appropriate action!
			});
		streams.start();
		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

	}
}
