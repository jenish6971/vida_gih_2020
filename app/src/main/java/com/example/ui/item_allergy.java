package com.example.ui;

public class item_allergy {

    String allergy_name;
    String allergy_side_effects;

    public item_allergy() {
    }

    public item_allergy(String allergy_name, String allergy_side_effects) {
        this.allergy_name = allergy_name;
        this.allergy_side_effects = allergy_side_effects;
    }

    public String getAllergy_name() {
        return allergy_name;
    }

    public void setAllergy_name(String allergy_name) {
        this.allergy_name = allergy_name;
    }

    public String getAllergy_side_effects() {
        return allergy_side_effects;
    }

    public void setAllergy_side_effects(String allergy_side_effects) {
        this.allergy_side_effects = allergy_side_effects;
    }


}
