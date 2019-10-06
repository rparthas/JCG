package com.jcg.jsonParser;

public class Language {
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Language{" +
                "lang='" + lang + '\'' +
                ", knowledge='" + knowledge + '\'' +
                '}';
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    private String lang;
    private String knowledge;
}
