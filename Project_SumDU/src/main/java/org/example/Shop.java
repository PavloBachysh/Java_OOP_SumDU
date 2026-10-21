package org.example;

/**
 * Enum для визначення магазину
 */
public enum Shop {

    KNIGOLUB("Книголюб"), KNIGARNYAE("Книгарня.Є"), LIBRARIUM("Лібраріум"), COMICSMANIA("Comics Mania");

    private String name;

    Shop(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
