package com.ps3.rem.Classes;

public class Solar_C {

    String  pid;
    String  status;
    String uptime;
    String effciency;
    String hbu;
    String energyg;
    String energyc;
    String nop;
    String cloudcover;
    String soiling;
    String sunint;
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    String temperature;

    public Solar_C(String pid, String status, String uptime, String effciency, String hbu, String energyg, String getEnergyc, String nop, String cloudcover, String soiling, String sunint, String temperature) {
        this.pid = pid;
        this.status = status;
        this.uptime = uptime;
        this.effciency = effciency;
        this.temperature = temperature;
        this.hbu = hbu;
        this.energyg = energyg;
        this.energyc = getEnergyc;
        this.nop = nop;
        this.cloudcover = cloudcover;
        this.soiling = soiling;
        this.sunint = sunint;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getEffciency() {
        return effciency;
    }

    public void setEffciency(String effciency) {
        this.effciency = effciency;
    }

    public String getHbu() {
        return hbu;
    }

    public void setHbu(String hbu) {
        this.hbu = hbu;
    }

    public String getEnergyg() {
        return energyg;
    }

    public void setEnergyg(String energyg) {
        this.energyg = energyg;
    }

    public String getGetEnergyc() {
        return energyc;
    }

    public void setGetEnergyc(String getEnergyc) {
        this.energyc = getEnergyc;
    }

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getSoiling() {
        return soiling;
    }

    public void setSoiling(String soiling) {
        this.soiling = soiling;
    }

    public String getSunint() {
        return sunint;
    }

    public void setSunint(String sunint) {
        this.sunint = sunint;
    }
}
