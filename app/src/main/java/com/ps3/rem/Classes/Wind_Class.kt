package com.ps3.rem.Classes

class Wind_Class {

    private lateinit var pid: String
    private lateinit var status: String
    private lateinit var uptime:String
    private lateinit var effciency:String
    private lateinit var energyg:String
    private lateinit var energyc:String
    private lateinit var bladerad:String
    private lateinit var airdensity:String
    private lateinit var windspeed:String
    private lateinit var nob:String

    fun Wind_Class(
        pid: String,
        status: String,
        uptime: String,
        effciency: String,
        energyg: String,
        energyc: String,
        bladerad: String,
        airdensity: String,
        windspeed: String,
        nob: String
    ) {
        this.pid = pid
        this.status = status
        this.uptime = uptime
        this.effciency = effciency
        this.energyg = energyg
        this.energyc = energyc
        this.bladerad = bladerad
        this.airdensity = airdensity
        this.windspeed = windspeed
        this.nob = nob
    }
}