package me.faolou.avro.bytes;

import me.faolou.avro.User;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * Apache avro data bytes deserializing example
 * Created by zhangkai on 9/24/14.
 */
public class AvroReadExample {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = FileUtils.openInputStream(new File("sam.avro"));

        DatumReader<User> datumReader = new SpecificDatumReader<User>(User.class);
        BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(fis, null);
        User user = datumReader.read(null, binaryDecoder);

        System.out.println(user);

        IOUtils.closeQuietly(fis);
    }
}
