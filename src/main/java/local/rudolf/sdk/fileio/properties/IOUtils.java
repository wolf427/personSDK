package local.rudolf.sdk.fileio.properties;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {
	
	public static void closeQuietly(RandomAccessFile is){
		if (is!=null) {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}
	public static void closeQuietly(InputStream is){
		if (is!=null) {
			try {
				is.close();
			} catch (Exception e) {
			}
		}
	}
	public static void closeQuietly(Reader r){
		if (r!=null) {
			try {
				r.close();
			} catch (Exception e) {
			}
		}
	}
	
	public static void closeQuietly(OutputStream os){
		if (os!=null) {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
	}
	public static void closeQuietly(Writer r){
		if (r!=null) {
			try {
				r.close();
			} catch (Exception e) {
			}
		}
	}
}
