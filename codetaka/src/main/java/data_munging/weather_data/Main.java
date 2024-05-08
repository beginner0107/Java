package data_munging.weather_data;

import java.io.*;

// 날씨 데이터
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src\\main\\java\\data_munging\\weather_data\\weather.dat";

        int minSpreadDay = findDayWithMinTemperatureSpread(filePath);
        System.out.println("온도 분포가 가장 낮은 날짜 ? " + minSpreadDay);
    }

    private static int findDayWithMinTemperatureSpread(String filePath) {
        int minSpreadDay = -1;
        double minSpread = Double.MAX_VALUE;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidData(line)) {
                    String[] parts = line.trim().split("\\s+"); // 정규식 '\s' 공백 문자 '+' 패턴 하나 이상
                    int day = Integer.parseInt(parts[0]); // 날짜
                    double maxTemp = removeSpecialCharacter(parts[1]);
                    double minTemp = removeSpecialCharacter(parts[2]);
                    double spread = maxTemp - minTemp;

                    if (spread < minSpread) {
                        minSpread = spread;
                        minSpreadDay = day;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minSpreadDay;
    }

    private static double removeSpecialCharacter(String part) {
        return Double.parseDouble(part.replace("*", ""));
    }

    private static boolean isValidData(String line) {
        return !line.trim().isEmpty() && Character.isDigit(line.trim().charAt(0));
    }
}
