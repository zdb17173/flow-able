package org.fran.demo.drools;

/**
 * @author qiushi
 * @date 2023/3/13
 */
public class FactOrder {
    private int amount;//金额
    private int score;//积分

    public FactOrder(){}

    public FactOrder(int amount, int score) {
        this.amount = amount;
        this.score = score;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "FactOrder{" +
                "amount=" + amount +
                ", score=" + score +
                '}';
    }
}
