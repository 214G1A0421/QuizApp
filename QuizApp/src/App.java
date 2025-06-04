import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        
        List<Question> questions = Arrays.asList(
            new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "Paris"),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, "Mars"),
            new Question("Who wrote 'Hamlet' ?", new String[]{"Shakespeare", "Hemingway", "Tolstoy", "Dickens"}, "Shakespeare"),
            new Question("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Pacific", "Arctic"}, "Pacific"),
            new Question("What is the chemical symbol for Gold?", new String[]{"Au", "Ag", "Pb", "Fe"}, "Au"),
            new Question("Which country has the most population?", new String[]{"USA", "India", "China", "Brazil"}, "China"),
            new Question("Who discovered gravity?", new String[]{"Newton", "Einstein", "Galileo", "Tesla"}, "Newton"),
            new Question("Which is the tallest mountain in the world?", new String[]{"K2", "Everest", "Kilimanjaro", "Denali"}, "Everest"),
            new Question("Which element is essential for breathing?", new String[]{"Hydrogen", "Oxygen", "Nitrogen", "Carbon"}, "Oxygen"),
            new Question("What is the speed of light?", new String[]{"300,000 km/s", "150,000 km/s", "500,000 km/s", "1,000,000 km/s"}, "300,000 km/s")
        );
        
        StartQuiz game = new StartQuiz(player, questions);
        game.start();
        scanner.close();
    }
}
