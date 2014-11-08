package me.faolou.avro.file;

import me.faolou.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;

/**
 * Apache avro file deserializing example.
 * Avro data file contains avro schema
 * <p/>
 * Created by Walter on 9/24/14.
 */
public class AvroReadExample {

    public static void main(String[] args) throws Exception {
        DatumReader<User> datumReader = new SpecificDatumReader<User>();
        // read user from a file
        DataFileReader<User> dataFileReader = new DataFileReader<User>(new File("walter.avro"),datumReader);

        while (dataFileReader.hasNext()) {
            User user = dataFileReader.next();
            System.out.println(user.getName());
            System.out.println(user.getFavoriteColor());
            System.out.println(user.getFavoriteNumber());
        }
    }

}
