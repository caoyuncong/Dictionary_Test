package model;

import java.util.List;

/**
 * Created by Administrator on 2017/2/26.
 */
public class Pos {
    private Integer id;
    private String pos;
    private int wordId;

    private Concise concise;
    private List<Detail> details;
    private List<Sentence> sentences;

    public Pos(Integer id, String pos, int wordId, Concise concise, List<Detail> details, List<Sentence> sentences) {
        this.id = id;
        this.pos = pos;
        this.wordId = wordId;
        this.concise = concise;
        this.details = details;
        this.sentences = sentences;
    }

    public Pos(Integer id, String pos, int wordId) {
        this.id = id;
        this.pos = pos;
        this.wordId = wordId;
    }

    public Pos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public Concise getConcise() {
        return concise;
    }

    public void setConcise(Concise concise) {
        this.concise = concise;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "id=" + id +
                ", pos='" + pos + '\'' +
                ", wordId=" + wordId +
                ", concise=" + concise +
                ", details=" + details +
                ", sentences=" + sentences +
                '}';
    }
}
