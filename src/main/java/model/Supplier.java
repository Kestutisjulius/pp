package model;

public enum Supplier {
    MAXIMA(10, "first"),
    IKI(7, "third"),
    NORFA(8, "second"),
    RIMI(6, "fourth"),
    AIBE(5,"no priority");

    private int commissionInPercent;
    private String priority;

    Supplier(int commissionInPercent, String priority) {
        this.commissionInPercent = commissionInPercent;
        this.priority = priority;
    }

    public int getCommissionInPercent() {
        return commissionInPercent;
    }

    public String getPriority() {
        return priority;
    }

    public void setCommissionInPercent(int commissionInPercent) {
        this.commissionInPercent = commissionInPercent;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
