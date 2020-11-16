package com.ps3.rem.Classes

class Solar_Class {

    private lateinit var pid: String
    private lateinit var status: String
    private lateinit var uptime:String
    private lateinit var effciency:String
    private lateinit var hbu:String
    private lateinit var energyg:String
    private lateinit var energyc:String
    private lateinit var nop:String
    private lateinit var Cloudcover:String
    private lateinit var soiling:String
    private lateinit var SunInt:String

    fun Solar_Class(
        pid: String,
        status: String,
        uptime: String,
        effciency: String,
        hbu: String,
        energyg: String,
        energyc: String,
        nop: String,
        Cloudcover: String,
        soiling: String,
        SunInt: String
    ) {
        this.pid = pid
        this.status = status
        this.uptime = uptime
        this.effciency = effciency
        this.hbu = hbu
        this.energyg = energyg
        this.energyc = energyc
        this.nop = nop
        this.Cloudcover = Cloudcover
        this.soiling = soiling
        this.SunInt = SunInt
    }




}