package org.apache.batik.svggen;
public class SVGGraphicContext implements org.apache.batik.util.SVGConstants, org.apache.batik.svggen.ErrorConstants {
    private static final java.lang.String[] leafOnlyAttributes = { SVG_OPACITY_ATTRIBUTE,
    SVG_FILTER_ATTRIBUTE,
    SVG_CLIP_PATH_ATTRIBUTE };
    private static final java.lang.String[] defaultValues = { "1",
    SVG_NONE_VALUE,
    SVG_NONE_VALUE };
    private java.util.Map context;
    private java.util.Map groupContext;
    private java.util.Map graphicElementContext;
    private org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack;
    public SVGGraphicContext(java.util.Map context, org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (context ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          context =
          context;
        this.
          transformStack =
          transformStack;
        computeGroupAndGraphicElementContext(
          );
    }
    public SVGGraphicContext(java.util.Map groupContext, java.util.Map graphicElementContext,
                             org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (groupContext ==
              null ||
              graphicElementContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          groupContext =
          groupContext;
        this.
          graphicElementContext =
          graphicElementContext;
        this.
          transformStack =
          transformStack;
        computeContext(
          );
    }
    public java.util.Map getContext() { return context;
    }
    public java.util.Map getGroupContext() {
        return groupContext;
    }
    public java.util.Map getGraphicElementContext() {
        return graphicElementContext;
    }
    public org.apache.batik.ext.awt.g2d.TransformStackElement[] getTransformStack() {
        return transformStack;
    }
    private void computeContext() { if (context !=
                                          null)
                                        return;
                                    context =
                                      new java.util.HashMap(
                                        groupContext);
                                    context.
                                      putAll(
                                        graphicElementContext);
    }
    private void computeGroupAndGraphicElementContext() {
        if (groupContext !=
              null)
            return;
        groupContext =
          new java.util.HashMap(
            context);
        graphicElementContext =
          new java.util.HashMap(
            );
        for (int i =
               0;
             i <
               leafOnlyAttributes.
                 length;
             i++) {
            java.lang.Object attrValue =
              groupContext.
              get(
                leafOnlyAttributes[i]);
            if (attrValue !=
                  null) {
                if (!attrValue.
                      equals(
                        defaultValues[i]))
                    graphicElementContext.
                      put(
                        leafOnlyAttributes[i],
                        attrValue);
                groupContext.
                  remove(
                    leafOnlyAttributes[i]);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUaDXAU1fndhYSQ/wT5lQQIARrQnCD+Rq0QSYheICWYmQYk" +
       "bPbeXRb2dtfdd8kFiz/MOFI7pWpRaVXqTFH8QXEcndb6R8f6N1pnRFtrHZVW" +
       "22qpo9TROrXVft97e7t7u7dHM0Jm9mX3ve977/v/2b39H5FSyyRNVGNtbMyg" +
       "VttKjfVKpkUTHapkWetgblC+tUT6dOMHq8+JkrIBUjMsWT2yZNFOhaoJa4A0" +
       "KprFJE2m1mpKE4jRa1KLmiMSU3RtgExRrO60oSqywnr0BEWAfsmMk3qJMVMZ" +
       "yjDabW/ASGMcKIlxSmLL/cvtcVIl68aYCz7dA97hWUHItHuWxUhdfLM0IsUy" +
       "TFFjccVi7VmTLDZ0dSyl6qyNZlnbZvUMWwQXx88IiKD5odrPv7xhuI6LYLKk" +
       "aTrj7FlrqaWrIzQRJ7Xu7EqVpq3LyZWkJE4qPcCMtMRzh8bg0BgcmuPWhQLq" +
       "q6mWSXfonB2W26nMkJEgRubmb2JIppS2t+nlNMMO5czmnSMDt3McbgWXARZv" +
       "XhzbdevGuodLSO0AqVW0PiRHBiIYHDIAAqXpIWpayxMJmhgg9Roou4+aiqQq" +
       "W21NN1hKSpNYBtSfEwtOZgxq8jNdWYEegTczIzPddNhLcoOyn0qTqpQCXqe6" +
       "vAoOO3EeGKxQgDAzKYHd2SgTtihagpHZfgyHx5ZLAABQJ6YpG9adoyZoEkyQ" +
       "BmEiqqSlYn1geloKQEt1MECTkZmhm6KsDUneIqXoIFqkD65XLAHUJC4IRGFk" +
       "ih+M7wRamunTkkc/H60+b+cV2iotSiJAc4LKKtJfCUhNPqS1NElNCn4gEKsW" +
       "xW+Rpj65I0oIAE/xAQuYX3zv6IWnNB18QcCcXABmzdBmKrNBee9QzauzOlrP" +
       "KUEyyg3dUlD5eZxzL+u1V9qzBkSYqc6OuNiWWzy49rnvXn0fPRIlFd2kTNbV" +
       "TBrsqF7W04aiUrOLatSUGE10k0lUS3Tw9W4yEe7jikbF7Jpk0qKsm0xQ+VSZ" +
       "zp9BREnYAkVUAfeKltRz94bEhvl91iCETISLdMLVTMQf/8/IhtiwnqYxSZY0" +
       "RdNjvaaO/FsxiDhDINvh2BBY/ZaYpWdMMMGYbqZiEtjBMM0tjKRSVIv19Xd1" +
       "mZIx7HhSG1qZcYL3zyJ/k0cjERD9LL/jq+Azq3Q1Qc1BeVdmxcqjDw6+JIwK" +
       "HcGWDCOtcGSbOLKNH9kmjmwLHEkiEX7SSXi0UDCoZws4OkTaqta+yy7etKO5" +
       "BCzLGJ0Aso0CaHNexulwo0EuhA/KBxqqt859Z8kzUTIhThokmWUkFRPIcjMF" +
       "oUneYntv1RDkIjclzPGkBMxlpi7TBESksNRg71Kuj1AT5xk5ybNDLmGha8bC" +
       "00VB+snB3aPX9F91WpRE87MAHlkKAQzRezF2OzG6xe/9hfatve6Dzw/csk13" +
       "40BeWsllwwAm8tDstwW/eAblRXOkRwef3NbCxT4J4jSTwK8gBDb5z8gLM+25" +
       "kI28lAPDSd1MSyou5WRcwYZNfdSd4UZaz+9PArOoRL+bBVe77Yj8P65ONXCc" +
       "Jowa7czHBU8J5/cZd/zhlQ9P5+LOZY9aT9rvo6zdE7FwswYem+pds11nUgpw" +
       "b+/u/fHNH123ntssQMwrdGALjh0QqUCFIOZrX7j8zXff2ft61LHzCIOUnRmC" +
       "yifrMInzpKIIk3DaApceiHgqRAW0mpZLNbBPJalIQypFx/pP7fwlj/5jZ52w" +
       "AxVmcmZ0yrE3cOdnrCBXv7TxX018m4iMGdeVmQsmwvhkd+flpimNIR3Zaw41" +
       "/uR56Q5ICBCELWUr5XE16vh6o+vr6E99mSGLrZVGeWoblDcsrJvacs6nzSLz" +
       "NBWA9eTAnY//amBgYZ0sgJsLbZyf++7ZVy6/lX7ufYEwowCCgJtyT+yH/W9s" +
       "fplbTzmGFJxHgVZ7AgaEHo/p1jlarUEl1sN12Nbq4eOTQwANCjslDbVIbJ2S" +
       "pgksLJGH45RDiu6fBdVNywvTrtLu36Iu//jsu88XYp0bEhld+Me+c/jVO7Ye" +
       "2C9sFcXLyOKwUjhYf2Poml8k/LoG8lnXuQc/fK//MiQMtVODQ7vwv+mMVLv2" +
       "2yNxh+vgS8vQXYXTYnzJNxOx80Xfr33ihoaSToiL3aQ8oymXZ2h3wps0obC0" +
       "MkMeu3ErPj7hNZqv4S8C11d4obHghDCahg67+pnjlD+GkcV1SLSL4NYq7Cbc" +
       "IQWtGyqfe9r6+V8fzknh7PwgOwf88qAwVPGfkY3f0JJQg9Ioi6WWJmKF650T" +
       "fAJKpYiJeISz5+55r1y1Z96fwBYHSLliQRUAfl2g9vbgfLL/3SOHqhsf5EmR" +
       "26+t4vymJdiT5LUaXBe1OPQ4Frk0UGUh7cBoGzAK+UjSLMykvOKxvbOAxc7K" +
       "81PembsZ/b7XzvrdvhtvGRXO2houJB/e9H+vUYe2//kL7rSBAqZA3+HDH4jt" +
       "v31mxwVHOL5bSSB2SzZYl4IeXNyl96U/izaXPRslEwdInWx3wv2SmsH8PACS" +
       "tnLtMXTLeev5nZxoW9qdSmmWv4rxHOuvYbyuPYHluXG90GKE8CCygWMs5OMi" +
       "HE4VyQ9v2xhsqmiSyvFWQU2gUi3Fhq2iqug1ISozZcQOPrFtDe9uuf2DB+wk" +
       "Gaji8oDpjl3Xf922c5cItqIpnhfoS704ojEW8YlTid40t9gpHKPzbwe2PX7P" +
       "tusEVQ35Ld5KLZN+4Pf/fblt9+EXC3QXJeAq+LDWyDr2nCsZbNcQxQZqEdpg" +
       "XaNYt+TWRKuh6G3OKwhYzBbwjMY8z+jh3uia2ds1N733WEtqxXh6DJxrOkYX" +
       "gc+zQSaLwjXsJ+X57X+fue6C4U3jaBdm+zTk3/Lenv0vdi2Qb4rytxzC/gNv" +
       "R/KR2vOtvsKkLGNq+SlsnrB9rj1h+Dgs5obDn09z9EC4HkQSGimyxgeo10tl" +
       "VLSwiyLgVwRmsTidXbjsXZk2GC9Ut/5y2iPn7dvzDq/QjSzxWws+dmX5AWcU" +
       "OfwaHOZb3m4tX7meV3mD8g2vf1Ld/8lTRwNBNL85gWqk3Q0sC3jt5e+mV0nW" +
       "MMAtO7h6Q5168EuevyolGZKNtcaEbj6b18rY0KUT//jrZ6ZuerWERDtJhapL" +
       "iU6Jd4VkErRj1BrW1UTW+PaFohwYLYehjrNKAswHhY4TVwpFNQb7uB67GO4p" +
       "3Me5lhPsjsJQfWop4YSU4OO5zhDn+/+oiAZvxOF6vrQdhx8I1q79RlIQCyfz" +
       "yTJ+3+/wNQMBy+Bqtfma7xeJnUhuLZxIShiZaJjKCNSCkD8s/mIWVwd9jeX0" +
       "3NYFjoC0qFIpuUZTx5w36xZHv8SmvddwqpI6N/SKV6GByMoZNHJ07y2WAAWl" +
       "PDzgsAmHBA53BmM/Pm7GQQ0Gc3zWDb7RnTiwIiq+v8jaAzjci8OYoKII7IFQ" +
       "dYeED9e2uWntPpZpFTCSmK3BxSFG8kiIkeDtbTjcHmYbi0N2hsYoQZNSRhUV" +
       "FEf8mY+TR/9/Tqpy5y2xz1sSwskThTnhorzNR39lkf3APWTRCzhRwEP5k+Ok" +
       "vBGupfZJS0Mo/40bvp4O0hmGzUhVytQzRkc4sc+Ok9gFcJ1uH3d6CLEvFSU2" +
       "DJuRKSnRZ9l9RxGqXx4n1XjWMvvcZSFUHypKdRg2IzUsr2nC2biP3NeKkJst" +
       "lJj4H/pm3kcCz7Ge4O/Ur82B1o4n5r7+LufLXg50Qdi79pWmqZsOOJYFjWFf" +
       "iHhJvnf7rj2JNXctyXX+SQZ5XjdOVekIVQMZSncYrEV+MAJttBnc6NeKK8Kw" +
       "pB2GWiS8flhk7QgO7zNSkaJ5pueq8S/HI28XEkQTXNTmho5fEGGoRZj9vMja" +
       "FzgchXoRBNHlDx+uNP55oqSxEC7VZkkdvzTCUMM5jpQUWSvFya8Ymc6lERaf" +
       "XLF8fQLEMg/XEMyyebPGL5Yw1CKs1xVZa8ChkpF6EMu6YAB05BGpOgHy4DF9" +
       "LkLZTI0eQx4FAnoYahGeG4uszcYBImsNfkuGUtc2Dg4r4bBKMAcF9YQRXUm4" +
       "AppxogR0FlxX2VxeNX4BhaEWEcKpRdZiOHyLkRZbQDyyLNcSYT4VmeuKqPW4" +
       "NExgrIFPydjHTw/8UkX8ukJ+cE9t+bQ9l74h3sLmfgFRFSflyYyqel/Wee7L" +
       "DJMmFS7fKtFh8xYichYj00KyLvZY/AZJj5wp4M+FrsgPz0gp/++FOx8ylgsH" +
       "W4kbL8iFjJQACN4uN3IlgKflEu8ssxFPvrbFyCPalGNJ30HxfrnEdxT8l0K5" +
       "l0WZXvvjzIE9F6++4uiZd4kvp7Iqbd2Ku1TGyUTxEZdvWhL40OPdLbdX2arW" +
       "L2semjQ/V3/UC4Jd6z7Zk9iuhFLfQI3P9H1WtFqcr4tv7j3vqd/uKDsUJZH1" +
       "JCIxMnl98O1u1shAYbQ+Hvxu0y+Z/Htne+tPxy44JfnxW/zlDwm8NffDD8qv" +
       "77vstZum722KkspuUgqlFc3y184XjWlrqTxiDpBqxVqZBRJhF0VS8z4K1aBx" +
       "Stg4c7nY4qx2ZvG7OxSIwZeywV8rVKj6KDVX6BmN98zVcVLpzgjN+N7ZZQzD" +
       "h+DO2KrEsVNEQdQG2ONgvMcwch+hKt40uJN2Ob7r73Ej6/gt3l36P/UtId9F" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7eawr13kf33vat/ckL5JVS3qSnmzLk9zhMuSQfolrLkNy" +
       "yOGQwyE55DjS8+wznH1fXEWO08ZuU7huIyduGwto4XRxFTtoE7RF60JF0CZp" +
       "ggAOgnQBGrsLULuuEfuPOEXdND0zvPt990qKnQvM4cw53znfcr7vd76Zc+5r" +
       "3yrd6XslyLGNVDHsYE9Kgr2tUd8LUkfy90ZEfcZ5viR2Dc73F6DulvDML139" +
       "7vc+rV67XLqLLb2Nsyw74ALNtvy55NtGJIlE6epRLWZIph+UrhFbLuLgMNAM" +
       "mND84CZRuv9Y16B0gzgQAQYiwEAEuBABbh9RgU4PSlZodvMenBX4bunHS5eI" +
       "0l2OkIsXlJ4+OYjDeZy5P8ys0ACMcE/+vAJKFZ0Tr3T9UPedzmcU/gwEv/Jz" +
       "L177x1dKV9nSVc2ic3EEIEQAmLClB0zJ5CXPb4uiJLKlhy1JEmnJ0zhDywq5" +
       "2dIjvqZYXBB60qGR8srQkbyC55HlHhBy3bxQCGzvUD1Zkwzx4OlO2eAUoOs7" +
       "j3TdadjP64GC92lAME/mBOmgyx26ZolB6anTPQ51vDEGBKDr3aYUqPYhqzss" +
       "DlSUHtnNncFZCkwHnmYpgPROOwRcgtLj5w6a29rhBJ1TpFtB6bHTdLNdE6C6" +
       "tzBE3iUoveM0WTESmKXHT83Ssfn5Fvkjn/qoNbQuFzKLkmDk8t8DOj15qtNc" +
       "kiVPsgRp1/GB9xM/y73zy5+8XCoB4necIt7R/NO/8J0P/dCTr//6jubP3YZm" +
       "ym8lIbglfJ5/6Cvv7j7fupKLcY9j+1o++Sc0L9x/tt9yM3FA5L3zcMS8ce+g" +
       "8fX5v9187AvSNy+X7sNLdwm2EZrAjx4WbNPRDMkbSJbkcYEk4qV7JUvsFu14" +
       "6W5wT2iWtKudyrIvBXjpDqOoussunoGJZDBEbqK7wb1myfbBvcMFanGfOKVS" +
       "6W5wlfrgeqa0+yt+g9KPwaptSjAncJZm2fDMs3P9fViyAh7YVoV54PU67Nuh" +
       "B1wQtj0F5oAfqNJBQ6QokgXTq8HA4xz1MJL2ci9z/ozHT3L9rsWXLgHTv/t0" +
       "4BsgZoa2IUreLeGVsIN954u3fvPyYSDsWyYoPQ9Y7u1Y7hUs93Ys986wLF26" +
       "VHB6e856N8FgenQQ6AACH3iefmH0kU8+cwV4lhPfAWx7GZDC5yNx9wga8AIA" +
       "BeCfpdc/G//E6uXy5dLlk5Caiwuq7su7z3IgPAS8G6dD6XbjXv3E17/7pZ99" +
       "yT4KqhMYvR/rZ3vmsfrMacN6tiCJAP2Ohn//de5Xbn35pRuXS3cAAACgF3DA" +
       "SQGePHmax4mYvXmAf7kudwKFZdszOSNvOgCt+wLVs+OjmmLGHyruHwY2vj93" +
       "4neD6+a+Vxe/eevbnLx8+85D8kk7pUWBrz9KO5/7D7/9jVph7gMovnpscaOl" +
       "4Oax8M8Hu1oE+sNHPrDwJAnQ/efPzn7mM9/6xIcLBwAUz96O4Y287IKwB1MI" +
       "zPyXft39j1/9/c//7uVDp7kUgPUv5A1NSA6VzOtL912gJOD2niN5AHwYIMRy" +
       "r7mxtExb1GSN4w0p99L/e/W5yq/8r09d2/mBAWoO3OiH3niAo/p3dUof+80X" +
       "/+jJYphLQr58HdnsiGyHiW87GrnteVyay5H8xO888Td/jfscQFeAaL6WSQVI" +
       "XT4MnKfPCZw5FxdrxS3hn1Nf+8rnsi+9tlOF5wAYlqDz0o6zmU/u2c9dEJ1H" +
       "C9IfDj7w+jf+2+qFfJJya91/ODFP5PNw/SLvK0jfEZQePLLBhCva6v6F/AtL" +
       "7fi/+vee/e2XX332vwBF2dI9mg+ynban3GYRPdbn26999Zu/8+ATXywCsjBO" +
       "zvO+09nH2eTiRM5QqPvAyWAD6l5+faft7jcovfh9Qnw+VVwcwEpVhG+/iPwZ" +
       "czicpuqZtSAnAT33QE8Q6Jzl5xAFUkZBz1NhaT9r3csjdxe/YFqfP39a+7n1" +
       "j3Dzsf8zNfiP/9f/XfjwGbi/Tcpzqj8Lv/bzj3c/+M2i/xHu5r2fTM4uicBz" +
       "jvpWv2D+4eVn7vo3l0t3s6Vrwn4SvuKMMEczFviGf5CZg0T9RPvJJHKXMd08" +
       "XFfefRrzj7E9jfhHSzG4z6kLN92BfF58ILlUKsIFK3o8XZQ38uK9O6jIb98X" +
       "gEE1izP2IfNPwN8lcP2//MpdNK/Yueoj3f2U6/phzuUA/7rLkCwlUC+eu5mn" +
       "mWAViPbTTfilR76q//zXf3GXSp6eqFPE0idf+St/svepVy4fS+CfPZNDH++z" +
       "S+ILSzyYF3hyAhVvw6Xo0f8fX3rpX/yDlz6xk+qRk+koBt62fvH3/vi39j77" +
       "td+4TSZ0BaBB/tBykkOvPkDk/QDZYXk+7SBlty0pXxYO2nZpkWbvHb4ugcbk" +
       "NvHx/vNtPCnQ58hJf+3j//PxxQfVj7yFfOipUzY6PeQ/nLz2G4P3CH/jcunK" +
       "ocueeZc62enmSUe9z5PAy5+1OOGuT+zctbDfzlfz4rli6orn9x9aolRYYreY" +
       "fOSCNj4vXgDOLeSm3s3MBeRSsvuFL6BR8uIp/3jWeHIOjr2f3xI+/bvffnD1" +
       "7X/1nTPwdDJJAivazaOQvZ476qOnU+Qh56uADnmd/LFrxuvfK9ay+zkBoLU/" +
       "9UCKnpxIqfap77z7P/3rX33nR75ypXS5X7rPsDmxzxXZaelekBZKvgqy+8T5" +
       "8x/aLUfxPaC4VqhaOqN8UfH42bxxsr9yT26fNx5N5Nls7Lyup8x/pZDgSvFc" +
       "Pps6XChAfZcpnOwK55TVN9e1cJriObjAK7K8sIum4o1xP/71N2XZHe1jxdO9" +
       "xf2HDkV9V05xF7ie3xf1udOi7sP7y7eH9ytB6W7H0yKA0wCk/eJLTd46LMTG" +
       "AZ4bEidPLSNtB4Gn8WEA/ClvQg9FeHvO8fEcefZFuLRbCW6dXQk+cN0NOV9z" +
       "QzuQ3rdLwq/veF4vlpfru88lH37h+mTaw26R7QlGX//R65YU77d8lDP5lz68" +
       "t7f3ws3nHecwq7h2BJo7ujOYWFgtLz5xYJC/etF6d8wEeTHOi2le/NRZ5M4f" +
       "l3nBnIXi/JndsS1658WLF/jJz1zQ9pm8+Ot5IewkuYD255LSUXgVHvexN/K4" +
       "2/gUvD+h0Dk+9bfO8an89ifz4i+ecKUHRUnmQmOX4fiH9jgm5N9+80I+kNc+" +
       "Bq7KvpCVc4T8O7cX8lIh5IFodwu7ZPUUEBRMrl7E5CQQHFPl775FVXK4qu5z" +
       "qZ6jyhfejCoPKJ4dOt2L9TmX07n6/KO3qM97wFXb51I7R59/8mb0eYeye53Y" +
       "fxt4A8XOZXmuYr/8FhXLR0b2uSDnKPYv34xiDwUn3nby2tYp2b78hrIVYyWX" +
       "LoEcprqH7pXz51+9ICzfdzYsH90awo0DrF5Jng/yjxtbA82b//IpgfA3LRBI" +
       "UR46QmXCtpSbP/3fP/1bf+3Zr4LMZFS6M8pBAOQkx6CbDPN9gZ967TNP3P/K" +
       "1366+GIDbLb62HN/UPD+d29NrcdztejifZXg/GBSfGSRxFyzYgjimD6zoHQH" +
       "yACVP7W2wSPXhoiPtw/+iCXXW7eXFdkS1Q1NwfGiblAU3p57lNXtQXO3TNEb" +
       "VcK7zMakNjo/46X1nK+KgSyKTb2vZfBk2sdRh3Hm3GrtLvrDJrXGBEvkG/Om" +
       "3CArjjXvB96QXTHVquvYrcV86q1XctBCJTRAQ1QcTsojs2Wua5HUQlE4gqt8" +
       "rTWs9+k0nZOrARnwk1RZBcF4K6/Gjr5cDDlHZ6RA4Y0uFCwXDXE6GbpNaKR7" +
       "eGe5nfjMopqyZH+qcvaIQ9rlseP1R1jVrJjOGEO2c64yJkxtQi9r80DBkrk3" +
       "bZRt2k1jyyt3MKYt++ZEr7mjyWrCptsexzNwmx5MhDFuJLRJELAQBcIKNxpN" +
       "btPNULHdQlVmOcSDYcgkS1WUiUkZ95fpot/fCsJKQ1fmguixZZFOjYabkqxh" +
       "8Wy0nDAxtU6aTVwb9+q26M0iNFFDvEFsiLHOLbwt2jc8l2M8PKPmI3Qdopi7" +
       "ctwakbKMPsIQdyZ0J8FknqlNXil3FMEMZ4xKEa7bMBl6LdtWp8pUG9YEECvz" +
       "kDf56gh3HLoaQJZBTibTupCZFj3pBbWJwCvMuj1no7Wa8aIUDUJbJOhpue2u" +
       "mPJMmw87Gr4Z9oDbuGsHZxwuTSYjU1WU1ty2QwTiNJdymWqFJCvqmHbITSeg" +
       "ZSwOpqySuM0tKTIbTFIWQoZnM1EkVUKwp6lVdheuQ3XXrtSI2vZ0WsOkwTih" +
       "lF47G2+GYpVWFoGmcoozZGUlHSZ1lmi3O9SosXEGLU60U9bG9JTqmJjmurSx" +
       "sSqKZNhjCgsqE6y70FlTNRtjv7e0JNxd23jf1XuN+ppoD5ejLoLPB31dU6EJ" +
       "Gs85M7QWui7Aw0YZ4iFhVdXsgNZGbQEhxuNgJHeXKjlz6QqJGWTXQhRs7DMJ" +
       "A82dbaOOl228jcFJmwo361oWNXDGIjuVJiV0hXW7Y2Zixxx7ZEeSWlTGhdnU" +
       "8GbjJZamSk1cGr26xCYZAYWVVcvNOjq9cYXGNCQ1hslSpOVZ0doqy7M5bvTF" +
       "qr4g+dWi4/luH2XKCKctvSnBBfRygFXKetlY0rVF3GKQFJPQrabzfXTk6GV3" +
       "7JvlhIJWNJs5rc4cszZtfbVsy9LYCOZZC+ExNTJaFa2LLXCaECfEajGhZLgJ" +
       "42qgxZa7SWh2U56L5DbiuCnc9xOtp/ZwMlKrnc4GZrmNw4iTyWSw4V1Ww4Jt" +
       "ZzIpB9vxnF7hUaW1FismiyfoUKUHFZcVNkQtS0ewXha22LzXAhG1daF25tao" +
       "CiVUOtJKNBPB3fbiBjTC4/FQGDC97jQQBjQ/JcbksKWbWzMmhpiuYWuUptda" +
       "ednr2mzsI1N9wbkBB6UpKgXjab3TzYjBqNz27XKXG5JSEhqxXcZCtQ2PO4nr" +
       "Bs16i23q2XKBqwvV1k1mqffnM1zYTvo28JuNFUSVeU/Ht4KRzQZ6Z5IYjoYu" +
       "Ohit++RcQSvjcFtpL+qJXk95skeYA5Vr8t1yedWBfKtT42brVr9VAfCINdFJ" +
       "e2jo4zaVzaWsX51mg0YiwS1V5oJIavSyGBZ8vVJDyh2J8Q0jjttmM+j5QczA" +
       "Ups35uupPo8luUby3WSBjJAtvYjHTaXT4+tZUyEmULWu49Wm0Z71aLEyoVM7" +
       "rDNzId6wpCzSIrJkuQxqzdre1J4TEN9ZSSi62TZnjfqUXHeFkR1zqJANO8vm" +
       "qA4LrAhnqkG1ZnWImLKbFrdoeZHdyEQM7cd+vJFMyBH9SsVaKk7MQ3AIy0Ny" +
       "WKnWrMD3qUnsiYM2sVXLlLvs9vEp663RbTNby3JVDhoVYph18enSmpvdVJO9" +
       "CW5lzhjH9VqPazuCpA0Vd95myqbDEiTfmY04A6dSp5/AzgyVY2ML17dsvRq3" +
       "k5UpmGw59bCaMBUtr9tZR+giWZcrTRPRJgNRWpmUb8aRqouQDObOJPF5jeVi" +
       "pAKH83qDquPdThcjmKVXX2OVRqQ2bCjyGlirZdIDwmNXA4mxeaMn+N4o4gS/" +
       "YWU0kZEdpt2SFm1rA8Oc2VE2bNlXRj7Bs6kMQSi7ShuwsUZDeYPFdtztKqMg" +
       "XUDpEGZavuwY/CIzB/1RMlRWLNpWOGxow05la3DeEjMqPlmpkryLSNMFFbfJ" +
       "7tY3evwK50dV2lF0nxgNhkh93tPChtwRV2QaRwsvIMJaAw9heOuHzeZ645RB" +
       "UBsiNJEgAd6upuhGqnZbfl9YE+l0HC+36kauzmzTaOowYQ+ahrUOKQGWxzA8" +
       "0ahJsJr2KDSKI8icrIioWk3JRIUihW5G1HqzXmysbEQm06RZXsteraapNkcv" +
       "bI2ocVTTTs01W1VrseOXbRAKE30ihTXMm21RlWTdCKGb3UpFRGx+qKi9Lqcq" +
       "DRRyrK3Rgwa6sKrQBE0g5MZFu7yAU0wwSF1ZankNaNWUM91S0VmsTGO52XTb" +
       "8Wo2kPVNTS6PRpTSwm2twTAjc9xv1MsLuT0aOxttJOF0Vofqda+SVthWQ447" +
       "myFNGBo1BxBoVJVWxCsyAKEaPR26qi/XMXNebUABEqXmSNQWdZAjrTtSZTqj" +
       "kL6nl5eDpYoKHXuQtcfQcksTk1SPpuMk4qftREDHzcpMMnmfhXl0nUWeGKlB" +
       "NADBW1XtcNSBpdYQipZgOmBYJ1CP7rRdtl2Dhr0hsg2iWsVM4tVwStR5mu5U" +
       "6YzdGAgurcnUaDWWsJZx69ncN7BYxC0mqcVRlTb9YXPW7tKBRQST9YKQpKhu" +
       "sYnNtFyRNk0mQrxkOA2jDZ+Gs83QCNeDVnkwxprdbqowE78+nWhDDFmlVCuq" +
       "JqrvmhqdRn2GWlaVpVbrq25Vc0OlgtN2xgrUdOb1g57UCkO52utAsT7gtlrT" +
       "7jlbo7aWW9WqUBfwwMUdS5VtGi0j9hZjmhtjoYlIOWiB1Xw8y/hYqs7W6CwI" +
       "fWxF1eqEWB8TLAkhMxmWeSNoQdi6W6PWI6ntQkSPSXte1er6LE8KVEKxLiY6" +
       "ypojNwG0YObjUG0MasCr1U3W4ePtZNPMoK1aCzWuChCKRGs1BgvcZK02eqPE" +
       "m+qbtSJAGUVzRLxd+yNoXUfXkBxKjS6yrG25jmhC2UKvwYRkReVI1KoUj3hp" +
       "kGRdWCGjOTyeV6NpEPljnRiQLkQbvuV1Wt62okI9xa/bfM8qt7IW1kWGOkUP" +
       "NDNNFMmulANjRdCxlhLKKp6bPrDImt/6a1avDrqtZQDX06o2s1AxynouTG3p" +
       "LGFiHxLNdb3NCMupHHPDKcvXTCRYo6a0qpm9plKN5Aohwk1jMY/JDkk06wrj" +
       "6jWq7Hdr26AuQeaqbDGTSTuYoiqAu0qjiYVSlNrGgB2TgcBh/LbBV5repjxe" +
       "LgB+eGyDDSWPAUtzMFI5h9CWjZGIrHTMm28rHY+pLBcMNOP6thpviI2kbj1y" +
       "3PbjobpBFqvY6ZMUj4adBjqYIk5tItUNdeZv/RElM7aDbOglMp3WM7VnQTBk" +
       "a202Sqb9RuRRopo08YqLtuYA6rupnKWLEVSD4JikJp0U6riBbHJoIo2spRoS" +
       "bILTqsZyo+24S9Jdvdf0YRNnVrHY2krrco3c9Ld2t+z2cSdcsoukHtcaCTuM" +
       "mrQZiWLsOniDhOnxqjHopBObJYejMppWmXabMWa9TPHb5rDTrtc65gSemeiA" +
       "osoDoZYxPR6dWwstxjUXippbrp1tBa053dhg7ULxPiVuJKzXkqohYwUzh3X6" +
       "iy5tjmudhO4PmrqG61Iv4BdbYWhueK1MVlV/Y1MsSc/V5aqPyU1zAy3mcAsG" +
       "iXEKvCHJKj4d+/pCXViq7WXkvNYydLnWnjGLeTdT5zE2q+vQVI86g9CR2RFd" +
       "ntgwUuYjB5mWVXOQLdVVGoCEQxcQXwCELaUvjCrhsCY2ugQW9elltTcK52Pa" +
       "mrMtozVPBu46QazKestMokhg6f5ymDpjca5U8Wzp51FY5bVZjZTG+sgPjNEW" +
       "GcKOWdMF8Co0kJApvPSa1U7FRqy6h0JEKBNrpV6mRA1tOYzpsv50OgJzw/Rl" +
       "baiOIktGvW11RK6FIF2vIZpi6+utOF1JOr6iJixtCRsPW0GT9igIOpbQAHzH" +
       "zXHsdKoDRqObsqHqKKVM0YykdW5Ud0LJbdLwEKRBa0ynFmtyYap2XcYGA3vO" +
       "blvRZMv1M0VQ1/a8Qw6NXgKF5Kxet106wbroitV1EH2L7nIyqW8dasnQUT/l" +
       "mhtTaBjYnJPXRL8pUwQ2UeA1NklTiZ8NiPomrnTHfiVZsVyzq+pOv4FNwsam" +
       "3SnXOwNnqgxTpNdvETrBLvCyRCVIv23ZG04dSAMk9DNh08FNn5T1cLAMhGpP" +
       "QTyE74wnbaHf2lDz9dJE2o6T2Mq83DeSdXWVSOQa6agcxmDC2JmLrDYdpoQ+" +
       "Z3mql6YEKdCbBbIypXDszhiExBLFw/uzVNwOFzHcXOrrZqiPIAFrBRBPtQwU" +
       "UWs+YcpKf96nZSPdpK5kwIwkoURvNDH7NCqPg77aTDaaoG625fI4JSJ2A7fZ" +
       "0bYeO8gE6nu+MsvKigNDUB9kBamh+EMG0XmiqfW3I6rdJZGQrOGGMpYNLGz6" +
       "ftKfRR7fT7szzhiQo1p5mMiehYnJommUx3WjzLDrKNpmONbqNyAICTVWRPTI" +
       "QXGXF6vjsLIYpMtFgrFixKgEUp7ORIIX11XOY4iqL5lbCl7V4GUXGYmNDGX1" +
       "lhaqfUKm8NqsNawwQd8VPCSI0G0tckU4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HPf85YgdVkZdPJlYRqs5rYQVX21veAoaRklYTiEWHgaWBAWzJEWQkWwlDJwZ" +
       "vdhskrLc6zXdCEUjP2BDE61Wx7oPYEdxjb5QSytNBEQTeJdfgNcmp+MmK5ft" +
       "zEdqv7yimxkyrnAAHgIFEVBrg7hJlY0G6DSh8ZiV0njV9FbjbWPcW60bHZNs" +
       "NbOVsCKcTNmSEImyLJX1wKIzrY49zF+RGCVSg+qUVKKJEAsqpI4DpByOyOqU" +
       "Rz20hm0bsBLUjFpjBi8DXGz1x23wSl/68dLvvbVPVg8XX+IOD5n+Kb7BJbfb" +
       "Tyv+8u/5Jw4mHvtseWx/6XAf+pkzBzWKfUN6NTg8TXxA+p7zzvdhnmd7h+T5" +
       "ruUT551KLbbWP//xV14Vp79QOTgHRAWlewPb+WFDiiTjmJB37fZVDhXMP/wW" +
       "uxYv7iv44u2+/l674KPs+3ZTcMGOyrcuaPuDvPh6ULpPkc75Pl3shj70RhIe" +
       "24wsZvobb2WX8HY2eRJc0j5H6Qdvk+9d0PbHefHdoHQV2GRw/o7EoWEuFPO0" +
       "Yf7o+zXMe8Fl7HM0fuCGuXTvBW3358UdQemxwjBvvLVxaKEL5T1loUt3fh8W" +
       "ejavzLc2/H2O/g/eQo9e0PauvHgEwCGw0OLsHsmRkm/7PpQs9nKezpv3lYzf" +
       "qpI/+YZKPntBW35u5dKTQemh/Ih6GEjHJ//01kRka+KR1k99v1qj4Hp5X+uX" +
       "f/BaVy9oQ/Lih4PSjX2tC2RoW+JtAyGnfe+R3ntv6cwEcJ8zx8vzs7KPnfnv" +
       "ld1/XAhffPXqPY++uvz3uwOdB/8VcS9RukcODeP4Kbpj93c5niRrhUnu3R3Q" +
       "cQo9bwalR89ZFfNjFsVNLvOlD+zoPxiUrp2mD0p3Fr/H6dpgkTmiA0Ptbo6T" +
       "9ILSFUCS32LOwRJ9bJdtd5gwuXRsPd13kwJaH3kjKx92OX4AOz/iVPz30MGR" +
       "sHC2f4j4S6+OyI9+p/ELuwPggsFlxVmYe4jS3buz6MWg+bGyp88d7WCsu4bP" +
       "f++hX7r3uYP84KGdwEcue0y2p25/2hoznaA4H539s0d/+Uf+/qu/X2wz/n/+" +
       "Seta1jUAAA==");
}
