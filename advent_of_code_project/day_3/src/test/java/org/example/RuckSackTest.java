package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RuckSackTest {

    @Test
    public void testStringSplitIntoTwo_evenChars(){
        List<String> result = RuckSack.splitStringInHalf("aaaa");
        assertEquals(List.of("aa", "aa"), result);
    }

    @Test
    public void testStringSplitIntoTwo_oddChars(){
        List<String> result = RuckSack.splitStringInHalf("aaaaa");
        assertEquals(List.of("aaa", "aa"), result);
    }

    @Test
    public void testStringSplitIntoTwo_mixedCase(){
        List<String> result = RuckSack.splitStringInHalf("aBcDEf");
        assertEquals(List.of("aBc", "DEf"), result);
    }

    @Test
    public void testBuildPriorityMap_a_is_1(){
        Map<String, Integer> result = RuckSack.getPriorityMap();
        assertEquals(1, result.get("a"));
    }

    @Test
    public void testBuildPriorityMap_p_is_16(){
        Map<String, Integer> result = RuckSack.getPriorityMap();
        assertEquals(16, result.get("p"));
    }

    @Test
    public void testBuildPriorityMap_L_is_38(){
        Map<String, Integer> result = RuckSack.getPriorityMap();
        assertEquals(38, result.get("L"));
    }

    @Test
    public void testBuildPriorityMap_P_is_42(){
        Map<String, Integer> result = RuckSack.getPriorityMap();
        assertEquals(42, result.get("P"));
    }

    @Test
    public void testReturnsCommonString_stringContainsLetterALowercase_returnALowercase(){
        Set<String> result = RuckSack.getCommonItems("abc", "ade");
        assertTrue(result.contains("a"));
    }

    @Test
    public void testReturnsCommonString_stringContainsLetterAUppercase_returnAUppercase(){
        Set<String> result = RuckSack.getCommonItems("abcA", "tdeA");
        assertTrue(result.contains("A"));
    }

}