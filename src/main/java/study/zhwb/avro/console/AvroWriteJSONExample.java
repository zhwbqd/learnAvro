package study.zhwb.avro.console;

import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import study.zhwb.avro.User;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

/**
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

        String string = fos.toString();
        System.out.println(string);

        JsonDecoder jsonDecoder = DecoderFactory.get().jsonDecoder(User.getClassSchema(), string);
        DatumReader<User> datumReader = new SpecificDatumReader<User>(User.class);
        User read = datumReader.read(user, jsonDecoder);

        System.out.println(read);

        IOUtils.closeQuietly(fos);
    }
}
