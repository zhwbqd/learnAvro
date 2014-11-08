package me.faolou.avro.bytes;

import me.faolou.avro.User;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.DirectBinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Apache avro data bytes serializing example
 * Created by Walter on 9/24/14.
 */
public class AvroWriteExample {


    public static void main(String[] args) throws Exception{
        FileOutputStream fos = FileUtils.openOutputStream(new File("james.avro"));
        User user = User.newBuilder()
                .setName("James")
                .setFavoriteNumber(10)
                .setFavoriteColor("Black")
                .build();

        DatumWriter<User> datumWriter = new SpecificDatumWriter<User>(User.class);
        BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(fos, null);
        datumWriter.write(user,binaryEncoder);
        binaryEncoder.flush();

        IOUtils.closeQuietly(fos);
    }
}
