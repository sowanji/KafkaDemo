package com.doit.kafka.KafkaDemo;

import java.util.Properties;

import org.apache.kafka.common.security.JaasUtils;

import kafka.admin.AdminUtils;
import kafka.utils.ZkUtils;

public class TopicTest {

	// 连接ZK
	private static final String ZK_CONNECT = "hd03:2181,hd04:2181,hd05:2181";
	private static final int SESSION_TIMEOUT = 30000;
	private static final int CONNECT_TIMEOUT = 30000;

	@SuppressWarnings("static-access")
	public static void createTopic(String topic, int partition, int repilca, Properties properties) {
		ZkUtils zkutil = null;
		try {
			zkutil = zkutil.apply(ZK_CONNECT, SESSION_TIMEOUT, CONNECT_TIMEOUT, JaasUtils.isZkSecurityEnabled());
			if(!AdminUtils.topicExists(zkutil, topic)) {
				AdminUtils.createTopic(zkutil, topic, partition, repilca, properties,AdminUtils.createTopic$default$6());
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			zkutil.close();
		}

	}

	public static void main(String[] args) {
		TopicTest.createTopic("test", 3, 1, new Properties());

	}

}
