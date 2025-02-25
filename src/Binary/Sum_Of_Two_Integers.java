package Binary;

class Sum_Of_Two_Integers {
    public int getSum(int a, int b) {
        int carry = 1;
        while(carry != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}