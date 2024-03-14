
package MytaskManager.Components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Riddle {
     private String question;
    private String answer;

    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public static Riddle getRiddle() {
        List<Riddle> riddles = Riddle.getRiddles();
        Random random = new Random();
        int randomIndex = random.nextInt(riddles.size());
        return riddles.get(randomIndex);
    }
    
    public static List<Riddle> getRiddles() {
        List<Riddle> riddles = new ArrayList<>();
        riddles.add(new Riddle("What has keys but can't open locks?", "piano"));
        riddles.add(new Riddle("What has to be broken before you can use it?", "egg"));
        riddles.add(new Riddle("What gets wetter the more it dries?", "towel"));
        riddles.add(new Riddle("David's father has three sons: Snap, Crackle, and _____", "David"));
        riddles.add(new Riddle("What is more useful when it is broken?","egg"));
        riddles.add(new Riddle("I am easy to lift, but hard to throw. What am I?", "feather"));
        riddles.add(new Riddle("Which fish costs the most?","goldfish"));
        riddles.add(new Riddle("What goes up, but never comes down?", "age"));
        riddles.add(new Riddle("What has a neck but no head?","bottle"));
        riddles.add(new Riddle("How do you spell COW in thirteen letters?","SEE O DOUBLE YOU."));
        riddles.add(new Riddle("I add 5 to 9 and get 2. The answer is correct, so what am I?","clock"));
        riddles.add(new Riddle("What is 3/7 chicken, 2/3 cat, and 2/4 goat?","chicago"));
        riddles.add(new Riddle("If you multiply this number by any other number, the answer will always be the same. What number is this?","zero"));
        riddles.add(new Riddle("I am an odd number. Take away a letter and I become even. What number am I?","seven"));
        riddles.add(new Riddle("Who has married many women but was never married?","priest"));
        riddles.add(new Riddle("Paul's height is six feet, he's an assistant at a butcher's shop, and wears size 9 shoes. What does he weigh?","meat"));
        riddles.add(new Riddle("What kind of tree can you carry in your hand?","palm"));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));
        riddles.add(new Riddle("",""));

        return riddles;
    }
}
