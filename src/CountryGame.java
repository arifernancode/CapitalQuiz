public class CountryGame {
    public static final double totalQuestions = 10;
    public static double questionsCorrect = 0;
    public static double finalScore = 0;

    public CountryGame() {
        askQuestion("Bulgaria", "Sofia", new String[]{"Sofia", "Amsterdam", "Berlin"});
        askQuestion("Belgium", "Brussels", new String[]{"Washington", "Buenos Aires", "Brussels"});
        askQuestion("Canada", "Ottawa", new String[]{"Santiago", "New Mexico", "Ottawa"});
        askQuestion("Thailand", "Bangkok", new String[]{"UlaanBaatar", "Beijing", "Bangkok"});
        askQuestion("Peru", "Lima", new String[]{"Caracas", "Buenos Aires", "Lima"});

        askQuestion("India", "New Delhi", new String[]{"New Delhi", "Mumbai", "Kolkata"});
        askQuestion("Russia", "Moscow", new String[]{"Moscow", "St. Petersburg", "Novosibirsk"});
        askQuestion("South Africa", "Pretoria", new String[]{"Pretoria", "Cape Town", "Johannesburg"});
        askQuestion("South Korea", "Seoul", new String[]{"Seoul", "Busan", "Incheon"});
        askQuestion("Italy", "Rome", new String[]{"Rome", "Milan", "Naples"});

        finalScore = Math.round((questionsCorrect / totalQuestions) * 100.0);
        System.out.println(finalScore + "%");

        new EndScreen().setVisible(true);

    }

    private void askQuestion(String country, String capital, String[] options) {
        QuestionScreen questionScreen = new QuestionScreen(country, capital, options);
        questionScreen.setVisible(true);

        while (!questionScreen.isDisposable) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}