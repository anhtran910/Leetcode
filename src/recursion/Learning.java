package recursion;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learning {
	private static void printReverse(char [] str) {
		  helper(0, str);
		}

	private static void helper(int index, char [] str) {
		  if (str == null || index >= str.length) {
		    return;
		  }
		  helper(index + 1, str);
		  System.out.print(str[index]);
	}
	
	private static void threeDigit(Optional<Integer> optional) {
		optional.map(n -> ""+n)
		.filter(s -> s.length()==3)
		.ifPresent(System.out::println);
	}
	
//	private static void threeDigit2(Optional<Integer> optional) {
//		Optional<Integer> result=optional.flatMap(ChainingOptionals::calculator);
//	}
	
	public static void main (String[] agrs) {
		char[] str= {'c','o','n','v','e','r','t'};
		Learning test=new Learning();
		test.printReverse(str);
		System.out.println("");
		test.threeDigit(Optional.of(4));
		test.threeDigit(Optional.of(123));
		test.threeDigit(Optional.of(346));
		
		//
		var cats=new ArrayList<String>();
		cats.add("Annie");
		cats.add("Ripley");
		var stream=cats.stream();
		cats.add("KC");
		stream.forEach(System.out::println);
		//System.out.println(stream.count());
		//
		var ohMy= Stream.of("lions","tigers","bears");
		Map<Integer, Optional<Character>> map=ohMy.collect(
		Collectors.groupingBy(
		String::length,
		Collectors.mapping(
		s-> s.charAt(0),
		Collectors.minBy((a,b)-> b-a))));
		System.out.println(map);

		//
//		var ohMy1= Stream.of("lions","tigers","bears");
//		var map1=ohMy.collect(groupingBy(
//				String::length,
//				mapping(s-> s.charAt(0),
//				minBy((a,b)-> b-a))));
//		System.out.println(map1);
		
	}
}
