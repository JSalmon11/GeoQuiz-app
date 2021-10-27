package dev.JSalmon.geoquiz;

public class Preguntas {
    private int mtextResId;
    private boolean mAnswerTrue;

    public Preguntas (int TextResId, boolean Respuesta) {
        mtextResId = TextResId;
        mAnswerTrue = Respuesta;
    }

    public int getTextResId () {
        return mtextResId;
    }

    public void setTextResId (int TextResId) {
        this.mtextResId = TextResId;
    }

    public boolean isAnswerTrue () {
        return mAnswerTrue;
    }

    public void setAnswerTrue (boolean Respuesta) {
        mAnswerTrue = Respuesta;
    }
}// Preguntas