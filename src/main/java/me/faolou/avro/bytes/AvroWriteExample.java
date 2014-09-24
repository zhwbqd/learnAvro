package me.faolou.avro.bytes;

import me.faolou.avro.User;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.DirectBinaryEncoder;
import org.apache.avro.specific.SpecificDatumWriter;

/**
 * Apache avro data bytes serializing example
 * Created by zhangkai on 9/24/14.
 */
public class AvroWriteExample {

    public static void main(String[] args) {
        User user = User.newBuilder()
                .setName("James")
                .setFavoriteNumber(10)
                .setFavoriteColor("Black")
                .build();

        DatumWriter<User> datumWriter = new SpecificDatumWriter<User>();
    }
}
