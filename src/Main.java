import java.util.*;
public class Main{
    static Scanner input = new Scanner(System.in);
    static Random r = new Random();

    private static String [] itemCategory = new String [0];
    private static String [][] supplier = new String [0][2];
    private static String [][] item = new String[0][6];

    private static String [] entry = {"Mixage", "1234"};

    public static void linePrint(){
        System.out.print("+");
        for(int i = 0; i < 80; i++){
            System.out.print("-");
            try{
                Thread.sleep(10);
            } catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
        System.out.println("+");
    }

    public static void threadSleep(){
        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }
    }

    public static boolean loginPage(){
        linePrint();
        System.out.println("|                                    LOGIN PAGE                                  |");
        linePrint();
        while(true){
            System.out.print("User Name : ");
            String userName=input.next();
            if(userName.equals(entry[0])){
                System.out.println();
                while(true){
                    System.out.print("Password   : ");
                    String Password=input.next();
                    if(Password.equals(entry[1])){
                        return true;
                    }else{
                        System.out.println("Password is incorrect. Please try again!\n");
                    }
                }
            }else{
                System.out.println("User name is invalid. Please try again!\n");
            }
        }
    }

    public static void print(){
        linePrint();
        System.out.println("|                  WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                       |");
        linePrint();
        threadSleep();

        System.out.print("\n\n");

        System.out.print("[1] Change the Credentials			[2] Supplier Manage");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("[3] Stock Manage				[4] Log Out");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("[5] Exit The System ");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("Enter An Option To Continue > ");
    }

    public static int inputFNum(){
        int x = input.nextInt();
        return x;
    }

    public static boolean changeCredentials(){
        linePrint();
        System.out.println("|                               CREDENTIAL MANAGE                                |");
        linePrint();

        while(true){
            System.out.print("please enter the user name to verify it's you : ");
            String userName=input.next();
            if(userName.equals(entry[0])){
                System.out.print("Hey " + entry[0]);
                System.out.println();
                while(true){
                    System.out.print("Enter Your Current Password   : ");
                    String Password=input.next();
                    if(Password.equals(entry[1])){
                        System.out.print("Enter your new password : ");
                        String Password1 = input.next();
                        entry[1] = Password1;
                        System.out.println();
                        System.out.print("Password Changed Successfully! ");
                        System.out.print("Do you want To Go To Main Menu (Y/N): ");
                        char a = input.next().charAt(0);
                        if(a == 'y' || a == 'Y'){
                            return true;
                        }else if(a == 'N' || a == 'n'){
                            clearConsole();
                            changeCredentials();
                        }
                    }else{
                        System.out.println("Incorrect password. try again!\n");
                    }
                }
            }else{
                System.out.println("invalid user name. try again!\n");
            }
        }
    }


    public static void supplyManage(){
        linePrint();
        System.out.println("|                                 SUPPLY MANAGE                                  |");
        linePrint();
        threadSleep();

        System.out.print("\n\n");

        System.out.print("[1] Add Supplier			[2] Update Supplier");
        threadSleep();
        System.out.print("\n");

        System.out.print("[3] Delete Supplier			[4] View Suppliers");
        threadSleep();
        System.out.print("\n");

        System.out.print("[5] Search Supplier			[6] Home Page ");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("Enter Option Here : ");

    }

    public static void addSupplier(){
        linePrint();
        System.out.println("|                                 ADD SUPPLIERS                                  |");
        linePrint();

        System.out.println();

        while(true){
            boolean flag = false;

            System.out.print("Supplier ID : ");
            String supId=input.next();

            for (int i = 0; i < supplier.length; i++){
                if(supId.equals(supplier[i][0])){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                System.out.print("Supplier Name : ");
                String supName = input.next();

                grow();

                supplier[supplier.length -1][0] = supId;
                supplier[supplier.length -1][1] = supName;

                System.out.print("added successfully! Do you want to add another supplier(Y/N)? ");
                char op=input.next().charAt(0);
                if(op=='n'||op=='N'){
                    clearConsole();
                    return;
                }else if(op=='y'||op=='Y'){
                    System.out.println();
                }
            }else{
                System.out.print("already exists. try another supplier id!\n");
            }
        }
    }

    public static void grow(){
        String [][] temp = new String [supplier.length + 1][2];
        for (int i = 0; i < supplier.length; i++) {
            temp[i]=supplier[i];
        }
        supplier=temp;
    }



    public static void updateSupplier(){
        linePrint();
        System.out.println("|                               UPDATE SUPPLIERS                                 |");
        linePrint();

        System.out.println();


        while(true){
            System.out.print("Supplier ID : ");
            String supId=input.next();

            for (int i = 0; i < supplier.length; i++){
                if(supId.equals(supplier[i][0])){
                    System.out.println("Supplier Name : " + supplier[i][1]);

                    System.out.print("Enter the new supplier name: ");
                    String supName = input.next();
                    supplier[i][1] = supName;

                    System.out.println();
                    System.out.print("update successfully! Do you want to add another supplier(Y/N)? ");

                    char op=input.next().charAt(0);
                    if(op=='n'||op=='N'){
                        clearConsole();
                        return;
                    }else if(op=='y'||op=='Y'){
                        System.out.println();
                    }
                }
            }
            System.out.println("can't find supplier id.try again !");
        }
    }

    public static void deleteSupplier(){
        linePrint();
        System.out.println("|                               DELETE SUPPLIERS                                 |");
        linePrint();

        System.out.println();

        while(true){
            System.out.print("Supplier ID : ");
            String supId=input.next();

            for (int i = 0; i < supplier.length; i++){
                if(supId.equals(supplier[i][0])){
                    supplier[i][0]=null;
                    supplier[i][1]=null;
                    for (int k=0,j=0; j < supplier.length-1 ; j++){
                        if(supplier[j][0]==null){j++;}
                        supplier[k][0] = supplier[j][0];
                        supplier[k][1] = supplier[j][1];
                        k++;
                    }

                    String[][] newArray = Arrays.copyOfRange(supplier, 0, supplier.length-1);
                    supplier = newArray;

                    System.out.print("deleted successfully! Do you want to delete another?(Y/N)  ");

                    char ch = input.next().charAt(0);
                    if(ch == 'n' || ch == 'N'){
                        return;
                    }else if(ch == 'y' || ch == 'Y'){
                        System.out.println();
                    }
                }
            }
            System.out.print("can't find supplier id.try again !\n");
        }
    }

    public static void linkSup(){
        System.out.print("+");
        for(int i = 0; i < 47; i++){
            System.out.print("-");
            try{
                Thread.sleep(10);
            } catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
        System.out.println("+");
    }

    public static void viewSupplier(){
        linePrint();
        System.out.println("|                                VIEW SUPPLIERS                                  |");
        linePrint();

        linkSup();
        System.out.println("|	SUPPLIER ID	|	SUPPLIER NAME	|");
        linkSup();

        while(true){
            for(int i = 0; i < supplier.length; i++){
                System.out.println("|          " + supplier[i][0] + "         |         " + supplier[i][1] + "         |");
            }

            linkSup();
            System.out.println();

            System.out.print("Do You Want To Go To Main Menu (Y/N): ");
            char ch = input.next().charAt(0);
            if(ch=='y' || ch=='Y'){
                break;
            }else if(ch == 'N' || ch == 'n'){
                return;
            }
        }

    }

    public static void searchSupplier(){
        linePrint();
        System.out.println("|                                SEARCH SUPPLIERS                                |");
        linePrint();

        System.out.println();

        while(true){
            System.out.print("Supplier ID : ");
            String supId=input.next();

            for (int i = 0; i < supplier.length; i++){
                if(supId.equals(supplier[i][0])){
                    System.out.println("Supplier Name  : " +supplier[i][1]);

                    System.out.print("added successfully! Do you want to add another find(Y/N)? ");

                    char op=input.next().charAt(0);
                    if(op=='n'||op=='N'){
                        return;
                    }else if(op=='y'||op=='Y'){
                        System.out.println();
                    }
                }
            }System.out.print("can't find supplier id.try again !\n");
        }

    }

    public static void stockManage(){
        linePrint();
        System.out.println("|                                 STOCK MANAGE                                   |");
        linePrint();

        System.out.println();

        System.out.print("[1] Manage Item Categories			[2] Add Item");
        threadSleep();
        System.out.print("\n");

        System.out.print("[3] Get Items Supplier Wise			[4] View Items");
        threadSleep();
        System.out.print("\n");

        System.out.print("[5] Rank Items Per Unit Price			[6] Home Page ");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("Enter Option Here : ");
    }

    public static void itemCat(){
        linePrint();
        System.out.println("|                            MANAGE ITEM CATEGORIES                              |");
        linePrint();

        System.out.println();

        System.out.print("[1] Add new Item Category			[2] Update new Item Category");
        threadSleep();
        System.out.print("\n");

        System.out.print("[3] Delete new Item Category			[4] Stock Management");
        threadSleep();
        System.out.print("\n\n");

        System.out.print("Enter Option Here : ");
    }

    public static void addItemCat(){
        linePrint();
        System.out.println("|                               ADD ITEM CATERGORY                               |");
        linePrint();

        System.out.println();

        while(true){
            boolean flag = false;

            System.out.print("Enter the new Item Category: ");
            String itemCatName = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){
                    flag = true;
                    break;
                }
            }

            if(flag == false){
                growItemCategory();

                itemCategory[itemCategory.length-1] = itemCatName;
                System.out.print("added successfully! Do you want to add another category(Y/N)? ");

                char op=input.next().charAt(0);
                if(op=='n'||op=='N'){
                    return;
                }else if(op=='y'||op=='Y'){
                    System.out.println();
                }
            }else{
                System.out.print("already exists. try another Item category!\n");
            }
        }
    }

    public static void growItemCategory(){
        String [] temp = new String [itemCategory.length + 1];
        for (int i = 0; i < itemCategory.length; i++) {
            temp[i]=itemCategory[i];
        }
        itemCategory=temp;
    }

    public static void updateItemCat(){
        linePrint();
        System.out.println("|                               UPDATE ITEM CATERGORY                            |");
        linePrint();

        while(true){
            System.out.print("Item Category : ");
            String itemCatName = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){

                    System.out.print("Enter the new item Category: ");
                    String newItemCatName = input.next();
                    itemCategory[i] = newItemCatName;

                    System.out.println();
                    System.out.print("update successfully! Do you want to add another Item category(Y/N)? ");

                    char op=input.next().charAt(0);
                    if(op=='n'||op=='N'){
                        clearConsole();
                        return;
                    }else if(op=='y'||op=='Y'){
                        System.out.println();
                    }
                }
            }
            System.out.println("can't find supplier id.try again !");
        }
    }

    public static void deleteItemCat(){
        linePrint();
        System.out.println("|                               DELETE ITEM CATERGORY                            |");
        linePrint();

        System.out.println();

        while(true){
            System.out.print("Item Category : ");
            String itemCatName = input.next();

            for (int i = 0; i < itemCategory.length; i++){
                if(itemCatName.equals(itemCategory[i])){
                    itemCategory[i] = null;

                    for (int k=0,j=0; j < itemCategory.length-1 ; j++){
                        if(itemCategory[j] == null){j++;}
                        itemCategory[k] = itemCategory[j];
                        k++;
                    }

                    String [] newArray = Arrays.copyOfRange(itemCategory, 0, itemCategory.length-1);
                    itemCategory = newArray;

                    System.out.print("deleted successfully! Do you want to delete another?(Y/N)  ");

                    char ch = input.next().charAt(0);
                    if(ch == 'n' || ch == 'N'){
                        return;
                    }else if(ch == 'y' || ch == 'Y'){
                        System.out.println();
                    }
                }
            }
            System.out.println("can't find Item Category. Try again !");
        }
    }



    public static void addItem(){
        linePrint();
        System.out.println("|                                       ADD ITEM                                 |");
        linePrint();

        System.out.println();

        while(true){
            if(itemCategory.length == 0){
                System.out.println("OOPS! It seems that don't have any item categories in the system.");
                System.out.print("Do you want to add a new item category?(Y/N) : ");

                char ch = input.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    return;
                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    addItemCat();
                    return;
                }
            }else if(supplier.length == 0){
                System.out.println("OOPS! It seems that don't have any supplier in the system.");
                System.out.print("Do you want to add a new supplier?(Y/N) : ");

                char ch = input.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    return;
                }else if(ch == 'y' || ch == 'Y'){
                    clearConsole();
                    addSupplier();
                    return;
                }
            }else{
                growItem();

                while(true){
                    boolean flag = false;

                    System.out.print("Item Code : ");
                    String itemCode=input.next();

                    for (int i = 0; i < item.length; i++){
                        if(itemCode.equals(item[i][0])){
                            System.out.println("Item Code already exists! Enter Item Code again");
                        }
                    }

                    if(flag == false){
                        item[item.length-1][0] =itemCode;
                        break;
                    }
                }

                System.out.println();
                System.out.println("Suppliers list : ");

                System.out.printf("+------------------+-------------------+-------------------+%n");
                System.out.printf("|     %s      |    %s    |   %s   |%n","   #   ","SUPPLIER ID","SUPPLIER NAME");
                System.out.printf("+------------------+-------------------+-------------------+%n");

                for (int i = 0; i < supplier.length; i++){
                    System.out.printf("|    %-10s    |     %-10s    |    %-10s     |%n",(i+1),supplier[i][0],supplier[i][1]);
                }
                System.out.printf("+------------------+-------------------+-------------------+%n");

                while(true){
                    System.out.println();
                    System.out.print("Enter the supplier number > ");

                    int supNum = input.nextInt();

                    if(supNum > supplier.length || supNum <= 0){
                        System.out.print("Invalid number! Enter again");
                    }else{
                        item[item.length-1][1] = supplier[supNum-1][0];
                        break;
                    }
                }

                System.out.println();
                System.out.println("Item Categories : ");

                System.out.printf("+------------------+-------------------+%n");
                System.out.printf("|     %s      |   %s   |%n","   #   ","CATEGORY NAME");
                System.out.printf("+------------------+-------------------+%n");

                for (int i = 0; i < itemCategory.length; i++){
                    System.out.printf("|    %-10s    |     %-10s    |%n",(i+1),itemCategory[i]);
                }
                System.out.printf("+------------------+-------------------+%n");

                while(true){
                    System.out.println();
                    System.out.print("Enter the category number : ");
                    int catNum = input.nextInt();

                    if(catNum > itemCategory.length || catNum <= 0){
                        System.out.print("Invalid number.! Enter again..");
                    }else{
                        item[item.length-1][2] = itemCategory[catNum-1];
                        break;
                    }
                }

                System.out.println();
                System.out.print("Description : ");
                String description = input.next();

                item[item.length-1][3] = description;

                while(true){
                    System.out.println();
                    System.out.print("Unit price : ");
                    String price = input.next();

                    if(Double.parseDouble(price)>0){
                        item[item.length-1][4] = price;
                        break;
                    }else{
                        System.out.print("Invalid Unit price enter again..\n");
                    }
                }

                while(true){
                    System.out.println();
                    System.out.print("Qty on hand : ");
                    String qty=input.next();

                    if(Integer.parseInt(qty)>0){
                        item[item.length-1][5] = qty;
                        break;
                    }else{
                        System.out.print("Invalid Unit price enter again..\n");
                    }
                }

                System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
                char ch = input.next().charAt(0);
                if(ch == 'n' || ch == 'N'){
                    return;
                }else if(ch == 'y' || ch == 'Y'){
                    System.out.println();
                }
            }
        }
    }

    public static void growItem(){
        String [][] temp = new String [item.length + 1][6];
        for (int i = 0; i < item.length; i++) {
            temp[i] = item[i];
        }
        item = temp;
    }

    public static void itemSupWise(){
        linePrint();
        System.out.println("|                                  SEARCH SUPPLIER                               |");
        linePrint();

        System.out.println();

        while(true){
            boolean flag = false;

            System.out.println();
            System.out.print("Supplier ID    : ");
            String supId = input.next();

            for (int i = 0; i < supplier.length; i++){
                if(supId.equals(supplier[i][0])){
                    flag = true;

                    System.out.println("Supplier Name : "+supplier[i][1] + "\n\n");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
                    System.out.printf("|     %s    |    %s    |     %s    |     %s   |     %s      |%n","ITEM CODE","DESCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    for (int j = 0; j < item.length; j++){
                        if(supId.equals(item[j][1])){
                            System.out.printf("|    %10s    |    %-10s    |    %10s      |    %10s    |    %10s     |%n",item[j][0],item[j][3],item[j][4],item[j][5],item[j][2]);
                        }
                    }
                    System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");

                    System.out.print("search successfully! Do you want to another search?(Y/N) ");
                    char ch = input.next().charAt(0);
                    if(ch == 'n' || ch == 'N'){
                        return;
                    }else if(ch == 'y' || ch == 'Y'){
                        System.out.println();
                    }
                }
            }
            System.out.print("can't find supplier id.try again !\n");
        }
    }

    public static void viewItem(){
        linePrint();
        System.out.println("|                                      VIEW ITEMS                                |");
        linePrint();

        System.out.println();

        for (int i = 0; i < itemCategory.length; i++){
            System.out.println("\n"+itemCategory[i]+":");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |%n","SID","CODE","DESC","PRICE","QTY");
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
            for (int j = 0; j < item.length; j++){
                if(item[j][2].equals(itemCategory[i])){
                    System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |%n",item[j][1],item[j][0],item[j][3],item[j][4],item[j][5]);
                }
            }
            System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+%n");
        }
        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            return;
        }else if(ch == 'y' || ch == 'Y'){
            System.out.println();
        }
    }

    public static void rankItem(){
        linePrint();
        System.out.println("|                                  RANKED UNIT PRICE                             |");
        linePrint();

        System.out.println();

        String [][] sortedArray = new String[item.length][6];

        for (int i = 0; i < item.length; i++){
            sortedArray[i] = item[i];
        }

        for (int i = 0; i < item.length; i++){
            for (int j = 0; j < item.length-1; j++){
                if(Double.parseDouble(sortedArray[j][4])>Double.parseDouble(sortedArray[j+1][4])){
                    String [] temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }

            }
        }

        System.out.println();
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");
        System.out.printf("|        %s       |        %s       |        %s       |        %s      |        %s        |        %s        |%n","SID","CODE","DESC","PRICE","QTY","CAT");
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        for (int i = 0; i < sortedArray.length; i++){
            System.out.printf("|    %10s    |    %10s     |    %10s     |    %10s     |    %10s     |    %10s     |%n",sortedArray[i][1],sortedArray[i][0],sortedArray[i][3],Double.parseDouble(sortedArray[i][4]),sortedArray[i][5],sortedArray[i][2]);
        }
        System.out.printf("+------------------+-------------------+-------------------+-------------------+-------------------+-------------------+%n");

        System.out.print("Do you want to go stock manage page?(Y/N)  ");

        char ch = input.next().charAt(0);
        if(ch == 'n' || ch == 'N'){
            return;
        }else if(ch == 'y' || ch == 'Y'){
            System.out.println();
        }
    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }


    public static void main(String [] args){
        loginPage();
        clearConsole();
        while(true){
            print();
            int x = inputFNum();
            if(x == 1){
                clearConsole();
                changeCredentials();
                clearConsole();
            }else if(x == 2){
                clearConsole();
                while(true){
                    supplyManage();
                    int y = inputFNum();
                    if(y == 1){
                        clearConsole();
                        addSupplier();
                        clearConsole();
                    }else if(y == 2){
                        clearConsole();
                        updateSupplier();
                        clearConsole();
                    }else if(y == 3){
                        clearConsole();
                        deleteSupplier();
                        clearConsole();
                    }else if(y == 4){
                        clearConsole();
                        viewSupplier();
                        clearConsole();
                    }else if(y == 5){
                        clearConsole();
                        searchSupplier();
                        clearConsole();
                    }else if(y == 6){
                        clearConsole();
                        break;
                    }
                }
            }else if(x == 3){
                clearConsole();
                while(true){
                    stockManage();
                    int z = inputFNum();
                    if(z == 1){
                        clearConsole();
                        while(true){
                            itemCat();
                            int a = inputFNum();
                            if(a == 1){
                                clearConsole();
                                addItemCat();
                                clearConsole();
                            }else if(a == 2){
                                clearConsole();
                                updateItemCat();
                                clearConsole();
                            }else if(a == 3){
                                clearConsole();
                                deleteItemCat();
                                clearConsole();
                            }else if(a == 4){
                                clearConsole();
                                break;
                            }
                        }
                    }else if(z == 2){
                        clearConsole();
                        addItem();
                        clearConsole();
                    }else if(z == 3){
                        clearConsole();
                        itemSupWise();
                        clearConsole();
                    }else if(z == 4){
                        clearConsole();
                        viewItem();
                        clearConsole();
                    }else if(z == 5){
                        clearConsole();
                        rankItem();
                        clearConsole();
                    }else if(z == 6){
                        clearConsole();
                        break;
                    }
                }
            }else if(x == 4){
                clearConsole();
                loginPage();
                clearConsole();
            }else if(x == 5){
                return;
            }else{
                clearConsole();
                System.out.println("Invalid Output ! ");
                clearConsole();
            }
        }
    }
}


