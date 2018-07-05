package com.doit.kafka.KafkaDemo;

import java.io.Serializable;

public class StockQuotationInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String stockConde;
	private String stockName;
	private long tardeTime;
	private float preClosePrice;
	private float openPrice;
	private float currentPrice;
	private float highPrice;
	private float lowPrice;
	public String getStockConde() {
		return stockConde;
	}
	public void setStockConde(String stockConde) {
		this.stockConde = stockConde;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public long getTardeTime() {
		return tardeTime;
	}
	public void setTardeTime(long tardeTime) {
		this.tardeTime = tardeTime;
	}
	public float getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(float preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public float getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	public float getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(float highPrice) {
		this.highPrice = highPrice;
	}
	public float getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(float lowPrice) {
		this.lowPrice = lowPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "StockQuotationInfo [stockConde=" + stockConde + ", stockName=" + stockName + ", tardeTime=" + tardeTime
				+ ", preClosePrice=" + preClosePrice + ", openPrice=" + openPrice + ", currentPrice=" + currentPrice
				+ ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + "]";
	}
	
}
