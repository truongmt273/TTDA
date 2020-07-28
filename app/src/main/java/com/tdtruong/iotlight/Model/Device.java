package com.tdtruong.iotlight.Model;

public class Device {
    private String id;
    private float temperature;
    private float humidity;

    private float maxTemp;
    private float minTemp;
    private float maxHumi;
    private float minHumi;
    private String date;

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxHumi() {
        return maxHumi;
    }

    public void setMaxHumi(float maxHumi) {
        this.maxHumi = maxHumi;
    }

    public float getMinHumi() {
        return minHumi;
    }

    public void setMinHumi(float minHumi) {
        this.minHumi = minHumi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Device(float maxTemp, float minTemp, float maxHumi, float minHumi, String date) {
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.maxHumi = maxHumi;
        this.minHumi = minHumi;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public boolean isLimitedTemperature(float temperature){
        return (temperature > 50) || (temperature < 10);
    }

    public boolean isLimitedHumidity(float humidity){
        return (humidity > 85) || (humidity < 20);
    }
}
