public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business
        // presentations
        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm", "transform" };
        detectAndPrint(sentences, keywords);
    }

    public static boolean contains(String str1, String str2) {
        int longstring = str1.length();
        int shortstring = str2.length();
        if (shortstring == 0) {
            return true;
        }
        if (shortstring > longstring) {
            return false;
        }
        for (int i = 0; i <= longstring - shortstring; i++) {
            boolean match = true;
            for (int j = 0; j < shortstring; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;

    }// Iterates through all the sentences.
     // If a sentence contains one or more of the kewords, prints it.

    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (String sentence : sentences) {
            String lowerSentence = sentence.toLowerCase();
            for (String keyword : keywords) {
                String lowerKeyword = keyword.toLowerCase();
                if (contains(lowerSentence, lowerKeyword)) {
                    System.out.println(sentence);
                    break;
                }
            }
        }
    }
}
