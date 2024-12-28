public class ApiResponse {
    private String field1;
    private int field2;

    // Getters e Setters
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public int getField2() {
        return field2;
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                '}';
    }
}