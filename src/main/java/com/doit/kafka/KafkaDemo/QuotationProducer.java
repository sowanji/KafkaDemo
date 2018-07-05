package com.doit.kafka.KafkaDemo;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;


public class QuotationProducer {

	private static final Logger LOG = Logger.getLogger(QuotationProducer.class);
	
	//设置实例生产消息的总数
	private static final int MSG_SIZE = 1;
	//主题名称
	private static final String TOPIC = "stock-quotation";
	//kafka集群
	private static final String BROKER_LIST = "hd03:9092,hd04:9092,hd05:9092";
	
	private static KafkaProducer<String,String> producer = null;
	
	static {
		//1.构建用于实例化KafkaProducer的Properties信息
		Properties configs = initConfig();
		//2.初始化一个KafkaProducer
		producer = new KafkaProducer<String,String>(configs);
	}
	
	private static Properties initConfig() {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return properties;
	}
	
	private static StockQuotationInfo createQuotationInfo() {
		StockQuotationInfo quotationInfo = new StockQuotationInfo();
		Random r = new Random();
		Integer stockCode = 600100 + r.nextInt(10);
		float random = (float) Math.random();
		if(random / 2 < 0.5) {
			random = -random;
		}
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		quotationInfo.setCurrentPrice(Float.valueOf(decimalFormat.format(11 + random)));
		quotationInfo.setPreClosePrice(11.80f);
		quotationInfo.setOpenPrice(11.5f);
		quotationInfo.setLowPrice(10.5f);
		quotationInfo.setHighPrice(12.5f);
		quotationInfo.setStockConde(stockCode.toString());
		quotationInfo.setTardeTime(System.currentTimeMillis());
		quotationInfo.setStockName("股票-" + stockCode);
		return quotationInfo;
	}
	
	public static void main(String[] args) {
		ProducerRecord<String,String> record = null;
		StockQuotationInfo qutotationInfo = null;
		ExecutorService executor = Executors.newFixedThreadPool(MSG_SIZE);
		
		try {
//			int num = 0;
			for(int i = 0; i < MSG_SIZE; i++) {
				qutotationInfo = createQuotationInfo();
				record = new ProducerRecord<String,String>(TOPIC,null,qutotationInfo.getTardeTime(),qutotationInfo.getStockConde(),qutotationInfo.toString());
				executor.submit(new KafkaProducerThread(producer,record));
//				executor.execute(new KafkaProducerThread(producer,record));
//				producer.send(record, new Callback() {
//
//					@Override
//					public void onCompletion(RecordMetadata metadata, Exception exception) {
//						if(null != exception) {
//							LOG.error("Send message occurs exception", exception);
//						}
//						if(null != metadata) {
//							LOG.info(String.format("offset:%s,partition:%s", metadata.offset(),metadata.partition()));
//							System.out.println(String.format("offset:%s,partition:%s", metadata.offset(),metadata.partition()));
//						}
//					}
//					
//				});
//				if(num++ % 10 == 0) {
//					Thread.sleep(2000L);
//				}
			}
		} catch (Exception e) {
			LOG.error("Send message occurs exception", e);
		} finally {
			producer.close();
			executor.shutdown();
		}
	}
}
