package Binary;

public class Main {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int ret = 0;

//        System.out.println(String.format("cur : %s, 1 : %s, cur & 1 : %d",
//                Integer.toBinaryString(cur), Integer.toBinaryString(1), cur & 1));
        int i = 0;
        int cur = 1;
        while (true)  {
//            System.out.println(String.format("ret = %s, cur = %s, cur&n = %d", Integer.toBinaryString(ret), Integer.toBinaryString(cur), cur & n));
            ret ^= (cur & n) != 0 ? 1 : 0;
            cur <<= 1;
            if (i == 31) break;
            ret <<= 1;
            i++;
        }


        return ret;

    }
}