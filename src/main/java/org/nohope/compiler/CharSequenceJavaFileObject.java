package org.nohope.compiler;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;

/**
 * @author <a href="mailto:ketoth.xupack@gmail.com">Ketoth Xupack</a>
 * @since 2014-04-14 20:16
 */
class CharSequenceJavaFileObject extends SimpleJavaFileObject {

    /**
     * CharSequence representing the source code to be compiled
     */
    private final CharSequence content;

    /**
     * This constructor will store the source code in the
     * internal "content" variable and register it as a
     * source code, using a URI containing the class full name
     *
     * @param className name of the public class in the source code
     * @param content source code to compile
     */
    CharSequenceJavaFileObject(final String className, final CharSequence content) {
        super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }

    /**
     * Answers the CharSequence to be compiled. It will give
     * the source code stored in variable "content"
     */
    @Override
    public CharSequence getCharContent(final boolean ignoreEncodingErrors) {
        return content;
    }
}
