package 스트림예제;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
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
        System.out.println("===== stream7 =====");
        stream7.forEach(System.out::println);
        System.out.println();


        /*
            중개연산 : Stream 필터링
            filter() 메소드는 해당 스트림에서 주어진 조건(predicate)에 맞는 요소만으로 구성된 새로운 스트림을 반환
            distinct() 메소드는 해당 스트림에서 중복된 요소가 제거된 새로운 스트림을 반환
            distinct() 메소드는 내부적으로 Object 클래스의 equals() 메소드를 사용하여 요소의 중복을 비교
        */
        IntStream stream8 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        IntStream stream9 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        // 스트림에서 중복된 요소를 제거함.
        System.out.println("===== 스트림에서 중복된 요소를 제거함 =====");
        stream8.distinct().forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 스트림에서 홀수만을 골라냄.
        System.out.println("===== 스트림에서 홀수만을 골라냄 =====");
        stream9.filter(n -> n % 2 != 0).forEach(e -> System.out.print(e + " "));
        System.out.println();


        /*
            중개연산 : Stream 변환
            map() 메소드는 해당 스트림의 요소들을 주어진 함수에 인수로 전달하여, 그 반환값들로 이루어진 새로운 스트림을 반환
            만약 해당 스트림의 요소가 배열이라면, flatMap() 메소드를 사용하여 각 배열의 각 요소의 반환값을 하나로 합친 새로운 스트림을 얻을 수 있다.
         */
        Stream<String> stream10 = Stream.of("HTML", "CSS", "JAVA", "JAVASCRIPT");
        System.out.println("===== Stream 변환 : String의 길이로 변환 =====");
        stream10.map(s -> s.length()).forEach(System.out::println);


        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> stream11 = Arrays.stream(arr);
        System.out.println("===== Stream 변환 : 띄어쓰기를 기준으로 줄바꿈 변환 =====");
        stream11.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println);


        /*
            중개연산 : Stream 제한 -> limit(), skip()
            limit() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소만으로 이루어진 새로운 스트림을 반환
            skip() 메소드는 해당 스트림의 첫 번째 요소부터 전달된 개수만큼의 요소를 제외한 나머지 요소만으로 이루어진 새로운 스트림을 반환
         */
        IntStream stream12 = IntStream.range(0, 10);
        IntStream stream13 = IntStream.range(0, 10);
        IntStream stream14 = IntStream.range(0, 10);

        System.out.println("===== Stream 제한 : 4를 제외하고 출력 =====");
        stream12.skip(4).forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("===== Stream 제한 : 5개까지만 출력 =====");
        stream13.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("===== Stream 제한 : 3를 제외하고 5개까지만 출력 =====");
        stream14.skip(3).limit(5).forEach(n -> System.out.print(n + " "));


        /*
            중개연산 : Stream 정렬 -> sorted()
            sorted() 메소드는 해당 스트림을 주어진 비교자(comparator)를 이용하여 정렬
            이때 비교자를 전달하지 않으면 기본적으로 사전 편찬 순(natural order)으로 정렬
         */
        Stream<String> stream15 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        Stream<String> stream16 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        System.out.println("===== Stream 정렬 : 문자열 뒤에 띄어쓰기를 포함하여 출력 =====");
        stream15.sorted().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("===== Stream 정렬 : 스트림을 역순으로 출력 =====");
        stream16.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
