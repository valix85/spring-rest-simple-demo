package it.nextre.academy.restdemo.exception;

public class MovieException extends RuntimeException {
    public MovieException(){
        this("Errore oggetto Movie");
    }
    public MovieException(String mex){
        super(mex);
    }
}//end class
