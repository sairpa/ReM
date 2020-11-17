package com.ps3.rem.Classes;

public class Wind_C {

    String  pid;
    String  status;
    String uptime;
    String effciency;
    String energyg;
    String energyc;
    String nob;
    String windspeed;
    String airdensity;
    String bladeradi;

    public Wind_C(String pid, String status, String uptime, String effciency, String energyg, String energyc, String nob, String windspeed, String airdensity, String bladeradi) {
        this.pid = pid;
        this.status = status;
        this.uptime = uptime;
        this.effciency = effciency;

        this.energyg = energyg;
        this.energyc = energyc;
        this.nob = nob;
        this.windspeed = windspeed;
        this.airdensity = airdensity;
        this.bladeradi = bladeradi;
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

    public String getEnergyg() {
        return energyg;
    }

    public void setEnergyg(String energyg) {
        this.energyg = energyg;
    }

    public String getEnergyc() {
        return energyc;
    }

    public void setEnergyc(String energyc) {
        this.energyc = energyc;
    }

    public String getNob() {
        return nob;
    }

    public void setNob(String nob) {
        this.nob = nob;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getAirdensity() {
        return airdensity;
    }

    public void setAirdensity(String airdensity) {
        this.airdensity = airdensity;
    }

    public String getBladeradi() {
        return bladeradi;
    }

    public void setBladeradi(String bladeradi) {
        this.bladeradi = bladeradi;
    }
}
