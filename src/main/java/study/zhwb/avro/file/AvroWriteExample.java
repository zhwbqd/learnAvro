package study.zhwb.avro.file;

import study.zhwb.avro.User;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;

/**
 */
public class AvroWriteExample {

    public static void main(String[] args) throws Exception {
        User user = User.newBuilder()
                .setName("Lily")
                .setFavoriteColor("Red")
                .setFavoriteNumber(11).build();

        DatumWriter<User> datumWriter = new SpecificDatumWriter<User>();
        // save user into a file
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(datumWriter);
        Schema schema = User.getClassSchema();

        dataFileWriter.create(schema, new File("lily.avro"));
        dataFileWriter.append(user);
        dataFileWriter.close();
    }

}
