package main.java.week_8.pratice_problem;
import java.util.*;

class ExamQuestion {

    String type;
    String question;
    String correctAnswer;
    String studentAnswer;
    double points;

    ExamQuestion(String type, String question,
                 String correctAnswer,
                 String studentAnswer,
                 double points) {

        this.type = type;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    double calculateScore() {

        if (type.equals("MCQ") || type.equals("TF")) {

            if (correctAnswer.equalsIgnoreCase(studentAnswer)) {
                return points;
            }

            return 0;
        }

        if (type.equals("ESSAY")) {

            String[] keywords = correctAnswer.split(",");

            int count = 0;

            for (String keyword : keywords) {

                if (studentAnswer.toLowerCase()
                        .contains(keyword.trim().toLowerCase())) {

                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }

        return 0;
    }
}

public class ExamGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> values = new ArrayList<>();

            boolean insideQuotes = false;

            StringBuilder current = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {

                char ch = line.charAt(j);

                if (ch == '"') {

                    if (insideQuotes) {
                        values.add(current.toString());
                        current.setLength(0);
                    }

                    insideQuotes = !insideQuotes;

                } else if (insideQuotes) {

                    current.append(ch);
                }
            }

            String[] firstPart = line.split(" ");

            String type = firstPart[0];

            double points =
                    Double.parseDouble(firstPart[firstPart.length - 1]);

            String question = values.get(0);
            String correctAnswer = values.get(1);
            String studentAnswer = values.get(2);

            ExamQuestion exam = new ExamQuestion(
                    type,
                    question,
                    correctAnswer,
                    studentAnswer,
                    points
            );

            System.out.printf("%.2f%n", exam.calculateScore());
        }

        sc.close();
    }
}
