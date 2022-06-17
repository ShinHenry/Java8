package 스트림예제;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of("돼지","댱매","포메","말티");
        System.out.println("===== stream1 =====");
        stream1.forEach(System.out::println); // stream1.forEach(s->System.out.println(s));


        Stream<String> stream2 = Stream.empty(); //Stream.empty()는 비어있는 스트림을 생성
        System.out.println("===== stream2 =====");
        stream2.forEach(System.out::println);


        /*
            Stream.generate()는 Arguments로 함수를 받는다.
            함수에서 리턴받는 객체가 스트림으로 생성.
            함수는 무한히 호출되기 때문에 무한한 길이의 스트림이 생성된다.
            그렇기 때문에 limit(5)로 5개의 객체만 생성되도록 하였다.
        */
        Stream<String> stream3 = Stream.generate(()->"Echo").limit(5);
        System.out.println("===== stream3 =====");
        stream3.forEach(System.out::println);


        /*
            Stream.genetator()에 Math:random을 Args로 넘겨주면 랜덤 숫자로 이어진 스트림이 생성됨.
        */
        Stream<Double> stream4 = Stream.generate(Math::random).limit(5);
        System.out.println("===== stream4 =====");
        stream4.forEach(System.out::println);


        /*
            Stream.Iterate()도 generate()와 유사하다. 하지만 Args로 2개의 값을 받는다.
            첫번째는 초기값이고 두번째는 함수이다.
            초기값을 함수에 대입하면서 무한한 스트림이 생성된다.
         */
        Stream<Integer> stream5 = Stream.iterate(0, n->n+2).limit(5);
        System.out.println("===== stream5 =====");
        stream5.forEach(System.out::println);


        /*
            List로 생성된 객체도 스트림으로 생성가능하다. List에 stream()메소드를 List를 스트림으로 생성.
        */
        List<String> list = Arrays.asList("돼지","사슴","고라니","강아지","고양이");
        Stream<String> stream6 = list.stream();
        System.out.println("===== stream6 =====");
        stream6.forEach(System.out::println);


        /*
            Array객체 역시 스트림으로 생성 가능
        */
        String[] array = new String[]{"댱매","돼지","멈미","떡볶이","여행","집"};
        Stream<String> stream7 = Arrays.stream(array);
        System.out.println("===== stream8 =====");
        stream7.forEach(System.out::println);
    }

}
