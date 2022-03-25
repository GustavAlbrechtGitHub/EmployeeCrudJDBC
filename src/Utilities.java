
import java.util.Scanner;

    public class Utilities implements UtilitiesInterface{

        Scanner sc = new Scanner(System.in);

        public int getIntInput(){

            int input = sc.nextInt();
            sc.nextLine();

            return input;
        }

        public double getDoubleInput(){

            double input = sc.nextDouble();
            sc.nextLine();

            return input;
        }

        public String getStringInput(){

            String input = sc.nextLine();

            return input;
        }

        public String fixString(int wantedSize, String stringToFix){
            if (stringToFix.length()< wantedSize){
                while(stringToFix.length()<wantedSize){
                    stringToFix = stringToFix + " ";

                }
                return stringToFix+"  ";
            }
            else
                return stringToFix.substring(0, wantedSize)+"  ";

        }

    }


