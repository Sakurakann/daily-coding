import java.io.UnsupportedEncodingException;
import org.sknn.domian.User;

/**
 * Created with IntelliJ IDEA. Project: daily-coding. Package: PACKAGE_NAME.
 * User: Administrator. Date: 2018-03-01 09:39. Author: Haiyangp.
 */
public class SystemTest {

  public static void main(String[] args) throws UnsupportedEncodingException {
   /* Properties properties = System.getProperties();
    Set<Entry<Object, Object>> entries = properties.entrySet();*/
    byte[] bytes = "".getBytes("utf-8");
    System.out.println(bytes.length);
    for (byte aByte : bytes) {
      System.out.println(aByte);
    }
    String decode = new String(bytes);
    System.out.println(decode.length());
    String trim = " ".trim();
    System.out.println(trim.length());

    User sknn = new User(1, "sknn");
    String s = String.valueOf(sknn);
    System.out.println(s);

  }
}
