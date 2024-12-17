import java.util.Random;

public class RandomKeyGenerator {

        public static String generateRandomKey(int length) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuilder key = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                key.append(characters.charAt(index));
            }

            return key.toString();
        }
}
