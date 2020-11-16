package com.ps3.rem.Classes

class Geo_Class {

    private lateinit var pid: String
    private lateinit var status: String
    private lateinit var uptime:String
    private lateinit var effciency:String
    private lateinit var energyg:String
    private lateinit var energyc:String
    private lateinit var Soiltype:String
    private lateinit var Moisture:String

    fun Geo_Class(
        pid: String,
        status: String,
        uptime: String,
        effciency: String,
        energyg: String,
        energyc: String,
        Soiltype: String,
        Moisture: String
    ) {
        this.pid = pid
        this.status = status
        this.uptime = uptime
        this.effciency = effciency
        this.energyg = energyg
        this.energyc = energyc
        this.Soiltype = Soiltype
        this.Moisture = Moisture
    }
}