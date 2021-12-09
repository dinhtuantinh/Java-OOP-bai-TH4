/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller5_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class FileIO {
    public static void readToList(ArrayList list,String file){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));) {
            Object object;
            while((object=ois.readObject())!=null){
                list.add(object);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    
    public static void writeToFile(ArrayList list,String file){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));) {
            for(Object object:list){
                oos.writeObject(object);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
}
