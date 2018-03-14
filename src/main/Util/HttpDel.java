package main.Util;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

/**
 * Created by orvillelim on 14/03/2018.
 */
public class HttpDel extends HttpEntityEnclosingRequestBase {

    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpDel(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public HttpDel(final URI uri) {
        super();
        setURI(uri);
    }

    public HttpDel() {
        super();
    }
}
