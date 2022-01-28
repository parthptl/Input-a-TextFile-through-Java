/**
 *
 * @author Parth
 */
import java.io.*;
import java.util.*;

public class P06 
{
private int number = 0;
private int lineNr = 0;
private int columnNr = 0;
private int data = 0;
public static List <String> inputArray = new ArrayList <String>();
  
  	P06() {}
  
  	public void setnumber(int newValue) { number = newValue; }
  
  	public int getnumber() { return number; }
  
  	public void setlineNr(int newValue) { lineNr = newValue; }
  
 	public int getlineNr() { return lineNr; }
  
  	public void setcolumnNr(int newValue) { columnNr = newValue; }
  
  	public int getcolumnNr() { return columnNr; }
  
  	public void setdata(int newValue) { data = newValue; }
  
  	public int getdata() { return data; }
  
public static void main(String[] args) 
{
    		P06 nC = new P06();
   		int n = 0; // char counter
int linecount = 1;
int ascii = 0;
int CurrentLine;
int colcount = 0;
    		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) 
{
      			while ((CurrentLine = br.read()) != -1) 
{
        				char character = (char) CurrentLine;
       				ascii = (int) character;
        
if (CurrentLine == 10)
{ 
         					linecount++; 
                   				n--;
        				}
if (CurrentLine == 13 || CurrentLine == 10)
{
          					colcount = 0;
        				}
        				else
{
          					colcount++;
        				}
        				n++; // char counter, increments for each ascii char found
       				nC.setnumber(n);
        				nC.setlineNr(linecount);
        				nC.setcolumnNr(colcount);
nC.setdata(ascii);
toSQL(nC.getnumber(), nC.getlineNr(), nC.getcolumnNr(), nC.getdata());
}
} 
catch (IOException e) 
{
e.printStackTrace();
    		}
  	}
  
public static void toSQL(int number, int line, int column, int value)
{
   		String s = "";
   		char Asciival = (char) value;
s = ("insert into t1 values " + "(" + number + "," + line + "," + column + ",'" + Asciival + "');");
inputArray.add(s);
    		toTxt();
  	}
  	public static void toTxt()
{
    		try
{ //create an print writer for writing to a file
PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
out.println("create table t1 (number integer, line integer, column integer, character text);");
      			String temp1 = "";
for (int i = 0; i < inputArray.size(); i++)
{
        				temp1 = inputArray.get(i);
        				out.println(temp1);
}
out.println("select * from t1;");
out.println(".quit");
//close the file
out.close();
}
    		catch(IOException e1)
{
      			System.out.println("Error!");
}
System.out.println("Success! ");
}
}
