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
            case MONDAY -> "It's Monday";
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


    // Pattern Matching for switch
    // Now
    static String formatter(Object o) {
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    // New preposition
//    static String formatterPatternSwitch(Object o) {
//        return switch (o) {
//            case null      -> System.out.println("It's null!")
//            case Integer i -> String.format("int %d", i);
//            case Long l    -> String.format("long %d", l);
//            case Double d  -> String.format("double %f", d);
//            case String s  -> String.format("String %s", s);
//                default    -> o.toString();
//        };
//    }

}
