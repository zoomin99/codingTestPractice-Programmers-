import java.util.ArrayList;
import java.util.Collections;

class Solution {
    class Student implements Comparable<Student> {
        int studentNum;
        int[] answer;
        int correctCount;

        public Student(int studentNum, int[] answer) {
            this.studentNum = studentNum;
            this.answer = answer;
            this.correctCount = 0;
        }

        @Override
        public int compareTo(Student student) {
            return student.correctCount - this.correctCount;
        }
    }

    public int[] solution(int[] answers) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();

        int[][] studentsAnswer = new int[3][answers.length];
        for (int j = 0; j < answers.length; j++) {
            studentsAnswer[0][j] = firstStudent(j);
            studentsAnswer[1][j] = secondStudent(j);
            studentsAnswer[2][j] = thirdStudent(j);
        }

        students.add(new Student(1, studentsAnswer[0]));
        students.add(new Student(2, studentsAnswer[1]));
        students.add(new Student(3, studentsAnswer[2]));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == students.get(i).answer[j]) {
                    students.get(i).correctCount++;
                }
            }
        }
        Collections.sort(students);
        answerList.add(students.get(0).studentNum);

        for (int i = 1; i < 3; i++) {
            if (students.get(i - 1).correctCount == students.get(i).correctCount) {
                answerList.add(students.get(i).studentNum);
            }
            else 
                break;
        }


        int[] answer = answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }


    public int firstStudent(int i) {
        return (i % 5) + 1;
    }

    public int secondStudent(int i) {
        if (i % 2 == 0)
            return 2;
        else {
            switch (i % 8) {
                case 1:
                    return 1;
                case 3:
                    return 3;
                case 5:
                    return 4;
                case 7:
                    return 5;

                default:
                    return 0;
            }
        }
    }

    public int thirdStudent(int i) {
        int index = i;
        if (i % 10 < 2) {
            return 3;
        } else if (i % 10 < 4) {
            return 1;
        } else if (i % 10 < 6) {
            return 2;
        } else if (i % 10 < 8) {
            return 4;
        } else {
            return 5;
        }
    }
}
