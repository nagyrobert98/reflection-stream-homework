package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).sorted(Comparator.comparing(x -> x.getName())).forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).sorted(Comparator.comparing(x -> x.getName())).map(x -> x.getName()).distinct().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x -> x.getParameterCount() > 1 && Arrays.stream(x.getParameterTypes()).allMatch(y -> y == Arrays.stream(x.getParameterTypes()).findFirst().get())).sorted(Comparator.comparing(z -> z.getName())).forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).sorted(Comparator.comparing(x -> x.getReturnType().getName())).map(y -> y.getReturnType().getName()).distinct().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x -> Arrays.stream(x.getParameterTypes()).anyMatch(y -> y == boolean.class)).sorted(Comparator.comparing(z -> z.getName())).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x -> Arrays.stream(x.getParameterTypes()).allMatch(y -> y == int.class) && x.getParameterCount() != 0).sorted(Comparator.comparing(z -> z.getName())).forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).map(x -> x.getName()).distinct().max(Comparator.comparing(y -> y.length())).get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).filter(x -> x.getModifiers() == 1).map(y -> y.getName()).distinct().max(Comparator.comparing(z -> z.length())).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(x -> x.getParameterCount()).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).mapToInt(x -> x.getParameterCount()).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods()).max(Comparator.comparing(x -> x.getParameterCount())).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).flatMap(x -> Arrays.stream(x.getParameterTypes())).distinct().sorted(Comparator.comparing(y -> y.getName())).forEach(System.out::println);
    }

}
