package designpatterns.decorator.io;

import java.io.FilterInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author james reall008@163.com  10/11/2018
 */
public class LowerCaseInputStream extends FilterInputStream {


    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }


    @Override
    public int read() throws IOException {
        int c = in.read();
        System.out.println(Character.toLowerCase((char) c));
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
        int result = in.read(b, offset, length);
        for (int i = 0; i < offset + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }

}
