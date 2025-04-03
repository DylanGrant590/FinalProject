import java.nio.file.*;
import java.util.Scanner;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;

public class FileOut
{
public static void main(String[] args)
{
String path = "C:\\Users\\harve\\fileout.txt";
Path file = Paths.get(path);

String name;

Scanner object = new Scanner(System.in);

System.out.println("Please enter an account name: "); //Ask user to enter an account name.
name = object.nextLine();

System.out.println("\n" + name + " has created a new account.");
object.close();

byte[] data = name.getBytes();

OutputStream output = null;
try
{
output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));

output.write(data);
output.flush(); //Flush() is used on both objects to ensure that all of the data has been written successfully before closing them off.
output.close();
System.out.println("\nThe file was written correctly."); //Displays a message to the user that the file was written correctly. 
}
catch(Exception e)
{
System.out.println("Message: " + e);
}
}
}
