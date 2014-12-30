package study.zhwb.avro.console;

import study.zhwb.avro.User;
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
public class AvroBinaryReadExample {

    public static void main(String[] args) throws Exception {
        // Use a file as a binary stream data source
        FileInputStream fis = FileUtils.openInputStream(new File("sam.avro"));

        DatumReader<User> datumReader = new SpecificDatumReader<User>(User.class);
        BinaryDecoder binaryDecoder = DecoderFactory.get().binaryDecoder(fis, null);
        User user = datumReader.read(null, binaryDecoder);

        System.out.println(user);

        IOUtils.closeQuietly(fis);
    }
}
