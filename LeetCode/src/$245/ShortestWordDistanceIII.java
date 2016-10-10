package $245;

public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2)) {
                    if (index1 == -1) {
                        index1 = i;
                        continue;
                    } else {
                        if (index2 == -1) {
                            index2 = i;
                        } else {
                            if (index2 > index1) {
                                index1 = i;
                            } else {
                                index2 = i;
                            }
                        }
                        minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                        continue;
                    }
                } else {
                    index1 = i;
                    if (index2 != -1) {
                        minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                    }
                    continue;
                }
            }
            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                }
            }
        }
        return minDistance;
    }
}
