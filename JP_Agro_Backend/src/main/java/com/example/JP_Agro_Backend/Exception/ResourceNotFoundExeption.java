package com.example.JP_Agro_Backend.Exception;

public class ResourceNotFoundExeption extends RuntimeException{
    public ResourceNotFoundExeption() { super();}

    public ResourceNotFoundExeption(String massage) { super(massage);}
}
