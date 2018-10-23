package com.example.csipro.aigiswar;

import java.io.Serializable;

public class Estadisticas implements Serializable{
    private String Img;
    private String Inicial;
    private String Hp;
    private String Atk;
    private String Def;
    private String Block;
    private String Range;
    private String Max;
    private String Min;
    private String Bonus;

    public Estadisticas(String img,String inicial,String hp,String atk,String def,String block,String range,String max,String min,String bonus){
        this.Atk=atk;
        this.Block=block;
        this.Bonus=bonus;
        this.Def=def;
        this.Hp=atk;
        this.Img=img;
        this.Inicial=inicial;
        this.Max=max;
        this.Min=min;
        this.Range=range;
    }

    public String getImg() {
        return Img;
    }

    public String getInicial() {
        return Inicial;
    }

    public String getHp() {
        return Hp;
    }

    public String getAtk() {
        return Atk;
    }

    public String getDef() {
        return Def;
    }

    public String getBlock() {
        return Block;
    }

    public String getRange() {
        return Range;
    }

    public String getMax() {
        return Max;
    }

    public String getMin() {
        return Min;
    }

    public String getBonus() {
        return Bonus;
    }
}
