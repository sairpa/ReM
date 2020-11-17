package com.ps3.rem.Classes;

public class Geo_C {

    String pid;
    String status;
    String uptime;
    String effciency;
    String soiltype;
    String energyg;
    String energyc;
    String moisture;

    public Geo_C(String pid, String status, String uptime, String effciency, String soiltype, String energyg, String energyc, String moisture) {
        this.pid = pid;
        this.status = status;
        this.uptime = uptime;
        this.effciency = effciency;
        this.soiltype = soiltype;
        this.energyg = energyg;
        this.energyc = energyc;
        this.moisture = moisture;
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

    public String getSoiltype() {
        return soiltype;
    }

    public void setSoiltype(String soiltype) {
        this.soiltype = soiltype;
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

    public String getMoisture() {
        return moisture;
    }

    public void setMoisture(String moisture) {
        this.moisture = moisture;
    }
}