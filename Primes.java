public class Primes {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean arr[] = new boolean[n + 1];
        for (int i = 0; i <= 1; i++) {
            arr[i] = true;
        }

        System.out.println("Prime numbers up to " + n + ":");
        int prime = 2;

        while (prime * prime <= n) {
            if (arr[prime] == false) {
                int multiple = prime * prime;
                while (multiple <= n) {
                    arr[multiple] = true;
                    multiple += prime;
                }
            }
            prime++;
        }
        int count = 0;
        for (int j = 2; j <= n; j++) {
            if (arr[j] == false) {
                System.out.println(j);
                count++;
            }
        }
        double percentage = (double) count / n * 100;
        int roundedPercentage = (int) Math.round(percentage);
        System.out.println("There are " + count + " primes between 2 and " + n + " (" + roundedPercentage
                + "% are primes)");

    }
}
