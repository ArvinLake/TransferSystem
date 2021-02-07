package com.arvin.bat;

public class PrimeCounter {

    public static void main(String[] args) {
        System.out.println(new PrimeCounter().countPrime(100));
    }

    public int countPrime(int max) {
        int count = 0;
        int prime = 0;
        while ((prime = nextPrime(prime, max)) != -1) {
            System.out.println(prime);
            count++;
        }
        return count;
    }

    private int nextPrime(int prime, int max) {
        int possiblePrime = prime;
        while ((possiblePrime = nextPossiblePrime(possiblePrime, max)) != -1) {
            if (isPrime(possiblePrime)) {
                return possiblePrime;
            }
        }
        return -1;
    }

    private int nextPossiblePrime(int prime, int max) {
        if (prime <= 3) {
            return prime + 1;
        }
        prime = prime % 2 == 1 ? prime + 2 : prime + 1;
        for (int i = prime; i < max; i += 2) {
            if (i % 2 == 0 || i % 3 == 0) {
                continue;
            }
            return i;
        }
        return -1;
    }

    private boolean isPrime(int num) {
        if (num <= 3) {
            return true;
        }
        int sqrt = (int) Math.sqrt(num);
        if (Math.pow(sqrt, 2) == num) {
            return false;
        }
        for (int i = 2; i < sqrt + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
