package ocp7.advanced;

public enum OCPEnumeration3 {
                             ESPRESSO("Very Strong"),
                             MOCHA,
                             LATTE;
    public String strength;

    OCPEnumeration3(String strength) {
        this.strength = strength;
    }

    OCPEnumeration3() {
    }
}
