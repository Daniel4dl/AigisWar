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
    private String Clas2;
    private String Clas3;
    private String Clas4;
    private String Clas5;
    public Unidades(String image, String name, String Class,String id,Boolean favorito,String rare) {
        this.rare=rare;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;
        this.Favorito=favorito;
    }

    public Unidades(String image, String name, String Class,String id,String rare,String clas2) {
        this.rare=rare;
        this.Clas2=clas2;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;

    }
    public Unidades(String image, String name, String Class,String id,String rare,String clas2,String clas3,String clas4) {
        this.rare=rare;
        this.Clas3=clas3;
        this.Clas4=clas4;
        this.Clas2=clas2;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;

    }
    public Unidades(String image, String name, String Class,String id,String rare,String clas2,String clas3,String clas4, String clas5) {
        this.rare=rare;
        this.Clas3=clas3;
        this.Clas4=clas4;
        this.Clas2=clas2;
        this.image = image;
        this.name = name;
        this.Clas = Class;
        this.Id = id;
        this.Clas5=clas5;

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

    public Boolean getFavorito() {
        return Favorito;
    }

    public String getClas2() {
        return Clas2;
    }

    public String getClas3() {
        return Clas3;
    }

    public String getClas4() {
        return Clas4;
    }

    public String getClas5() {
        return Clas5;
    }
}