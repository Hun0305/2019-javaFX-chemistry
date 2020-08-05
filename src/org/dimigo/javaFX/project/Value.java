package org.dimigo.javaFX.project;

public class Value {
    private static String name1; // 산 물질 이름
    private static double value1; // 산 물질 가수
    private static double m1 = 0; // 산 몰농도
    private static double volume1; // 산 부피

    private static String name2; // 염기 이름
    private static double value2; // 염기 가수
    private static double m2 = 0; // 염기 몰농도
    private static double volume2; // 염기 부피

    private static String acidOrBasic; // 몰농도 설정하는 씬에서 설정되고, 결과씬에서 이름 출력하기 위해 사용되는 변수. 산 또는 염기

    // getters and setters
    public static double getValue1() {
        return value1;
    }

    public static void setValue1(double value1) {
        Value.value1 = value1;
    }

    public static double getM1() {
        return m1;
    }

    public static void setM1(double m1) {
        Value.m1 = m1;
    }

    public static double getVolume1() {
        return volume1;
    }

    public static void setVolume1(double volume1) {
        Value.volume1 = volume1;
    }

    public static double getValue2() {
        return value2;
    }

    public static void setValue2(double value2) {
        Value.value2 = value2;
    }

    public static double getM2() {
        return m2;
    }

    public static void setM2(double m2) {
        Value.m2 = m2;
    }

    public static double getVolume2() {
        return volume2;
    }

    public static void setVolume2(double volume2) {
        Value.volume2 = volume2;
    }

    public static String getName1() {
        return name1;
    }

    public static void setName1(String name1) {
        Value.name1 = name1;
    }

    public static String getName2() {
        return name2;
    }

    public static void setName2(String name2) {
        Value.name2 = name2;
    }

    public static String getAcidOrBasic() {
        return acidOrBasic;
    }

    public static void setAcidOrBasic(String acidOrBasic) {
        Value.acidOrBasic = acidOrBasic;
    }
}
