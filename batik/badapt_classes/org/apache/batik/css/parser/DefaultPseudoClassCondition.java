package org.apache.batik.css.parser;
public class DefaultPseudoClassCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    public DefaultPseudoClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          value);
        this.
          namespaceURI =
          namespaceURI;
    }
    public short getConditionType() { return SAC_PSEUDO_CLASS_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return null; }
    public boolean getSpecified() { return false; }
    public java.lang.String toString() { return ":" + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wUx3nujN9v84wBY4wh4pG7kAYiakIDxgaTs7EwoNYk" +
                                                              "HHN7c77Fe7vL7px9duo0QamgqUoJJUAr4l9EJIgAqholVRpElKZJlLRSEtqE" +
                                                              "ViFVW6m0KWpQ1bQqbdNvZvb2dQ9qqamlnd2b+b5vvvf3zfjsdVRqGqiFqDRE" +
                                                              "x3RihrpU2o8Nk8Q7FWya22EuKh0vwX/Zfa1vTRCVDaK6JDZ7JWySbpkocXMQ" +
                                                              "zZdVk2JVImYfIXGG0W8QkxgjmMqaOohmymZPSldkSaa9WpwwgJ3YiKBGTKkh" +
                                                              "x9KU9FgEKJofAU7CnJPwev9yRwTVSJo+5oDPcYF3ulYYZMrZy6SoIbIXj+Bw" +
                                                              "mspKOCKbtCNjoOW6powNKRoNkQwN7VVWWSrYElmVo4K2C/Wf3jycbOAqmI5V" +
                                                              "VaNcPHMbMTVlhMQjqN6Z7VJIytyHHkYlEVTtAqaoPZLdNAybhmHTrLQOFHBf" +
                                                              "S9R0qlPj4tAspTJdYgxRtNBLRMcGTllk+jnPQKGCWrJzZJC21ZZWSJkj4pPL" +
                                                              "w0eP7274fgmqH0T1sjrA2JGACQqbDIJCSSpGDHN9PE7ig6hRBWMPEEPGijxu" +
                                                              "WbrJlIdUTNNg/qxa2GRaJwbf09EV2BFkM9IS1QxbvAR3KOtXaULBQyDrLEdW" +
                                                              "IWE3mwcBq2RgzEhg8DsLZdqwrMYpWuDHsGVsvx8AALU8RWhSs7eapmKYQE3C" +
                                                              "RRSsDoUHwPXUIQAt1cABDYqaCxJlutaxNIyHSJR5pA+uXywBVCVXBEOhaKYf" +
                                                              "jFMCKzX7rOSyz/W+tYceUjerQRQAnuNEUhj/1YDU4kPaRhLEIBAHArFmWeQY" +
                                                              "nvXywSBCADzTByxgXvjqjftWtFx6Q8DMzQOzNbaXSDQqnYrVvTOvc+maEsZG" +
                                                              "ha6ZMjO+R3IeZf3WSkdGhwwzy6bIFkPZxUvbfvKVR86Qj4OoqgeVSZqSToEf" +
                                                              "NUpaSpcVYmwiKjEwJfEeVEnUeCdf70Hl8B2RVSJmtyYSJqE9aJrCp8o0/htU" +
                                                              "lAASTEVV8C2rCS37rWOa5N8ZHSFUDg+qgWceEn/8TdHecFJLkTCWsCqrWrjf" +
                                                              "0Jj8ZhgyTgx0mwzHwOuHw6aWNsAFw5oxFMbgB0liLUimySITEmF4I0ngtEL7" +
                                                              "TZKOa9yiEFVxroAQ8zn9/7pbhsk+fTQQALPM8ycFBeJps6bEiRGVjqY3dN04" +
                                                              "F31LOBwLEktrFN0DDIQEAyHOQAgYCAkGQkUYQIEA33cGY0S4AhhyGFIC5OSa" +
                                                              "pQMPbtlzsK0EfFAfnQZWYKBtntrU6eSNbLKPSuebascXXl35ahBNi6AmLNE0" +
                                                              "VlipWW8MQRKThq04r4lB1XKKR6ureLCqZ2gSiUPuKlRELCoV2ggx2DxFM1wU" +
                                                              "sqWNBXG4cGHJyz+6dGL00Z1fuzOIgt56wbYshVTH0PtZlrezebs/T+SjW3/g" +
                                                              "2qfnj01oTsbwFKBs3czBZDK0+T3Dr56otKwVPx99eaKdq70SMjrFEIGQLFv8" +
                                                              "e3gSUkc2uTNZKkDghGaksMKWsjquoklDG3VmuMs28u8Z4BbVLEKXwLPYCln+" +
                                                              "ZquzdDbOFi7O/MwnBS8e9w7oT33wsz98gas7W2fqXQ3CAKEdrtzGiDXxLNbo" +
                                                              "uO12gxCA+/BE/3eevH5gF/dZgFiUb8N2NnZCTgMTgpq//sa+Kx9dPXU56Pg5" +
                                                              "heKejkGPlLGFZPOoqoiQsNsShx/IjQpkDOY17TtU8E85IeOYQlhg/bN+8crn" +
                                                              "/3SoQfiBAjNZN1pxawLO/G0b0CNv7f5bCycTkFhtdnTmgImEP92hvN4w8Bjj" +
                                                              "I/Pou/O/+zp+CkoHpGtTHic8Awe5DoJc8jnQqnFMVoZDogyz+dXcpKs4zJ18" +
                                                              "vJupg2MivraGDYtNd2h4o8/VYUWlw5c/qd35ycUbXBZvi+b2hF6sdwjnY8OS" +
                                                              "DJCf7U9dm7GZBLi7L/U90KBcugkUB4GiBGna3GpAIs14/MaCLi3/5Suvztrz" +
                                                              "TgkKdqMqRcPxbsxDEFWC7xMzCTk4o3/pPmH60QoYGrioKEf4nAmm/gX5DduV" +
                                                              "0ik3xfiLs3+w9vTkVe6DuqAx18658zw5lzf6Ttifee+en59+4tioaBWWFs51" +
                                                              "Prw5/9iqxPb/5u85KudZLk8b48MfDJ892dy57mOO76Qbht2eyS1lkLId3LvO" +
                                                              "pP4abCt7LYjKB1GDZDXWO7GSZkE8CM2kme22ofn2rHsbQ9EFddjpdJ4/1bm2" +
                                                              "9Sc6p4TCN4Nm37W+3FbHTNgGT6sV9q3+3BZA/ON+jnI7H5ex4Y5sKqnUDY0C" +
                                                              "lyTuyya1RchSVMPYM6Gmkx3benjMiSzKxi+yISLI3ZvPK8XS7WxYbm/K/8r8" +
                                                              "rZU7hTluh1hszS/U/fLO/dT+o5PxrU+vFI7X5O0ou+DA9Nwv/vV26MSv38zT" +
                                                              "sFRSTb9DISNEce3Jjr7zPa7eyw8Gjt98WHfktz9sH9owlc6CzbXcondgvxeA" +
                                                              "EMsKR4+fldf3/7F5+7rknik0CQt86vSTfLb37JublkhHgvwUJBw65/TkRerw" +
                                                              "unGVQeC4p273OPMi2wEamWEXwhOyHCCUv1Dn8R27/BVCLVIKSJE1Xk32QJUZ" +
                                                              "ItRuS3mn4Wk1mZEH0jET2kI5BTAj1lnqrv490sH2/t8JH7wtD4KAm/lM+Fs7" +
                                                              "39/7NrdWBXMPW0cu1wA3cjU4DUL4z+AvAM+/2cP4ZhPsDZmo0zoYtdonI5a8" +
                                                              "i2ZhnwDhiaaPhk9ee04I4E+5PmBy8Ojjn4UOHRUBJY7Xi3JOuG4cccQW4rBB" +
                                                              "YdwtLLYLx+j+/fmJl56ZOBC0rPRlCsGZ1Axq2zBgF6cZXqULTjd+o/5Hh5tK" +
                                                              "uiFQe1BFWpX3pUlP3Ous5WY65rKCcx53XNfimWmcosCybGXk6Q8XSX//RVFm" +
                                                              "E506n3/A9vKmbICstrx89dQDpBBqkSDYX2TtMTZMQBsEAdLnrwiONh7+vLTR" +
                                                              "As86S6R1U9dGIdQiEn+7yNoTbHgciiNoI6JJWOmz/Mmlim9+DqqYztYWwNNt" +
                                                              "ydM9dVUUQi0i7skia5NsOC5UMaATCc4HRNyhyVaks5fq+oajYHlM0xSCVX8c" +
                                                              "s5+jruA68Xm5UzM8vZYieqeuw0KoRfR0rsjaBTY8S1EF1VxnG0cNZ/4XashQ" +
                                                              "NLfIHQw7HszJuQwWF5jSucn6itmTO97nDY99yVgDNSyRVhR3A+v6LtMNkpC5" +
                                                              "gDWindX560VgpMhFETv08g8uyAsC5yWKZuTDoagERjfkRSjifkgoG/zthnuF" +
                                                              "oioHDjYVH26QHwN1AGGfr+nZc+jqYndc66HSG9AP2v+ksNWbCXi7Wtu2M29l" +
                                                              "W1cjvMhTz/kFf7bkpcUVf1Q6P7ml76Ebq58W1xiSgsfHGZVqKHTiRsXuAxcW" +
                                                              "pJalVbZ56c26C5WLs/W3UTDsxMdclxN3QvzqzIuafWd8s90+6l85tfbiTw+W" +
                                                              "vQudwy4UwBRN35V7isroaWjAd0VyCzr0zPzyoWPp98bWrUj8+Vf8nIpyTqd+" +
                                                              "+Kh0+fSD7x2Zc6oliKp7UCm0FiTDj3cbx9RtRBoxBlGtbHZlgEWgImPF0y3U" +
                                                              "MYfHLC65Xix11tqz7BKMorbcDij36hDO9KPE2KCl1TgjA/1GtTPj+c+DFURV" +
                                                              "aV33ITgzri5xRCRYZg3w2mikV9ezDWL5Jp2ngNH82ZaNH/BPNlz5D+CPVcT8" +
                                                              "GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
