package org.phoenix.node.compiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;
 /**
  * 将字符串映射到内存，用于编译对象
  * @author mengfeiyang
  *
  */
public class JavaClassObject extends SimpleJavaFileObject {
 
    protected final ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
 
    public JavaClassObject(String name, JavaFileObject.Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/')
            + kind.extension), kind);
    }
 
 
    public byte[] getBytes() {
        return bos.toByteArray();
    }
 
    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}