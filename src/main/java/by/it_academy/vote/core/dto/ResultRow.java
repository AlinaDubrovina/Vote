package by.it_academy.vote.core.dto;

public class ResultRow<KEY>{
    private KEY item;
    private int count;

    public ResultRow(KEY item, int count) {
        this.item = item;
        this.count = count;
    }

    public ResultRow(KEY item) {
        this.item = item;
    }

    public void inc(){
        count++;
    }

    public void dec(){
        count--;
    }

    public KEY getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
}
