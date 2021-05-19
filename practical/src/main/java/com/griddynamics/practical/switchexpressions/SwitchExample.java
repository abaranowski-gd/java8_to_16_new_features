package com.griddynamics.practical.switchexpressions;


public class SwitchExample {
    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;
    private static final int WEDNESDAY = 3;
    private static final int THURSDAY = 4;
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;

    public static int returnExample(){
        // you can return from switch statement
        int day = 2;
        switch (day) {
            case MONDAY -> {
                System.out.println("It monday!");
                return -1;
            }
            case SATURDAY, SUNDAY -> {
                System.out.println("It's the weekend!");
                return day;
            }
            default -> {
                System.out.println("It's still not the weekend");
                return -1;
            }
        }
    }

//    public static int wrongReturnExample(){
//        int day = 2;
//        // You cannot return outside of an enclosing switch expression
//        int x = switch (day) {
//            case MONDAY -> {
//                System.out.println("It monday!");
//                return -1;
//            }
//            case SATURDAY, SUNDAY -> {
//                System.out.println("It's the weekend!");
//                return day;
//            }
//            default -> {
//                System.out.println("It's still not the weekend");
//                return -1;
//            }
//        }
//    }

    public static void main(String[] args) {
        // Old
        int day = 2;
        switch (day) {
            case MONDAY:
                System.out.println("It monday!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's the weekend!");
                break;
            default:
                System.out.println("It's still not the weekend");
                break;
        }

        // New
        switch (day) {
            case MONDAY -> System.out.println("It monday!");
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend!");
            default -> System.out.println("It's still not the weekend");
        }

        //Switch expression
        String result = switch (day) {
            case MONDAY, TUESDAY, THURSDAY, FRIDAY -> "It's Monday";
            case SATURDAY, SUNDAY -> "It's weekend";
            case WEDNESDAY -> throw new IllegalArgumentException("We don't like Wednesday");
            default -> {
                String s = "No ";
                for (int i = 0; i < 3; i++) {
                    s = s + "no ";
                }
                s = s + "still not weekend!";
                yield s;
            }
        };
        System.out.println(result);
    }
}
