package ocp7.advanced;

public class OCPEnumeration {

    interface MyInterface {
    }

    enum Level implements MyInterface {
                                       BEGINNER,
                                       INTERMEDIATE,
                                       EXPERT {

                                           //override toString for EXPERT
                                           public String toString() {
                                               return "superexpert";
                                           }
                                       };

        //method add
        private int skill;

        public int getSkill() {
            return skill;
        }

        public void setSkill(int i) {
            skill = i;
        }

        public static void main(String args[]) {
            System.out.println("enum main");
        }

    }

    public static void main(String args[]) {

        Level levelBeg = Level.BEGINNER;
        levelBeg.setSkill(1);
        System.out.println(levelBeg + " " + levelBeg.getSkill());

        Level levelExp = Level.EXPERT;
        levelExp.setSkill(3);
        System.out.println(levelExp + " " + levelExp.getSkill());

        Level.INTERMEDIATE.setSkill(2);
        System.out.println(Level.INTERMEDIATE + " " + Level.INTERMEDIATE.getSkill());

    }

}
