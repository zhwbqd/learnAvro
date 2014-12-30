package study.zhwb.avro.bytes;

import study.zhwb.avro.User;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

/**
 * Apache avro data bytes serializing example
 * Created by Walter on 9/24/14.
 */
public class AvroWriteJSONExample {


    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        User user = User.newBuilder()
                .setName("James")
                .setFavoriteNumber(10)
                .setFavoriteColor("Black")
                .build();

        DatumWriter<User> datumWriter = new SpecificDatumWriter<User>(User.class);
        JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(User.getClassSchema(), fos);
        datumWriter.write(user, jsonEncoder);
        jsonEncoder.flush();

        System.out.println(fos.toString());

        IOUtils.closeQuietly(fos);
    }
}
