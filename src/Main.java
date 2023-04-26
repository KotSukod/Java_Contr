import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        view.view();
        Scanner user_input = new Scanner(System.in);
        int choise = user_input.nextInt();
        while (choise != 6) {

            if (choise == 2) {
                System.out.println("Выбирите тип игрушки:");
                System.out.println("1. Машинка");
                System.out.println("2. Мяч");
                Scanner choise_class = new Scanner(System.in);
                int class_choise = choise_class.nextInt();

                if (class_choise == 1) {
                    car car = new car(getname(), getcount(), getdrop());
                    sql_db.add_toy(car.name, car.count, car.drop);
                } else {
                    balls balls = new balls(getname(), getcount(), getdrop());
                    sql_db.add_toy(balls.name, balls.count, balls.drop);
                }


            } else if (choise == 3) {
                sql_db.viewall();

            } else if (choise == 4) {
                sql_db.viewall();
                System.out.println("Введите Id:");
                Scanner idin = new Scanner(System.in);
                int idget = idin.nextInt();
                System.out.println("Введите количество:");
                int countget = idin.nextInt();
                sql_db.updatecount(idget,countget);


            } else if (choise == 5) {
                sql_db.viewall();
                System.out.println("Введите Id:");
                Scanner idin = new Scanner(System.in);
                int idget = idin.nextInt();
                System.out.println("Введите шанс выпадения:");
                int dropget = idin.nextInt();
                sql_db.updatedrop(idget,dropget);


            }
            view.view();
            user_input = new Scanner(System.in);
            choise = user_input.nextInt();
        }
    }

    public static String getname(){
        Scanner name = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String nameget = name.nextLine();
        return nameget;
    }

    public static int getcount(){
        Scanner count = new Scanner(System.in);
        System.out.print("Введите количество: ");
        int countget = count.nextInt();
        return countget;
    }

    public static int getdrop(){
        Scanner drop = new Scanner(System.in);
        System.out.print("Введите шанс выпадения: ");
        int dropget = drop.nextInt();
        return dropget;
    }
}



