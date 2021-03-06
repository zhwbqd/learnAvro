package study.zhwb.avro.console;

import study.zhwb.avro.User;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 */
public class AvroBinaryWriteExample {


    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        User user = User.newBuilder()
                .setName("James")
                .setFavoriteNumber(10)
                .setFavoriteColor("Black")
                .build();

        DatumWriter<User> datumWriter = new SpecificDatumWriter<>(User.class);
        BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(fos, null);
        datumWriter.write(user, binaryEncoder);
        binaryEncoder.flush();

        System.out.println(fos.toString());

        IOUtils.closeQuietly(fos);
    }
}
