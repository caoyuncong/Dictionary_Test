package model;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Concise {
    private Integer id;
    private String chinese;
    private int posId;

    public Concise(Integer id, String chinese, int posId) {
        this.id = id;
        this.chinese = chinese;
        this.posId = posId;
    }

    public Concise() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Concise{" +
                "id=" + id +
                ", chinese='" + chinese + '\'' +
                ", posId=" + posId +
                '}';
    }
}
