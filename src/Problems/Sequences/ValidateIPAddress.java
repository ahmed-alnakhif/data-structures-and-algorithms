package Problems.Sequences;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */

public class ValidateIPAddress {

    public String validIPAddress(String queryIP) {
        if (validateIPv4(queryIP))
            return "IPv4";
        if (validateIPv6(queryIP))
            return "IPv6";
        return "Neither";
    }

    boolean validateIPv4(String IP) {
        String[] segmentsArr = IP.split("\\.");

        if (segmentsArr.length != 4) {
            return false;
        }
        if (IP.endsWith(".")) {
            return false;
        }

        for (String segment : segmentsArr) {
            if (segment.length() == 0) {
                return false;
            }
            if (segment.length() > 3) {
                return false;
            }
            if (segment.charAt(0) == '0' && segment.length() > 1) {
                return false;
            }
            for (int j = 0; j < segment.length(); j++) {
                if (!Character.isDigit(segment.charAt(j))) {
                    return false;
                }
            }
            if (Integer.valueOf(segment) > 255) {
                return false;
            }
        }
        return true;
    }

    boolean validateIPv6(String IP) {
        String[] segmentArr = IP.split(":");
        if (segmentArr.length != 8) {
            return false;
        }
        if (IP.endsWith(":")) {
            return false;
        }

        for (String segment : segmentArr) {
            if (segment.length() == 0) {
                return false;
            }
            if (segment.length() > 4) {
                return false;
            }
            segment = segment.toUpperCase();
            for (int j = 0; j < segment.length(); j++) {
                if (!Character.isDigit(segment.charAt(j)) && (segment.charAt(j) < 'A' || segment.charAt(j) > 'F')) {
                    return false;
                }
            }
        }

        return true;
    }

    public void run() {
        String queryIP = "172.16.254.1";
        System.out.println(validIPAddress(queryIP));
    }
}
