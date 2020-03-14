package com.example.quiz;

public class Question {

    private String question;
    private String answer;
    private String userAnswer;
    private boolean judgement;
    private boolean played;

    public Question() {
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.played = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
        judge();
    }

    public void judge(){
        if(userAnswer != null)
            if(userAnswer.equals(answer)){
                judgement = true;
                return;
            }

        judgement = false;
    }

    public boolean isJudgement() {
        return judgement;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setJudgement(boolean judgement) {
        this.judgement = judgement;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }
}
