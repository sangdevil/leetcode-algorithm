package Binary;

class Number_Of_1_Bits {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            ret += n & 1;
            n = n >> 1;
        }
        return ret;
    }
}
