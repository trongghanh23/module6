public class Main {
    public static void main(String[] args) {
        String str = "aabacsdc";
        StringBuilder str2 = new StringBuilder();
        int count;

        for (int i = 0; i < str.length(); i++) {
            if (!str2.toString().contains(str.substring(i,i+1))) {
                count = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        count++;
                    }
                }

                if (str2.length() > 0) {
                    str2.append(",");
                }

                str2.append(count).append(str.substring(i,i+1));
            }
        }

        System.out.println(str2);
    }
}