package com.vaflya.politic.quiz;

public class Weight {
    public String label;
    public double value;

    public Weight(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Weight()
    {

    }
}
