import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main
{
    static int id = 1;
    public static int getUsersList() throws IOException {
        FileReader fr = new FileReader("users.txt");
        Scanner scan = new Scanner(fr);

        int i = 0;

        while (scan.hasNextLine()) {
            i++;
            System.out.println(scan.nextLine());
        }

        fr.close();
        return i;
    }
    public static void saveUsersList(ArrayList<User> users) {
        try(FileWriter fileWriter = new FileWriter("users.txt")) {
            for(int i = 0; i < users.size(); i++) {
                fileWriter.write(users.get(i).toString());
            }
            fileWriter.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        User u1 = new User(id++,"111111","1111111");
        User u2 = new User(id++,"2222","22222");
        User u3 = new User(id++,"33333","44444");


        ArrayList<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        boolean check = true;
        while(check) {
            System.out.println("PRESS [1] TO ADD USERS");
            System.out.println("PRESS [2] TO LIST USERS");
            System.out.println("PRESS [3] TO DELETE USER");
            System.out.println("PRESS [4] TO EXIT");
            int which = scan.nextInt();
            System.out.println();
            switch(which) {
                case 1:
                    System.out.print("Введите логин: ");
                    String log = scan.next();
                    System.out.print("Введите пароль: ");
                    String pass = scan.next();
                    User u = new User(id++,log,pass);
                    users.add(u);
                    System.out.println();
                    break;
                case 2:
                    for(int i = 0; i < users.size(); i++) {
                        System.out.print(users.get(i).getId() + " ");
                        System.out.println(users.get(i).getLogin());
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Какого user-а удалить?");
                    int index = scan.nextInt();
                    for(int i = 0; i < users.size(); i++) {
                        if(i == index) {
                            users.remove(i - 1);
                        }
                    }
                    System.out.println();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Неправильный выбор!");
                    check = false;
                    break;
            }
        }
        saveUsersList(users);
        System.out.println(getUsersList());
    }
}

