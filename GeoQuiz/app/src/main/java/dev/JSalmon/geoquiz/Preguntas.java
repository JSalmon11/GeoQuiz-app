package dev.JSalmon.geoquiz;

public class Preguntas {
    private int textResId;
    private boolean respuesta;

    public Preguntas (int TextResId, boolean Respuesta) {
        textResId = TextResId;
        respuesta = Respuesta;
    }

    public int getTextResId () {
        return textResId;
    }

    public void setTextResId (int TextResId) {
        this.textResId = TextResId;
    }

    public boolean isRespuesta () {
        return respuesta;
    }

    public void setRespuesta (boolean Respuesta) {
        respuesta = Respuesta;
    }
}// Preguntas