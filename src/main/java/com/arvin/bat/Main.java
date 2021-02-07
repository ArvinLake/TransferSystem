package com.arvin.bat;

public class Main {

    public static void main(String[] args) {
        String[] dataDirs = new String[]{
                "/home/arvin/tmp/BraveSoftware/new1/Brave-Browser",
                "/home/arvin/tmp/BraveSoftware/new2/Brave-Browser"
        };
        for (int i = 0; i < dataDirs.length; i++) {
            String dataDir = dataDirs[i];
            new Thread(() -> {
                new BraveBrowser(dataDir).browse();
            }, "Browser-" + i).start();
        }
    }
}
