package model;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Sentence {
    private Integer id;
    private String english;
    private String chinese;
    private int posId;

    public Sentence(Integer id, String english, String chinese, int posId) {
        this.id = id;
        this.english = english;
        this.chinese = chinese;
        this.posId = posId;
    }

    public Sentence() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + id +
                ", english='" + english + '\'' +
                ", chinese='" + chinese + '\'' +
                ", posId=" + posId +
                '}';
    }
}
