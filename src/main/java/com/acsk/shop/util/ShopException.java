package com.acsk.shop.util;

public class ShopException extends Exception{

    public ShopException(){
        super();
    }

    public ShopException(String msg) {
        super(msg);
    }

    public ShopException(Throwable throwable) {
        super(throwable);
    }

    public ShopException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
