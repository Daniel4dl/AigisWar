package com.example.csipro.aigiswar;

import java.io.Serializable;

public class Unidades implements Serializable {
    private String image;
    private String name;
    private String Clas;
    private String rare;
    private String Id;
    private String Perfil;
    private  Boolean Favorito;
    public Unidades(String image, String name, String Class,String id,Boolean favorito,String rare) {
        this.rare=rare;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;
        this.Favorito=favorito;
    }
    public Unidades(String image, String name, String Class,String id,String rare) {
        this.rare=rare;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;

    }

     public Unidades(String image, String name, String price) {
        this.image = image;
        this.name = name;
        this.Clas = price;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return Clas;
    }

    public void setPrice(String price) {
        this.Clas = price;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getPerfil() {
        return Perfil;
    }

    public int getId() {
        return Integer.parseInt(Id);
    }
    public boolean getFav(){
        return Favorito;
    }
}