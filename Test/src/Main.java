public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        A ob = new A();


        if (ob.toString().equals("1")
                &&ob.toString().equals("2")
                &&ob.toString().equals("3")) {
            System.out.println("ok");
        }
        byte2String();
    }

    private static void byte2String(){
        byte[] raw = {0x01,0x22,0x02,0x2f};
        for (byte aRaw : raw) {
            System.out.println(Integer.toHexString(aRaw & 0xff));
        }
        double weightKg = 12345 / 1000.0;
        double weightKg1 = (double) 12345 / 1000;
        System.out.println(weightKg);
        System.out.println(weightKg1);
    }
}
