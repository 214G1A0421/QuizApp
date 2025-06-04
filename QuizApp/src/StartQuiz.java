import java.util.*;

class Question {
    String question;
    String[] options;
    String correctOption;
    
    public Question(String question, String[] options, String correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
    
    public void display() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
    
    public boolean checkAnswer(int answer) {
        return options[answer - 1].equals(correctOption);
    }
}

public class StartQuiz {
    Player player;
    List<Question> questions;
    int currentQuestionIndex;
    Scanner scanner;
    
    public StartQuiz(Player player, List<Question> questions) {
        this.player = player;
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        System.out.println("Welcome " + player.name + " to the Quiz Game!");
        System.out.println("Rules: Answer questions correctly to win money. You have 2 lifelines.");
        
        while (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            question.display();
            
            System.out.print("Do you want to use a lifeline? (yes/no): ");
            String useLifeline = scanner.next().toLowerCase();
            
            if (useLifeline.equals("yes")) {
                System.out.print("Choose lifeline (50-50/Skip): ");
                String chosenLifeline = scanner.next();
                if (player.useLifeline(chosenLifeline)) {
                    System.out.println("Lifeline " + chosenLifeline + " used!");
                    if (chosenLifeline.equals("50-50")) {
                        String correct = question.correctOption;
                        List<String> optionsList = new ArrayList<>(Arrays.asList(question.options));
                        
                        // Remove correct answer temporarily to pick one wrong answer
                        optionsList.remove(correct);
                        
                        // Randomly select one incorrect answer
                        Random rand = new Random();
                        String randomWrong = optionsList.get(rand.nextInt(optionsList.size()));
                        
                        // Show correct and one incorrect option
                        List<String> reducedOptions = Arrays.asList(correct, randomWrong);
                        Collections.shuffle(reducedOptions);  // Shuffle to randomize position
                        
                        System.out.println("Updated Options:");
                        for (int i = 0; i < reducedOptions.size(); i++) {
                            System.out.println((i + 1) + ". " + reducedOptions.get(i));
                        }

                        // NOTE: You may need to map these reduced options back for answer checking
                    }
 else if (chosenLifeline.equals("Skip")) {
                        System.out.println("Question skipped!");
                        currentQuestionIndex++;
                        continue;
                    }
                } else {
                    System.out.println("Lifeline not available. Proceeding without lifeline.");
                }
            }
            
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();
            if (question.checkAnswer(answer)) {
                System.out.println("Correct answer!");
                player.winnings += 1000;
                currentQuestionIndex++;
            } else {
                System.out.println("Wrong answer! Game over.");
                break;
            }
        }
        
        System.out.println("Game over! " + player.name + " won Rs." + player.winnings);
    }
}
