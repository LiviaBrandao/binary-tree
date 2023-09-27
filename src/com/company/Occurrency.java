package com.company;

class Occurrency implements Comparable<Occurrency> {

    private char character;
    private int howMany;


    public Occurrency(char character, int howMany) {
        this.character = character;
        this.howMany = howMany;
    }


    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }


    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public String toString() {
        return "Occurrency of " + character + "{" +
                howMany +
                "}";
    }

    @Override
    public int compareTo(Occurrency oAux) {
        if(this.character ==  oAux.character && this.character != '\0')
            return 0;
        if(this.howMany > oAux.howMany)
            return 1;

        return -1;
    }
}
