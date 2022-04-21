package Companies.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Amazon's AWA provides fast and efficient server solutions. The developers
 * want to stress-test the quality of the server channels.
 * They must ensure the followings:
 * 1) each of the packets must be sent via a single channel
 * 2) each of the channels must transfer at least one packet
 * 
 * The quality of the transfer for a channels is defined by the medium of the
 * sizes of all the data packets sent through that channel
 * 
 * Find the maximum possible sum of the qualities of the channels.if the answer
 * is a floating point number,round it to the nearest integer.
 * 
 * 
 * Example:
 * 
 * packets = [1,2,3,4,5]
 * channels = 2
 * Output: 8
 */

public class QualityOfServerChannels {

    public long findMaxQuality(List<Integer> packets, int channels) {
        List<List<Integer>> channelsPackets = new ArrayList<>();

        Collections.sort(packets, (a, b) -> b - a);

        int i = 0;
        for (; i < channels - 1; i++) {
            channelsPackets.add(new ArrayList<>(Arrays.asList(packets.get(i))));
        }

        List<Integer> restOfPackages = new ArrayList<>();
        for (; i < packets.size(); i++) {
            restOfPackages.add(packets.get(i));
        }
        channelsPackets.add(restOfPackages);

        double maxQuality = 0;
        for (int j = 0; j < channelsPackets.size(); j++) {
            maxQuality += getMedian(channelsPackets.get(j));
        }

        return Math.round(maxQuality);
    }

    private double getMedian(List<Integer> packets) {
        if (packets.size() % 2 == 0) {
            return (packets.get(packets.size() / 2) + packets.get(packets.size() / 2 - 1)) / 2.0;
        } else {
            return packets.get(packets.size() / 2);
        }
    }

    public static void main(String[] args) {
        QualityOfServerChannels obj = new QualityOfServerChannels();
        System.out.println(obj.findMaxQuality(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 2));
    }
}
