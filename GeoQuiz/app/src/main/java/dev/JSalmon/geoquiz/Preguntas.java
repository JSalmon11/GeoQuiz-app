package dev.JSalmon.geoquiz;

public class Preguntas {
    private int textResId;
    private boolean respuesta;

    public Preguntas (int textResId, boolean respuesta) {
        textResId = textResId;
        respuesta = respuesta;
    }

    public int getTextResId () {
        return textResId;
    }

    public void setTextResId (int textResId) {
        this.textResId = textResId;
    }

    public boolean isRespuesta () {
        return respuesta;
    }

    public void setRespuesta (boolean respuesta) {
        this.respuesta = respuesta;
    }
}// Preguntas