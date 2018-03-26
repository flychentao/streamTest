package com.chen.kafka.service;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class KafkaStreamService implements Processor<String, String>{

	private ProcessorContext processorContext;
	private KeyValueStore<String, Integer> keyValueStore;
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ProcessorContext processorContext) {
		this.processorContext = processorContext;
		processorContext.schedule(1000);
		keyValueStore = (KeyValueStore<String, Integer>) processorContext.getStateStore("counts");
	}

	@Override
	public void process(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void punctuate(long arg0) {
		// TODO Auto-generated method stub
		
	}

}
