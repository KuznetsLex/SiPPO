package org.kuzne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileInput {
    public static List<Double> fileInput(String pathName) throws FileNotFoundException {
        List<Double> input = new ArrayList<>();
        try {
            
            File Obj = new File(pathName);
            if (!Obj.exists() || Obj.isDirectory()) { throw new FileNotFoundException("ERROR: Файл с таким именем не найден.");} 
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                double data = Reader.nextDouble();
                input.add(data);
            }
            Reader.close();
            if (input.size() != 5) { throw new ArrayIndexOutOfBoundsException("ERROR: В файле ожидалось 5 параметров.");}
            
        }
        
        catch (FileNotFoundException e) {
            System.err.println("ERROR: Файл с таким именем не найден.");
            e.printStackTrace();
            throw e;
        }
        catch (InputMismatchException e){
            System.err.println("ERROR: В файле допустимы только дробные числа.");
            e.printStackTrace();
            throw e;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("ERROR: В файле ожидалось 5 параметров.");
            e.printStackTrace();
            throw e;
        }
        return input;
    }
}